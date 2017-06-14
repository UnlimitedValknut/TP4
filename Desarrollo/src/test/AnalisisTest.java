package test;

import org.junit.Test;

import grafo.GrafoNDNP;
import prueba.Analisis;

public class AnalisisTest {
	
	@Test
	public void analisisGrafo600y40AS() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y40.in");
		Analisis analisis = new Analisis(1, grafo);
		
		analisis.ejecucionGrafoSecuencialAleatorio();
		analisis.recopilarInformacion();
		analisis.mostrarInformacion();
	}
	
	@Test
	public void analisisGrafo600y40WP() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y40.in");
		Analisis analisis = new Analisis(10000, grafo);
		
		analisis.ejecucionGrafoWelshPowell();
		analisis.recopilarInformacion();
		analisis.mostrarInformacion();
	}
	
	@Test
	public void analisisGrafo600y40M() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y40.in");
		Analisis analisis = new Analisis(10000, grafo);
		
		analisis.ejecucionGrafoMatula();
		analisis.recopilarInformacion();
		analisis.mostrarInformacion();
	}
	
	
	@Test
	public void analisisGrafo600y60AS() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y60.in");
		Analisis analisis = new Analisis(10000, grafo);
		
		analisis.ejecucionGrafoSecuencialAleatorio();
		analisis.recopilarInformacion();
		analisis.mostrarInformacion();
	}
	
	@Test
	public void analisisGrafo600y60WP() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y60.in");
		Analisis analisis = new Analisis(10000, grafo);
		
		analisis.ejecucionGrafoWelshPowell();
		analisis.recopilarInformacion();
		analisis.mostrarInformacion();
	}
	
	@Test
	public void analisisGrafo600y60M() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y60.in");
		Analisis analisis = new Analisis(10000, grafo);
		
		analisis.ejecucionGrafoMatula();
		analisis.recopilarInformacion();
		analisis.mostrarInformacion();
	}
	
	private static final String PATH_ARCHIVOS_ENT = "PreparacionDePrueba/LoteDePruebaPP/IN/";
}
