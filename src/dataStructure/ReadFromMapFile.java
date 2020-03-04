package dataStructure;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeMap;

public class ReadFromMapFile {

	public static String getHashFromNameFile(String nameFile) throws FileNotFoundException {
		TreeMap<String, String> map = readFromFile("map01.txt");
		return returnHashFromNameFile(nameFile, map);
		
	}
	
	private static TreeMap<String, String> readFromFile (String ruta) throws FileNotFoundException{
	    Scanner scanner = new Scanner(new FileReader(ruta));

	    TreeMap<String, String> map = new TreeMap<String, String>();


	    while (scanner.hasNextLine()) {

	        String lineToProcess = scanner.nextLine();

	        String[] columns = lineToProcess.split("	");
	        map.put(columns[0],columns[1]);
	        }

	    scanner.close();
	    return map;
	    }
	
	private static String returnHashFromNameFile(String namefile, TreeMap<String, String> map) {
		String hash = map.get(namefile);
		return hash;
	}

}
