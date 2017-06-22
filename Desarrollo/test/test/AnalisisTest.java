package test;

import org.junit.Test;

import grafo.GrafoNDNP;
import herramientas.Constante;

public class AnalisisTest {
	private static final String PATH_ARCHIVOS_ENT = "Preparacion de Prueba/Programa Probador/Entrada/";
	private static final String PATH_ARCHIVOS_EJECUCION = "Ejecucion De Prueba/Salida Obtenida/";

	@Test
	public void analisisGrafo600y40AS() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y40.in");
		grafo.ejecutarCaso(Constante.SECUENCIAL_ALEATORIO, 10000, PATH_ARCHIVOS_EJECUCION + "grafo600y40AS.out");
	}

	@Test
	public void analisisGrafo600y40WP() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y40.in");
		grafo.ejecutarCaso(Constante.WELSH_POWELL, 10000, PATH_ARCHIVOS_EJECUCION + "grafo600y40WP.out");
	}

	@Test
	public void analisisGrafo600y40M() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y40.in");
		grafo.ejecutarCaso(Constante.MATULA, 10000, PATH_ARCHIVOS_EJECUCION + "grafo600y40M.out");
	}

	@Test
	public void analisisGrafo600y60AS() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y60.in");
		grafo.ejecutarCaso(Constante.SECUENCIAL_ALEATORIO, 10000, PATH_ARCHIVOS_EJECUCION + "grafo600y60AS.out");
	}

	@Test
	public void analisisGrafo600y60WP() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y60.in");
		grafo.ejecutarCaso(Constante.WELSH_POWELL, 10000, PATH_ARCHIVOS_EJECUCION + "grafo600y60WP.out");
	}

	@Test
	public void analisisGrafo600y60M() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y60.in");
		grafo.ejecutarCaso(Constante.MATULA, 10000, PATH_ARCHIVOS_EJECUCION + "grafo600y60M.out");
	}

	@Test
	public void analisisGrafo600y90AS() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y90.in");
		grafo.ejecutarCaso(Constante.SECUENCIAL_ALEATORIO, 10000, PATH_ARCHIVOS_EJECUCION + "grafo600y90AS.out");
	}

	@Test
	public void analisisGrafo600y90WP() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y90.in");
		grafo.ejecutarCaso(Constante.WELSH_POWELL, 10000, PATH_ARCHIVOS_EJECUCION + "grafo600y90WP.out");
	}

	@Test
	public void analisisGrafo600y90M() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo600y90.in");
		grafo.ejecutarCaso(Constante.MATULA, 10000, PATH_ARCHIVOS_EJECUCION + "grafo600y90M.out");
	}

	@Test
	public void analisisGrafoRegular1000y50AS() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo1000y50.in");
		grafo.ejecutarCaso(Constante.SECUENCIAL_ALEATORIO, 10000, PATH_ARCHIVOS_EJECUCION + "grafo1000y50AS.out");
	}

	@Test
	public void analisisGrafoRegular1000y50WP() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo1000y50.in");
		grafo.ejecutarCaso(Constante.WELSH_POWELL, 10000, PATH_ARCHIVOS_EJECUCION + "grafo1000y50WP.out");
	}

	@Test
	public void analisisGrafoRegular1000y50M() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo1000y50.in");
		grafo.ejecutarCaso(Constante.MATULA, 10000, PATH_ARCHIVOS_EJECUCION + "grafo1000y50M.out");
	}

	@Test
	public void analisisGrafoRegular1000y75AS() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo1000y75.in");
		grafo.ejecutarCaso(Constante.SECUENCIAL_ALEATORIO, 10000, PATH_ARCHIVOS_EJECUCION + "grafo1000y75AS.out");

	}

	@Test
	public void analisisGrafoRegular1000y75WP() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo1000y75.in");
		grafo.ejecutarCaso(Constante.WELSH_POWELL, 10000, PATH_ARCHIVOS_EJECUCION + "grafo1000y75WP.out");
	}

	@Test
	public void analisisGrafoRegular1000y75M() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS_ENT + "grafo1000y75.in");
		grafo.ejecutarCaso(Constante.MATULA, 10000, PATH_ARCHIVOS_EJECUCION + "grafo1000y75M.out");
	}

}
