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
	private Long userId;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String email;

	private String phone;
}
