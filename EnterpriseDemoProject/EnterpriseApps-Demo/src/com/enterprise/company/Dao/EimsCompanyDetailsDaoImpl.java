package com.enterprise.company.Dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.eims.assignment.Dao.EimsUserDetailsDaoImpl;
import com.enterprise.blueprint.constants.EnterpriseConstants;
import com.enterprise.blueprint.schema.InnoUserBasicInfo;
import com.enterprise.blueprint.schema.InnoUserInfo;
import com.enterprise.company.schema.EimsCompanyInfo;
import com.enterprise.company.schema.EimsTechnologyInfo;
@Repository
public class EimsCompanyDetailsDaoImpl implements EimsCompanyDetailsDao
{
	private static Log log = LogFactory.getLog(EimsCompanyDetailsDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveModel(Object obj) {

		sessionFactory.getCurrentSession().save(obj);

		log.info("Data saved Successfully");
	}

	@Override
	public List<Object[]> fetchModel(int id) {

		StringBuilder strquery = new StringBuilder("");
		List lstResult = null;
		try {

			strquery.append("SELECT ci.companyid, ci.companyname, ci.companydescription, ci.foundyear, ci.employeename,ti.technologyid, ti.technologyname, ti.technologydescription, ti.flag, ti.createddate, ti.updateddate");
			strquery.append(" FROM eims_company_info as ci,eims_technology_info_d as ti");
			strquery.append(" WHERE ci.companyid=ti.companyid and ci.companyid = ").append(id);			
			lstResult = sessionFactory.getCurrentSession().createSQLQuery(strquery.toString()).list();
			log.info("fetch eims company information from 2 tables lstresult.size() : " + lstResult.size());

		} catch (Exception e) {

			log.error("Exception in fetch details from eims company details DAO : ", e);

		}
		return lstResult;
	}

	@Override
	public void updateModel(Object obj) throws DataAccessException,java.sql.SQLException{
		
		sessionFactory.getCurrentSession().update(obj);
		log.info("Data Updated Successfully");
	}

	
	@Override
	public String deleteModel(int companyId) {
		String res="";
		log.info("inside dao class");
		//delete technology info record
		 Query q1 = sessionFactory.getCurrentSession().createSQLQuery("delete from eims_technology_info_d as ui where ui.companyId = :companyId");
         q1.setParameter("companyId", companyId);
         int deletedCount1 = q1.executeUpdate();
         if(deletedCount1>0)
         {
        	 res="success ";
         log.info(deletedCount1 + " technology records deleted for userId: " + companyId);
         }
         else
         {
        	 log.error("id not found in eims company technology info entity");
        	 res=" not found";
         }

        
         // Delete company info record
         Query q = sessionFactory.getCurrentSession().createSQLQuery("delete from eims_company_info as ui where ui.companyId = :companyId");
         q.setParameter("companyId", companyId);
         int deletedCount3 = q.executeUpdate();
         if(deletedCount3>0)
         {
        	 res=res+" success";
        	 log.info(deletedCount3 + " user info record deleted for userId: " + companyId);
         }
         else
         {
        	 log.error("id not found in eimsCompanyInfo entity");
        	 res=res+" not found";
         }
         
         return res;
	
	}

	@Override
	public EimsCompanyInfo fetchEimsCompanyInfo(int companyId) {
	    List<EimsCompanyInfo> lstresult = null;
	    log.info("inside dao class");
	    EimsCompanyInfo reportStatus = null;
	    try {
	        log.info("int companyId " + companyId);
	        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EimsCompanyInfo.class);
	
	        criteria.add(Restrictions.eq("companyId", companyId));
	        lstresult = criteria.list();
	 
	        if (lstresult != null && !lstresult.isEmpty()) {
	            reportStatus = lstresult.get(0); 
	            
	        }
	        log.info(reportStatus + " this is details of company");
	 
	    } catch (Exception e) {
	        log.error("Exception in fetchEimsCompanyInfo -->", e);
	    }
	    return reportStatus;
	}
	
	@Override
	public EimsTechnologyInfo fetchEimsTechnologyInfo2(int companyId)
	{
//		EimsTechnologyInfo eimsTechnologyInfo=sessionFactory.getCurrentSession().get(EimsTechnologyInfo.class, companyId);
//		return eimsTechnologyInfo;
		List<EimsTechnologyInfo> lstresult = null;
	    log.info("inside technology dao class");
	    EimsTechnologyInfo reportStatus = null;
	    try {
	        log.info("int companyId " + companyId);
	        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EimsTechnologyInfo.class);
	
	        criteria.add(Restrictions.eq("companyId", companyId));
	        lstresult = criteria.list();
	 
	        if (lstresult != null && !lstresult.isEmpty()) {
	            reportStatus = lstresult.get(0); 
	            
	        }
	        log.info(reportStatus + " this is details of company");
	 
	    } catch (Exception e) {
	        log.error("Exception in fetchEimsCompanyInfo -->", e);
	    }
	    return reportStatus;
		
	}


}
