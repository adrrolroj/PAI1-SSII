package main;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.TreeMap;

import dataStructure.ReadFromMapFile;
import hash.VerificationHash;
import mac.MacCalculator;

public class CheckClientFile {

	public static HashMap<String, String> checkClientFile(String fichero, String token, String hash) throws FileNotFoundException {
		HashMap<String, String> res = new HashMap<String, String>();
		//paso 1: Compruebo el archivo en la estructura de datos:
		TreeMap<String, String> treeMap = ReadFromMapFile.readFromFile("dss_map.txt");
		String hash_fichero = "";
		hash_fichero = treeMap.get(fichero);
		
		if(hash_fichero == "") {
			res.put("hash", hash_fichero);
			res.put("mac", "VERIFICATION_FAILED_NOT_FOUND");
			return res;

		}
		
		//paso 2: Compruebo el hash que tengo con el que me pasan y con las retinas
		
		int containersBad = VerificationHash.verificateAllContainer(fichero, hash);
		if(containersBad == 3) {
			res.put("hash", hash_fichero);
			res.put("mac", "VERIFICATION_FAILED_HASH_NOT_EQUAL_ON_3_CONTAINERS");
			return res;
		}
		
		//Paso 3: calculo el MAC y devuelvo
		
		String mac;
		
		mac = MacCalculator.calculateMac(hash, token);
		
		res.put("hash", hash_fichero);
		res.put("mac", mac);
		
		
		
		return res;
	}
}
