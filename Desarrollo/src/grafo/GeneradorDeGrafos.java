package grafo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Clase que genera grafos. <br>
 */
public class GeneradorDeGrafos {
	/**
	 * Cantidad de nodos del grafo. <br>
	 */
	private int cantidadNodos;
	/**
	 * Cantidad de aristas del grafo. <br>
	 */
	private int cantidadAristas;
	/**
	 * Grado máximo del grafo. <br>
	 */
	private int gradoMax;
	/**
	 * Grado mínimo del grafo. <br>
	 */
	private int gradoMin;
	/**
	 * Porcentaje de adyacencia del grafo. <br>
	 */
	private int porcentaje;
	/**
	 * Matriz de adyacencia del grafo. <br>
	 */
	private byte matrizAdyacencia[][];

	/**
	 * Genera un grafo. <br>
	 * 
	 * @param cantidadNodos
	 *            Cantidad de nodos. <br>
	 */
	public GeneradorDeGrafos(final int cantNodos) {
		this.cantidadNodos = cantNodos;
		matrizAdyacencia = new byte[cantNodos][cantNodos];
	}

	/**
	 * Genera un grafo con un porcentaje de adyacencia. <br>
	 * 
	 * @param porcentajeAdyacencia
	 *            Porcentaje de adyacencia del grafo. <br>
	 */
	public void generarGrafoConPorcAdyacencia(final int porcentajeAdyacencia) {
		this.porcentaje = porcentajeAdyacencia;
		double proba = porcentaje / 100.0;
		Random r = new Random();
		for (int f = 0; f < cantidadNodos - 1; f++) {
			for (int c = f + 1; c < cantidadNodos; c++) {
				if (r.nextDouble() < proba) {
					matrizAdyacencia[f][c] = 1;
					matrizAdyacencia[c][f] = 1;
					cantidadAristas++;
				}
			}
		}
		calcularGrados();
	}

	public void generarGrafoConAristasMax() {
		Random r = new Random();
		int fil, col;
		int maxAristas = (int) (((cantidadNodos * (cantidadNodos - 1) / 2) * porcentaje) / 100);
		while (cantidadAristas < maxAristas) {
			fil = r.nextInt(cantidadNodos);
			col = r.nextInt(cantidadNodos);
			if (matrizAdyacencia[fil][col] == 0 && fil != col) {
				matrizAdyacencia[fil][col] = 1;
				matrizAdyacencia[col][fil] = 1;
				cantidadAristas++;
			}
		}
		calcularGrados();
	}

	/**
	 * Graba un grafo. <br>
	 * 
	 * @param salida
	 *            Dirección de salida. <br>
	 */
	public void escribir(final String salida) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(salida);
			pw = new PrintWriter(fichero);
			pw.println(cantidadNodos + " " + cantidadAristas + " " + porcentaje + " " + gradoMax + " " + gradoMin);
			for (int f = 0; f < cantidadNodos; f++) {
				for (int c = 0; c < cantidadNodos; c++) {
					if (c > f && matrizAdyacencia[f][c] == 1) {
						pw.println((f + 1) + " " + (c + 1));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * Elimina un arista. <br>
	 * 
	 * @param nodo1
	 *            Nodo origen. <br>
	 * @param nodo2
	 *            Nodo fin. <br>
	 */
	private void eliminarArista(int nodo1, int nodo2) {
		matrizAdyacencia[nodo1][nodo2] = 0;
		matrizAdyacencia[nodo2][nodo1] = 0;
	}

	/**
	 * Genera un grafo n-partito. <br>
	 * 
	 * @param n
	 *            Cantidad de partitos. <br>
	 */
	public void generarGrafoNPartito(final int n) {
		int nodosXconjunto = cantidadNodos / n;
		int resto = cantidadNodos % n;
		int nodo1 = 0;
		generarGrafoConAristasMax();
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				nodosXconjunto = nodosXconjunto + resto;
			}
			for (int j = 0; j < nodosXconjunto - 1; j++) {
				int nodo2 = nodo1 + 1;
				for (int k = j + 1; k < nodosXconjunto; k++) {
					eliminarArista(nodo1, nodo2);
					nodo2++;
				}
				nodo1++;
			}
			nodo1++;
		}
		calcularGrados();
	}

	/**
	 * Muestra un grafo. <br>
	 */
	public void mostrarGrafo() {
		for (int f = 0; f < cantidadNodos; f++) {
			System.out.println();
			for (int c = 0; c < cantidadNodos; c++) {
				System.out.print(matrizAdyacencia[f][c] + " ");
			}
		}
	}

	/**
	 * Calcula los grados de un grafo. <br>
	 */
	private void calcularGrados() {
		int temp = 0;
		for (int f = 0; f < cantidadNodos; f++) {
			for (int c = 0; c < cantidadNodos; c++) {
				if (matrizAdyacencia[f][c] == 1) {
					temp++;
				}
			}
			if (temp < gradoMin) {
				gradoMin = temp;
			}
			if (temp > gradoMax) {
				gradoMax = temp;
			}
			temp = 0;
		}
	}
}