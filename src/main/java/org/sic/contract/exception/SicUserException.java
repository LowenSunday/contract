package org.sic.contract.exception;

public class SicUserException extends SicException {
	private static final long serialVersionUID = 2689113786950473625L;
	
	public static SicUserException USER_EXIST_EXCEPTION = new SicUserException("�û����Ѿ�����");
	
	public static SicUserException USER_NOTEXIST_EXCEPTION = new SicUserException("�û���������");
	
	public SicUserException(String message) {
		super(message);
	}

}
