package grafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import herramientas.Constante;

/**
 * Clase que administra y resuelve un gráfo no dirigido no ponderado. <br>
 */
public class GrafoNDNP {
	/**
	 * Matriz simétrica del gráfo. <br>
	 */
	private MatrizSimetrica matriz;
	/**
	 * Cantidad de nodos del gráfo. <br>
	 */
	private int cantidadDeNodos;
	/**
	 * Cantidad de aristas del gráfo. <br>
	 */
	private int cantidadDeAristas;
	/**
	 * Porcentaje de adyacencia del gráfo. <br>
	 */
	private double porcentajeAdyacencia;
	/**
	 * Grado máximo del gráfo. <br>
	 */
	private int gradoMaximo;
	/**
	 * Grado mínimo del gráfo. <br>
	 */
	private int gradoMinimo;
	/**
	 * Vector de nodos. <br>
	 */
	private Nodo[] nodos;
	/**
	 * Cantidad de colores del gráfo. <br>
	 */
	private int cantidadDeColores;

	/**
	 * Crea un gráfo no dirigido y no ponderado. <br>
	 * 
	 * @param path
	 *            Dirección del archivo. <br>
	 */
	public GrafoNDNP(final String path) {
		BufferedReader bf = null;
		FileReader entrada = null;
		String linea;
		String[] data;
		boolean bandera = false;
		int fila, columna;
		try {
			entrada = new FileReader(new File(path));
			bf = new BufferedReader(entrada);
			while ((linea = bf.readLine()) != null) {
				data = linea.split(" ");
				if (!bandera) {
					this.cantidadDeNodos = Integer.parseInt(data[0]);
					this.cantidadDeAristas = Integer.parseInt(data[1]);
					this.porcentajeAdyacencia = Double.parseDouble(data[2]);
					this.gradoMinimo = Integer.parseInt(data[3]);
					this.gradoMaximo = Integer.parseInt(data[4]);
					this.nodos = new Nodo[this.cantidadDeNodos];
					for (int i = 0; i < this.cantidadDeNodos; i++) {
						this.nodos[i] = new Nodo(i, 0, 0);
					}
					this.matriz = new MatrizSimetrica(this.cantidadDeNodos);
					bandera = true;
				} else {
					fila = Integer.parseInt(data[0]);
					columna = Integer.parseInt(data[1]);
					matriz.setMatrizSimetrica(fila, columna);
					this.nodos[fila].setGrado(this.nodos[fila].getGrado() + 1);
					this.nodos[columna].setGrado(this.nodos[columna].getGrado() + 1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Crea un gráfo no dirigido y no ponderado. <br>
	 * 
	 * @param matriz
	 *            Matriz simétrica del gráfo. <br>
	 * @param cantNodos
	 *            Cantidad de nodos del gráfo. <br>
	 * @param cantAristas
	 *            Cantidad de aristas del gráfo. <br>
	 * @param PorcAdyacencia
	 *            Porcentaje de adyacencia del gráfo. <br>
	 * @param gMin
	 *            Grado mínimo. <br>
	 * @param gMax
	 *            Grado máximo. <br>
	 */
	public GrafoNDNP(final MatrizSimetrica matriz, final int cantNodos, final int cantAristas,
			final double PorcAdyacencia, final int gMin, final int gMax) {
		this.matriz = matriz;
		this.cantidadDeNodos = cantNodos;
		this.cantidadDeAristas = cantAristas;
		this.porcentajeAdyacencia = PorcAdyacencia;
		this.gradoMinimo = gMin;
		this.gradoMaximo = gMax;
	}

	/**
	 * Devuelve la matriz simétrica del gráfo. <br>
	 * 
	 * @return Matriz simétrica del gráfo. <br>
	 */
	public MatrizSimetrica getMatrizSimetrica() {
		return this.matriz;
	}

	/**
	 * Crea un archivo de entrada de gráfo, un generador de casos de prueba.
	 * <br>
	 * 
	 * @param pathIn
	 *            Dirección de entrada. <br>
	 */
	public void grabarEntradaGrafo(final String pathIn) {
		try {
			PrintWriter entrada = new PrintWriter(new File(pathIn));
			entrada.println(this.cantidadDeNodos + " " + this.cantidadDeAristas + " " + this.porcentajeAdyacencia + " "
					+ this.gradoMaximo + " " + this.gradoMinimo);
			for (int i = 0; i < cantidadDeNodos; i++) {
				for (int j = i + 1; j < cantidadDeNodos; j++) {
					if (this.matriz.getMatrizSimetrica(i, j)) {
						entrada.println(i + " " + j);
					}
				}
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Colorea un gráfo utilizando el algoritmo de coloración de Nelsh-Powell.
	 * <br>
	 */
	public void colorearPowell() {
		ordenarGradoMayorAMenor(nodos, 0, nodos.length - 1);
		colorear();
	}

	/**
	 * Colorea un gráfo utilizando el algoritmo de coloración de Matula. <br>
	 */
	public void colorearMatula() {
		ordenarGradoMenorAMayor(nodos, 0, nodos.length - 1);
		colorear();
	}

	/**
	 * Colorea el nodo de utilizando una secuencia aleatoria. <br>
	 */
	public void colorearSecuencialAleatorio() {
		colorear();
	}

	/**
	 * Colorea el gráfo. <br>
	 */
	private void colorear() {
		int i, color;
		this.cantidadDeColores = 0;
		for (i = 0; i < cantidadDeNodos; i++) {
			color = 1;
			while (!sePuedeColorear(i, color)) {
				color++;
			}
			nodos[i].setColor(color);
			if (color > this.cantidadDeColores) {
				this.cantidadDeColores = color;
			}
		}
	}

	/**
	 * Indica si un nodo se puede colorear. <br>
	 * 
	 * @param pos
	 *            Posición del nodo en el vector. <br>
	 * @param color
	 *            Color del nodo. <br>
	 * @return true si se puede colorear, false de lo contrario. <br>
	 */
	private boolean sePuedeColorear(final int pos, final int color) {
		int i = 0;
		if (this.nodos[pos].getColor() != 0) {
			return false;
		}
		while (i < this.cantidadDeNodos) {
			// si el nodo a colorear es adyacente a un nodo ya pintado de ese
			if (nodos[i].getColor() == color) {
				if (esAdyacente(this.nodos[i], this.nodos[pos])) {
					return false;
				}
			}
			i++;
		}
		return true;
	}

	/**
	 * Indica si un nodo es adyacente a otro. <br>
	 * 
	 * @param nodoUno
	 *            Primer nodo. <br>
	 * @param nodoDos
	 *            Segúndo nodo. <br>
	 * @return true si es adyacente, false de lo contrario. <br>
	 */
	private boolean esAdyacente(Nodo nodoUno, Nodo nodoDos) {
		return matriz.getMatrizSimetrica(nodoUno.getNumero(), nodoDos.getNumero()) == true;
	}

	/**
	 * Ordena la lista de nodos de mayor a menor. <br>
	 * 
	 * @param nodo
	 *            Lista de nodos. <br>
	 * @param izq
	 *            Primer nodo. <br>
	 * @param der
	 *            Último nodo. <br>
	 */
	private void ordenarGradoMenorAMayor(Nodo[] nodo, int izq, int der) {
		Nodo pivote = new Nodo(nodo[(izq + der) / 2]);
		int i = izq, d = der;
		do {
			while ((nodo[i].compararGrados(pivote) < 0)) {
				i++;
			}
			while ((nodo[d].compararGrados(pivote) > 0)) {
				d--;
			}
			if (i <= d) {
				nodo[i].intercambiar(nodo[d]);
				i++;
				d--;
			}
		} while (i <= d);
		if (izq < d) {
			ordenarGradoMenorAMayor(nodo, izq, d);
		}
		if (i < der) {
			ordenarGradoMenorAMayor(nodo, i, der);
		}
	}

	/**
	 * Ordena la lista de nodos de mayor a menor. <br>
	 * 
	 * @param nodo
	 *            Lista de nodos. <br>
	 * @param izq
	 *            Primer nodo del vector. <br>
	 * @param der
	 *            Último nodo del vector. <br>
	 */
	private void ordenarGradoMayorAMenor(Nodo nodo[], int izq, int der) {
		Nodo pivote = new Nodo(nodo[(izq + der) / 2]);
		int i = izq, d = der;
		do {
			while ((nodo[i].compararGrados(pivote) > 0)) {
				i++;
			}
			while ((nodo[d].compararGrados(pivote) < 0)) {
				d--;
			}
			if (i <= d) {
				nodo[i].intercambiar(nodo[d]);
				i++;
				d--;
			}
		} while (i <= d);
		if (izq < d) {
			ordenarGradoMayorAMenor(nodo, izq, d);
		}
		if (i < der) {
			ordenarGradoMayorAMenor(nodo, i, der);
		}
	}

	public void alterarOrdenNodos() {
		cantidadDeColores = 0; // vuelvo a setearlo en 0 por si se ejecuta
								// varias veces el coloreo
		Nodo vectorAux[] = new Nodo[cantidadDeNodos]; // creo vector auxiliar
														// donde voy a alterar
														// posiciones
		int[] numeros = new int[cantidadDeNodos];
		Random rnd = new Random();
		int aux = cantidadDeNodos, pos;
		// se rellena una matriz ordenada del 1 al..n
		for (int i = 0; i < cantidadDeNodos; i++) {
			numeros[i] = i;
		}
		for (int i = 0; i < cantidadDeNodos; i++) {
			pos = rnd.nextInt(aux);
			vectorAux[numeros[pos]] = new Nodo(nodos[i].getNumero(), 0, nodos[i].getGrado()); // cambio
																								// la
																								// pos
																								// del
																								// nodo,
																								// en
																								// un
																								// vector
																								// de
																								// nodos
																								// aux
			numeros[pos] = numeros[aux - 1];
			aux--;
		}
		nodos = vectorAux;
		vectorAux = null;
	}

	/**
	 * Indica que método de coloreo se va a utilizar. <br>
	 * 
	 * @param algoritmo
	 *            Algoritmo de coloreo de grafo.
	 *            <p>
	 *            1 para secuencial aleatorio. <br>
	 *            2 para Welsh-Powell. <br>
	 *            3 para Matula. <br>
	 */
	public void selectorColoreoGrafo(final int algoritmo) {
		if (algoritmo == 1) {
			colorearSecuencialAleatorio();
		}
		if (algoritmo == 2) {
			colorearPowell();
		}
		if (algoritmo == 3) {
			colorearMatula();
		}
	}

	/**
	 * Ejecuta un caso de prueba para obtener datos adicionales. <br>
	 * 
	 * @param codAlgoritmo
	 *            Algoritmo a utilizar. <br>
	 * @param cantCorridas
	 *            Cantidad de corridas. <br>
	 * @param path
	 *            Dirección del archivo. <br>
	 */
	public void ejecutarCaso(int codAlgoritmo, int cantCorridas, String path) {
		int cantColor[] = new int[cantidadDeNodos];
		int nroCromatico = cantidadDeNodos;
		int menorPosicion = 0;
		for (int i = 0; i < cantCorridas; i++) {
			selectorColoreoGrafo(codAlgoritmo);
			cantColor[cantidadDeColores] += 1;
			if (cantidadDeColores < nroCromatico) {
				menorPosicion = i + 1;
				nroCromatico = cantidadDeColores;
			}
			alterarOrdenNodos();
		}
		grabarResumenCaso(codAlgoritmo, cantColor, nroCromatico, menorPosicion, path);
	}

	/**
	 * Graba un archivo con las características usadas para resolver el gráfo.
	 * <br>
	 * 
	 * @param codAlgoritmo
	 *            Algóritmo utilizado. <br>
	 * @param cantColor
	 *            Cantidad de colores. <br>
	 * @param nroCromatico
	 *            Número cromático. <br>
	 * @param menorPosicion
	 *            Posición de la primera aparición del menor. <br>
	 * @param path
	 *            Dirección del archivo. <br>
	 */
	public void grabarResumenCaso(final int codAlgoritmo, final int[] cantColor, final int nroCromatico,
			final int menorPosicion, final String path) {
		try {
			String algoritmo = null;
			PrintWriter salida = new PrintWriter(new FileWriter(path));
			switch (codAlgoritmo) {
			case 1:
				algoritmo = Constante.ALG_SA;
				break;
			case 2:
				algoritmo = Constante.ALG_WP;
				break;
			case 3:
				algoritmo = Constante.ALG_M;
				break;
			}
			salida.println("Algoritmo: " + algoritmo);
			salida.println("Número cromático: " + nroCromatico);
			salida.println("Primera aparición menor: " + menorPosicion);
			salida.println("CantColores  CantRepeticiones");
			for (int i = 0; i < cantColor.length; i++) {
				if (cantColor[i] > 0) {
					salida.println(i + " " + cantColor[i]);
				}
			}
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Graba la salida del gráfo. <br>
	 * 
	 * @param pathOut
	 *            Dirección del archivo de salida. <br>
	 * @param coloreo
	 *            Lista de nodos. <br>
	 */
	public void grabarSalidaGrafo(final String pathOut, Nodo[] coloreo) {
		try {
			algSeleccion(coloreo);
			PrintWriter salida = new PrintWriter(new File(pathOut));
			salida.print(this.cantidadDeNodos + " " + this.cantidadDeColores + " ");
			salida.print(this.cantidadDeAristas + " " + this.porcentajeAdyacencia + " ");
			salida.println(this.gradoMaximo + " " + this.gradoMinimo);
			for (int i = 0; i < this.cantidadDeNodos; i++) {
				salida.println(coloreo[i].getNumero() + " " + coloreo[i].getColor());
			}
			salida.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ordena un vector utilizando algoritmo de selección. <br>
	 * 
	 * @param vector
	 *            Vector de nodos. <br>
	 */
	private void algSeleccion(Nodo[] vector) {
		int minValor;
		Nodo aux;
		for (int i = 0; i < (vector.length - 1); i++) {
			minValor = i;
			for (int j = i + 1; j < vector.length; j++) {
				if (vector[j].getNumero() < vector[minValor].getNumero()) {
					minValor = j;
				}
			}
			aux = vector[i];
			vector[i] = vector[minValor];
			vector[minValor] = aux;
		}
	}

	/**
	 * Devuelve los nodos del gráfo. <br>
	 * 
	 * @return Nodos del gráfo. <br>
	 */
	public Nodo[] getVectorNodos() {
		return this.nodos;
	}
}
