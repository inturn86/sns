package com.sdc.sns.domain.user;

import com.sdc.sns.domain.user.dto.UserDTO;
import com.sdc.sns.domain.user.repository.UserRepository;
import com.sdc.sns.exception.ExistUserException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository userRepository;


	@Test
	@DisplayName("사용자 등록 - 기 사용자 존재로 실패")
	void save_user_fail_by_exist_user() {

		//Given
		final String email = "test@gmail.com";
		var userParam = getUserDTO(email);

		//when
		when(userRepository.findByEmail(userParam.getEmail())).thenReturn(UserEntity.builder()
				.userId(1L).email(userParam.getEmail())
				.build());

		//then
		assertThrows(ExistUserException.class, () -> userService.saveUser(userParam));
	}

	@Test
	@DisplayName("사용자 등록 - 성공")
	void save_user_success() {

		//Given
		final String email = "test@gmail.com";
		var userParam = getUserDTO(email);

		//when
		when(userRepository.findByEmail(userParam.getEmail())).thenReturn(null);
		when(userRepository.save(any(UserEntity.class))).thenReturn(getUserEntity(email));

		//then
		var result = userService.saveUser(userParam);
		assertEquals(result.getEmail(), userParam.getEmail());
	}

	private UserEntity getUserEntity(String email) {
		return UserEntity.builder().email(email)
				.userId(1L)
				.userName("test")
				.password("1")
				.phone("010-1111-1111")
				.build();
	}

	private UserDTO getUserDTO(String email) {
		return UserDTO.builder().email(email)
				.userId(1L)
				.userName("test")
				.password("1")
				.phone("010-1111-1111")
				.build();
	}
}