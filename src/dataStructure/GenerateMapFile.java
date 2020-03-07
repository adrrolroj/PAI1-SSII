package dataStructure;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import hash.Hashing;

public class GenerateMapFile {

	public static void exportNewTreeMap(TreeMap<String, String> map) throws IOException {
		String fileName = "dss_map.txt";
		FileWriter fstream = new FileWriter(fileName);
		File f = new File (fileName);
		BufferedWriter out = new BufferedWriter(fstream);
		for (Map.Entry<String, String> entry : map.entrySet()) {

		     try {
				out.write(entry.getKey() + "\t" + entry.getValue()+ "\n");
				out.flush();
		 } catch (IOException e) {
				e.printStackTrace();
			}
	}
		try {
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		String ruta = f.getAbsolutePath();
		generateSHAfromExportedMap(ruta);
	}
	
	public static void generateSHAfromExportedMap(String ruta) throws IOException {
		String hash = Hashing.hash(ruta);
		String fileName = "hash_dss_map.txt";
		FileWriter fstream = new FileWriter(fileName);
		BufferedWriter out = new BufferedWriter(fstream);

		try {
			out.write(hash);
			out.flush();
			out.close();

	 } catch (IOException e) {
			e.printStackTrace();
		}
	}

}
