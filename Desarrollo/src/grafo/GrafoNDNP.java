package grafo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;

import herramientas.ComparadorDeNumeros;

public class GrafoNDNP {
	private Coloreo coloreo;
	private MatrizSimetrica matriz;
	private int cantidadDeNodos;
	private int cantidadDeAristas;
	private double porcentajeAdyacencia;
	private int gradoMaximo;
	private int gradoMinimo;

	public GrafoNDNP(String path) {
		try {
			Scanner entrada = new Scanner(new File(path));
			if (entrada.hasNextLine()) {
				this.cantidadDeNodos = entrada.nextInt();
				this.cantidadDeAristas = entrada.nextInt();
				matriz = new MatrizSimetrica(this.cantidadDeNodos); // Crea la
																	// matriz
																	// Simetrica
				this.porcentajeAdyacencia = entrada.nextDouble();
				this.gradoMaximo = entrada.nextInt();
				this.gradoMinimo = entrada.nextInt();
				int fila, columna;
				for (int i = 0; i < this.cantidadDeAristas; i++) {
					fila = entrada.nextInt();
					columna = entrada.nextInt();
					matriz.setMatrizSimetrica(fila, columna);
				}
				entrada.close();
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	public GrafoNDNP(MatrizSimetrica matriz, int cantNodos, int cantAristas, double PorcAdyacencia, int gMin,
			int gMax) {
		this.matriz = matriz;
		this.cantidadDeNodos = cantNodos;
		this.cantidadDeAristas = cantAristas;
		this.porcentajeAdyacencia = PorcAdyacencia;
		this.gradoMinimo = gMin;
		this.gradoMaximo = gMax;
	}

	public MatrizSimetrica getMatrizSimetrica() {
		return this.matriz;
	}

	public void crearColoreo() {
		this.coloreo = new Coloreo(matriz);
	}

	public Coloreo getColoreo() {
		return coloreo;
	}

	public void grabarEntradaGrafo(String pathIn) {
		PrintWriter entrada = null;

		try {
			entrada = new PrintWriter(new File(pathIn));

			entrada.println(this.cantidadDeNodos + " " + this.cantidadDeAristas + " " + (int) this.porcentajeAdyacencia
					+ " " + this.gradoMaximo + " " + this.gradoMinimo);

			for (int i = 0; i < cantidadDeNodos; i++) {
				for (int j = i + 1; j < cantidadDeNodos; j++) {
					if (this.matriz.getMatrizSimetrica(i, j))
						entrada.println(i + " " + j);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			entrada.close();
		}
	}

	public void grabarSalidaGrafo(String pathOut) {
		PrintWriter salida = null;
		Collections.sort(coloreo.nodos, new ComparadorDeNumeros());
		try {
			salida = new PrintWriter(new File(pathOut));
			salida.print(this.cantidadDeNodos + " " + this.coloreo.getCantidadDeColores() + " ");
			salida.print(this.cantidadDeAristas + " " + (int) this.porcentajeAdyacencia + " ");
			salida.println(this.gradoMaximo + " " + this.gradoMinimo);

			for (int i = 0; i < this.cantidadDeNodos; i++) {
				salida.println(coloreo.nodos.get(i).getNumero() + " " + coloreo.nodos.get(i).getColor());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			salida.close();
		}
	}
}
