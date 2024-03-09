package com.sdc.sns.domain.user;

import com.sdc.sns.domain.user.dto.UserDTO;
import com.sdc.sns.manager.util.ModelMapperUtils;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@Entity(name = "user")
public class UserEntity extends User {

}
