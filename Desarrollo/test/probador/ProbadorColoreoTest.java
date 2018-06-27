package probador;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import constantes.Archivos;
import constantes.Paths;
import probador.ProgramaProbador;

@RunWith(Parameterized.class)
public class ProbadorColoreoTest {
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
				{ Paths.PATH_ENTRADA_REGULAR.getPath() + Archivos.ARCHIVO_50_ADYACENCIA.getArchivo() + ".in",
						Paths.PATH_SALIDA_REGULAR.getPath() + Archivos.ARCHIVO_50_ADYACENCIA.getArchivo() },
				{ Paths.PATH_ENTRADA_REGULAR.getPath() + Archivos.ARCHIVO_75_ADYACENCIA.getArchivo() + ".in",
						Paths.PATH_SALIDA_REGULAR.getPath() + Archivos.ARCHIVO_75_ADYACENCIA.getArchivo() },
				{ Paths.PATH_ENTRADA_ALEATORIO.getPath() + Archivos.ARCHIVO_40_ADYACENCIA.getArchivo() + ".in",
						Paths.PATH_SALIDA_ALEATORIO.getPath() + Archivos.ARCHIVO_40_ADYACENCIA.getArchivo() },
				{ Paths.PATH_ENTRADA_ALEATORIO.getPath() + Archivos.ARCHIVO_60_ADYACENCIA.getArchivo() + ".in",
						Paths.PATH_SALIDA_ALEATORIO.getPath() + Archivos.ARCHIVO_60_ADYACENCIA.getArchivo() },
				{ Paths.PATH_ENTRADA_ALEATORIO.getPath() + Archivos.ARCHIVO_90_ADYACENCIA.getArchivo() + ".in",
						Paths.PATH_SALIDA_ALEATORIO.getPath() + Archivos.ARCHIVO_90_ADYACENCIA.getArchivo() } };
		return Arrays.asList(data);
	}

	@Test
	public void testSecuencial() {
		assertTrue(ProgramaProbador.coloreo(this.nombreArchivoEntrada, this.nombreArchivoSalida + "_SA.out"));
	}

	@Test
	public void testWellsPowell() {
		assertTrue(ProgramaProbador.coloreo(this.nombreArchivoEntrada, this.nombreArchivoSalida + "_WP.out"));
	}

	@Test
	public void testMatula() {
		assertTrue(ProgramaProbador.coloreo(this.nombreArchivoEntrada, this.nombreArchivoSalida + "_MA.out"));
	}
}
