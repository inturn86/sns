package com.sdc.sns.service.mdm.user;

import com.sdc.sns.service.common.JpaCommonService;
import com.sdc.sns.service.mdm.user.dto.UserDTO;
import com.sdc.sns.service.mdm.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService extends JpaCommonService<String, UserEntity, UserRepository> {

	public Page<UserDTO> getUserPagingList(UserDTO param, Pageable page) {
		return getRepository().getUserPagingList(param, page);
	}

	public List<UserDTO> getUserList(UserDTO param, Sort sort) {
		return getRepository().getUserList(param, sort);
	}

	@Transactional
	public void saveUserList(List<UserDTO> userList) {
		this.saveList(userList);
	}
}
