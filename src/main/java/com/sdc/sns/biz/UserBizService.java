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
		UserDTO user = userService.getUserById(param.getUserId());
		//이름이 기존과 같다면.
		if(StringUtils.equals(user.getUserName(), param.getUserName())) {
			//return user;
			//TODO Exception을 만들어서 해보자.
			throw new RuntimeException("이미 현재 이름과 같습니다.");
		}

		var changeUser = userService.patchUser(param);

		userNameChangeHistoryService.addUserNameChangeHistory(user.getUserId(), user.getUserName(), param.getUserName());

		return changeUser;
	}


}
