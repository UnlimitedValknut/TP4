package grafo;

/**
 * Clase que administra la matriz simétrica de un gráfo. <br>
 */
public class MatrizSimetrica {
	/**
	 * Indicador de si hay relación de nodos en la matriz simétrica. <br>
	 */
	private boolean[] matrizEnVector;
	/**
	 * Cantidad de nodos. <br>
	 */
	private int posiciones;

	/**
	 * Crea una matriz simétrica a partir de la cantidad de nodos de un gráfo.
	 * <br>
	 * 
	 * @param cantidadDeNodos
	 *            Cantidad de nodos del gráfo. <br>
	 */
	public MatrizSimetrica(final int cantidadDeNodos) {
		this.posiciones = cantidadDeNodos;
		int cantidadDePosiciones = (cantidadDeNodos * (cantidadDeNodos - 1)) / 2;
		this.matrizEnVector = new boolean[cantidadDePosiciones];
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
		int indice = (int) (fila * this.posiciones + columna - (Math.pow(fila, 2) + 3 * fila + 2) / 2);
		this.matrizEnVector[indice] = true;
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
		int indice = (int) (fila * this.posiciones + columna - (Math.pow(fila, 2) + 3 * fila + 2) / 2);
		return this.matrizEnVector[indice];
	}

	/**
	 * Devuelve la cantidad de aristas en la matriz. <br>
	 * 
	 * @return Cantidad de aristas. <br>
	 */
	public int getCantidadAristas() {
		return matrizEnVector.length;
	}

	/**
	 * Devuelve la cantidad de posiciones en la matriz simétrica. <br>
	 * 
	 * @return Cantidad de posiciones. <br>
	 */
	public int getPosiciones() {
		return this.posiciones;
	}

	/**
	 * Devuelve la condición de relación entre dos nodos, dada su posición en el
	 * vector de la matriz. <br>
	 * 
	 * @param pos
	 *            Posición del vector. <br>
	 * @return true si existe la relación, false de lo contrario. <br>
	 */
	public boolean getValorMatrizSimetrica(final int pos) {
		return this.matrizEnVector[pos];
	}

	/**
	 * Establece la relación entre dos nodos, dada su posición en el vector de
	 * la matriz. <br>
	 * 
	 * @param pos
	 *            Posición del vector. <br>
	 */
	public void setValorMatrizSimetrica(final int pos) {
		this.matrizEnVector[pos] = true;
	}
}