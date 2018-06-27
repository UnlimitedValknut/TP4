package generador;

import org.junit.Ignore;
import org.junit.Test;

import constantes.Archivos;
import constantes.Paths;

public class GeneradorGrafosTest {
	@Ignore
	public void testGenerarRegularPorcentaje() {
		GeneradorDeGrafos.generarGrafoRegularPorcentajeAdyacencia(Paths.PATH_ENTRADA_REGULAR.getPath()
				+ Archivos.ARCHIVO_GENERICO_REGULAR_PORCENTAJE.getArchivo() + ".in", 100, 40);
	}

	@Ignore
	public void testGenerarRegularGrado() {
		GeneradorDeGrafos.generarGrafoRegularGrado(
				Paths.PATH_ENTRADA_REGULAR.getPath() + Archivos.ARCHIVO_GENERICO_REGULAR_GRADO.getArchivo() + ".in", 20,
				5);
	}

	@Test
	public void testGenerarAleatorioPorcentaje() {
		GeneradorDeGrafos.generarGrafoAleatorioPorcentajeAdyacencia(Paths.PATH_ENTRADA_ALEATORIO.getPath()
				+ Archivos.ARCHIVO_GENERICO_ALEATORIO_PORCENTAJE.getArchivo() + ".in", 1000, 30);
	}

	@Ignore
	public void testGenerarAleatorioProbabilidad() {
		GeneradorDeGrafos.generarGrafoAleatorioNProbabilidad(Paths.PATH_ENTRADA_ALEATORIO.getPath()
				+ Archivos.ARCHIVO_GENERICO_ALEATORIO_PROBABILIDAD.getArchivo() + ".in", 100, 10);
	}

	@Ignore
	public void testGenerarNPartito() {
		GeneradorDeGrafos.generarGrafoNPartito(
				Paths.PATH_ENTRADA_NPARTITO.getPath() + Archivos.ARCHIVO_GENERICO_NPARTITO.getArchivo() + ".in", 6, 3);
	}
}
