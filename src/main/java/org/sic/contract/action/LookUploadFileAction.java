package org.sic.contract.action;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.sic.contract.entity.Contract;
import org.sic.contract.persistence.ContractMapper;
import org.sic.contract.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LookUploadFileAction extends ActionSupport implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9219898929636233084L;
	static final Logger logger = Logger.getLogger(LookUploadFileAction.class);
	
	@Autowired
	private ContractService contractService;
	@Autowired 
	private ContractMapper contractMapper;
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public static int getNumperpage() 
	{
		return numPerPage;
	}
	private int page;//请求第几页的记录
	final static int numPerPage=5;//每页5条记录
	private int start;//从第start条记录开始读，start值受page影响
	private String sortname;//以sortname排序
	private String action;//CRUD操作
	private String query;//查询内容
	private String qtype;//查询字段
	
	public String execute()throws Exception
	{
		
		
		   HttpServletResponse response=ServletActionContext.getResponse();
		   // response相关处理      
	       response.setHeader("Pragma", "no-cache");   
	       response.setHeader("Cache-Control", "no-cache, must-revalidate");   
	       response.setHeader("Pragma", "no-cache");  
	       response.setContentType("text/html");
	       response.setCharacterEncoding("UTF-8");
	       PrintWriter out=response.getWriter(); 
		   HttpServletRequest request=ServletActionContext.getRequest();
		   //根据查询条件返回文件信息
		   
		   if(this.qtype!=null && this.query!=null && !this.qtype.equals("") && !this.query.equals(""))
		   {
			   List<Contract> list=null;
		       Contract contract=new Contract();
			   int Totalcount=0;
			   logger.info("qtype= "+this.qtype+"::query = "+this.query+"::this.page= "+this.page);
			   //通过文件名(部分或者全部)，查找该文件
			   if(this.qtype.equals("contractName"))
			   {
				   System.out.println("In LookUploadFileAction, this.query = "+this.query);
				   list=contractMapper.findByContractName("%"+this.query+"%");
			   }
			   //通过id,查找该文件
			   if(this.qtype.equals("id"))
			   {
				   if((contractMapper.findById(Long.valueOf(this.query))!=null))
					{
			          contract=contractMapper.findById(Long.valueOf(this.query));
					   logger.info("In LookUploadFile contract name is "+contract.getContractName());
			        }
				   
			   }
			   int count=0;
		       start=0;
		   	   if(page>=1)
		   	    {
		   		 start=(page-1)*numPerPage;
		   	    }
		   	   //if query reuslt is one contract,not List<Contract>
		   	   if(contract.getContractName()!=null)
		   	   {
			   Totalcount=1;
		   	   }
		   	   else if(list!=null && list.size()>0)
		   	   {
		   	   Totalcount=list.size();
		   	   }
			   //所有的信息放入map中
			   Map map = new HashMap();
			   map.put("total", Totalcount);
		       map.put("page", this.page);   
		       List rows=new ArrayList();
		       count=Totalcount-start;
		   	   if(count>5)
		   	    {
		   		 count=5;
		   	    }  
		   
		       for (int i = start; i < start+count; i++) 
		       {
		    	   Map cellMap = new HashMap();
		    	   cellMap.put("id",i+1);
		    	   //if only one Contract
		    	   if(contract.getContractName()!=null)
		    	   {
		    		   cellMap.put("cell",new Object[]{contract.getId(),contract.getContractName(),contract.getCreateTime()});
		    		   logger.info("In LookUploadFileAction  contract id is "+contract.getId());
		    	   }
		    	   // if List<Contract>
		    	   else if(list.size()>0)
		    	   {
		    	        cellMap.put("cell",new Object[]{((Contract)list.get(i)).getId(),((Contract)list.get(i)).getContractName(),((Contract)list.get(i)).getCreateTime()});
		    	   }
		    	   rows.add(cellMap);
		       }
		       map.put("rows", rows);
		       Gson son=new Gson();
		       // 数据JSON格式化
		       String kk=son.toJson(map);
		       logger.info(" kk = "+kk);     
		       //String jsoncallback=request.getParameter("callbackparam");        
		       //out.print(jsoncallback + "([{results:" + kk + "}])");
		       out.print(kk);
		       //out.print(jsoncallback+"("+kk+")");
		       out.flush();
		       out.close();
		   	   return null;
		   }
		   
		   //默认操作，即读取用户信息
		   else
		   {
		   logger.info("in LookUploadFileAction pageNumber is "+page);
	   	   /*
	   	   if(sortname!=null && sortname.equals("id"))
	   	   {
	   		   sortname="id";
	   		   logger.info("sortname is "+sortname);
	   	   }
	   	  */
	       int count=0;
	       start=0;
	   	   if(page>=1)
	   	    {
	   		 start=(page-1)*numPerPage;
	   	    }
	   	   //System.out.println("In UserAdminAction usi==null is "+usi==null);
	       //though userName,get Contract list.
	   	   String userName=(String)ActionContext.getContext().getSession().get("userName");
		   List<Contract> list=contractService.getContractByUserName(userName);
		  
		   //System.out.println("In UserAdminAction list.size() is "+list.size());
		   //总记录数
		   int Totalcount=list.size();
		   //所有的信息放入map中
		   Map map = new HashMap();
		   map.put("total", Totalcount);
	       map.put("page", this.page);   
	       List rows=new ArrayList();
	       count=Totalcount-start;
	   	   if(count>5)
	   	    {
	   		 count=5;
	   	    }  
	   
	       for (int i = start; i < start+count; i++) 
	       {
	    	   Map cellMap = new HashMap();
	    	   cellMap.put("id",i+1);
	    	   //System.out.println("((Map)list.get(i)).get("+"name"+") is "+((Map)list.get(i)).get("name").toString());
	    	   cellMap.put("cell",new Object[]{((Long)list.get(i).getId()),((Contract)list.get(i)).getContractName(),((Contract)list.get(i)).getCreateTime()});
	       	   rows.add(cellMap);
	       }
	       map.put("rows", rows);
	       Gson son=new Gson();
	       // 数据JSON格式化
	       String kk=son.toJson(map);
	       logger.info(" kk = "+kk);
	      
	             
	       //String jsoncallback=request.getParameter("callbackparam");        
	       //out.print(jsoncallback + "([{results:" + kk + "}])");
	       out.print(kk);
	       //out.print(jsoncallback+"("+kk+")");
	       out.flush();
	       out.close();
	   	   return null; 
		   }
	}
	

}
