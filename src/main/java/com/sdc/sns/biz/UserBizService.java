package com.sdc.sns.biz;

import com.sdc.sns.domain.user.UserEntity;
import com.sdc.sns.domain.user.UserService;
import com.sdc.sns.domain.user.dto.UserDTO;
import com.sdc.sns.domain.usernamechangehistory.UserNameChangeHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserBizService {

	private final UserService userService;

	private final UserNameChangeHistoryService userNameChangeHistoryService;

	@Transactional
	public UserEntity saveUserWithNameChangeHistory(UserDTO param) {
		//userId를 바로 받는 것이 아니고 email을 받아서 해당 id를 조회
		UserEntity user = userService.getUserByEmailWithDsl(param.getEmail());

		//이름이 기존과 같다면.
		if(StringUtils.equals(user.getUserName(), param.getUserName())) {
			//return user;
			//TODO Exception을 만들어서 해보자.
			throw new RuntimeException("이미 현재 이름과 같습니다.");
		}

		var changeUser = userService.patchUser(UserDTO.builder().userId(user.getUserId())
				.userName(param.getUserName())
				.email(user.getEmail())
				.phone(user.getPhone())
				.password(user.getPassword())
				.build());

		userNameChangeHistoryService.addUserNameChangeHistory(user.getUserId(), user.getUserName(), param.getUserName());

		return changeUser;
	}


}
