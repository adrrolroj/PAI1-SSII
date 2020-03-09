package test;

import java.io.IOException;
import java.util.Map;

import generator.GenerateRandomFiles;
import hash.Hashing;
import main.CheckClientFile;

public class TestCompleteFunctioning {

	
	public static void main (String[] args) throws IOException {
//	GenerateRandomFiles.generateRandomFiles(30);
		String hash = "6e823621a38f002bf7468c951c2d124d4f223403643f283585d70f79cdac902d";
		Map<String, String> res = CheckClientFile.checkClientFile("aalelqhj.txt", "ef1w546f41wef1wefw5ef1wefw1e0f5ew6f4wefwe6", hash);
	
		String res2 = res.get("mac");
		String res3 = res.get("hash");
		System.out.println("Hash: " + res3);
		System.out.println("MAC: " + res2);
//		
	}
}
