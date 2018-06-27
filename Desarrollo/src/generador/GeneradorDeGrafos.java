package generador;

import java.util.Random;

import grafo.EntradaSalidaGrafo;
import grafo.Grafo;
import grafo.MatrizSimetrica;

/**
 * Clase que genera grafos. <br>
 */
public class GeneradorDeGrafos {
	/**
	 * Generador de grafo aleatorio dados la cantidad de nodos y la probabilidad
	 * que tiene cada nodo de ser adyacente con otro nodo.
	 */
	public static void generarGrafoAleatorioNProbabilidad(String path, int cantNodos, int prob) {
		int cantMaxAristas = (cantNodos * (cantNodos - 1)) / 2;
		Grafo grafo = new Grafo();
		grafo.cantidadNodos = cantNodos;
		grafo.matrizSimetrica = new MatrizSimetrica(cantNodos);
		Random generador = new Random();
		for (int i = 0; i < cantNodos - 1; i++)
			for (int j = i + 1; j < cantNodos; j++)
				if (generador.nextInt(101) < prob) {
					// Arroja un valor entre 0 y 100.
					grafo.matrizSimetrica.insertarArista(i, j);
					grafo.cantidadAristas++;
				}
		grafo.porcentajeAdyacencia = Math.round((grafo.cantidadAristas * 100) / (float) cantMaxAristas);
		grafo.gradoMax = 0;
		grafo.gradoMin = cantNodos + 1;
		int gr = 0;
		for (int i = 0; i < cantNodos; i++) {
			gr = grafo.matrizSimetrica.getGrado(i);
			if (gr > grafo.gradoMax)
				grafo.gradoMax = gr;
			if (gr < grafo.gradoMin)
				grafo.gradoMin = gr;
		}
		EntradaSalidaGrafo.generarGrafoArch(path, grafo);
	}

	/**
	 * Generador de grafo aleatorio dados la cantidad de nodos y el porcentaje
	 * de adyacencia. <br>
	 * 
	 * @param path
	 *            Dirección del archivo a guardar. <br>
	 * @param cantidadNodos
	 *            Cantidad de nodos. <br>
	 * @param procentajeAdyacencia
	 *            Porcentaje de adyacencia. <br>
	 */
	public static void generarGrafoAleatorioPorcentajeAdyacencia(final String path, final int cantidadNodos,
			final int procentajeAdyacencia) {
		int cantMaxAristas = (cantidadNodos * (cantidadNodos - 1)) / 2;
		Grafo grafo = new Grafo();
		grafo.cantidadNodos = cantidadNodos;
		grafo.matrizSimetrica = new MatrizSimetrica(cantidadNodos);
		grafo.cantidadAristas = (procentajeAdyacencia * cantMaxAristas) / 100;
		for (int i = 0; i < cantidadNodos - 1; i++) {
			for (int j = i + 1; j < cantidadNodos; j++) {
				grafo.matrizSimetrica.insertarArista(i, j);
			}
		}
		int cantABorrar = cantMaxAristas - grafo.cantidadAristas;
		int cantBorradas = 0;
		Random generador = new Random();
		while (cantBorradas != cantABorrar) {
			int fil = generador.nextInt(grafo.cantidadNodos);
			int col = generador.nextInt(grafo.cantidadNodos);
			if (fil != col && grafo.matrizSimetrica.esNodoAdyacenteCon(fil, col)) {
				grafo.matrizSimetrica.eliminarArista(fil, col);
				cantBorradas++;
			}
		}
		grafo.porcentajeAdyacencia = procentajeAdyacencia;
		grafo.gradoMax = 0;
		grafo.gradoMin = cantidadNodos + 1;
		int gr = 0;
		for (int x = 0; x < cantidadNodos; x++) {
			gr = grafo.matrizSimetrica.getGrado(x);
			if (gr > grafo.gradoMax) {
				grafo.gradoMax = gr;
			}
			if (gr < grafo.gradoMin) {
				grafo.gradoMin = gr;
			}
		}
		EntradaSalidaGrafo.generarGrafoArch(path, grafo);
	}

