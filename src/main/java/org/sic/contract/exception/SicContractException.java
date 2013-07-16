package org.sic.contract.exception;

import java.io.Serializable;

public class SicContractException extends SicException implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5782761290064570974L;
    public static SicContractException Contract_EXIST_EXCEPTION = new SicContractException("合同已经存在");
	public static SicContractException Contract_NOTEXIST_EXCEPTION = new SicContractException("合同不存在");
	public SicContractException(String message)
	{
		super(message);
	}

}
