package org.sic.contract.persistence;

import java.util.List;

import org.sic.contract.entity.Contract;

public interface ContractMapper {
	void insert(Contract contract);
	
	Contract findById(Long id);
	
	Contract findByMD5(String md5);
	
	List<Contract> findByContractName(String contractName);
	
	List<Contract> queryInitiatedByCompanyId(Long companyId);
	
	List<Contract> querySignedByCompanyId(Long companyId);
	
	void update(Contract contract);
	
	void deleteById(Long id);
	
	
}
