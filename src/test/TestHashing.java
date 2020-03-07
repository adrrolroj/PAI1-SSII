
package test;

import hash.Hashing;
import hash.VerificationHash;

public class TestHashing {

	public static void main(final String[] args) {
		String fichero = "dss_map.txt";
//		boolean ver = VerificationHash.verificateAllContainer(fichero, "35f821c72f5423de9b746a8b87024af39274bbe69fd5adc7ac1bb542e7eb48d3");
//		System.out.println(ver);
		String hash = Hashing.hash(fichero);
		System.out.println(hash);
	}
}
