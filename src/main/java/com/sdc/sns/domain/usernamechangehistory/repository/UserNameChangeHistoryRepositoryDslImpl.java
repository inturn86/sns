package com.sdc.sns.domain.usernamechangehistory.repository;

import com.querydsl.core.types.Projections;
import com.sdc.sns.domain.usernamechangehistory.QUserNameChangeHistoryEntity;
import com.sdc.sns.domain.usernamechangehistory.dto.UserNameChangeHistoryDTO;
import com.sdc.sns.manager.support.CustomQuerydslRepositorySupport;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class UserNameChangeHistoryRepositoryDslImpl extends CustomQuerydslRepositorySupport implements UserNameChangeHistoryRepositoryDsl {
	/**
	 * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
	 *
	 * @param domainClass must not be {@literal null}.
	 */

	QUserNameChangeHistoryEntity qUserNameChangeHistory = QUserNameChangeHistoryEntity.userNameChangeHistoryEntity;

	public UserNameChangeHistoryRepositoryDslImpl() {
		super(QUserNameChangeHistoryEntity.class);
	}

	public List<UserNameChangeHistoryDTO> getList(UserNameChangeHistoryDTO param ) {
		return from(qUserNameChangeHistory)
				.select(Projections.fields(
						UserNameChangeHistoryDTO.class,
						qUserNameChangeHistory.userNameChangeHistoryId,
						qUserNameChangeHistory.userId,
						qUserNameChangeHistory.beforeUserName,
						qUserNameChangeHistory.afterUserName,
						qUserNameChangeHistory.createdDt

				))
				.fetch();
	}
}
