
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
	// 0 no hay fallos de integridad, 1 falla en 1 contenedor, 2 en 2, 3 NO HAY INTEGRIDAD
	public static int verificateAllContainer(final String file, final String hash) {
		int res = 0;
		String container1 = "Contenedor1/" + file;
		String container2 = "Contenedor2/" + file;
		String container3 = "Contenedor3/" + file;
		String calculatedHash1 = Hashing.hash(container1);
		if (!calculatedHash1.equals(hash)) {
			res = res + 1;
		}
		String calculatedHash2 = Hashing.hash(container2);
		if (!calculatedHash2.equals(hash)) {
			res = res + 1;
		}
		String calculatedHash3 = Hashing.hash(container3);
		if (!calculatedHash3.equals(hash)) {
			res = res + 1;
		}
		return res;
	}
}
