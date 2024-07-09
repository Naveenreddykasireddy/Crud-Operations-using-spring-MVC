package com.enterprise.company.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eims.assignment.Dao.EimsUserDetailsDao;
import com.eims.assignment.dto.EimsUserFetchReqDto;
import com.enterprise.company.Dao.EimsCompanyDetailsDao;
import com.enterprise.company.Dto.EimsCompanyDetailsDto;
import com.enterprise.company.Dto.EimsCompanyFetchDetailsDto;
import com.enterprise.company.schema.EimsCompanyInfo;
import com.enterprise.company.schema.EimsTechnologyInfo;

@Service
@Transactional
public class EimsCompanyDetailsServiceImpl implements EimsCompanyDetailsService {
	private static Log log = LogFactory.getLog(EimsCompanyDetailsServiceImpl.class);

	@Autowired
	private EimsCompanyDetailsDao eimsCompanyDetailsDao;

	@Override
	public String saveCompanyDetails(EimsCompanyDetailsDto eimsCompanyDetailsDto) {

		String strjson = "";
		try {
			log.info("Company name :" + eimsCompanyDetailsDto.getCompanyName());

			EimsCompanyInfo eimsCompanyInfo = new EimsCompanyInfo();

			eimsCompanyInfo.setCompanyId(eimsCompanyDetailsDto.getCompanyId());
			eimsCompanyInfo.setCompanyName(eimsCompanyDetailsDto.getCompanyName());
			eimsCompanyInfo.setCompanyDescription(eimsCompanyDetailsDto.getCompanyDescription());
			eimsCompanyInfo.setCompanyFoundedYear(eimsCompanyDetailsDto.getCompanyFoundedYear());
			eimsCompanyInfo.setEmployeeName(eimsCompanyDetailsDto.getEmployeeName());
			eimsCompanyInfo.setCreatedDate(new Date());
			eimsCompanyInfo.setUpdatedDate(new Date());

			log.info("inserting table 1");

			eimsCompanyDetailsDao.saveModel(eimsCompanyInfo);

			int companyid1 = eimsCompanyInfo.getCompanyId();

			EimsTechnologyInfo eimsTechnologyInfo = new EimsTechnologyInfo();
			eimsTechnologyInfo.setCompanyId(companyid1);
			eimsTechnologyInfo.setTechnologyId(eimsCompanyDetailsDto.getTechnologyId());
			eimsTechnologyInfo.setTechnologyName(eimsCompanyDetailsDto.getTechnologyName());
			eimsTechnologyInfo.setTechnologyDescription(eimsCompanyDetailsDto.getTechnologyDescription());
			eimsTechnologyInfo.setFlag(eimsCompanyDetailsDto.getFlag());
			eimsTechnologyInfo.setCreatedDate(new Date());
			eimsTechnologyInfo.setUpdatedDate(new Date());

			eimsCompanyDetailsDao.saveModel(eimsTechnologyInfo);

			log.info("table2 data is inserted");

			strjson = "success";
		} catch (Exception e) {
			strjson = "error";
			log.error("error for inserting", e);
		}
		return strjson;
	}

	@Override
	public EimsCompanyFetchDetailsDto fetchTheUserDetails(int id) {

		List<Object[]> listresult = null;
		EimsCompanyFetchDetailsDto eimsCompanyFetchDetailsDto = new EimsCompanyFetchDetailsDto();
		try {
			listresult = eimsCompanyDetailsDao.fetchModel(id);
			if (listresult.size() > 0) {
				Object[] obj = listresult.get(0);
				eimsCompanyFetchDetailsDto.setCompanyId((Integer) obj[0]);
				eimsCompanyFetchDetailsDto.setCompanyName((String) obj[1]);
				eimsCompanyFetchDetailsDto.setCompanyDescription((String) obj[2]);
				eimsCompanyFetchDetailsDto.setCompanyFoundedYear((String) obj[3]);
				eimsCompanyFetchDetailsDto.setEmployeeName((String) obj[4]);
				eimsCompanyFetchDetailsDto.setTechnologyId((Integer) obj[5]);
				eimsCompanyFetchDetailsDto.setTechnologyName((String) obj[6]);
				eimsCompanyFetchDetailsDto.setTechnologyDescription((String) obj[7]);
				eimsCompanyFetchDetailsDto.setFlag((String) obj[8]);
				eimsCompanyFetchDetailsDto.setCreatedDate((Date) obj[9]);
				eimsCompanyFetchDetailsDto.setUpdatedDate((Date) obj[10]);
			} else {
				log.error("No results found");
			}
		} catch (Exception e) {
			log.error("Exception in getUserDetailsById " + "Index out of bound exception", e);
		}

		return eimsCompanyFetchDetailsDto;
	}

