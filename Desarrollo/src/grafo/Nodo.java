package grafo;

/**
 * Clase que administra un nodo, sea su número, color y grado. <br>
 */
public class Nodo {
	/**
	 * Color del nodo. <br>
	 */
	private int color;
	/**
	 * Número del nodo. <br>
	 */
	private int numero;
	/**
	 * Grado del nodo. <br>
	 */
	private int grado;

	/**
	 * Crea un nodo. <br>
	 */
	public Nodo() {
		this.numero = 0;
		this.color = 0;
		this.grado = 0;
	}

	/**
	 * Crea un nodo. <br>
	 * 
	 * @param numero
	 *            Número del nodo. <br>
	 * @param color
	 *            Color del nodo. <br>
	 * @param grado
	 *            Grado del nodo. <br>
	 */
	public Nodo(final int numero, final int color, final int grado) {
		this.numero = numero;
		this.color = color;
		this.grado = grado;
	}

	/**
	 * Crea un nodo a partir de otro nodo. <br>
	 * 
	 * @param nodo
	 *            Nodo. <br>
	 */
	public Nodo(final Nodo nodo) {
		this(nodo.numero, nodo.color, nodo.grado);
	}

	/**
	 * Devuelve el color del nodo. <br>
	 * 
	 * @return Color del nodo. <br>
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Establece el color del nodo. <br>
	 * 
	 * @param color
	 *            Color. <br>
	 */
	public void setColor(final int color) {
		this.color = color;
	}

	/**
	 * Devuelve el número del nodo. <br>
	 * 
	 * @return Número del nodo. <br>
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Establece el número del nodo. <br>
	 * 
	 * @param numero
	 *            Número del nodo. <br>
	 */
	public void setNumero(final int numero) {
		this.numero = numero;
	}

	/**
	 * Devuelve el grado del nodo. <br>
	 * 
	 * @return Grado del nodo. <br>
	 */
	public int getGrado() {
		return grado;
	}

	/**
	 * Establece el grado del nodo. <br>
	 * 
	 * @param grado
	 *            Grado del nodo. <br>
	 */
	public void setGrado(final int grado) {
		this.grado = grado;
	}

	/**
	 * Copia los valores de un nodo en otro nodo. <br>
	 * 
	 * @param nodo
	 *            Nodo. <br>
	 */
	public void copiarValores(final Nodo nodo) {
		numero = nodo.numero;
		color = nodo.color;
		grado = nodo.grado;
	}

	/**
	 * Intercambia un nodo con otro nodo adyacente. <br>
	 * 
	 * @param ady
	 *            Nodo adyacente. <br>
	 */
	public void intercambiar(Nodo ady) {
		Nodo aux = new Nodo(this);
		this.copiarValores(ady);
		ady.copiarValores(aux);
	}

	/**
	 * Compara el grado de un nodo con su adyacente. <br>
	 * 
	 * @param ady
	 *            Nodo adyacente. <br>
	 * @return 1 si el grado del nodo es mayor que el grado del nodo adyacente.
	 *         <br>
	 *         0 si el grado de los nodos es igual. <br>
	 *         -1 si el grado del nodo es menor que el grado del nodo adyacente.
	 *         <br>
	 */
	public int compararGrados(final Nodo ady) {
		if (this.grado > ady.grado) {
			return 1;
		}
		if (this.grado < ady.grado) {
			return -1;
		}
		return 0;
	}
}
