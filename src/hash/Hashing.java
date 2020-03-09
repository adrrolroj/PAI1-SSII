
package hash;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {

	public static String hash(final String fichero) {
		String originalString = Hashing.readFile(fichero);
		String hashHex = "";
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
			hashHex = Hashing.bytesToHex(encodedhash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashHex;
	}

	public static String readFile(final String fichero) {
		String res = "";
		try {
			File file = new File(fichero);
			FileReader fileRead;
			fileRead = new FileReader(file);
			BufferedReader br = new BufferedReader(fileRead);
			String linea;
			while ((linea = br.readLine()) != null) {
				if (res.equals("")) {
					res = res + linea;
				} else {
					res = res + "\n" + linea;
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

	private static String bytesToHex(final byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (byte element : hash) {
			String hex = Integer.toHexString(0xff & element);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
