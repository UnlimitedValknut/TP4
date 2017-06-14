package prueba;

import java.util.ArrayList;
import java.util.Iterator;

import grafo.GrafoNDNP;

public class Analisis { 
	private int[] cantCorridas;
	private GrafoNDNP grafo;
	private ArrayList<Ejecucion> ejecuciones;
	
	public Analisis(int cantidadCorridas, GrafoNDNP grafo) {
		this.cantCorridas = new int[cantidadCorridas];
		this.grafo = grafo;
		ejecuciones = new ArrayList<>();
	}
	
	
	public void ejecucionGrafoSecuencialAleatorio() {
		for (int i = 0; i < cantCorridas.length; i++) {
			this.grafo.crearColoreo();
			this.grafo.getColoreo().aleatorioSecuencial();
			this.cantCorridas[i] = this.grafo.getColoreo().getCantidadDeColores();
		}
	}
	
	public void ejecucionGrafoWelshPowell() {
		for (int i = 0; i < cantCorridas.length; i++) {
			this.grafo.crearColoreo();
			this.grafo.getColoreo().welshPowell();
			this.cantCorridas[i] = this.grafo.getColoreo().getCantidadDeColores();
		}
	}
	
	public void ejecucionGrafoMatula() {
		for (int i = 0; i < cantCorridas.length; i++) {
			this.grafo.crearColoreo();
			this.grafo.getColoreo().matula();
			this.cantCorridas[i] = this.grafo.getColoreo().getCantidadDeColores();
		}
	}
	
	public void recopilarInformacion() {
		int i = 0, pos = -1;
		algSeleccion(cantCorridas);
		
		while(i < cantCorridas.length) {
			int cc = cantCorridas[i];
			ejecuciones.add(new Ejecucion(cc, 0));
			pos++;
			
			while(i < cantCorridas.length && cantCorridas[i] == cc) {
				ejecuciones.get(pos).setRepeticiones(ejecuciones.get(pos).getRepeticiones() + 1);
				i++;
			}
		}
	}
	
	public void mostrarInformacion() {
		for (Iterator iterator = ejecuciones.iterator(); iterator.hasNext();) {
			Ejecucion ejecucion = (Ejecucion) iterator.next();
			
			System.out.println(ejecucion.getCantColores() + "::" + ejecucion.getRepeticiones());
			
		}
	}
	
	private void algSeleccion(int[] vector) {
		int minValor;
		int aux;
		
		for(int i=0;i<(vector.length-1);i++)
		{
			minValor = i;
			
			for(int j=i+1;j<vector.length;j++)
			{
				if(vector[j]<vector[minValor])
					minValor = j;
			}
			
			aux = vector[i];
			vector[i] = vector[minValor];
			vector[minValor] = aux;
		}
	}
}
