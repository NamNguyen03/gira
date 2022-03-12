/**
 * 
 */
package com.nam_nguyen_03.application.role.model;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.nam_nguyen_03.application.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author nam
 *
 */
@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Table(name="gira_role")
public class GiraRole extends BaseEntity {
	@Size(max = 30 , min =  3 )
	private String code;
	@NotBlank
	private String description;
	@ManyToMany(mappedBy = "roles")
	private Set<GiraGroup> groups = new LinkedHashSet<>();
}

