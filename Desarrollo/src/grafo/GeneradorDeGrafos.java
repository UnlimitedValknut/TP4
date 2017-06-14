package grafo;

import java.util.Random;

@SuppressWarnings("unused")
public class GeneradorDeGrafos {

	private int cantNodos;
	private double porcAdyacencia;
	private static int gradoMax, gradoMin;

	public static GrafoNDNP generarAleatorioNYProbabilidad(int cantNodos, double probabilidad) { // Probabilidad
																									// ejemplo=
																									// 0,5
		Random arista = new Random();
		int cantAristas = 0;
		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		Double aux = arista.nextDouble();
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (aux < probabilidad) {
					matriz.setMatrizSimetrica(i, j);
					cantAristas++;
				}
				aux = arista.nextDouble();
			}
		}
		double porcentajeDeAdyacencia = (cantAristas * 100 / matriz.getCantidadAristas());
		calcularGradoMinYMax(matriz, cantNodos);
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcentajeDeAdyacencia, gradoMax, gradoMin);
		return grafo;
	}

	public static GrafoNDNP generarAleatorioNYPorcAdyacencia(int cantNodos, double porcentajeAdyacencia) {
		int numRand;
		Random arista = new Random();
		MatrizSimetrica matriz = new MatrizSimetrica(cantNodos);
		int maximoAristas = (cantNodos * (cantNodos - 1)) / 2;
		int cantAristas = (int) Math.round((porcentajeAdyacencia * (cantNodos - 1)) / 100);
		for (int i = 0; i < cantAristas; i++) {
			numRand = arista.nextInt(maximoAristas);
			if (matriz.getValorMatrizSimetrica(numRand)) {
				i--;
			} else {
				matriz.setValorMatrizSimetrica(numRand);
			}
		}
		double porcAdy = porcentajeAdyacencia;
		calcularGradoMinYMax(matriz, cantNodos);
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcAdy, gradoMax, gradoMin);
		return grafo;
	}

	public static GrafoNDNP generarRegularNYGrado(int cantNodos, int grado) {
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

	public static GrafoNDNP generarRegularNYAdyacencia(int cantNodos, double porcAdyacencia) {
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

	public static GrafoNDNP generarGrafoNPartito(int cantNodos, int n) {
		MatrizSimetrica matriz;
		if (cantNodos % n != 0) {
			System.out.println("No se puede generar grafo n partito.");
			return null;
		}
		final int aristasCont = (cantNodos / n) - 1;
		int auxiliar = aristasCont;
		int cantAristas = 0;
		matriz = new MatrizSimetrica(cantNodos);
		for (int i = 0; i < cantNodos; i++) {
			if (auxiliar > 0) {
				matriz.setMatrizSimetrica(i, i + 1);
				cantAristas++;
				auxiliar--;
			} else {
				auxiliar = aristasCont;
			}
		}
		double porcAdyacencia = (cantAristas * 100) / ((cantNodos * (cantNodos - 1)) / 2);
		calcularGradoMinYMax(matriz, cantNodos);
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantAristas, porcAdyacencia, gradoMax, gradoMin);
		return grafo;
	}

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
			if (sumador[j] < gradoMin)
				gradoMin = sumador[j];
		}
	}
}