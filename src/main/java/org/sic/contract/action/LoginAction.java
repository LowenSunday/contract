package org.sic.contract.action;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.sic.contract.entity.User;
import org.sic.contract.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements Serializable

{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5210934955750259107L;
	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	private UserService userSerivce;
	
	private  String userName;
	
	private String password;
	
	
	private String validatecode;
	
	private User user;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValidatecode() {
		return validatecode;
	}
	public void setValidatecode(String validatecode) {
		this.validatecode = validatecode;
	}
	public String execute() throws Exception
	{
		String validateString;
		//获取session中的验证码：validateString
		validateString=(String)ServletActionContext.getRequest().getSession().getAttribute("random");
		//validateString =(String)ActionContext.getContext().getSession().get("random");	
		if(userSerivce.exists(userName))
		{
			user=userSerivce.findUserByName(userName);
			if(this.password.equals(user.getPassword()))
			{
				if(validatecode.equalsIgnoreCase(validateString))
				{
					//If login Success,put userName to session
				    ActionContext.getContext().getSession().put("userName", userName);
					
			        return SUCCESS;
				}
				else
				{
					this.addFieldError("validatecode", "验证码错误");
					return INPUT;
				}
			}
			else
			{
				this.addFieldError("password", "密码错误");
				return INPUT;
			}
		}
		else
		{
			this.addFieldError("userName", "用户名不存在");
			return INPUT;
		}
		
	}
      
}
