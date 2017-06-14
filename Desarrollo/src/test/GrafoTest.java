package test;

import org.junit.Test;

import grafo.Coloreo;
import grafo.GrafoNDNP;

public class GrafoTest {

	@Test
	public void pruebaDeColoreoAleatorioSecuencialUno(){
		GrafoNDNP grafoUno = new GrafoNDNP(PATH_ARCHIVOS + "grafoRegular5N.in");
		grafoUno.crearColoreo();
		grafoUno.getColoreo().aleatorioSecuencial();
		grafoUno.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafoRegular5N.out"); 
	}
	
	@Test
	public void pruebaDeColoreoAleatorioSecuencialDos(){
		GrafoNDNP grafoDos = new GrafoNDNP(PATH_ARCHIVOS + "grafo6N.in");
		grafoDos.getColoreo().aleatorioSecuencial();
		grafoDos.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafo6N.out");
	}
	
	@Test
	public void pruebaDeColoreoWelshPowell(){
		GrafoNDNP grafoTres = new GrafoNDNP(PATH_ARCHIVOS + "grafo7N.in");
		grafoTres.getColoreo().welshPowell();
		grafoTres.grabarSalidaGrafo(PATH_ARCHIVOS_SAL + "grafo7N.out");
	}
	
	private static final String PATH_ARCHIVOS = "PreparacionDePrueba/LoteDePruebaPP/IN/";
	private static final String PATH_ARCHIVOS_SAL = "PreparacionDePrueba/LoteDePruebaPP/OUT/";
}
