package com.sdc.sns.service.mdm.user.repository;

import com.sdc.sns.service.mdm.user.UserEntity;
import com.sdc.sns.service.mdm.user.dto.UserDTO;
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
