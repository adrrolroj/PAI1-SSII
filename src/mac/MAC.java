
package mac;

import java.math.BigInteger;
import java.security.SecureRandom;

public class MAC {

	public static void main(final String[] args) {
		System.out.println("Token: " + MAC.generateRandomText());

	}

	public static String generateRandomText() {
		SecureRandom random = new SecureRandom();
		String text = new BigInteger(130, random).toString(32);
		return text;
	}

}