	@Override
	public String updateTheCompanyDetailsById(EimsCompanyDetailsDto eimsCompanyDetailsDto) {

		EimsCompanyInfo eimsCompanyInfo =eimsCompanyDetailsDao.fetchEimsCompanyInfo(eimsCompanyDetailsDto.getCompanyId());
		String res = "";
		EimsTechnologyInfo eimsTechnologyInfo=eimsCompanyDetailsDao.fetchEimsTechnologyInfo2(eimsCompanyDetailsDto.getCompanyId());
		log.info("inside the service class details of update");
		
		if(eimsCompanyInfo!=null)
		{
			if (eimsCompanyDetailsDto.getCompanyName().equals("")) {
				eimsCompanyInfo.setCompanyName(eimsCompanyInfo.getCompanyName());
				log.info("companyName "+eimsCompanyInfo.getCompanyName());
			} else {
				eimsCompanyInfo.setCompanyName(eimsCompanyDetailsDto.getCompanyName());
				log.error("companyName1 "+eimsCompanyDetailsDto.getCompanyName());
			  
			}

			if (eimsCompanyDetailsDto.getCompanyDescription().equals("")) {
				log.info("company description "+eimsCompanyInfo.getCompanyDescription());
				eimsCompanyInfo.setCompanyDescription(eimsCompanyInfo.getCompanyDescription());
			} else {
			    // Retain previous value
				log.error("company description1 "+eimsCompanyDetailsDto.getCompanyDescription());
				eimsCompanyInfo.setCompanyDescription(eimsCompanyDetailsDto.getCompanyDescription());
			}

			if (eimsCompanyDetailsDto.getCompanyFoundedYear().equals("")) {
				log.info("found year "+eimsCompanyInfo.getCompanyFoundedYear());
				eimsCompanyInfo.setCompanyFoundedYear(eimsCompanyInfo.getCompanyFoundedYear());
			} else {
			    // Retain previous value
				log.error("found year1 "+eimsCompanyDetailsDto.getCompanyFoundedYear());
				eimsCompanyInfo.setCompanyFoundedYear(eimsCompanyDetailsDto.getCompanyFoundedYear());
			}

			if (eimsCompanyDetailsDto.getEmployeeName().equals("")) {
				log.info("employee name "+eimsCompanyInfo.getEmployeeName());
				eimsCompanyInfo.setEmployeeName(eimsCompanyInfo.getEmployeeName());
			} else {
			    // Retain previous value
				log.error("employee name1 "+eimsCompanyDetailsDto.getEmployeeName());
				eimsCompanyInfo.setEmployeeName(eimsCompanyDetailsDto.getEmployeeName());
			}

			// Set updated date
			eimsCompanyInfo.setUpdatedDate(new Date());
			log.info("primary table updated");
			
		}
		
		if(eimsTechnologyInfo!=null)
		{
			if (eimsCompanyDetailsDto.getTechnologyName().equals("")) {
				log.info("technology name "+eimsTechnologyInfo.getTechnologyName());
				eimsTechnologyInfo.setTechnologyName(eimsTechnologyInfo.getTechnologyName());
			} else {
	            // Retain previous value
				log.error("technology name1 "+eimsCompanyDetailsDto.getTechnologyName());
	        	eimsTechnologyInfo.setTechnologyName(eimsCompanyDetailsDto.getTechnologyName());
	        }

	        if (eimsCompanyDetailsDto.getTechnologyDescription().equals("")) {
	        	log.info("Technology Description "+eimsTechnologyInfo.getTechnologyDescription());
	        	eimsTechnologyInfo.setTechnologyDescription(eimsTechnologyInfo.getTechnologyDescription());
	        } else {
	            // Retain previous value
	        	log.error("Technology Description1 "+eimsCompanyDetailsDto.getTechnologyDescription());
	        	eimsTechnologyInfo.setTechnologyDescription(eimsCompanyDetailsDto.getTechnologyDescription());
	        }

	        if (eimsCompanyDetailsDto.getFlag().equals("") ) {
	        	log.info("Flag "+eimsTechnologyInfo.getFlag());
	        	eimsTechnologyInfo.setFlag(eimsTechnologyInfo.getFlag());
	        } else {
//	             Retain previous value
	        	log.error("Flag1 "+eimsCompanyDetailsDto.getFlag());
	        	eimsTechnologyInfo.setFlag(eimsCompanyDetailsDto.getFlag());
	        }

	        // Set updated date
	        eimsTechnologyInfo.setUpdatedDate(new Date());
			log.info("child table updated");
			
		}
		try {
			eimsCompanyDetailsDao.updateModel(eimsCompanyInfo);
			eimsCompanyDetailsDao.updateModel(eimsTechnologyInfo);
			res="updated";
		} catch (DataAccessException | SQLException e) {
			res="not updated";
			log.error("not updated ",e);
		}
		return res;
	}
	@Override
	public String deleteCompanyDetails(int id) {
		log.info("inside the service class");
		return eimsCompanyDetailsDao.deleteModel(id);

	}

	@Override
	public EimsCompanyInfo fetchEimsCompanyInfo1(int id) {
		log.info("inside service class");
		return eimsCompanyDetailsDao.fetchEimsCompanyInfo(id);
	}

}
