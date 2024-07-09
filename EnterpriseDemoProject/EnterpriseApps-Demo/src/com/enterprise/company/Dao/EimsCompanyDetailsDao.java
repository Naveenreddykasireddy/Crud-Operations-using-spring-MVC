package com.enterprise.company.Dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.enterprise.company.schema.EimsCompanyInfo;
import com.enterprise.company.schema.EimsTechnologyInfo;

public interface EimsCompanyDetailsDao 
{

	public void saveModel(Object obj) throws DataAccessException,java.sql.SQLException;

	
	public String deleteModel(int userId);

	public List<Object[]> fetchModel(int id);

	public void updateModel(Object obj)throws DataAccessException,java.sql.SQLException;
	
	public EimsCompanyInfo fetchEimsCompanyInfo(int companyId);
	
	EimsTechnologyInfo fetchEimsTechnologyInfo2(int companyId);
	
}
