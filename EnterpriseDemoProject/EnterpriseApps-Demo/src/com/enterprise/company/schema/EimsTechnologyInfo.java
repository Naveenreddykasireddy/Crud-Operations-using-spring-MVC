package com.enterprise.company.schema;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "eims_technology_info_d",catalog = "enterprisedb")
public class EimsTechnologyInfo 
{
	private Integer technologyId;
	private Integer companyId;
	private String technologyName;
	private String technologyDescription;
	private String flag;
	private Date createdDate;
	private Date updatedDate;
	
	
	public EimsTechnologyInfo() {
		super();
		
	}


	public EimsTechnologyInfo(Integer technologyId, Integer companyId, String technologyName,
			String technologyDescription, String flag, Date createdDate, Date updatedDate) {
		super();
		this.technologyId = technologyId;
		this.companyId = companyId;
		this.technologyName = technologyName;
		this.technologyDescription = technologyDescription;
		this.flag = flag;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "technologyid", unique = true, nullable = false)
	public Integer getTechnologyId() {
		return technologyId;
	}


	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}

	@Column(name = "companyid")
	public Integer getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Column(name="technologyname")
	public String getTechnologyName() {
		return technologyName;
	}


	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	@Column(name="technologydescription")
	public String getTechnologyDescription() {
		return technologyDescription;
	}


	public void setTechnologyDescription(String technologyDescription) {
		this.technologyDescription = technologyDescription;
	}

	@Column(name="flag")
	public String getFlag() {
		return flag;
	}


	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Column(name="createddate")
	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name="updateddate")
	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
