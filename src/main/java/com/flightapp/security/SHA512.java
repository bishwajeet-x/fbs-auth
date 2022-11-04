package com.flightapp.security;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component
public class SHA512 {
	public SHA512() {
		super();
//		System.out.println("Hash Service initialized..");
	}
	
	public String SHA512(String password) {
		String generatedKey=null;
		try{
			MessageDigest algorithm = MessageDigest.getInstance("SHA-512"); 
			algorithm.update(password.getBytes("UTF-8"));
	      	byte[] output = algorithm.digest();	      	
			generatedKey = bytesToHex(output).toLowerCase();
		}catch(Exception e){
			e.printStackTrace();
		}		
		return generatedKey;
	}
	
	public String bytesToHex(byte[] b) {
		char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	    StringBuffer buf = new StringBuffer();
	    for (int j=0; j<b.length; j++) {
	    	buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
	        buf.append(hexDigit[b[j] & 0x0f]);
	    }
	    return buf.toString();
	}
}
