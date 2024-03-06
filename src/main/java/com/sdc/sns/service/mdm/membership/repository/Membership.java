package com.sdc.sns.service.mdm.membership.repository;

import com.sdc.sns.service.dto.DefaultDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
public class Membership extends DefaultDTO {

	@Id
	@Column(name = "membership_id")
	private String membershipId;

	private String membershipType;

	private String userId;
}
