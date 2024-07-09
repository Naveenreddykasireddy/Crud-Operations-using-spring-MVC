package com.enterprise.company.schema;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "eims_company_info",catalog = "enterprisedb")
public class EimsCompanyInfo 
{

	private Integer companyId;
	private String companyName;
	private String companyDescription;
	private String companyFoundedYear;
	private String employeeName;
	private Date createdDate;
	private Date updatedDate;
	
	public EimsCompanyInfo() {
		super();
	
	}

	public EimsCompanyInfo(Integer companyId, String companyName, String companyDescription, String companyFoundedYear,
			String employeeName, Date createdDate, Date updatedDate) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyDescription = companyDescription;
		this.companyFoundedYear = companyFoundedYear;
		this.employeeName = employeeName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "companyid", unique = true, nullable = false)
	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Column(name="companyname")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Column(name="companydescription")
	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	@Column(name="foundyear")
	public String getCompanyFoundedYear() {
		return companyFoundedYear;
	}

	public void setCompanyFoundedYear(String companyFoundedYear) {
		this.companyFoundedYear = companyFoundedYear;
	}

	@Column(name="employeename")
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
