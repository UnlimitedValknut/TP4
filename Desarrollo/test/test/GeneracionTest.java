package test;

import org.junit.Test;

import grafo.GeneradorDeGrafos;

public class GeneracionTest {
	private static final String PATH_ARCHIVOS = "Preparacion de Prueba/Programa Probador/Entrada/";
	//
	// @Test
	// public void generarGrafoAleatorioNyPorcAdy600y40() {
	// GrafoNDNP grafo = GeneradorDeGrafos.generarAleatorioNYPorcAdyacencia(600,
	// 40.0);
	// grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo600y40.in");
	// }
	//
	// @Test
	// public void generarGrafoAleatorioNyPorcAdy600y60() {
	// GrafoNDNP grafo = GeneradorDeGrafos.generarAleatorioNYPorcAdyacencia(600,
	// 60.0);
	// grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo600y60.in");
	// }
	//
	// @Test
	// public void generarGrafoAleatorioNyPorcAdy600y90() {
	// GrafoNDNP grafo = GeneradorDeGrafos.generarAleatorioNYPorcAdyacencia(600,
	// 90.0);
	// grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo600y90.in");
	// }
	//
	// @Test
	// public void generarGrafoRegular1000y75() {
	// GrafoNDNP grafo = GeneradorDeGrafos.generarRegularNYAdyacencia(1000,
	// 75.0);
	// grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo1000y75.in");
	// }
	//
	// @Test
	// public void generarGrafoRegular1000y50() {
	// GrafoNDNP grafo = GeneradorDeGrafos.generarRegularNYAdyacencia(1000,
	// 50.0);
	// grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo1000y50.in");
	// }

	@Test
	public void generarGrafoNPartito() {
		GeneradorDeGrafos grafoNpartito = new GeneradorDeGrafos(6);
		grafoNpartito.generarGrafoNPartito(3);
		grafoNpartito.escribir(PATH_ARCHIVOS + "GrafoNPartito.in");
	}

	@Test
	public void generarGrafoRegularProb() {
		GeneradorDeGrafos grafoAleatorioProb = new GeneradorDeGrafos(6);
		grafoAleatorioProb.generarGrafoConPorcAdyacencia(80);
		grafoAleatorioProb.escribir(PATH_ARCHIVOS + "GrafoRegularProbabilidad.in");
	}

}
