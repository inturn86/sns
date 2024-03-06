package com.sdc.sns.service.common;

import com.sdc.sns.service.dto.DefaultDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPagingListService<K, E extends DefaultDTO, R extends JpaRepository<E, K>> extends IService<K, E, R> {


	//TODO - 필요가 있을까? queryDsl로 할껀데?
	// 우선 queryDsl로 하자. 이유는 DTO를 하는 이슈가 별도의 table join에 따른 column 추가 부분인데 그렇다면 getRepository에서 DTO를 지원할 필요가 없음.
	default <D extends DefaultDTO> Page<E> getPagingList(E param, Pageable paging) {
		return getRepository().findAll(Example.of(param), paging);
	}

}
