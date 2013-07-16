package org.sic.contract.action;

import java.io.Serializable;
import java.util.List;

import org.sic.contract.entity.Contract;
import org.sic.contract.persistence.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4165809736312638654L;

	/**
	 * @param args
	 */
	@Autowired
	private ContractMapper contractMapper;
	public  void funA()throws Exception{
		contractMapper=ContractMapper.class.newInstance();
		List<Contract> list=contractMapper.findByContractName("db");
		System.out.println(list.size());
	}
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        new TestAction().funA();
	}

}
