package grafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class EntradaSalidaGrafo {
	/**
	 * Genera un archivo con un grafo. <br>
	 * 
	 * @param path
	 *            Dirección del archivo. <br>
	 * @param grafo
	 *            Grafo. <br>
	 */
	public static void generarGrafoArch(String path, Grafo grafo) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			pw.println(grafo.cantidadNodos + " " + grafo.cantidadAristas + " " + grafo.porcentajeAdyacencia + " " + grafo.gradoMax + " "
					+ grafo.gradoMin);
			for (int fil = 0; fil < grafo.cantidadNodos - 1; fil++) {
				for (int col = fil + 1; col < grafo.cantidadNodos; col++) {
					if (grafo.matrizSimetrica.esNodoAdyacenteCon(fil, col)) {
						pw.println(fil + " " + col);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * Lee un archivo y devuelve un grafo con la cantidad de nodos, cantidad de
	 * aristas, porcentaje de adyacencia, grado maximo y grado minimo. Las
	 * aristas son cargadas en la Matriz Simetrica.
	 *
	 * @param path
	 *            Dirección del archivo. <br>
	 * @return Grafo. <br>
	 */
	public static Grafo leerGrafoArch(String path) {
		Grafo grafo = new Grafo();
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File(path);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea = br.readLine();
			String[] datos = linea.split(" ");
			grafo.cantidadNodos = Integer.parseInt(datos[0]);
			grafo.cantidadAristas = Integer.parseInt(datos[1]);
			grafo.porcentajeAdyacencia = Integer.parseInt(datos[2]);
			grafo.gradoMax = Integer.parseInt(datos[3]);
			grafo.gradoMin = Integer.parseInt(datos[4]);
			grafo.matrizSimetrica = new MatrizSimetrica(grafo.cantidadNodos);
			for (int i = 0; i < grafo.cantidadAristas; i++) {
				linea = br.readLine();
				datos = linea.split(" ");
				grafo.matrizSimetrica.insertarArista(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return grafo;
	}

	/**
	 * Genera un archivo con la solución al coloreo. <br>
	 * 
	 * @param path
	 *            Dirección del archivo. <br>
	 * @param grafo
	 *            Grafo. <br>
	 * @param listaNodoColor
	 */
	public static void generarArchColoreo(String path, Grafo grafo, ArrayList<Integer> listaNodoColor) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			pw.println(grafo.cantidadNodos + " " + grafo.cantColores + " " + grafo.cantidadAristas + " " + grafo.porcentajeAdyacencia + " "
					+ grafo.gradoMax + " " + grafo.gradoMin);
			for (int i = 0; i < listaNodoColor.size(); i++) {
				pw.println(i + " " + listaNodoColor.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * Genera un archivo con la cantidad de colores que utilizó en cada vez que
	 * se coloreó (corrida).
	 * 
	 * @param path
	 *            Dirección del archivo. <br>
	 * @param cantColores
	 *            Lista de cantidad de colores usados. <br>
	 */
	public static void generarArchAnalisisCantColores(String path, ArrayList<Integer> cantColores) {
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			for (int i = 0; i < cantColores.size(); i++)
				pw.println(i + " " + cantColores.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
