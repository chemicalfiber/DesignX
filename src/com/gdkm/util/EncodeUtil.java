package com.gdkm.util;

/**
 * 编码工具类
 */
public class EncodeUtil {	
	//编码为utf8
	public static String IsoToUtf8(String str){
		try{
			String strOld=str;
			byte[] bytes=strOld.getBytes("ISO8859-1");
			String strNew=new String(bytes,"UTF-8");
			return strNew;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
