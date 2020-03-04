package generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class RandomTests {

	public static void main (String[] args) throws IOException {
		
		TreeMap<String, String> sortMap = new TreeMap<String, String>();
		String fileName = "map"+String.valueOf("01.txt");
		FileWriter fstream = new FileWriter(fileName);
		BufferedWriter out = new BufferedWriter(fstream);
		File f = new File (fileName);
		for (Map.Entry<String, String> entry : sortMap.entrySet()) {
		     try {
				out.write(entry.getKey() + "\t" + entry.getValue());
				out.flush();   // Flush the buffer and write all changes to the disk
		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		System.out.println(f.getAbsolutePath());
		
	}
	}
