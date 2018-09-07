package com.ibm.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.ibm.company.entities.Company;

/**
 * 
 * @author saket
 *  This is the repository Interface of Type company. Connects to the database to get
 *  all the company information based on certain conditions
 */
@Repository
public interface ICompanyRepository extends JpaRepository<Company, ID> {

	@Query("select c from Company c where c.id= :id")
	public Company findCompanyById(@Param("id") long id);
	
	@Query("select c from Company c where c.companycode= :code")
	public Company findCompanyByCode(@Param("code") long code);
}
