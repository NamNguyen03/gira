/**
 * 
 */
package com.nam_nguyen_03.application.common.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author nam
 *
 */
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	protected UUID id;
	@Version
	protected int version;
	@CreatedBy
	protected String createBy;
	@CreatedDate
	protected Date createDate;
	@LastModifiedBy
	protected String updateBy;
	@LastModifiedDate
	protected Date updateDate;
	
}
