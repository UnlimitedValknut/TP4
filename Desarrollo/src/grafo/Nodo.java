package grafo;

/**
 * Clase que crea y administra la información de un nodo. <br>
 */
public class Nodo implements Comparable<Nodo> {
	/**
	 * Color de nodo. <br>
	 */
	private int color;
	/**
	 * Identificador de nodo. <br>
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
	 * Crea un nodo con su número idenitificador, su grado y el color que lo
	 * identifique, llegado el caso. <br>
	 * 
	 * @param numero
	 *            Posición del nodo. <br>
	 * @param color
	 *            Color del nodo. <br>
	 * @param grado
	 *            Grado del nodo. <br>
	 */
	public Nodo(int numero, int color, int grado) {
		this.numero = numero;
		this.color = color;
		this.grado = grado;
	}

	/**
	 * Crea un nodo de otro nodo. <br>
	 * 
	 * @param nodo
	 *            El otro nodo. <br>
	 */
	public Nodo(Nodo nodo) {
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
	 *            Color del nodo. <br>
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * Devuelve el número identificador del nodo. <br>
	 * 
	 * @return Número identificador. <br>
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Establece el número identificador del nodo. <br>
	 * 
	 * @param numero
	 *            Número identificador. <br>
	 */
	public void setNumero(int numero) {
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
	public void setGrado(int grado) {
		this.grado = grado;
	}

	/**
	 * Compara el grado de los nodos. <br>
	 */
	@Override
	public int compareTo(Nodo o) {
		Integer gradoA = this.grado;
		Integer gradoB = o.getGrado();
		return gradoA.compareTo(gradoB);
	}

	/**
	 * Copia los valores de un nodo. <br>
	 * 
	 * @param nodo
	 *            Nodo. <br>
	 */
	public void copiarValores(Nodo nodo) {
		this.numero = nodo.getNumero();
		this.color = nodo.getColor();
		this.grado = nodo.getGrado();
	}

	/**
	 * Intercambia los valores del nodo con su adyacente. <br>
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
	 * Compara el número de nodo. <br
	 * 
	 * @param o
	 *            Nodo. <br>
	 * @return true si el número es mayor, false de lo contrario. <br>
	 */
	public boolean comparaNumero(Nodo o) {
		return this.numero > o.numero;
	}
}
