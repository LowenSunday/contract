package org.sic.contract.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.sic.contract.entity.Contract;
import org.sic.contract.entity.User;
import org.sic.contract.service.ContractService;
import org.sic.contract.service.UserService;
import org.sic.contract.tool.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class VerifyContractAction extends ActionSupport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5316821251800856535L;
	@Autowired
	private UserService userSerivce;
	@Autowired
	private ContractService contractService;
	 // myFile属性用来封装上传的文件   
    private File myFile;   
       
    // myFileContentType属性用来封装上传文件的类型   
    private String myFileContentType;   
  
    // myFileFileName属性用来封装上传文件的文件名   
    private String myFileFileName;   

	 private String fileIntroduction;
	 
	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getFileIntroduction() {
		return fileIntroduction;
	}

	public void setFileIntroduction(String fileIntroduction) {
		this.fileIntroduction = fileIntroduction;
	}

	public String execute()throws Exception
	{
		//基于myFile创建一个文件输入流   
        InputStream is = new FileInputStream(myFile);   
           
        // 设置上传文件目录   
        String uploadPath = ServletActionContext.getServletContext()   
                .getRealPath("/")+"upload_file";   
           
        // 设置目标文件   
        File toFile = new File(uploadPath, this.getMyFileFileName());   
           
        // 创建一个输出流   
        OutputStream os = new FileOutputStream(toFile);   
  
        //设置缓存   
        byte[] buffer = new byte[1024];   
  
        int length = 0;   
  
        //读取myFile文件输出到toFile文件中   
        while ((length = is.read(buffer)) > 0)
        {   
            os.write(buffer, 0, length);   
        }
        //get Company ID  by userName
        String userName=(String)ActionContext.getContext().getSession().get("userName");
        User user=userSerivce.findUserByName(userName);
        Long ComanyID=user.getCompanyId();
        //add Contract to table TBL_Contract
        Contract contract=new Contract();
        contract.setContractName(myFileFileName);
        contract.setCreateTime(DateFormat.getDateTimeInstance().format(new Date()));
        contract.setFileUri(uploadPath);
        contract.setMd5(MD5Util.getFileMD5String(myFile));
        contract.setId(0L);
        
        HttpServletRequest request=ServletActionContext.getRequest();
        
        //if file is exists in table, false:MD5 value is same with table
        //0:contract_server name is same with contract
        if(contractService.verifyContract(contract)==0)
        {
        	request.setAttribute("verify_message", "文件内容未被改动，文件已经存在！");
        }
        //1:contract_server name is not same with contract
        else if(contractService.verifyContract(contract)==1)
        {
        	request.setAttribute("verify_message", "文件内容未被改动，但文件名不一致");
        }
        //2 MD5 not exists in server.
        else
        {
        	request.setAttribute("verify_message", "该文件不存在！");
        }
        
        //关闭输入流   
        is.close();   
        //关闭输出流   
        os.close();   
        return SUCCESS;
        
        
        
	}

}
