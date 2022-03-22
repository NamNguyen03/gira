/**
 * 
 */
package com.nam_nguyen_03.application.role.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.nam_nguyen_03.application.common.model.BaseEntity;
import com.nam_nguyen_03.application.user.model.GiraUser;

import lombok.Builder;
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
@Table(name = "gira_group")
public class GiraGroup extends BaseEntity {
	@Size(max = 100 , min =  3 )
	private String code;
	@NotBlank
	private String description;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(
			name = "gira_group_role",
			joinColumns = @JoinColumn(name = "group_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	@Builder.Default
	private Set<GiraRole> roles  = new LinkedHashSet<>();
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(
		name = "gira_group_user",
		joinColumns = @JoinColumn(name = "group_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	@Builder.Default
	private Set<GiraUser> users = new LinkedHashSet<>();

	public void addRole(GiraRole role) {
		roles.add(role);
		role.getGroups().add(this);
	}
	
	public void removeRole(GiraRole role) {
		roles.remove(role);
		role.getGroups().remove(this);
	}
	
	public void clearRole() {
		this.roles.clear();
	}
}
