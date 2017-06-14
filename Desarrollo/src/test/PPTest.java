package test;

import org.junit.Assert;
import org.junit.Test;

import probador.ProgramaProbador;

public class PPTest {
	@Test
	public void probadorGrafoRegular5N() {
		ProgramaProbador probador = new ProgramaProbador(PATH_ARCHIVOS_ENT + "grafoRegular5N.in", 
				PATH_ARCHIVOS_SAL + "grafoRegular5N.out");
		
		Assert.assertTrue(probador.probador());
	}
	
	@Test
	public void probadorGrafo6N() {
		ProgramaProbador probador = new ProgramaProbador(PATH_ARCHIVOS_ENT + "grafo6N.in", 
				PATH_ARCHIVOS_SAL + "grafo6N.out");
		
		Assert.assertTrue(probador.probador());
	}
	
	@Test
	public void probadorGrafo7N() {
		ProgramaProbador probador = new ProgramaProbador(PATH_ARCHIVOS_ENT + "grafo7N.in", 
				PATH_ARCHIVOS_SAL + "grafo7N.out");
		
		Assert.assertTrue(probador.probador());
	}
	
	private static final String PATH_ARCHIVOS_ENT = "PreparacionDePrueba/LoteDePruebaPP/IN/";
	private static final String PATH_ARCHIVOS_SAL = "PreparacionDePrueba/LoteDePruebaPP/OUT/";
}
