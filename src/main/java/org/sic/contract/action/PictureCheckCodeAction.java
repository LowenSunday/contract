package org.sic.contract.action;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.sic.contract.tool.IdentifyingCode;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PictureCheckCodeAction extends ActionSupport
{
  	
  /**
	 * 
	 */
	private static final long serialVersionUID = -1514571661421839049L;
	private ByteArrayInputStream inputStream;
	
	public String execute() throws Exception{
		init();
		return SUCCESS;
	} 
	
	public void setInputStream(ByteArrayInputStream inputStream) {    
		this.inputStream = inputStream;    
	}  
	
	public ByteArrayInputStream getInputStream() {    
		return inputStream;    
	}   


	private void init()throws Exception
  {
	 HttpServletResponse response= ServletActionContext.getResponse();
	 HttpServletRequest request=ServletActionContext.getRequest();
	 //设置不缓存图片  
     response.setHeader("Pragma", "No-cache");  
     response.setHeader("Cache-Control", "No-cache");  
     response.setDateHeader("Expires", 0) ;  
     //指定生成的相应图片  
     response.setContentType("image/jpeg") ;
     IdentifyingCode idCode = new IdentifyingCode();  
     BufferedImage image =new BufferedImage(idCode.getWidth() , idCode.getHeight() , BufferedImage.TYPE_INT_BGR) ;  
     Graphics2D g = image.createGraphics() ;  
     //定义字体样式  
     Font myFont = new Font("黑体" , Font.BOLD , 16) ;  
     //设置字体  
     g.setFont(myFont) ;  
       
     g.setColor(idCode.getRandomColor(200 , 250)) ;  
     //绘制背景  
     g.fillRect(0, 0, idCode.getWidth() , idCode.getHeight()) ;  
       
     g.setColor(idCode.getRandomColor(180, 200)) ;  
     idCode.drawRandomLines(g, 160) ;  //画线
     String str=idCode.drawRandomString(4, g) ;//在g上写字符，验证码长度为4
     ActionContext.getContext().getSession().put("random",str);
     System.out.println("in PictureCheckCodeAction str is: "+str);
     g.dispose() ;//releases any system resources that it is using. A Graphics object cannot be used after disposehas been called.  
     
     ByteArrayOutputStream bos=new ByteArrayOutputStream();
     //ImageIO.write(image, "JPEG", response.getOutputStream());
     ImageIO.write(image, "JPEG", bos);
     bos.close();    
     inputStream = new ByteArrayInputStream(bos.toByteArray());   
  }
}
