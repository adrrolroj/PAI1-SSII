
package mac;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class MAC {

	public static void main(final String[] args) throws NoSuchAlgorithmException {

		String hash = MAC.generateHash("Esto es una prueba");
		String token = MAC.generateToken();

		System.out.println("MAC: " + token + "" + hash);

	}

	public static String generateHash(final String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes());

		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

	public static String generateToken() {
		SecureRandom random = new SecureRandom();
		String text = new BigInteger(130, random).toString(10);
		return text;
	}

}
