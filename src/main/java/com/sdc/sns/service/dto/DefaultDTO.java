package com.sdc.sns.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class DefaultDTO extends CrudDTO{

	private String regDay;

	@CreatedBy
	private String regId;

	@CreatedDate
	private LocalDateTime regDt;

	@LastModifiedBy
	private String modId;

	@LastModifiedDate
	private LocalDateTime modDt;

}
