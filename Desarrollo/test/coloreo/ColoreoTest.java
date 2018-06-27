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
import constantes.MetodoColoreo;
import constantes.Paths;
import grafo.GrafoNDNP;

@RunWith(Parameterized.class)
public class ColoreoTest {

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
		new GrafoNDNP(this.nombreArchivoEntrada).ejecutarCaso(MetodoColoreo.SECUENCIAL_ALEATORIO, CANTIDAD_VUELTAS,
				new File(this.nombreArchivoSalida + "_SA.out"), new File(this.nombreArchivoSalida + "_SA.txt"));
	}

	@Test
	public void testWellsPowell() {
		new GrafoNDNP(this.nombreArchivoEntrada).ejecutarCaso(MetodoColoreo.WELSH_POWELL, CANTIDAD_VUELTAS,
				new File(this.nombreArchivoSalida + "_WP.out"), new File(this.nombreArchivoSalida + "_WP.txt"));
	}

	@Test
	public void testMatula() {
		new GrafoNDNP(this.nombreArchivoEntrada).ejecutarCaso(MetodoColoreo.MATULA, CANTIDAD_VUELTAS,
				new File(this.nombreArchivoSalida + "_MA.out"), new File(this.nombreArchivoSalida + "_MA.txt"));
	}

}
