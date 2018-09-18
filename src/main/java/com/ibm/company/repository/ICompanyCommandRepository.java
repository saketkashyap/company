package com.ibm.company.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.company.entities.Company_Emp_Commands;

@Repository
public interface ICompanyCommandRepository extends JpaRepository<Company_Emp_Commands, Serializable>{

}
