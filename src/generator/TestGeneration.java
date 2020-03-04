package generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

import hash.Hashing;

public class TestGeneration {

	public static void main (String[] args) throws IOException {
		GenerateRandomFiles.generateRandomFiles(5);
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
