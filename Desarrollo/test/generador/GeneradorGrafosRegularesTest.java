package generador;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import constantes.Archivos;
import constantes.Paths;
import grafo.GeneradorDeGrafos;

/**
 * Test de generador de grafos regulares. <br>
 */
@RunWith(Parameterized.class)
public class GeneradorGrafosRegularesTest {
	/**
	 * Cantidad de nodos del grafo. <br>
	 */
	private static final int CANTIDAD_NODOS = 1000;

	/**
	 * Path y nombre del archivo. <br>
	 */
	private StringBuilder pathArchivo;

	/**
	 * Porcentaje de adyacencia del grafo. <br>
	 */
	@Parameter(0)
	public int porcentajeAdyacencia;

	/**
	 * Nombre del archivo a generar. <br>
	 */
	@Parameter(1)
	public String nombreArchivo;

	/**
	 * Crea los lotes parámetros para la misma prueba. <br>
	 * 
	 * @return Lotes a probar. <br>
	 */
	@Parameters(name = "{1}")
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 50, Archivos.ARCHIVO_50_ADYACENCIA.getArchivo() },
				{ 75, Archivos.ARCHIVO_75_ADYACENCIA.getArchivo() } };
		return Arrays.asList(data);
	}

	/**
	 * Inicializa las variables. <br>
	 */
	@Before
	public void iniciarVariables() {
		this.pathArchivo = new StringBuilder(Paths.PATH_ENTRADA_REGULAR.getPath());
	}

	/**
	 * Test para generar un grafo regular dada su cantidad de nodos y su grado
	 * de adyacencia. <br>
	 */
	@Test
	public void testGenerarGrafoRegular() {
		GeneradorDeGrafos.generarGrafoRegularPorcentajeAdyacencia(
				this.pathArchivo.append(this.nombreArchivo).append(".in").toString(), CANTIDAD_NODOS,
				this.porcentajeAdyacencia);
	}
}
