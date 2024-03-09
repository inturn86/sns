package com.sdc.sns.service.dto;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@SuperBuilder
public class CommonDTO {

	private static ObjectMapper mapper;

	protected static ObjectMapper getObjectMapper() {
		if(mapper == null) {
			mapper = new ObjectMapper();
			//Upper, Lower case 무시.
			mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
			//JSON에는 있지만 Mapping 될 Object에는 없는 필드를 무시해야하는 경우
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.registerModule(new JavaTimeModule());
			//localdatetime을 문자열로 표시.
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		}
		return mapper;
	}

	@Override
	public String toString() {
		try {
			return getObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(this);
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return "{}";
	}
}
