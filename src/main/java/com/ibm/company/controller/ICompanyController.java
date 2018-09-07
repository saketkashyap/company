package com.ibm.company.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.company.entities.Company;

@RequestMapping("/company")
public interface ICompanyController {

	@RequestMapping(value="/all",method=RequestMethod.GET)
	public  ResponseEntity<List<Company>>getAllCompanies();
	@RequestMapping(value="/id/{id}",method=RequestMethod.GET)
	public ResponseEntity<Company> getCompanyByCompanyId(@PathVariable("id") Integer id);
	@RequestMapping(value="/code/{code}",method=RequestMethod.GET)
	public ResponseEntity<Company> getCompanyByCompanyCode(@PathVariable("code") Integer code);
}
