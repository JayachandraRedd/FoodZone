package com.cassini.foodzone.util;

import java.util.Random;

public class GeneratePassword {
	
	public String generatePasscode() {
		StringBuilder passcode = new StringBuilder();
		for(int i=0 ;i<10;i++) {
			char c = (char) (new Random().nextInt(25)+'a');
			passcode.append(c);
			
		}
		return passcode.toString();

	}
	
}