	/**
	 * Generador de grafo regular dados la cantidad de nodos y el grado que
	 * tienen todos ellos.
	 * 
	 * @param path
	 *            Dirección del archivo a guardar. <br>
	 * @param cantidadNodos
	 *            Cantidad de nodos. <br>
	 * @param grado
	 *            Grado de los nodos. <br>
	 */
	public static void generarGrafoRegularGrado(final String path, final int cantidadNodos, int grado) {
		Grafo grafo = new Grafo();
		grafo.cantidadNodos = cantidadNodos;
		grafo.matrizSimetrica = new MatrizSimetrica(cantidadNodos);
		grafo.cantidadAristas = (cantidadNodos * grado) / 2;
		if (cantidadNodos != 1) {
			grafo.porcentajeAdyacencia = Math.round((grado * 100) / (float) (cantidadNodos - 1));
		}
		grafo.gradoMax = grafo.gradoMin = grado;
		// Camino externo.
		for (int i = 0; i < cantidadNodos - 1; i++)
			grafo.matrizSimetrica.insertarArista(i, i + 1);
		if (cantidadNodos > 2) { // Caso m�s de un nodo.
			grafo.matrizSimetrica.insertarArista(0, cantidadNodos - 1);
			grado -= 2;
			// Cruz.
			if (grado % 2 != 0) {
				for (int i = 0; i < cantidadNodos / 2; i++)
					grafo.matrizSimetrica.insertarArista(i, i + (cantidadNodos / 2));
				grado--;
			}
			// Salteando.
			int cantVeces = grado / 2;
			int saltear = 2;
			for (int i = 0; i < cantVeces; i++) {
				for (int nodoActual = 0; nodoActual < cantidadNodos; nodoActual++) {
					int aux = nodoActual + saltear;
					if (aux > cantidadNodos - 1)
						aux -= cantidadNodos;
					grafo.matrizSimetrica.insertarArista(nodoActual, aux);
				}
				saltear++;
			}
		}
		EntradaSalidaGrafo.generarGrafoArch(path, grafo);
	}

	/**
	 * Generador de grafos regular dados la cantidad de nodos y el porcentaje de
	 * adyacencia. <br>
	 * 
	 * @param path
	 *            Dirección del archivo de guardado. <br>
	 * @param cantidadNodos
	 *            Cantidad de nodos. <br>
	 * @param porcentajeAdyacencia
	 *            Porcentaje de adyacencia. <br>
	 */
	public static void generarGrafoRegularPorcentajeAdyacencia(final String path, final int cantidadNodos,
			final int porcentajeAdyacencia) {
		Grafo grafo = new Grafo();
		grafo.cantidadNodos = cantidadNodos;
		grafo.matrizSimetrica = new MatrizSimetrica(cantidadNodos);
		int grado = (porcentajeAdyacencia * (cantidadNodos - 1)) / 100;
		grafo.cantidadAristas = (cantidadNodos * grado) / 2;
		grafo.porcentajeAdyacencia = porcentajeAdyacencia;
		grafo.gradoMax = grafo.gradoMin = grado;
		for (int i = 0; i < cantidadNodos - 1; i++) {
			grafo.matrizSimetrica.insertarArista(i, i + 1);
		}
		if (cantidadNodos > 2) {// Caso más de un nodo.
			grafo.matrizSimetrica.insertarArista(0, cantidadNodos - 1);
			grado -= 2;
			// Cruz.
			if (grado % 2 != 0) {
				for (int i = 0; i < cantidadNodos / 2; i++) {
					grafo.matrizSimetrica.insertarArista(i, i + (cantidadNodos / 2));
				}
				grado--;
			}
			// Salteando.
			int cantVeces = grado / 2;
			int saltear = 2;
			for (int x = 0; x < cantVeces; x++) {
				for (int nodoActual = 0; nodoActual < cantidadNodos; nodoActual++) {
					int aux = nodoActual + saltear;
					if (aux > cantidadNodos - 1) {
						aux -= cantidadNodos;
					}
					grafo.matrizSimetrica.insertarArista(nodoActual, aux);
				}
				saltear++;
			}
		}
		EntradaSalidaGrafo.generarGrafoArch(path, grafo);
	}

