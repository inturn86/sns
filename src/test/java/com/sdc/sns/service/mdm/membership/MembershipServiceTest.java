package com.sdc.sns.service.mdm.membership;

import com.sdc.sns.service.mdm.membership.repository.MembershipEntity;
import com.sdc.sns.service.mdm.membership.repository.MembershipRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.orm.jpa.JpaSystemException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
class MembershipServiceTest {

	@Autowired
	private MembershipService membershipService;

	@MockBean
	private MembershipRepository membershipRepository;

	final String userId = "U0001";

	@Test
	@DisplayName("맴버쉽 등록 실패 - 이미 존재함.")
	void Membership_AlreadyExist() {

		MembershipEntity member = new MembershipEntity();
		member.setUserId(userId);


		when(membershipRepository.findByUserId(userId)).thenReturn(null);
//		when(membershipRepository.save(member)).thenReturn(member);

		MembershipEntity result = membershipService.addMembership(member);
		assertEquals(result.getUserId(), userId);

	}
}