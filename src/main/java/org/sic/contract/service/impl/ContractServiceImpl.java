package org.sic.contract.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.sic.contract.entity.Contract;
import org.sic.contract.entity.Sequence;
import org.sic.contract.entity.User;
import org.sic.contract.exception.SicContractException;
import org.sic.contract.exception.SicException;
import org.sic.contract.persistence.ContractMapper;
import org.sic.contract.persistence.SequenceMapper;
import org.sic.contract.persistence.UserMapper;
import org.sic.contract.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;

public class ContractServiceImpl implements ContractService{
	private static Logger logger = Logger.getLogger(ContractServiceImpl.class);
	@Autowired
	private ContractMapper contractMapper;
	@Autowired
	private SequenceMapper sequenceMapper;
	@Autowired
	private UserMapper userMapper;
	@Override
	public boolean addContract(Contract contract) throws SicException
	{
		//contractMapper.insert(contract);
		
		if(contractMapper.findByMD5(contract.getMd5())==null)
		{
			try{
				Long id = sequenceMapper.getId("contractId");
		        contract.setId(id);
                contractMapper.insert(contract);
				
				Sequence sequence = new Sequence();
				sequence.setName("contractId");
				sequence.setValue(id + 1);
				sequenceMapper.setId(sequence);
			}catch(Exception e){
				logger.error("添加合同错误:\n" + e.getMessage());
				throw new SicContractException(e.getMessage());
			}
			return true;
		}
		else
		{   
			logger.error("合同已经存在:\n" + SicContractException.Contract_EXIST_EXCEPTION.getMessage());
			return false;
			//throw SicContractException.Contract_EXIST_EXCEPTION;
		}
	}
	
	public int  verifyContract(Contract contract)
	{
		Contract contract_server;
		contract_server=contractMapper.findByMD5(contract.getMd5());
		//if contract_server exists 
		if(contract_server!=null)
		{
			//contract_server name is same with contract
			if(contract_server.getContractName().equals(contract.getContractName()))
			{
				return 0;
			}
			//contract_server name is not same with contract
			else
				return 1;
		}
		//else contract_server not exists 
		else
		{
			return 2;
		}
	}
	
	
	public List<Contract> getContractByUserName(String userName)
	{
		List<Contract> contract_list=new ArrayList<Contract>();
		User user=userMapper.findByName(userName);
		System.out.println(user.getCompanyId());
		contract_list=contractMapper.queryInitiatedByCompanyId(userMapper.findByName(userName).getCompanyId());
		return contract_list;
	}
	

}
