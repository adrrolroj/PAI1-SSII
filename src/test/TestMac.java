package test;

import mac.MacCalculator;

public class TestMac {

	public static void main (String[] args) {
		String token  =  "1134";
		
		String hash = "1a4bwehf";
				
		System.out.println(MacCalculator.calculateMac(hash, token));
	}
}
