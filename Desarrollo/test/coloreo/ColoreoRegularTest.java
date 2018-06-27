package coloreo;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import constantes.Archivos;
import constantes.Paths;
import grafo.GrafoNDNP;
import herramientas.Constante;

@RunWith(Parameterized.class)
public class ColoreoRegularTest {
	private static final int CANTIDAD_VUELTAS = 10000;

	/**
	 * Nombre del archivo de entrada. <br>
	 */
	@Parameter(0)
	public String nombreArchivoEntrada;

	/**
	 * Nombre del archivo de salida. <br>
	 */
	@Parameter(1)
	public String nombreArchivoSalida;

	/**
	 * Crea los lotes parámetros para la misma prueba. <br>
	 * 
	 * @return Lotes a probar. <br>
	 */
	@Parameters(name = "{0}")
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {
				{ Archivos.ARCHIVO_50_ADYACENCIA.getArchivo() + ".in", Archivos.ARCHIVO_50_ADYACENCIA.getArchivo() },
				{ Archivos.ARCHIVO_75_ADYACENCIA.getArchivo() + ".in", Archivos.ARCHIVO_75_ADYACENCIA.getArchivo() } };
		return Arrays.asList(data);
	}

	@Test
	public void testSecuencial() {
		new GrafoNDNP(Paths.PATH_ENTRADA_REGULAR.getPath() + this.nombreArchivoEntrada).ejecutarCaso(
				Constante.SECUENCIAL_ALEATORIO, CANTIDAD_VUELTAS,
				new File(Paths.PATH_SALIDA_REGULAR.getPath() + this.nombreArchivoSalida + "_SA.out"),
				new File(Paths.PATH_SALIDA_REGULAR.getPath() + this.nombreArchivoSalida + "_SA.txt"));
	}

	@Test
	public void testWellsPowell() {
		new GrafoNDNP(Paths.PATH_ENTRADA_REGULAR.getPath() + this.nombreArchivoEntrada).ejecutarCaso(
				Constante.WELSH_POWELL, CANTIDAD_VUELTAS,
				new File(Paths.PATH_SALIDA_REGULAR.getPath() + this.nombreArchivoSalida + "_WP.out"),
				new File(Paths.PATH_SALIDA_REGULAR.getPath() + this.nombreArchivoSalida + "_WP.txt"));
	}

	@Test
	public void testMatula() {
		new GrafoNDNP(Paths.PATH_ENTRADA_REGULAR.getPath() + this.nombreArchivoEntrada).ejecutarCaso(Constante.MATULA,
				CANTIDAD_VUELTAS, new File(Paths.PATH_SALIDA_REGULAR.getPath() + this.nombreArchivoSalida + "_MA.out"),
				new File(Paths.PATH_SALIDA_REGULAR.getPath() + this.nombreArchivoSalida + "_MA.txt"));
	}
}
