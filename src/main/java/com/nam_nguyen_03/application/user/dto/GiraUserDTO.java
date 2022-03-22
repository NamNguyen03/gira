package com.nam_nguyen_03.application.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.nam_nguyen_03.application.user.model.UserStatus;
import com.nam_nguyen_03.application.user.valication.anotation.UniqueEmail;
import com.nam_nguyen_03.application.user.valication.anotation.UniqueUsername;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author nam
 *
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class GiraUserDTO {
    @Size(min = 3, max = 100, message = "{user.username.size}")
	@UniqueUsername(message = "{user.username.existed}")
	private String username;
	
	private String password;
	
	private String displayName;
	
	@UniqueEmail(message = "{user.email.existed}")
	@NotBlank(message = "{user.email.notblank}")
	private String email;
	@Builder.Default
	private UserStatus status = UserStatus.ACTIVE;
}
