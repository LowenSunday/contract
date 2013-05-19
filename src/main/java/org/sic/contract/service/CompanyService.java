package org.sic.contract.service;

import java.util.List;

import org.sic.contract.entity.Company;

public interface CompanyService {
	void findById(Long id);
	
	List<Company> queryByName(String companyName);
	
	void addCompany();
	
	void update(Company company);
	
	void deleteCompanyById(Long id);
}
