package com.ibm.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.company.entities.Company;
import com.ibm.company.repository.ICompanyRepository;
import com.ibm.company.service.ICompanyService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author saket
 * This is the implementation class for ICompanyService. Talks to the repository Interface to get 
 * Company Information
 */
@Service
@Slf4j
public class CompanyServiceImpl implements ICompanyService {

	final String className = CompanyServiceImpl.class.toString();
	@Autowired
	ICompanyRepository companyRepository;
	
	/**
	 * Gets the list of all the companies from the database. 
	 */
	@Override
	public List<Company> getAllCompanies() {
		String methodName = "getAllCompanies()";
		log.info(className+","+methodName);
		return companyRepository.findAll();
		
	}

	
	/**
	 * Gets the company information from repository interface based on auto generated Id
	 */
	@Override
	public Company getAllCompaniesById(Integer id) {
		String methodName = "getAllCompaniesById(Integer id)";
		log.info(className+","+methodName);
		log.debug("id value is::"+id);
		return companyRepository.findCompanyById(id.longValue());
	}

	/**
	 * Gets the company information from repository interface based on company code
	 */
	@Override
	public Company getAllCompaniesByCode(Integer code) {
		String methodName = "getAllCompaniesById(Integer id)";
		log.info(className+","+methodName);
		log.debug("company code  is::"+code);
		return companyRepository.findCompanyByCode(code.longValue());
	}

}
