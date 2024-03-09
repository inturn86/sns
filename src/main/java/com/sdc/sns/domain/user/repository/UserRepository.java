package com.sdc.sns.domain.user.repository;

import com.sdc.sns.domain.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryDsl {
	UserEntity findByEmail(String email);
}

