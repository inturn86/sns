package com.sdc.sns.domain.usernamechangehistory;

import com.sdc.sns.domain.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@Entity(name = "user_name_change_history")
public class UserNameChangeHistoryEntity extends UserNameChangeHistory{

	@ManyToOne
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private UserEntity user;
}
