package com.sdc.sns.service.mdm.membership;

import com.sdc.sns.service.common.JpaCommonService;
import com.sdc.sns.service.mdm.membership.repository.MembershipEntity;
import com.sdc.sns.service.mdm.membership.repository.MembershipRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class MembershipService extends JpaCommonService<String, MembershipEntity, MembershipRepository> {

	public MembershipEntity addMembership(MembershipEntity entity) {

		final MembershipEntity membershipEntity = getRepository().findByUserId(entity.getUserId());

		if(!ObjectUtils.isEmpty(membershipEntity)){
			throw new RuntimeException();
		}

		return getRepository().save(entity);
	}
}
