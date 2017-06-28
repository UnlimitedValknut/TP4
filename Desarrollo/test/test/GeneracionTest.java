package test;

import org.junit.Test;

import grafo.GeneradorDeGrafos;

public class GeneracionTest {
	private static final String PATH_ARCHIVOS = "Preparacion de Prueba/Programa Probador/Entrada/";

//	@Test
//	public void generarGrafoAleatorioNyPorcAdy600y40() {
//		GeneradorDeGrafos.generarGrafoAleatorioPorcentajeAdyacencia(PATH_ARCHIVOS + "grafo600y40.in", 600, 40);
//	}
//
//	@Test
//	public void generarGrafoAleatorioNyPorcAdy600y60() {
//		GeneradorDeGrafos.generarGrafoAleatorioPorcentajeAdyacencia(PATH_ARCHIVOS + "grafo600y60.in", 600, 60);
//	}
//
//	@Test
//	public void generarGrafoAleatorioNyPorcAdy600y90() {
//		GeneradorDeGrafos.generarGrafoAleatorioPorcentajeAdyacencia(PATH_ARCHIVOS + "grafo600y90.in", 600, 90);
//	}
//
//	@Test
//	public void generarGrafoRegular1000y75() {
//		GeneradorDeGrafos.generarGrafoRegularPorcentajeAdyacencia(PATH_ARCHIVOS + "grafo1000y75.in", 1000, 75);
//	}
//
//	@Test
//	public void generarGrafoRegular1000y50() {
//		GeneradorDeGrafos.generarGrafoRegularPorcentajeAdyacencia(PATH_ARCHIVOS + "grafo1000y50.in", 1000, 50);
//	}
//
//	@Test
//	public void generarGrafoNPartito() {
//		GeneradorDeGrafos.generarGrafoNPartito(PATH_ARCHIVOS + "grafoNPartito.in", 5, 3);
//	}
//
//	@Test
//	public void generarGrafoRegularProb() {
//		GeneradorDeGrafos.generarGrafoRegularGrado(PATH_ARCHIVOS + "grafoRegularGrado.in", 6, 3);
//	}
//
//	@Test
//	public void generarGrafoRegularAdyacencia() {
//		GeneradorDeGrafos.generarGrafoRegularPorcentajeAdyacencia(PATH_ARCHIVOS + "grafoRegularAdyacencia.in", 6, 40);
//	}
//
//	@Test
//	public void generarGrafoAleatorioProbabilidad() {
//		GeneradorDeGrafos.generarGrafoAleatorioNProbabilidad(PATH_ARCHIVOS + "grafoAleatorioProbabilidad.in", 6, 80);
//	}
//
//	@Test
//	public void generarGrafoAleatorioAdyacencia() {
//		GeneradorDeGrafos.generarGrafoAleatorioPorcentajeAdyacencia(PATH_ARCHIVOS + "grafoAleatorioAdyacencia.in", 6,
//				40);
//	}
//	
	@Test
	public void generarSS() {
		GeneradorDeGrafos.generarGrafoRegularGrado(PATH_ARCHIVOS + "grafo1000y50SS.in", 1000, 50);
	}

}
