package org.sic.contract.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.sic.contract.entity.Contract;
import org.sic.contract.entity.User;
import org.sic.contract.service.ContractService;
import org.sic.contract.service.UserService;
import org.sic.contract.tool.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommitContractAction extends ActionSupport implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6270172718832095815L;
	 //private ServletContext sc;
	 //private String savePath;
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
		HttpServletRequest request=ServletActionContext.getRequest();
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
        //if file is exists in table
        if(contractService.addContract(contract)==false)
        {
        	//关闭输入流   
            is.close();   
            //关闭输出流   
            os.close();   
            
            request.setAttribute("upload_message", "文件已经存在！");
            return SUCCESS;
        }
        else
        {
        //System.out.println("上传用户"+username);   
        System.out.println("upload File Name is : "+myFileFileName);   
        System.out.println("upload File Type is : "+myFileContentType);
        System.out.println("File MD5 is :"+MD5Util.getFileMD5String(myFile));
        System.out.println("upload File time is:"+contract.getCreateTime());
        //关闭输入流   
        is.close();   
        //关闭输出流   
        os.close();   
        request=ServletActionContext.getRequest();
        request.setAttribute("upload_message", "上传文件成功！");
        return SUCCESS;
        }

	}
	
	public void validate()
	   {
		  
		  
	   }

}
