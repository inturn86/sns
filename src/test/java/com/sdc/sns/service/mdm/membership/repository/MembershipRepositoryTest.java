package com.sdc.sns.service.mdm.membership.repository;

import com.sdc.sns.define.EMembershipType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.orm.jpa.JpaSystemException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//사용할 Database를 Test용 DB로 교체할지 설정.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MembershipRepositoryTest {

	@Autowired
	private MembershipRepository membershipRepository;

	@Test
	@DisplayName("맴버쉽 등록 실패 - 맴버쉽 ID Not exist")
	void Add_Membership_ThrowException_When_MemberIdNotExist() {

		//given
		String membershipId = String.valueOf(System.currentTimeMillis());
		MembershipEntity entity = MembershipEntity.builder().membershipType(EMembershipType.YOUTUBE_PREMIER.getType()).userId(String.format("%s %s", "User", membershipId)).build();

		//when
		assertThrows(JpaSystemException.class, () ->{
			membershipRepository.save(entity);
		});
		//then
	}
	
	@Test
	@DisplayName("맴버쉽 등록 성공")
	void addMembershipTest() {
		//given
		String membershipId = String.valueOf(System.currentTimeMillis());
		String userId = String.format("%s %s", "User", membershipId);
		MembershipEntity entity = MembershipEntity.builder().membershipId(String.valueOf(System.currentTimeMillis())).membershipType(EMembershipType.YOUTUBE_PREMIER.getType()).userId(String.format("%s %s", "User", membershipId)).build();

		//when
		MembershipEntity result = membershipRepository.save(entity);

		//then
		assertEquals(entity.getMembershipId(), result.getMembershipId());
		assertNotNull(membershipRepository.findByMembershipId(membershipId));
		assertNotNull(membershipRepository.findByUserId(userId));
	}
}