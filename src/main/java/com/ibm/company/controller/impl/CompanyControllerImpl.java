package com.ibm.company.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.company.controller.ICompanyController;
import com.ibm.company.entities.Company;
import com.ibm.company.service.ICompanyService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author saket
 *  This is the implementation of class of the IcompanyController.
 */
@RestController
@Slf4j
public class CompanyControllerImpl implements ICompanyController {

	@Autowired
	ICompanyService companyService;
	
	final String className = CompanyControllerImpl.class.toString();
	
	/**
	 * Returns the list of all the companies from the database
	 */
	@Override
	public ResponseEntity<List<Company>> getAllCompanies() {
		String methodName = "getAllCompanies()";
		log.info(className+","+methodName);
		HttpStatus status = HttpStatus.FOUND;
		List<Company> compList = companyService.getAllCompanies();
		if(compList.size() <0)
		{
			status = HttpStatus.NOT_FOUND;
		}
		return ResponseEntity.status(status).body(compList);
	}

	/**
	 * Returns the company details based on autoGenerated Id.
	 * 	
	 */
	@Override
	public ResponseEntity<Company> getCompanyByCompanyId(@PathVariable Integer id) {
		String methodName = "getCompanyByCompanyId(Integer id)";
		log.info(className+","+methodName);
		HttpStatus status = HttpStatus.FOUND;
		Company comp = companyService.getAllCompaniesById(id);
		if(comp == null)
		{
			status= HttpStatus.NOT_FOUND;
		}
		return ResponseEntity.status(status).body(comp);
	}

	/**
	 * Returns the company details based on autoGenerated Id.
	 */
	@Override
	public ResponseEntity<Company> getCompanyByCompanyCode(@PathVariable Integer code) {
		String methodName = "getCompanyByCompanyCode(Integer code)";
		log.info(className+","+methodName);
		HttpStatus status = HttpStatus.FOUND;
		Company comp = companyService.getAllCompaniesByCode(code);
		if(comp == null)
		{
			status= HttpStatus.NOT_FOUND;
		}
		return ResponseEntity.status(status).body(comp);
	}

}