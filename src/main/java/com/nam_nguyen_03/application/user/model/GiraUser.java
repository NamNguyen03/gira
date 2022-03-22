package com.nam_nguyen_03.application.user.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.nam_nguyen_03.application.common.model.BaseEntity;
import com.nam_nguyen_03.application.role.model.GiraGroup;

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
@Table(name = "gira_user")
public class GiraUser extends BaseEntity {
 
    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "department")
    private String department;

    @Column(name = "major")
    private String major;

    @Column(name = "hobbies")
    private String hobbies;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @ManyToMany(mappedBy = "users")
    @Builder.Default
	private Set<GiraGroup> groups = new LinkedHashSet<>();
}
