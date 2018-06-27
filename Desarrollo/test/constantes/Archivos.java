package constantes;

/**
 * Clase que administra los nombres de un archivo. <br>
 */
public enum Archivos {
	/**
	 * Archivo de un grafo con 50% de adyacencia. <br>
	 */
	ARCHIVO_50_ADYACENCIA("50_Porciento_Adyacencia"),
	/**
	 * Archivo de un grafo con 70% de adyacencia. <br>
	 */
	ARCHIVO_75_ADYACENCIA("75_Porciento_Adyacencia"),
	/**
	 * Archivo de un grafo con 40% de adyacencia. <br>
	 */
	ARCHIVO_40_ADYACENCIA("40_Porciento_Adyacencia"),
	/**
	 * Archivo de un grafo con 60% de adyacencia. <br>
	 */
	ARCHIVO_60_ADYACENCIA("60_Porciento_Adyacencia"),
	/**
	 * Archivo de un grafo con 90% de adyacencia. <br>
	 */
	ARCHIVO_90_ADYACENCIA("90_Porciento_Adyacencia"),

	/**
	 * Archivo genérico de un grafo regular con porcentaje. <br>
	 */
	ARCHIVO_GENERICO_REGULAR_PORCENTAJE("Regular_Porcentaje"),
	/**
	 * Archivo genérico de un grafo regular con grado. <br>
	 */
	ARCHIVO_GENERICO_REGULAR_GRADO("Regular_Grado"),
	/**
	 * Archivo genérico de un grafo aleatorio con porcentaje. <br>
	 */
	ARCHIVO_GENERICO_ALEATORIO_PORCENTAJE("Aleatorio_Porcentaje"),
	/**
	 * Archivo genérico de un grafo aleatorio con probabilidad. <br>
	 */
	ARCHIVO_GENERICO_ALEATORIO_PROBABILIDAD("Aleatorio_Probabilidad"),
	/**
	 * Archivo genérico de un grafo n-partito. <br>
	 */
	ARCHIVO_GENERICO_NPARTITO("NPartito");

	/**
	 * Nombre del archivo. <br>
	 */
	private String archivo;

	/**
	 * Crea un nombre de archivo. <br>
	 * 
	 * @param archivo
	 *            Nombre del archivo. <br>
	 */
	private Archivos(String archivo) {
		this.archivo = archivo;
	}

	/**
	 * Devuelve el nombre del archivo. <br>
	 * 
	 * @return Nombre del archivo. <br>
	 */
	public String getArchivo() {
		return this.archivo;
	}
}
