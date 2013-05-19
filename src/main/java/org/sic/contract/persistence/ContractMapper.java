package org.sic.contract.persistence;

import java.util.List;

import org.sic.contract.entity.Contract;

public interface ContractMapper {
	void insert();
	
	Contract findById();
	
	List<Contract> queryInitiatedByCompanyId(Long companyId);
	
	List<Contract> querySignedByCompanyId(Long companyId);
	
	void update(Contract contract);
	
	void deleteById(Long id);
}
