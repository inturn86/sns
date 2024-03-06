package com.sdc.sns.service.mdm.user.repository;

import com.sdc.sns.service.mdm.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>, UserRepositoryDsl {
}