	/**
	 * Generador de grafo N partitos dados la cantidad de nodos y la cantidad de
	 * conjuntos.
	 * 
	 * @param path
	 *            Dirección del archivo a guardar. <br>
	 * @param cantidadNodos
	 *            Cantidad de nodos. <br>
	 * @param nPartito
	 *            N-partitos. <br>
	 */
	public static void generarGrafoNPartito(final String path, final int cantidadNodos, final int nPartito) {
		Grafo grafo = new Grafo();
		grafo.cantidadNodos = cantidadNodos;
		grafo.matrizSimetrica = new MatrizSimetrica(cantidadNodos);
		grafo.cantidadAristas = 0;
		grafo.porcentajeAdyacencia = 100;
		if (cantidadNodos == nPartito) {
			for (int fil = 0; fil < cantidadNodos; fil++)
				for (int col = fil + 1; col < cantidadNodos; col++) {
					grafo.matrizSimetrica.insertarArista(fil, col);
					grafo.cantidadAristas++;
				}

			grafo.gradoMax = 0;
			grafo.gradoMin = nPartito + 1;
			int gr = 0;
			for (int i = 0; i < nPartito; i++) {
				gr = grafo.matrizSimetrica.getGrado(i);
				if (gr > grafo.gradoMax) {
					grafo.gradoMax = gr;
				}
				if (gr < grafo.gradoMin) {
					grafo.gradoMin = gr;
				}
			}
			EntradaSalidaGrafo.generarGrafoArch(path, grafo);
		} else {
			if (cantidadNodos % nPartito == 0) {
				int islas = nPartito;
				int nodosPorIsla = cantidadNodos / nPartito;
				for (int i = 0; i < nodosPorIsla; i++)
					for (int j = 0; j < nodosPorIsla; j++) {
						grafo.matrizSimetrica.insertarArista(i, j + nodosPorIsla);
						grafo.cantidadAristas++;
					}
				islas -= 2;
				int nodoActual = 2 * nodosPorIsla;
				int cantidad = nodoActual;
				while (islas != 0) {
					for (int i = 0; i < nodosPorIsla; i++) {
						for (int j = 0; j < cantidad; j++) {
							grafo.matrizSimetrica.insertarArista(nodoActual, j);
							grafo.cantidadAristas++;
						}
						nodoActual++;
					}
					cantidad += nodosPorIsla;
					islas--;
				}
				grafo.gradoMax = 0;
				grafo.gradoMin = nPartito + 1;
				int gr = 0;
				for (int i = 0; i < nPartito; i++) {
					gr = grafo.matrizSimetrica.getGrado(i);
					if (gr > grafo.gradoMax) {
						grafo.gradoMax = gr;
					}
					if (gr < grafo.gradoMin) {
						grafo.gradoMin = gr;
					}
				}
				EntradaSalidaGrafo.generarGrafoArch(path, grafo);
			} else {// (cantidadNodos % nPartito != 0)
				int islas = nPartito;
				int nodosIsla1 = Math.round(cantidadNodos / (float) nPartito);
				int nodosIsla2 = Math.round(cantidadNodos / (float) nPartito);
				while (nodosIsla1 + nodosIsla2 > cantidadNodos)
					nodosIsla2--;
				int acum = nodosIsla1 + nodosIsla2;
				for (int i = 0; i < nodosIsla1; i++)
					for (int j = 0; j < nodosIsla2; j++) {
						grafo.matrizSimetrica.insertarArista(i, j + nodosIsla1);
						grafo.cantidadAristas++;
					}
				islas -= 2;
				int nodoActual = acum;
				int nodosNuevaIsla = 0;
				while (islas != 0) {
					if (islas != 1) {
						nodosNuevaIsla = Math.round(cantidadNodos / (float) nPartito);
					} else {
						nodosNuevaIsla = cantidadNodos - acum;
					}
					while (nodosNuevaIsla + acum > cantidadNodos) {
						nodosNuevaIsla--;
					}
					for (int i = 0; i < nodosNuevaIsla; i++) {
						for (int j = 0; j < acum; j++) {
							grafo.matrizSimetrica.insertarArista(nodoActual, j);
							grafo.cantidadAristas++;
						}
						nodoActual++;
					}
					acum += nodosNuevaIsla;
					islas--;
				}
				grafo.gradoMax = 0;
				grafo.gradoMin = nPartito + 1;
				int gr = 0;
				for (int i = 0; i < nPartito; i++) {
					gr = grafo.matrizSimetrica.getGrado(i);
					if (gr > grafo.gradoMax) {
						grafo.gradoMax = gr;
					}
					if (gr < grafo.gradoMin) {
						grafo.gradoMin = gr;
					}
				}
			}
			EntradaSalidaGrafo.generarGrafoArch(path, grafo);
		}
	}
}