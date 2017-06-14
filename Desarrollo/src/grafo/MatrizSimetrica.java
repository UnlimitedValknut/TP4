package grafo;

public class MatrizSimetrica {
	/**
	 * Matriz simétrica cargada en un vector. <br>
	 */
	private boolean[] matrizEnVector;
	/**
	 * Cantidad de nodos en el vector. <br>
	 */
	private int posiciones;

	/**
	 * Crea una matriz simetrica a partir de los nodos del grafo y sus aristas.
	 * <br>
	 * 
	 * @param cantidadDeNodos
	 *            Cantidad de nodos del grafo. <br>
	 */
	public MatrizSimetrica(final int cantidadDeNodos) {
		this.posiciones = cantidadDeNodos;
		int cantidadDePosiciones = (cantidadDeNodos * (cantidadDeNodos - 1)) / 2;
		this.matrizEnVector = new boolean[cantidadDePosiciones];
	}

	/**
	 * Establece
	 * 
	 * @param fila
	 * @param columna
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
	 * Devuelve la cantidad de nodos en la matriz. <br>
	 * 
	 * @return Cantidad de nodos. <br>
	 */
	public int getPosiciones() {
		return this.posiciones;
	}

	public boolean getValorMatrizSimetrica(int pos) {
		return this.matrizEnVector[pos];
	}

	public void setValorMatrizSimetrica(int pos) {
		this.matrizEnVector[pos] = true;
	}
}