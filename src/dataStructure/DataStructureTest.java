package dataStructure;

import java.io.FileNotFoundException;

public class DataStructureTest {

	public static void main(String[] args) throws FileNotFoundException {

		String hash = ReadFromMapFile.getHashFromNameFile("cmnvkcmc.txt");
		System.out.println(hash);
	}

}
