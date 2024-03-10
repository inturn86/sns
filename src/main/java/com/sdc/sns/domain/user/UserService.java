package com.sdc.sns.domain.user;

import com.sdc.sns.domain.user.dto.UserDTO;
import com.sdc.sns.domain.user.repository.UserRepository;
import com.sdc.sns.exception.ExistUserException;
import com.sdc.sns.manager.util.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService  {

	private final UserRepository userRepository;

	public UserDTO getUserById(Long userId){
		return userRepository.findById(userId).map(this::toDTO).orElseThrow(() -> new RuntimeException("Not found user"));
	}

	public UserEntity getUserByEmailWithDsl(String email) {
		return userRepository.getUserByEmail(email);
	}

	public UserEntity getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public UserEntity patchUser(UserDTO param) {

		UserEntity user = new UserEntity();
		ModelMapperUtils.getModelMapper().map(param, user);
		return userRepository.save(user);
	}


	@Transactional
	public UserEntity saveUser(UserDTO param) {
		var userEntity = userRepository.findByEmail(param.getEmail());

		if(Objects.nonNull(userEntity)){
			throw new ExistUserException("해당 사용자는 이미 존재합니다.");
		}

		UserEntity user = new UserEntity();
		ModelMapperUtils.getModelMapper().map(param, user);
		//아닐 경우 사용자 정보를 바로 저장
		//TODO - validate 는 어떻게 할까 ?
		return userRepository.save(user);
	}

	public Page<UserDTO> getUserPagingList(UserDTO param, Pageable page) {
		return userRepository.getUserPagingList(param, page);
	}

	public List<UserDTO> getUserList(UserDTO param, Sort sort) {
		return userRepository.getUserList(param, sort);
	}

	private UserDTO toDTO(UserEntity entity) {
		UserDTO dto = new UserDTO();
		ModelMapperUtils.getModelMapper().map(entity, dto);
		return dto;
	}
}
