
package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import generator.GenerateRandomFiles;

// Este hilo se encarga de modificar los archivos de los contenedores para luego hacer las comprobaciones de integreidad
public class ModificatorThread extends Thread {

	private List<String>	archivos;
	public boolean			ejecutar	= true;


	public ModificatorThread(final Set<String> archivos) {
		this.archivos = new ArrayList<String>();
		this.archivos.addAll(archivos);
	}

	@Override
	public void run() {
		Random rd = new Random();
		while (this.ejecutar) {
			int archivo = rd.nextInt(this.archivos.size());
			int prob = rd.nextInt(100);
			String file = this.archivos.get(archivo);
			String container1 = "Contenedor1/" + file;
			String container2 = "Contenedor2/" + file;
			String container3 = "Contenedor3/" + file;
			try {
				String content = GenerateRandomFiles.randomString(64);
				if (prob <= 60) {
					FileWriter fileWrite = new FileWriter(container1);
					BufferedWriter buffWrite = new BufferedWriter(fileWrite);
					buffWrite.write(content);
					buffWrite.close();
				} else if (prob <= 90) {
					FileWriter fileWrite = new FileWriter(container1);
					BufferedWriter buffWrite = new BufferedWriter(fileWrite);
					buffWrite.write(content);
					buffWrite.close();

					FileWriter fileWrite2 = new FileWriter(container2);
					BufferedWriter buffWrite2 = new BufferedWriter(fileWrite2);
					buffWrite2.write(content);
					buffWrite2.close();
				} else {
					FileWriter fileWrite = new FileWriter(container1);
					BufferedWriter buffWrite = new BufferedWriter(fileWrite);
					buffWrite.write(content);
					buffWrite.close();

					FileWriter fileWrite2 = new FileWriter(container2);
					BufferedWriter buffWrite2 = new BufferedWriter(fileWrite2);
					buffWrite2.write(content);
					buffWrite2.close();

					FileWriter fileWrite3 = new FileWriter(container3);
					BufferedWriter buffWrite3 = new BufferedWriter(fileWrite3);
					buffWrite3.write(content);
					buffWrite3.close();
				}
				Thread.sleep(100);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
