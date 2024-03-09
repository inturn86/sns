package com.sdc.sns.service.dto;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public class DefaultDTO extends CrudDTO{

	@CreatedDate
	private LocalDateTime createdDt;

	@LastModifiedDate
	private LocalDateTime updatedDt;

	@PrePersist
	public void prePersist(){
		this.createdDt = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate(){
		this.updatedDt = LocalDateTime.now();
	}
}
