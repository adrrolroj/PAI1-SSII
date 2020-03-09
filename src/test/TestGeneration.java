package test;

import java.io.IOException;

import generator.GenerateRandomFiles;

public class TestGeneration {

	public static void main (String[] args) throws IOException {
		GenerateRandomFiles.generateRandomFiles(2);
	}

}
