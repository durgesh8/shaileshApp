package com.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;


@MappedSuperclass
public abstract class AbstractEntity {

	
	@CreatedDate
	@Column(name = "CREATED_TS")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date createdTs;

	@CreatedBy
	@Column(name = "CREATED_BY")
	protected String createdBy;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_UPDATED_TS")
	protected Date lastUpdatedTs;

	@LastModifiedBy
	@Column(name = "LAST_UPDATED_BY")
	protected String lastUpdatedBy;

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdatedTs() {
		return lastUpdatedTs;
	}

	public void setLastUpdatedTs(Date lastUpdatedTs) {
		this.lastUpdatedTs = lastUpdatedTs;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	@PrePersist
	public void beforeCreate() {
		this.createdBy="Shailesh";
		this.createdTs = new Date();
		this.lastUpdatedBy = null;
		this.lastUpdatedTs = null;
		}

	@PreUpdate
	public void beforeUpdate() {
		this.lastUpdatedBy="Logged In User";
		this.lastUpdatedTs = new Date();
	}


}
