package com.sdc.sns.service.mdm.membership.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Setter
@Getter
@Entity(name = "mdm_membership")
@SuperBuilder
@NoArgsConstructor
public class MembershipEntity extends Membership{


}
