package com.amit;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;

/**
*
* @author Amit Patil
*
**/
public class TestJCEUnlimitedStength {

//	If the JCE Unlimited strengh policy files are installed correctly
//	Then we would get the output: 2147483647
//	Otherwise we would get output: 128
	public static void main(String[] args) {
		int maxKeyLen = 0;
		try {
			maxKeyLen = Cipher.getMaxAllowedKeyLength("AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	    System.out.println(maxKeyLen);
	}

}
