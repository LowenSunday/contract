package org.sic.contract.service;

import java.util.List;

import org.sic.contract.entity.Contract;
import org.sic.contract.exception.SicException;

public interface ContractService {
	boolean addContract(Contract contract)throws SicException;
	int  verifyContract(Contract contract);
	List<Contract> getContractByUserName(String userName);
	

}
