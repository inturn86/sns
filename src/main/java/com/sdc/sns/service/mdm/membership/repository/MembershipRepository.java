package com.sdc.sns.service.mdm.membership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<MembershipEntity, String> {

	MembershipEntity findByMembershipId(String membershipId);

	MembershipEntity findByUserId(String userId);
}
