package com.enterprise.company.Service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.enterprise.company.Dto.EimsCompanyDetailsDto;
import com.enterprise.company.Dto.EimsCompanyFetchDetailsDto;
import com.enterprise.company.schema.EimsCompanyInfo;
@Service
@Transactional
public interface EimsCompanyDetailsService {
	
	String saveCompanyDetails(EimsCompanyDetailsDto eimsCompanyDetailsDto);
	
	EimsCompanyFetchDetailsDto fetchTheUserDetails(int id);

	String updateTheCompanyDetailsById(EimsCompanyDetailsDto eimsCompanyDetailsDto);
	
	String deleteCompanyDetails(int id);
	
	EimsCompanyInfo fetchEimsCompanyInfo1(int id);
}
