package com.sdc.sns.service.common;

import com.sdc.sns.service.dto.DefaultDTO;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class JpaCommonService <K, E extends DefaultDTO, R extends JpaRepository<E, K>> implements IListCrudServiceService<K, E, R> {

	@Getter
	@Setter(onMethod_ = @Autowired)
	R repository;

	@Getter
	public Class<E> entityClass;

	@Getter
	public String entityId;

	@PostConstruct
	public void init() {
		Type type = getClass().getGenericSuperclass();
		var argsType = ((ParameterizedType) type).getActualTypeArguments()[1];
		entityClass = (Class<E>)argsType;
		recursive(entityClass);
	}

	private void recursive(Class<?> entityClass) {

		if(entityClass == null) return;
		Field[] fields = entityClass.getDeclaredFields();
		for(Field field : fields) {
			Id anno = field.getAnnotation(Id.class);
			if(anno != null) {
				entityId = field.getName();
			}
		}
		recursive(entityClass.getSuperclass());
	}
}
