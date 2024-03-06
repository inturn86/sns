package com.sdc.sns.define;


import lombok.Getter;

public enum EMembershipType {

	YOUTUBE_PREMIER("YOUTUBE_PREMIER"), MEGA_COFFEE("MEGA_COFFEE");

	@Getter
	String type;

	EMembershipType(String type) {
		this.type = type;
	}
}
