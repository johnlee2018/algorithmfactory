package com.ljc.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util{
	
	
	public static  String MD5Encode (String string) {
		//protected String MD5Encode (String string) {	
		try {
			byte[] btInput = string.getBytes();
			MessageDigest md5Instance=MessageDigest.getInstance("md5");
			
			md5Instance.update(btInput);
			byte[] md = md5Instance.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            
            return new String(str);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("md5º”√‹ ß∞‹ ! ! ");
			return null;
		}
		
	}
	//test the func;
    public static void main(String[] args) {
        System.out.println(MD5Util.MD5Encode("lee234123456"));
        System.out.println(MD5Util.MD5Encode("lee345123456"));
        System.out.println(MD5Util.MD5Encode("lee456123456"));   
    }
}