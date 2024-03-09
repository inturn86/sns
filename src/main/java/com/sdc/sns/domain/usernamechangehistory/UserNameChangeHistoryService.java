package com.sdc.sns.domain.usernamechangehistory;

import com.sdc.sns.domain.user.dto.UserDTO;
import com.sdc.sns.domain.usernamechangehistory.repository.UserNameChangeHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserNameChangeHistoryService {

	private final UserNameChangeHistoryRepository userNameChangeHistoryRepository;

	public void addUserNameChangeHistory(Long userId, String beforeName, String afterName) {

		userNameChangeHistoryRepository.save(UserNameChangeHistoryEntity.builder()
				.userId(userId)
				.beforeUserName(beforeName)
				.afterUserName(afterName)
				.build());

	}
}
