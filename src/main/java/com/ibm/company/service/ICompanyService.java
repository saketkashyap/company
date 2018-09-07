package com.ibm.company.service;

import java.util.List;

import com.ibm.company.entities.Company;
/**
 * 
 * @author saket
 * Interface for Service class
 */
public interface ICompanyService {

	public List<Company> getAllCompanies();
	public Company getAllCompaniesById(Integer id);
	public Company getAllCompaniesByCode(Integer code);
	
}
