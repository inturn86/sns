package com.sdc.sns.domain.usernamechangehistory.repository;

import com.sdc.sns.domain.usernamechangehistory.UserNameChangeHistory;
import com.sdc.sns.domain.usernamechangehistory.dto.UserNameChangeHistoryDTO;

import java.util.List;

public interface UserNameChangeHistoryRepositoryDsl {

	public List<UserNameChangeHistoryDTO> getList(UserNameChangeHistoryDTO param);
}
