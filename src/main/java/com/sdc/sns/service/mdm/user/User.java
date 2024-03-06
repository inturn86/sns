package com.sdc.sns.service.mdm.user;

import com.sdc.sns.service.dto.DefaultDTO;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public class User extends DefaultDTO {

	@Id
	protected String userId;

	protected String userName;

	protected String departmentId;

	protected Integer age;
}
