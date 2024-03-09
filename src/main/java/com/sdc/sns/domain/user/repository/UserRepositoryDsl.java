package com.sdc.sns.domain.user.repository;

import com.sdc.sns.domain.user.dto.UserDTO;
import com.sdc.sns.domain.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserRepositoryDsl {
	List<UserEntity> getUserList(UserEntity param);
	List<UserDTO> getUserList(UserDTO param);
	List<UserDTO> getUserList(UserDTO param, Sort sort);
	Page<UserDTO> getUserPagingList(UserDTO param, Pageable pageable);

}
