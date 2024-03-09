package com.sdc.sns.domain.user.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.sdc.sns.domain.user.QUserEntity;
import com.sdc.sns.domain.user.UserEntity;
import com.sdc.sns.domain.user.dto.UserDTO;
import com.sdc.sns.manager.support.CustomQuerydslRepositorySupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class UserRepositoryDslImpl extends CustomQuerydslRepositorySupport implements UserRepositoryDsl {
	/**
	 * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
	 *
	 * @param domainClass must not be {@literal null}.
	 */
	QUserEntity qUser = QUserEntity.userEntity;

	public UserRepositoryDslImpl() {
		super(QUserEntity.class);
	}

	@Override
	public List<UserEntity> getUserList(UserEntity param) {
		return from(qUser)
				.where(qUser.userId.eq(param.getUserId()))
				.fetch();
	}

	public Page<UserDTO> getUserPagingList(UserDTO param, Pageable pageable) {
		JPQLQuery<UserDTO> query = from(qUser)
			.where(
				eq(qUser.userName, param.getUserName())
			)
			.select(Projections.fields(UserDTO.class,
				qUser.userId,
				qUser.userName,
				qUser.email,
				qUser.password,
				qUser.createdDt,
				qUser.updatedDt
			))
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.orderBy(getOrderSpecifiers(qUser, pageable.getSort()));
		return new PageImpl<>(query.fetch(), pageable, query.fetchCount());
	}

	@Override
	public List<UserDTO> getUserList(UserDTO param, Sort sort) {
		return from(qUser)
				.where()
				//Projections.bean은  setter로 데이터를 컬럼에 바인딩하므로 불변객체에서 사용 불가
				//Projections.fields는 reflection을 이용하여 데이터를 set
				.select(Projections.fields(UserDTO.class,
					qUser.userId,
					qUser.userName,
					qUser.email,
					qUser.password,
					qUser.createdDt,
					qUser.updatedDt
				))
				.orderBy(getOrderSpecifiers(qUser, sort))
				.fetch();
	}

	@Override
	public List<UserDTO> getUserList(UserDTO param) {
		return from(qUser)
				.where()
				.select(Projections.bean(UserDTO.class,
						qUser.userId,
						qUser.userName,
						qUser.email,
						qUser.password,
						qUser.createdDt,
						qUser.updatedDt
				))
				.orderBy(qUser.userId.desc())
				.fetch();
	}
}
