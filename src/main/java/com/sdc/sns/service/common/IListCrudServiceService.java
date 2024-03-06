package com.sdc.sns.service.common;

import com.sdc.sns.service.dto.DefaultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IListCrudServiceService<K, E extends DefaultDTO, R extends JpaRepository<E, K>> extends ICrudService<K, E, R>, IPagingListService<K, E, R> {

	@Transactional
	default <D extends DefaultDTO> void saveList(List<D> entityList) {
		for(D entity : entityList) {
			//CRUD에 따른 변경. 조건절 추가.
			this.save(entity);
		}
	}



	@Transactional
	default void saveEntityList(List<E> entityList) {
		getRepository().saveAll(entityList);
	}

	@Transactional
	default void deleteList(List<E> entityList) {
		getRepository().deleteAll(entityList);
	}

}
