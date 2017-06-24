package grafo;

import java.util.Random;

/**
 * Clase que genera grafos. <br>
 */
@SuppressWarnings("unused")
public class GeneradorDeGrafos {
	/**
	 * Cantidad de nodos. <br>
	 */
	private int cantidadNodos;
	/**
	 * Porcentaje de adyacencia. <br>
	 */
	private double porcentajeAdyacencia;
	/**
	 * Grado máximo del gráfo. <br>
	 */
	private static int gradoMax;
	/**
	 * Grado mínimo del gráfo. <br>
	 */
	private static int gradoMin;

	/**
	 * Genera un gráfo aleatorio, dado su cantidad de nodos y una probabilidad
	 * para cada arista. <br>
	 * 
	 * @param cantNodos
	 *            Cantidad de nodos. <br>
	 * @param probabilidad
	 *            Probabilidad de cada arista. <br>
	 * @return Gráfo. <br>
	 */
	public static GrafoNDNP generarAleatorioNYProbabilidad(final int cantNodos, final double probabilidad) {
		// Probabilidad ejemplo= 0,5
		int cantAristas = 0;
		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (!matriz.getMatrizSimetrica(i, j)) {
					if (Math.random() < probabilidad) {
						matriz.setMatrizSimetrica(i, j);
						cantAristas++;
					}
				}
			}
		}
		int cantTotAristas = (cantNodos * (cantNodos - 1)) / 2;
		double porcentajeDeAdyacencia = Math.rint((cantAristas / cantTotAristas) * 100.0);
		calcularGradoMinYMax(matriz, cantNodos);
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcentajeDeAdyacencia, gradoMax, gradoMin);
		return grafo;
	}

	/**
	 * Genera un gráfo aleatorio, dado su cantidad de nodos y su porcentaje de
	 * adyacencia. <br>
	 * 
	 * @param cantNodos
	 *            Cantidad de nodos. <br>
	 * @param porcentajeAdyacencia
	 *            Porcentaje de adyacencia. <br>
	 * @return Gráfo. <br>
	 */
	// FUNCIONA BIEN
	public static GrafoNDNP generarAleatorioNYPorcAdyacencia(int cantNodos, double porcentajeAdyacencia) {
		Random arista = new Random();
		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		int maximoAristas = (cantNodos * (cantNodos - 1)) / 2;
		int cantAristas = (int) (Math.rint((cantNodos * cantNodos - cantNodos) * 0.5 * (porcentajeAdyacencia / 100.0)));
		int aristasAplicadas = 0;
		double porcAdy = porcentajeAdyacencia;
		while (aristasAplicadas != cantAristas) {
			for (int i = 0; i < cantNodos; i++) {
				for (int j = i + 1; j < cantNodos; j++) {
					if (!matriz.getMatrizSimetrica(i, j)) {
						if (arista.nextInt(2) == 1) {
							matriz.setMatrizSimetrica(i, j);
							aristasAplicadas++;
						}
					}
					if (aristasAplicadas == cantAristas) {
						break;
					}
				}
				if (aristasAplicadas == cantAristas) {
					break;
				}
			}
		}
		calcularGradoMinYMax(matriz, cantNodos);
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcAdy, gradoMax, gradoMin);
		return grafo;
	}

	/**
	 * Genera un gráfo regular, dado sun cantidad de nodos y el grado. <br>
	 * 
	 * @param cantNodos
	 *            Cantidad de nodos. <br>
	 * @param grado
	 *            Grado. <br>
	 * @return Gráfo. <br>
	 */
	public static GrafoNDNP generarRegularNYGrado(final int cantNodos, final int grado) {
		MatrizSimetrica matriz;
		int cantidadAristas = 0;
		double porcentajeDeAdyacencia;
		int saltoMax, j;
		if (grado >= cantNodos) {
			System.out.println("No se puede generar el grafo.");
			return null;
		}
		matriz = new MatrizSimetrica(cantNodos);
		if (((cantNodos % 2) == 0) || ((grado % 2) == 0)) {
			saltoMax = (grado) / 2;
			for (int salto = 0; salto <= saltoMax; salto++) {
				for (int i = 1; i < cantNodos; i++) {
					j = (i + salto) % cantNodos;
					matriz.setMatrizSimetrica(i, j);
					cantidadAristas++;
				}
			}
			if (grado % 2 != 0) {
				for (int i = 0; i < cantNodos / 2; i++) {
					j = (i + cantNodos) / 2;
					matriz.setMatrizSimetrica(i, j);
					cantidadAristas++;
				}
			}
		}
		porcentajeDeAdyacencia = (grado * (cantNodos - 1)) * 100;
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantidadAristas, porcentajeDeAdyacencia, grado, grado);
		return grafo;
	}

	/**
	 * Genera un gráfo regular dado su cantidad de nodos y el porcentaje de
	 * adyacencia. <br>
	 * 
	 * @param cantNodos
	 *            Cantidad de nodos. <br>
	 * @param porcAdyacencia
	 *            Porcentaje de adyacencia. <br>
	 * @return Gráfo. <br>
	 */
	public static GrafoNDNP generarRegularNYAdyacencia(final int cantNodos, final double porcAdyacencia) {
		MatrizSimetrica matriz;
		int grado = (int) (((porcAdyacencia / 100) * (cantNodos - 1)));
		int cantAristas = (cantNodos * grado) / 2;
		int saltoMax, j;
		matriz = new MatrizSimetrica(cantNodos);
		if (((cantNodos % 2) == 0) || ((grado % 2) == 0)) {
			saltoMax = (grado) / 2;
			for (int salto = 0; salto <= saltoMax; salto++) {
				for (int i = 1; i < cantNodos; i++) {
					j = (i + salto) % cantNodos;
					matriz.setMatrizSimetrica(i, j);
				}
			}
			if (grado % 2 != 0) {
				for (int i = 0; i < cantNodos / 2; i++) {
					j = (i + cantNodos) / 2;
					matriz.setMatrizSimetrica(i, j);
				}
			}
		}
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcAdyacencia, grado, grado);
		return grafo;
	}

	/**
	 * Genera un gráfo n-partitos. <br>
	 * 
	 * @param cantNodos
	 *            Cantidad de nodos. <br>
	 * @param n
	 *            Partitos. <br>
	 * @return Gráfo. <br>
	 */
	public static GrafoNDNP generarGrafoNPartito(final int cantNodos, final int n) {
		MatrizSimetrica matriz;
		int nodosXconjunto = cantNodos / n;
		int resto = cantNodos % n;
		int nodo1 = 0;
		if (cantNodos % n != 0 && n >= cantNodos) {
			System.out.println("No se puede generar grafo n partito.");
			return null;
		}
		int cantAristas = 0;
		matriz = new MatrizSimetrica(cantNodos);
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				nodosXconjunto = nodosXconjunto + resto;
			}
			for (int j = 0; j < nodosXconjunto - 1; j++) {
				int nodo2 = nodo1 + 1;
				for (int k = j + 1; k < nodosXconjunto; k++) {
					matriz.setEliminarArista(nodo1, nodo2);
					matriz.setEliminarArista(nodo2, nodo1);
					nodo2++;
				}
				nodo1++;
			}
			nodo1++;
		}
		double porcAdyacencia = (2 * (double) cantAristas * 100) / ((cantNodos * (cantNodos - 1)) / 2);
		calcularGradoMinYMax(matriz, cantNodos);
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcAdyacencia, gradoMax, gradoMax);
		return grafo;
	}

	/**
	 * Calcula el grado mínimo y el grado máximo del gráfo. <br>
	 * 
	 * @param matriz
	 *            Matriz simétrica del gráfo. <br>
	 * @param cantNodos
	 *            Cantidad de nodos del gráfo. <br>
	 */
	private static void calcularGradoMinYMax(MatrizSimetrica matriz, int cantNodos) {
		int[] sumador = new int[cantNodos];
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (matriz.getMatrizSimetrica(i, j)) {
					sumador[i] += 1;
					sumador[j] += 1;
				}
			}
		}
		gradoMax = 0;
		for (int j = 0; j < sumador.length; j++) {
			if (sumador[j] > gradoMax) {
				gradoMax = sumador[j];
			}
		}
		gradoMin = gradoMax - 1;
		for (int j = 0; j < sumador.length; j++) {
			if (sumador[j] < gradoMin) {
				gradoMin = sumador[j];
			}
		}
	}
}