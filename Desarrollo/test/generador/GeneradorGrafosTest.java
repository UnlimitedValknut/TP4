package generador;

import org.junit.Test;

import constantes.Archivos;
import constantes.Paths;

public class GeneradorGrafosTest {
	@Test
	public void testGenerarRegularPorcentaje() {
		GeneradorDeGrafos.generarGrafoRegularPorcentajeAdyacencia(Paths.PATH_ENTRADA_REGULAR.getPath()
				+ Archivos.ARCHIVO_GENERICO_REGULAR_PORCENTAJE.getArchivo() + ".in", 100, 40);
	}

	@Test
	public void testGenerarRegularGrado() {
		GeneradorDeGrafos.generarGrafoRegularGrado(
				Paths.PATH_ENTRADA_REGULAR.getPath() + Archivos.ARCHIVO_GENERICO_REGULAR_GRADO.getArchivo() + ".in", 20,
				5);
	}

	@Test
	public void testGenerarAleatorioPorcentaje() {
		GeneradorDeGrafos.generarGrafoAleatorioPorcentajeAdyacencia(Paths.PATH_ENTRADA_ALEATORIO.getPath()
				+ Archivos.ARCHIVO_GENERICO_ALEATORIO_PORCENTAJE.getArchivo() + ".in", 20, 70);
	}

	@Test
	public void testGenerarAleatorioProbabilidad() {
		GeneradorDeGrafos.generarGrafoAleatorioNProbabilidad(Paths.PATH_ENTRADA_ALEATORIO.getPath()
				+ Archivos.ARCHIVO_GENERICO_ALEATORIO_PROBABILIDAD.getArchivo() + ".in", 100, 10);
	}

	@Test
	public void testGenerarNPartito() {
		GeneradorDeGrafos.generarGrafoNPartito(
				Paths.PATH_ENTRADA_NPARTITO.getPath() + Archivos.ARCHIVO_GENERICO_NPARTITO.getArchivo() + ".in", 6, 3);
	}
}
