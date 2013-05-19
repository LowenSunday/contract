package org.sic.contract.exception;

public class SicUserException extends SicException {
	private static final long serialVersionUID = 2689113786950473625L;
	
	public static SicUserException USER_EXIST_EXCEPTION = new SicUserException("用户名已经存在");
	
	public static SicUserException USER_NOTEXIST_EXCEPTION = new SicUserException("用户名不存在");
	
	public SicUserException(String message) {
		super(message);
	}

}
