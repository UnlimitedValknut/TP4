package test;

import static org.junit.Assert.*;

import org.junit.Test;

import probador.ProgramaProbador;

public class PPTest {
	private static final String PATH_ARCHIVOS_ENT = "Preparacion de Prueba/Programa Probador/Entrada/";
	private static final String PATH_ARCHIVOS_SAL = "Ejecucion de Prueba/Salida Obtenida/";

	// @Test
	// public void probadorGrafoRegular5N() {
	// ProgramaProbador.coloreo(PATH_ARCHIVOS_ENT + "grafoRegular5N.in",
	// PATH_ARCHIVOS_SAL + "grafoRegular5N.out");
	// }
	//
	// @Test
	// public void probadorGrafo6N() {
	// ProgramaProbador.coloreo(PATH_ARCHIVOS_ENT + "grafo6N.in",
	// PATH_ARCHIVOS_SAL + "grafo6N.out");
	// }
	//
	// @Test
	// public void probadorGrafo7N() {
	// ProgramaProbador.coloreo(PATH_ARCHIVOS_ENT + "grafo7N.in",
	// PATH_ARCHIVOS_SAL + "grafo7N.out");
	// }
	//
	// @Test
	// public void probadorGrafo600y40() {
	// ProgramaProbador.coloreo(PATH_ARCHIVOS_ENT + "grafo600y40.in",
	// PATH_ARCHIVOS_SAL + "grafo600y40.out");
	// }

	@Test
	public void probadorGrafoRegular1000y50SSSA() {
		assertTrue(ProgramaProbador.coloreo(PATH_ARCHIVOS_ENT + "grafo1000y50SS.in",
				PATH_ARCHIVOS_SAL + "grafo1000y50SS.out"));
	}

}
