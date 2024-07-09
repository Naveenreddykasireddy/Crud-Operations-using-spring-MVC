package com.enterprise.company.Controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eims.assignment.Controller.EimsUserDetailsController;
import com.eims.assignment.dto.EimsUserFetchReqDto;
import com.eims.assignment.dto.EimsUserReqDto;
import com.enterprise.company.Dto.EimsCompanyDetailsDto;
import com.enterprise.company.Dto.EimsCompanyFetchDetailsDto;
import com.enterprise.company.Service.EimsCompanyDetailsService;
import com.enterprise.company.schema.EimsCompanyInfo;

@RestController
@RequestMapping("/eimsCompanyDetails")
public class EimsCompanyDetailsController 
{

private static Log log=LogFactory.getLog(EimsUserDetailsController.class);
	
	@Autowired
	private EimsCompanyDetailsService eimsCompanyDetailsService;

	@PostMapping("/saveCompany")
	public String saveCompanyDetails1(@RequestBody EimsCompanyDetailsDto eimsCompanyDetailsDto){
		
		String result = "";
		try{
			log.info("company name :"+eimsCompanyDetailsDto.getCompanyName());
			result=eimsCompanyDetailsService.saveCompanyDetails(eimsCompanyDetailsDto);

			log.info("result :"+result);
		}catch(Exception e){
			log.error("Exception in saveCompanyDetails :"+e);
		}
		return result ;
	}
	
	@GetMapping("/getCompanyById/{companyId}")
	public  EimsCompanyFetchDetailsDto fetchCompanyById(@PathVariable int companyId)
	{
		EimsCompanyFetchDetailsDto eimsCompanyFetchDetailsDto=null;
		eimsCompanyFetchDetailsDto= eimsCompanyDetailsService.fetchTheUserDetails(companyId);
		return eimsCompanyFetchDetailsDto;
	}
	
	@GetMapping("/getCompany")
	public  EimsCompanyFetchDetailsDto fetchCompany(@RequestBody EimsCompanyDetailsDto eimsCompanyDetailsDto)
	{
		EimsCompanyFetchDetailsDto eimsCompanyFetchDetailsDto=null;
		eimsCompanyFetchDetailsDto= eimsCompanyDetailsService.fetchTheUserDetails(eimsCompanyDetailsDto.getCompanyId());
		return eimsCompanyFetchDetailsDto;
	}
	
	@PutMapping("/updateCompany")
	public String updateCompany(@RequestBody EimsCompanyDetailsDto eimsCompanyDetailsDto)
	{
		log.info("success");
		return eimsCompanyDetailsService.updateTheCompanyDetailsById(eimsCompanyDetailsDto);

	}
	
	@DeleteMapping("/deleteCompany")
	public String deletedUser(@RequestBody EimsCompanyDetailsDto eimsCompanyDetailsDto)
	{
		log.info("success");
		return eimsCompanyDetailsService.deleteCompanyDetails(eimsCompanyDetailsDto.getCompanyId());
		
		
	}
	
	 @GetMapping("/fetchUser/{companyId}")
	public EimsCompanyInfo fetchEimsCompanyInfo(@PathVariable int companyId)
	{
		
		log.info("inside controller class");
		return eimsCompanyDetailsService.fetchEimsCompanyInfo1(companyId);
	}
	 
	 
	@RequestMapping("/home.html")
	public ModelAndView home()
	{
		ModelAndView mav=new ModelAndView("enterprise/sampleHome");
		
		
		return mav;
	}
	
	@RequestMapping("/saving")
	public ModelAndView savingCompany()
	{
		ModelAndView mav=new ModelAndView("enterprise/sample");

		return mav;
	}
	
	@RequestMapping("/getting")
	public ModelAndView gettingCompany()
	{
		ModelAndView mav=new ModelAndView("enterprise/sampleGetting");
		
		return mav;
	}
	
	
	@RequestMapping("/updating")
	public ModelAndView updateCompany()
	{
		ModelAndView mav=new ModelAndView("enterprise/sampleUpdating");
 
		return mav;
	}
	
	
	@RequestMapping("/deleting")
	public ModelAndView deleteCompany()
	{
		ModelAndView mav=new ModelAndView("enterprise/sampleDeleting");

	
		return mav;
	}
	
}

