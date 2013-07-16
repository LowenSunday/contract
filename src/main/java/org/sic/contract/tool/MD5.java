package org.sic.contract.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class MD5 {
static final Logger logger=Logger.getLogger(MD5.class);
	
	public static String generateMD5Code(String password)
	{
		 String s=password;
			if(s==null){
				return "";
			}else{
				String value = null;
				//信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。 
				MessageDigest md5 = null;
				try {
					md5 = MessageDigest.getInstance("MD5");
					}catch (NoSuchAlgorithmException ex) {
						logger.debug(Level.INFO, ex);
						}
				sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder();
				try {
					//先md5加密，再进行base64编码
					value = baseEncoder.encode(md5.digest(s.getBytes("utf-8")));
					} catch (Exception ex) {
					}
				return value;
				}
	}

}
