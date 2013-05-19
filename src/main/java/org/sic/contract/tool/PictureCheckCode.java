package org.sic.contract.tool;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PictureCheckCode extends HttpServlet
{
	//final static Logger logger=Logger.getLogger(PictureCheckCode.class);
	public PictureCheckCode() {  
        super();  
    }  
    public void init() throws ServletException {  
        super.init() ;  
    }  
    public void destroy() {  
        super.destroy();   
    }  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request, response) ;  
  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
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
        HttpSession session=request.getSession();
        session.setAttribute("validateString", str);//将str放入session中，以便比较用户输入的验证码
        System.out.println("in PictureCheckCode str is"+str);
        g.dispose() ;//releases any system resources that it is using. A Graphics object cannot be used after disposehas been called.  
        ImageIO.write(image, "JPEG", response.getOutputStream());  
    }  

}
