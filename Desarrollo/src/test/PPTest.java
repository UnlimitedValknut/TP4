package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import probador.ProgramaProbador;

public class PPTest {
	private static final String PATH_ARCHIVOS_ENT = "Preparacion de Prueba/Programa Probador/Entrada/";
	private static final String PATH_ARCHIVOS_SAL = "Preparacion de Prueba/Programa Probador/Salida Esperada/";

	@Test
	public void probadorGrafoRegular5N() {
		ProgramaProbador probador = new ProgramaProbador(PATH_ARCHIVOS_ENT + "grafoRegular5N.in",
				PATH_ARCHIVOS_SAL + "grafoRegular5N.out");
		assertTrue(probador.probador());
	}

	@Test
	public void probadorGrafo6N() {
		ProgramaProbador probador = new ProgramaProbador(PATH_ARCHIVOS_ENT + "grafo6N.in",
				PATH_ARCHIVOS_SAL + "grafo6N.out");
		assertTrue(probador.probador());
	}

	@Test
	public void probadorGrafo7N() {
		ProgramaProbador probador = new ProgramaProbador(PATH_ARCHIVOS_ENT + "grafo7N.in",
				PATH_ARCHIVOS_SAL + "grafo7N.out");
		assertTrue(probador.probador());
	}

	@Test
	public void probadorGrafo600y40() {
		ProgramaProbador probador = new ProgramaProbador(PATH_ARCHIVOS_ENT + "grafo600y40.in",
				PATH_ARCHIVOS_SAL + "grafo600y40.out");
		assertTrue(probador.probador());
	}

	@Test
	public void probadorGrafoNPartito() {
		ProgramaProbador probador = new ProgramaProbador(PATH_ARCHIVOS_ENT + "grafoNPartito800y400.in",
				PATH_ARCHIVOS_SAL + "grafoNPartito800y400.out");
		assertTrue(probador.probador());
	}
}
