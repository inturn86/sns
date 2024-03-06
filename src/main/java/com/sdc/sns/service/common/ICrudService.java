package com.sdc.sns.service.common;

import com.sdc.sns.manager.util.ModelMapperUtils;
import com.sdc.sns.service.dto.DefaultDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ICrudService<K, E extends DefaultDTO, R extends JpaRepository<E, K>> extends IService<K, E, R>{

	@Transactional
	default <D extends DefaultDTO> E save(D entity) {

		//D가 DTOClass 인 경우.
		// DTO인 경우에는 entity로 변경하여 save를 해야하는데.
		if(getEntityClass().equals(entity.getClass())) {
			return getRepository().save(getEntityClass().cast(entity));
		}
		E e = getEntity();
		ModelMapperUtils.getModelMapper().map(entity, e);
		return getRepository().save(e);
	}

	@Transactional
	default <D extends DefaultDTO> E patch(D entity) {
		E target = getRepository().findById(getEntityId(entity)).orElse(null);
		ModelMapperUtils.getModelMapper().map(entity, target);
		return getRepository().save(target);
	}

	@Transactional
	default <D extends DefaultDTO> void delete(D entity) {
		getRepository().deleteById(getEntityId(entity));
	}

	default <D extends DefaultDTO> E getDetail(D dto) {
		return getRepository().findOne(Example.of(convertEntity(dto))).orElse(null);
	}

	default <D extends DefaultDTO> E getDetailById(K id) {
		return getRepository().findById(id).orElse(null);
	}

	default <D extends DefaultDTO> D getDetailById(K id, Class<D> returnType) {
		E e = getDetailById(id);
		if(e == null)   return null;
		return ModelMapperUtils.getModelMapper().map(e, returnType);
	}

	default <D extends DefaultDTO> D getDetail(D dto, Class<D> returnType) {
		E e = getDetail(dto);
		if(e == null)   return null;
		return ModelMapperUtils.getModelMapper().map(e, returnType);
	}

	private E convertEntity(Object dto) {
		E entity = null;
		try {
			entity = getEntityClass().getDeclaredConstructor().newInstance();
			PropertyUtils.copyProperties(entity, dto);
		} catch (Exception e) {
		}
		return entity;
	}


}
