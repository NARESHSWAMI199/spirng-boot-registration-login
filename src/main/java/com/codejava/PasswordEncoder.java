
package com.codejava;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rowPassword = "naresh";
		String encodedPassword = encoder.encode(rowPassword);
		
		System.out.println("encodePassword : " + encodedPassword);
	}

}
