package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.TreeMap;

import dataStructure.ReadFromMapFile;
import generator.GenerateRandomFiles;
import hash.Hashing;
import hash.VerificationHash;

public class TestCheckSomeWrongElemOnce {

	public static void main (String[] args) throws IOException {
		//Generate the files, corrupt as many files as you want, and then check the files
		
		//part1GenerateFiles(1000);
		
		
		part2CheckFiles();

	}
	
	private static void part1GenerateFiles(int number) {
		try {
			GenerateRandomFiles.generateRandomFiles(number);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void part2CheckFiles() throws FileNotFoundException {
		System.out.println("Inicio: " + new Date().toString());

		int archivosCorrectos = 0;
		int archivosVerifFallida = 0;
		int archivosFallido1Contenedor = 0;
		int archivosFallido2Contenedor = 0;

		TreeMap<String, String> map = new TreeMap<String, String>();
		map = ReadFromMapFile.readFromFile("dss_map.txt");

		//Comprobamos integridad de dss_map.txt con su hash en hash_dss_map.txt
		String actualHash = Hashing.hash("dss_map.txt");
		String originalHash = Hashing.readFile("hash_dss_map.txt");
		if (actualHash.equals(originalHash)) {
			Set<String> listaArchivos = map.keySet();

				for (String archivo : listaArchivos) {
					String hashOriginal = map.get(archivo);
					int fallos = VerificationHash.verificateAllContainer(archivo, hashOriginal);
					if (fallos == 0) {
						archivosCorrectos++;
					} else if (fallos == 1) {
						archivosFallido1Contenedor++;
					} else if (fallos == 2) {
						archivosFallido2Contenedor++;
					} else {
						archivosVerifFallida++;
					}

				}
				
			
				System.out.println("Archivos correctos: " + archivosCorrectos);
				System.out.println("Archivos con verificación fallida total: " + archivosVerifFallida);
				System.out.println("Archivos con verificación fallida en 1 contenedor: " + archivosFallido1Contenedor);
				System.out.println("Archivos con verificación fallida en 2 contenedores: " + archivosFallido2Contenedor);
				System.out.println("Fin: " + new Date().toString());
		} else {
			System.out.println("Fallo integridad archivo de datos");
		}
	}
}
