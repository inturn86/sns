package com.sdc.sns.service.common;

import com.sdc.sns.service.dto.DefaultDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IService<K, E extends DefaultDTO, R extends JpaRepository> {


	R getRepository();

	Class<E> getEntityClass();

	default E getEntity() {
		try {
			return getEntityClass().getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	default K getEntityId(Object entity) {
		try {
			 return (K) PropertyUtils.getProperty(entity, getEntityId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getEntityId();

}
