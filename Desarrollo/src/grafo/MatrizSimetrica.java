package grafo;

import java.util.ArrayList;

/**
 * Clase que administra la matriz simétrica de un gráfo. <br>
 */
public class MatrizSimetrica {
	private boolean[] vector;
	private int tamVector;
	private int cantNodos;

	public MatrizSimetrica(int cant) {
		this.cantNodos = cant;
		this.tamVector = (cant * cant - cant) / 2;
		this.vector = new boolean[this.tamVector];
	}

	public ArrayList<Integer> getAdyacentes(int nodo) {
		ArrayList<Integer> listaAdya = new ArrayList<Integer>();
		for (int col = 0; col < this.cantNodos; col++) {
			if (nodo != col && esNodoAdyacenteCon(nodo, col)) {
				listaAdya.add(col);
			}
		}
		return listaAdya;
	}

	public int getGrado(int nodo) {
		int grado = 0;
		for (int col = 0; col < this.cantNodos; col++) {
			if (nodo != col && esNodoAdyacenteCon(nodo, col)) {
				grado++;
			}
		}
		return grado;
	}

	public boolean esNodoAdyacenteCon(int fil, int col) {
		if (fil > col) {
			return this.vector[col * this.cantNodos + fil - (col * col + 3 * col + 2) / 2];
		}
		return this.vector[fil * this.cantNodos + col - (fil * fil + 3 * fil + 2) / 2];
	}

	public void insertarArista(int fil, int col) {
		/** Es decir, crear adyacencia entre 2 nodos **/
		if (fil > col) {
			this.vector[col * this.cantNodos + fil - (col * col + 3 * col + 2) / 2] = true;
		} else
			this.vector[fil * this.cantNodos + col - (fil * fil + 3 * fil + 2) / 2] = true;
	}

	public void eliminarArista(int fil, int col) {
		/** Es decir, eliminar adyacencia entre 2 nodos **/
		if (fil > col) {
			this.vector[col * this.cantNodos + fil - (col * col + 3 * col + 2) / 2] = false;
		} else {
			this.vector[fil * this.cantNodos + col - (fil * fil + 3 * fil + 2) / 2] = false;
		}
	}

	/* Para cuando se imprime el mínimo coloreo. */
	public MatrizSimetrica clone() {
		MatrizSimetrica clone = new MatrizSimetrica(this.cantNodos);
		for (int i = 0; i < this.tamVector; i++) {
			clone.vector[i] = this.vector[i];
		}
		return clone;
	}

	/**
	 * Establece la condición de relación entre dos nodos en la matriz. <br>
	 * 
	 * @param fila
	 *            Fila de la matriz. <br>
	 * @param columna
	 *            Columna de la matriz. <br>
	 */
	public void setMatrizSimetrica(int fila, int columna) {
		if (columna < fila) {
			int aux = fila;
			fila = columna;
			columna = aux;
		}
		int indice = (int) (fila * this.cantNodos + columna - (Math.pow(fila, 2) + 3 * fila + 2) / 2);
		this.vector[indice] = true;
	}

	/**
	 * Devuelve la condición de relación entre dos nodos, dada su posición en la
	 * matriz simétrica. <br>
	 * 
	 * @param fila
	 *            Fila de la matriz. <br>
	 * @param columna
	 *            Columna de la matriz. <br>
	 * @return true si existe la relación, false de lo contrario. <br>
	 */
	public boolean getMatrizSimetrica(int fila, int columna) {
		if (columna < fila) {
			int aux = fila;
			fila = columna;
			columna = aux;
		}
		int indice = (int) (fila * this.cantNodos + columna - (Math.pow(fila, 2) + 3 * fila + 2) / 2);
		return this.vector[indice];
	}
}