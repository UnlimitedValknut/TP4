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
 * Test de generador de grafos aleatorios. <br>
 */
@RunWith(Parameterized.class)
public class GeneradorGrafosAleatoriosTest {
	/**
	 * Cantidad de nodos. <br>
	 */
	private static final int CANTIDAD_NODOS = 600;

	/**
	 * Path y nombre del archivo. <br>
	 */
	private StringBuilder pathArchivo;

	/**
	 * Porcentaje de adyacencia. <br>
	 */
	@Parameter(0)
	public int porcentajeAdyacencia;

	/**
	 * Nombre del archivo. <br>
	 */
	@Parameter(1)
	public String nombreArchivo;

	/**
	 * Parámetros para los test. <br>
	 * 
	 * @return Casos de pruebas. <br>
	 */
	@Parameters(name = "{1}")
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 40, Archivos.ARCHIVO_40_ADYACENCIA.getArchivo() },
				{ 60, Archivos.ARCHIVO_60_ADYACENCIA.getArchivo() },
				{ 90, Archivos.ARCHIVO_90_ADYACENCIA.getArchivo() } };
		return Arrays.asList(data);
	}

	/**
	 * Inicializa las variables. <br>
	 */
	@Before
	public void iniciarVariables() {
		this.pathArchivo = new StringBuilder(Paths.PATH_ENTRADA_ALEATORIO.getPath());
	}

	/**
	 * Test para generar un grafo aleatorio dada su cantidad de nodos y su grado
	 * de adyacencia. <br>
	 */
	@Test
	public void testGenerarGrafoAleatorio() {
		GeneradorDeGrafos.generarGrafoAleatorioPorcentajeAdyacencia(
				this.pathArchivo.append(this.nombreArchivo).append(".in").toString(), CANTIDAD_NODOS,
				this.porcentajeAdyacencia);
	}
}
