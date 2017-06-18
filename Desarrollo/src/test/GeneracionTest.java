package test;

import org.junit.Test;

import grafo.GeneradorDeGrafos;
import grafo.GrafoNDNP;

public class GeneracionTest {
	private static final String PATH_ARCHIVOS = "Preparacion de Prueba/Programa Probador/Entrada/";

	@Test
	public void generarGrafoAleatorioNyPorcAdy600y40() {
		GrafoNDNP grafo = GeneradorDeGrafos.generarAleatorioNYPorcAdyacencia(600, 40.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo600y40.in");
	}

	@Test
	public void generarGrafoAleatorioNyPorcAdy600y60() {
		GrafoNDNP grafo = GeneradorDeGrafos.generarAleatorioNYPorcAdyacencia(600, 60.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo600y60.in");
	}

	@Test
	public void generarGrafoAleatorioNyPorcAdy600y90() {
		GrafoNDNP grafo = GeneradorDeGrafos.generarAleatorioNYPorcAdyacencia(600, 90.0);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafo600y90.in");
	}

	@Test
	public void generarGrafoNPartito800y400() {
		GrafoNDNP grafo = GeneradorDeGrafos.generarGrafoNPartito(800, 400);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafoNPartito800y400.in");
	}

	@Test
	public void generarGrafoNPartito100y50() {
		GrafoNDNP grafo = GeneradorDeGrafos.generarGrafoNPartito(100, 50);
		grafo.grabarEntradaGrafo(PATH_ARCHIVOS + "grafoNPartito100y50.in");
	}
}
