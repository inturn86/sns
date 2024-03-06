package com.sdc.sns.service.mdm.user.repository;

import com.sdc.sns.manager.support.CustomQuerydslRepositorySupport;
import com.sdc.sns.service.mdm.user.QUserEntity;
import com.sdc.sns.service.mdm.user.UserEntity;
import com.sdc.sns.service.mdm.user.dto.UserDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
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
				.where(qUser.userId.eq(param.getUserName()))
				.fetch();
	}

	public Page<UserDTO> getUserPagingList(UserDTO param, Pageable pageable) {
		JPQLQuery<UserDTO> query = from(qUser)
			.where(
				eq(qUser.userName, param.getUserName()),
				eq(qUser.age, param.getAge())
			)
			.select(Projections.bean(UserDTO.class,
				qUser.userId,
				qUser.userName,
				qUser.departmentId,
				qUser.age
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
				.select(Projections.bean(UserDTO.class,
					qUser.userId,
					qUser.userName,
					qUser.departmentId,
					qUser.age
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
						qUser.departmentId,
						qUser.age
				))
				.orderBy(qUser.userId.desc())
				.fetch();
	}

//	private List<OrderSpecifier> getOrderSpecifiers(Sort sort) {
//		List<OrderSpecifier> orders = new ArrayList<>();
//		PathBuilder orderByExpression = new PathBuilder(qUser.getClass(), qUser.toString(), PathBuilderValidator.FIELDS);
//		sort.stream().forEach(order -> {
//			Order direction = order.isAscending() ? Order.ASC : Order.DESC;
//			try {
//				orders.add(new OrderSpecifier(direction, orderByExpression.get(order.getProperty())));
//			}
//			catch (Exception e) {
//			}
//		});
//		return orders;
//	}
}
