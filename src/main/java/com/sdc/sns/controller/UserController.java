package com.sdc.sns.controller;

import com.sdc.sns.service.mdm.user.UserEntity;
import com.sdc.sns.service.mdm.user.UserService;
import com.sdc.sns.service.mdm.user.dto.UserDTO;
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

	@GetMapping("/paging")
	public Page<UserDTO> getUserPagingList(UserDTO dto, Pageable paging) {
		return userService.getUserPagingList(dto, paging);
	}

	@GetMapping
	public List<UserDTO> getUserList(UserDTO dto, Sort sort) {
		return userService.getUserList(dto, sort);
	}

	@GetMapping("/{id}")
	public UserDTO getUserList(@PathVariable("id") String id) {
		return userService.getDetailById(id, UserDTO.class);
	}

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public UserEntity saveUser(@RequestBody UserDTO dto) {
		return userService.save(dto);
	}

	@PatchMapping
	public UserEntity patchUser(@RequestBody UserDTO dto) {
		return userService.patch(dto);
	}

	@DeleteMapping
	public void deleteUser(@RequestBody UserDTO dto) {
		userService.delete(dto);
	}

	//다중일 경우에 대해서는 /list는 명칭을 붙여 처리.
	@PostMapping("/list")
	public void saveUserList(@RequestBody List<UserDTO> saveUserList) {
		userService.saveUserList(saveUserList);
	}

	@RequestMapping(method = RequestMethod.TRACE)
	public UserDTO trace(UserDTO dto) {
		return dto;
	}
}
