
package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

import dataStructure.ReadFromMapFile;
import generator.GenerateRandomFiles;
import hash.Hashing;
import hash.VerificationHash;

public class VerificatorForOneMonth {

	public static void main(final String[] args) throws InterruptedException, IOException {
		int dias = 30;
		int archivosCorrectos = 0;
		int archivosVerifFallida = 0;
		int archivosFallido1Contenedor = 0;
		int archivosFallido2Contenedor = 0;
		String archivosFallidos = "";
		String informe = "";
		TreeMap<String, String> map = new TreeMap<String, String>();

		try {
			GenerateRandomFiles.generateRandomFiles(1000);
			map = ReadFromMapFile.readFromFile("dss_map.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ModificatorThread modificador = new ModificatorThread(map.keySet());
		modificador.start();
		//Comprobamos integridad de dss_map.txt con su hash en hash_dss_map.txt
		String actualHash = Hashing.hash("dss_map.txt");
		String originalHash = Hashing.readFile("hash_dss_map.txt");
		if (actualHash.equals(originalHash)) {
			Set<String> listaArchivos = map.keySet();
			while (dias > 0) {
				int comprobados = 0;
				int archivosCorrectosDia = 0;
				int archivosVerifFallidaDia = 0;
				int archivosFallido1ContenedorDia = 0;
				int archivosFallido2ContenedorDia = 0;
				for (String archivo : listaArchivos) {
					String hashOriginal = map.get(archivo);
					int fallos = VerificationHash.verificateAllContainer(archivo, hashOriginal);
					if (fallos == 0) {
						archivosCorrectos++;
						archivosCorrectosDia++;
					} else if (fallos == 1) {
						archivosFallido1Contenedor++;
						archivosFallido1ContenedorDia++;
					} else if (fallos == 2) {
						archivosFallido2Contenedor++;
						archivosFallido2ContenedorDia++;
					} else {
						archivosVerifFallida++;
						archivosVerifFallidaDia++;
						archivosFallidos = archivosFallidos + archivo + "\n";
					}
					comprobados++;

				}
				informe = informe + "DIA " + (31 - dias) + ": Comprobados: [" + comprobados + "], Correctos [" + archivosCorrectosDia + "], Fallos 1 contenedor [" + archivosFallido1ContenedorDia + "], Fallos 2 contenedor [" + archivosFallido2ContenedorDia
					+ "], Fallos de integridad [" + archivosVerifFallidaDia + "]" + "\n";
				dias--;
				Thread.sleep(800);
			}
			informe = informe + "RESULTADO FINAL: Comprobaciones correctas [" + archivosCorrectos + "], Fallos totales 1 contenedor [" + archivosFallido1Contenedor + "], Fallos totales 2 contenedor [" + archivosFallido2Contenedor
				+ "], Fallos de integridad totales [" + archivosVerifFallida + "]" + "\n" + "\n" + "	" + "Los archivos con integridad fallida son (" + archivosFallidos.split("\n").length + ") :" + "\n" + archivosFallidos + "\n";

		} else {
			System.out.println("Fallo integridad archivo de datos");
		}
		modificador.ejecutar = false;
		System.out.println(informe);
		File file = new File("INFORME.txt");
		FileWriter fileWrite = new FileWriter(file);
		BufferedWriter buffWrite = new BufferedWriter(fileWrite);
		buffWrite.write(informe);
		buffWrite.close();
	}

}
