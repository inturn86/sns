package com.sdc.sns.service.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@SuperBuilder
public class CrudDTO extends CommonDTO{

	private String crudMode;

}
