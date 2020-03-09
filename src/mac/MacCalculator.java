
package mac;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class MacCalculator {

	public static String calculateMac (String hash, String token) {

		int challenge;
		challenge = calculateChallenge(token, hash.length());
		String hashc1;
		String hashc2;
		if(challenge != 0) {
		hashc1 = hash.substring(0, challenge-1);
		hashc2 = hash.substring(challenge - 1, hash.length());
		}else {
			return hash + token;

		}
		return hashc1 + token + hashc2;

	}

	//for testing purposes
	private static String generateHash(final String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes());

		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

	//for testing purposes
	private static String generateToken() {
		SecureRandom random = new SecureRandom();
		String text = new BigInteger(130, random).toString(10);
		return text;
	}
	
	private static int calculateChallenge (String token, int lengthmax) {
		 int largo=token.length();
		 int suma = 0;
	     
	      for(int i=0; i<largo; i++){
	         if (Character.isDigit(token.charAt(i))){ 
	        	 char number = token.charAt(i);
	        	 int intnumber = Character.getNumericValue(number);
	            suma = suma + intnumber;
	         } 
	       }
	      
	      int res = suma % lengthmax;
		return res;	     
	    }

}
