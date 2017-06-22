package probador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import grafo.MatrizSimetrica;
import grafo.Nodo;

public class ProgramaProbador {
	/**
	 * Matriz simétrica del gráfo. <br>
	 */
	private MatrizSimetrica matrizSimetrica;
	/**
	 * Nodos del gráfo. <br>
	 */
	private ArrayList<Nodo> nodos;
	/**
	 * Cantidad total de nodos del gráfo. <br>
	 */
	private int cantNodos;
	/**
	 * Cantidad total de aristas del gráfo. <br>
	 */
	private int cantAristas;
	/**
	 * Cantidad de nodos coloreados. <br>
	 */
	private int cantNodosColoreo;
	/**
	 * Cantidad de aristas coloreadas. <br>
	 */
	private int cantAristasColoreo;
	/**
	 * Cantidad de colores utilizados. <br>
	 */
	private int cantColores;

	/**
	 * Crea el programa que prueba el algoritmo de coloreo del grafo. <br>
	 * 
	 * @param pathIn
	 *            Dirección del archivo de entrada. <br>
	 * @param pathOut
	 *            Dirección del archivo de salida. <br>
	 */
	public ProgramaProbador(final String pathIn, final String pathOut) {
		FileReader ent = null;
		FileReader sal = null;
		BufferedReader entrada = null;
		BufferedReader salida = null;
		String linea;
		String[] data;
		boolean bandera = false;
		int fila, columna, pos = 0;
		try {
			ent = new FileReader(new File(pathIn));
			entrada = new BufferedReader(ent);
			while ((linea = entrada.readLine()) != null) {
				data = linea.split(" ");
				if (!bandera) {
					this.cantNodos = Integer.parseInt(data[0]);
					this.cantAristas = Integer.parseInt(data[1]);
					this.matrizSimetrica = new MatrizSimetrica(this.cantNodos);
					bandera = true;
				} else {
					fila = Integer.parseInt(data[0]);
					columna = Integer.parseInt(data[1]);
					matrizSimetrica.setMatrizSimetrica(fila, columna);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				entrada.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		bandera = false;
		try {
			sal = new FileReader(new File(pathOut));
			salida = new BufferedReader(sal);
			while ((linea = salida.readLine()) != null) {
				data = linea.split(" ");
				if (!bandera) {
					this.cantNodosColoreo = Integer.parseInt(data[0]);
					this.cantColores = Integer.parseInt(data[1]);
					this.cantAristasColoreo = Integer.parseInt(data[2]);
					this.nodos = new ArrayList<>();
					bandera = true;
				} else {
					pos = Integer.parseInt(data[0]);
					int color = Integer.parseInt(data[1]);
					this.nodos.add(new Nodo(pos, color, 0));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				salida.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Comprueba que lo obtenido con el programa probador coincida con la salida
	 * esperada. <br>
	 * 
	 * @return true si coincide el resultado, false de lo contrario. <br>
	 */
	public boolean probador() {
		int color, numero;
		if (nodos.size() != matrizSimetrica.getPosiciones() || cantNodos != cantNodosColoreo
				|| cantAristas != cantAristasColoreo) {
			return false;
		}
		for (int i = 0; i < nodos.size(); i++) {
			color = nodos.get(i).getColor();
			numero = nodos.get(i).getNumero();
			for (int j = numero + 1; j < nodos.size(); j++) {
				if (matrizSimetrica.getMatrizSimetrica(numero, j) == true && color == nodos.get(j).getColor()) {
					return false;
				}
			}
		}
		return true;
	}
}
