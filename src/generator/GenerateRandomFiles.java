
package generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateRandomFiles {

	public static void generateRandomFiles(final Integer numFiles) {
		for (int i = 0; i < numFiles; i++) {
			try {
				String randomName = GenerateRandomFiles.randomString(8) + ".txt";
				String randomContend = GenerateRandomFiles.randomString(64);
				String container1 = "Contenedor1/" + randomName;
				String container2 = "Contenedor2/" + randomName;
				String container3 = "Contenedor3/" + randomName;
				FileWriter fileWrite = new FileWriter(container1);
				BufferedWriter buffWrite = new BufferedWriter(fileWrite);
				buffWrite.write(randomContend);
				buffWrite.close();
				FileWriter fileWrite2 = new FileWriter(container2);
				BufferedWriter buffWrite2 = new BufferedWriter(fileWrite2);
				buffWrite2.write(randomContend);
				buffWrite2.close();
				FileWriter fileWrite3 = new FileWriter(container3);
				BufferedWriter buffWrite3 = new BufferedWriter(fileWrite3);
				buffWrite3.write(randomContend);
				buffWrite3.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static String randomString(final Integer lenght) {
		String res = "";
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = lenght;
		Random random = new Random();

		res = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return res;
	}

}
