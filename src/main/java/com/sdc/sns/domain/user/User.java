package com.sdc.sns.domain.user;

import com.sdc.sns.service.dto.DefaultDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public class User extends DefaultDTO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long userId;

	@Column(nullable = false)
	protected String userName;

	@Column(nullable = false)
	protected String password;

	@Column(nullable = false)
	protected String email;

	protected String phone;
}
