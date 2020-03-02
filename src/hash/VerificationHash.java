
package hash;

public class VerificationHash {

	public static boolean verificate(final String file, final String hash) {
		boolean res = false;
		String calculatedHash = Hashing.hash(file);
		if (calculatedHash.equals(hash)) {
			res = true;
		}
		return res;
	}

	public static boolean verificateAllContainer(final String file, final String hash) {
		boolean res = false;
		String container1 = "Contenedor1/" + file;
		String container2 = "Contenedor2/" + file;
		String container3 = "Contenedor3/" + file;
		String calculatedHash1 = Hashing.hash(container1);
		if (calculatedHash1.equals(hash)) {
			res = true;
		} else {
			System.out.println("File " + file + " in container 1 contains an integrity failure.");
		}
		String calculatedHash2 = Hashing.hash(container2);
		if (calculatedHash2.equals(hash)) {
			res = true;
		} else {
			System.out.println("File " + file + " in container 2 contains an integrity failure.");
		}
		String calculatedHash3 = Hashing.hash(container3);
		if (calculatedHash3.equals(hash)) {
			res = true;
		} else {
			System.out.println("File " + file + " in container 3 contains an integrity failure.");
		}
		return res;
	}
}
