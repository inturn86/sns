package com.sdc.sns.domain.usernamechangehistory.repository;

import com.sdc.sns.domain.usernamechangehistory.UserNameChangeHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNameChangeHistoryRepository extends JpaRepository<UserNameChangeHistoryEntity, Long> , UserNameChangeHistoryRepositoryDsl {
}
