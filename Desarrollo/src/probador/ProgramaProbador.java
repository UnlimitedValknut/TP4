package probador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import grafo.MatrizSimetrica;
import grafo.Nodo;

@SuppressWarnings("unused")
public class ProgramaProbador {
	private MatrizSimetrica matrizSimetrica;
	private ArrayList<Nodo> nodos;
	private int cantNodos;
	private int cantAristas;
	private int cantNodosColoreo;
	private int cantAristasColoreo;
	private int cantColores;
	
	public ProgramaProbador(String pathIn, String pathOut) {
		Scanner in = null;
		Scanner out = null;
		
		//LEO ENTRADA
		try {
			in = new Scanner(new File(pathIn));
			
			if(in.hasNextLine()) {
				this.cantNodos = in.nextInt();
				this.cantAristas = in.nextInt();
				
				in.nextInt();
				in.nextInt();
				in.nextInt();
				
				this.matrizSimetrica = new MatrizSimetrica(this.cantNodos);
				
				for(int i=0; i < this.cantAristas; i++) {
					this.matrizSimetrica.setMatrizSimetrica(in.nextInt(), in.nextInt());
				}
			}
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		
		//LEO SALIDA
		try {
			out = new Scanner(new File(pathOut));
			
			if(out.hasNextLine()) {
				this.cantNodosColoreo = out.nextInt();
				this.cantColores = out.nextInt();
				this.cantAristasColoreo = out.nextInt();
				
				out.nextInt();
				out.nextInt();
				out.nextInt();
				
				this.nodos = new ArrayList<>();
				
				for (int i = 0; i < this.cantNodosColoreo; i++) {
					this.nodos.add(new Nodo(out.nextInt(), out.nextInt(), 0));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	public boolean probador() {
		int color;
		
		if(nodos.size() != matrizSimetrica.getPosiciones() || cantNodos != cantNodosColoreo || cantAristas != cantAristasColoreo)
			return false;
		
		for (int i = 0; i < cantNodos; i++) {
			color = nodos.get(i).getColor();

			for (int j = i+1; j < cantNodos; j++) {
					if(matrizSimetrica.getMatrizSimetrica(i, j)==true && color == nodos.get(j).getColor())
						return false;
			}
		}
		return true;
	}
}
