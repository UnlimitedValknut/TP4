package constantes;

/**
 * Clase que administra los distintos paths de los grafos. <br>
 */
public enum Paths {
	/**
	 * Path de entrada de un grafo aleatorio. <br>
	 */
	PATH_ENTRADA_ALEATORIO("Entrada/Aleatorio/"),
	/**
	 * Path de entrada de un grafo regular. <br>
	 */
	PATH_ENTRADA_REGULAR("Entrada/Regular/"),
	/**
	 * Path de salida de un grafo aleatorio. <br>
	 */
	PATH_SALIDA_ALEATORIO("Salida/Aleatorio/"),
	/**
	 * Path de salida de un grafo regular. <br>
	 */
	PATH_SALIDA_REGULAR("Salida/Regular/"),
	/**
	 * Path de entrada de un grafo n-partito. <br>
	 */
	PATH_ENTRADA_NPARTITO("Entrada/NPartito/"),
	/**
	 * Path de salida de un grafo n-partito. <br>
	 */
	PATH_SALIDA_NPARTITO("Salida/NPartito/");

	/**
	 * Path del grafo. <br>
	 */
	private final String path;

	/**
	 * Crea un path para el grafo. <br>
	 * 
	 * @param path
	 *            Path del grafo. <br>
	 */
	Paths(String path) {
		this.path = path;
	}

	/**
	 * Devuelve el path que va a tener el grafo. <br>
	 * 
	 * @return Path del grafo. <br>
	 */
	public String getPath() {
		return this.path;
	}
}
