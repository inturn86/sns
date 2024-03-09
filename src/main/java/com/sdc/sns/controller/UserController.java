package com.sdc.sns.controller;

import com.sdc.sns.biz.UserBizService;
import com.sdc.sns.domain.user.UserEntity;
import com.sdc.sns.domain.user.UserService;
import com.sdc.sns.domain.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	private final UserBizService userBizService;

	@GetMapping("/paging")
	public Page<UserDTO> getUserPagingList(UserDTO dto, Pageable paging) {
		return userService.getUserPagingList(dto, paging);
	}

	@GetMapping
	public List<UserDTO> getUserList(UserDTO dto, Sort sort) {
		return userService.getUserList(dto, sort);
	}

	@GetMapping("/{id}")
	public UserDTO getUserList(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public UserEntity saveUser(@RequestBody UserDTO dto) {
		return userService.saveUser(dto);
	}

	@PatchMapping
	public UserEntity patchUser(@RequestBody UserDTO dto) {
		return userBizService.saveUserWithNameChangeHistory(dto);
	}
//
//	@DeleteMapping
//	public void deleteUser(@RequestBody UserDTO dto) {
//		userService.delete(dto);
//	}

	@RequestMapping(method = RequestMethod.TRACE)
	public UserDTO trace(UserDTO dto) {
		return dto;
	}
}
