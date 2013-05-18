package org.sic.contract.persistence;

import org.sic.contract.entity.Company;

public interface CompanyMapper {
	Company findById(Long id);
	
	void insert(Company company);
	
	void update(Company company);
	
	void deleteById();
}
