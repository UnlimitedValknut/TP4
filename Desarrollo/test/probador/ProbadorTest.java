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

@RunWith(Parameterized.class)
public class ProbadorTest {
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
	@Parameters(name = "{1}")
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { {
				Paths.PATH_ENTRADA_REGULAR.getPath() + Archivos.ARCHIVO_GENERICO_REGULAR_PORCENTAJE.getArchivo()
						+ ".in",
				Paths.PATH_SALIDA_REGULAR.getPath() + Archivos.ARCHIVO_GENERICO_REGULAR_PORCENTAJE.getArchivo() },
				{ Paths.PATH_ENTRADA_REGULAR.getPath() + Archivos.ARCHIVO_GENERICO_REGULAR_GRADO.getArchivo() + ".in",
						Paths.PATH_SALIDA_REGULAR.getPath() + Archivos.ARCHIVO_GENERICO_REGULAR_GRADO.getArchivo() },
				{ Paths.PATH_ENTRADA_ALEATORIO.getPath() + Archivos.ARCHIVO_GENERICO_ALEATORIO_PORCENTAJE.getArchivo()
						+ ".in",
						Paths.PATH_SALIDA_ALEATORIO.getPath()
								+ Archivos.ARCHIVO_GENERICO_ALEATORIO_PORCENTAJE.getArchivo() },
				{ Paths.PATH_ENTRADA_ALEATORIO.getPath() + Archivos.ARCHIVO_GENERICO_ALEATORIO_PROBABILIDAD.getArchivo()
						+ ".in",
						Paths.PATH_SALIDA_ALEATORIO.getPath()
								+ Archivos.ARCHIVO_GENERICO_ALEATORIO_PROBABILIDAD.getArchivo() },
				{ Paths.PATH_ENTRADA_NPARTITO.getPath() + Archivos.ARCHIVO_GENERICO_NPARTITO.getArchivo() + ".in",
						Paths.PATH_SALIDA_NPARTITO.getPath() + Archivos.ARCHIVO_GENERICO_NPARTITO.getArchivo() } };
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
