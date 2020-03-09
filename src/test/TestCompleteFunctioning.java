package test;

import java.io.IOException;
import java.util.Map;

import hash.Hashing;
import main.CheckClientFile;

public class TestCompleteFunctioning {

	
	public static void main (String[] args) throws IOException {
		String hash = "17a78ce7b3109f44c0939d024b6666b8745158a3e8c4aadab8227b1cd886c4e1";
		Map<String, String> res = CheckClientFile.checkClientFile("aieidray.txt", "1234", hash);
	
		String res2 = res.get("mac");
		
		System.out.println(res2);
		
	}
}
