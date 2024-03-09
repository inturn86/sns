package com.sdc.sns.manager.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.spi.MatchingStrategy;

import java.util.concurrent.ConcurrentHashMap;

@UtilityClass
public class ModelMapperUtils {

	private final static ConcurrentHashMap<EModelMapperType, ModelMapper> modelMapperMap = new ConcurrentHashMap<>();

	public static ModelMapper getModelMapper() {
		return getModelMapper(EModelMapperType.STANDARD);
	}

	public static ModelMapper getModelMapper(EModelMapperType type) {
		if(!modelMapperMap.contains(type)) {
			modelMapperMap.put(type, getInstance(type));
		}
		return modelMapperMap.get(type);
	}

	private static ModelMapper getInstance(EModelMapperType type) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration()
				.setMatchingStrategy(type.getMatchingStrategies())
				.setSourceNameTokenizer(NameTokenizers.UNDERSCORE)
				.setDestinationNameTokenizer(NameTokenizers.UNDERSCORE)
				//setter가 없으면 동작하지 않는 부분을 AccessLevel을 private으로 변경하여 해결
				.setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
				//private 필드에 접근할 수 있도록 설정
				.setFieldMatchingEnabled(true)
				.setSkipNullEnabled(true);
		return mapper;
	}

	@RequiredArgsConstructor
	@Getter
	public enum EModelMapperType {

		LOOSE(MatchingStrategies.LOOSE), STANDARD(MatchingStrategies.STANDARD), STRICT(MatchingStrategies.STRICT);

		private final MatchingStrategy matchingStrategies;
	}
}
