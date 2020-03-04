package dataStructure;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class GenerateMapFile {

	public static void exportNewTreeMap(TreeMap<String, String> map) throws IOException {
		String fileName = "map"+String.valueOf("01.txt");
		FileWriter fstream = new FileWriter(fileName);
		File f = new File (fileName);
		BufferedWriter out = new BufferedWriter(fstream);
		for (Map.Entry<String, String> entry : map.entrySet()) {

		     try {
				out.write(entry.getKey() + "\t" + entry.getValue()+ "\n");
				out.flush();   // Flush the buffer and write all changes to the disk
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		
	}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(f.getAbsolutePath());
	}
}
