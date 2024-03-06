package com.sdc.sns.service.mdm.user.dto;

import com.sdc.sns.service.mdm.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.boot.model.internal.XMLContext;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class UserDTO extends User {
	//TODO - DTO 관련 처리 추후.
}
