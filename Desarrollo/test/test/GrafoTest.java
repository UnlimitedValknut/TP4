package test;

import org.junit.Test;

import grafo.GrafoNDNP;

public class GrafoTest {
	private static final String PATH_ARCHIVOS = "Preparacion de Prueba/Programa Probador/Entrada/";
	private static final String PATH_ARCHIVOS_SAL = "Preparacion de Prueba/Programa Probador/Salida Esperada/";

	@Test
	public void pruebaDeColoreoAleatorioSecuencialUno() {
		GrafoNDNP grafoUno = new GrafoNDNP(PATH_ARCHIVOS + "grafoRegular5N.in");
		grafoUno.colorearSecuencialAleatorio();
		grafoUno.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafoRegular5N.out", grafoUno.getVectorNodos());
	}

	@Test
	public void pruebaDeColoreoAleatorioSecuencialDos() {
		GrafoNDNP grafoDos = new GrafoNDNP(PATH_ARCHIVOS + "grafo6N.in");
		grafoDos.colorearSecuencialAleatorio();
		grafoDos.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafo6N.out", grafoDos.getVectorNodos());
	}

	@Test
	public void pruebaDeColoreoWelshPowell() {
		GrafoNDNP grafoTres = new GrafoNDNP(PATH_ARCHIVOS + "grafo7N.in");
		grafoTres.colorearPowell();
		grafoTres.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafo7NPOW.out", grafoTres.getVectorNodos());
	}

	@Test
	public void pruebaColoreo600y40() {
		GrafoNDNP grafoTres = new GrafoNDNP(PATH_ARCHIVOS + "grafo600y40.in");
		grafoTres.colorearPowell();
		grafoTres.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafo600y40.out", grafoTres.getVectorNodos());
	}

	@Test
	public void pruebaColoreo600y60() {
		GrafoNDNP grafoTres = new GrafoNDNP(PATH_ARCHIVOS + "grafo600y60.in");
		grafoTres.colorearPowell();
		grafoTres.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafo600y60.out", grafoTres.getVectorNodos());
	}

	@Test
	public void pruebaColoreo600y90() {
		GrafoNDNP grafoTres = new GrafoNDNP(PATH_ARCHIVOS + "grafo600y90.in");
		grafoTres.colorearPowell();
		grafoTres.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafo600y90.out", grafoTres.getVectorNodos());
	}

	@Test
	public void pruebaColoreo1000y50() {
		GrafoNDNP grafoTres = new GrafoNDNP(PATH_ARCHIVOS + "grafo1000y50.in");
		grafoTres.colorearPowell();
		grafoTres.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafo1000y50.out", grafoTres.getVectorNodos());
	}

	@Test
	public void pruebaColoreo1000y75() {
		GrafoNDNP grafoTres = new GrafoNDNP(PATH_ARCHIVOS + "grafo1000y75.in");
		grafoTres.colorearPowell();
		grafoTres.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafo1000y75.out", grafoTres.getVectorNodos());
	}

	@Test
	public void pruebaColoreoNPartito800y400() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS + "grafoNPartito800y400.in");
		grafo.colorearPowell();
		grafo.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafoNPartito800y400.out", grafo.getVectorNodos());
	}

	@Test
	public void pruebaColoreoNPartito100y50() {
		GrafoNDNP grafo = new GrafoNDNP(PATH_ARCHIVOS + "grafoNPartito100y50.in");
		grafo.colorearPowell();
		grafo.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafoNPartito100y50.out", grafo.getVectorNodos());
	}
}
