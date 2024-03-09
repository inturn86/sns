package com.sdc.sns.domain.usernamechangehistory;

import com.sdc.sns.service.dto.DefaultDTO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.boot.model.internal.XMLContext;

@Getter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public class UserNameChangeHistory extends DefaultDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userNameChangeHistoryId;

	private Long userId;

	private String beforeUserName;

	private String afterUserName;

}
