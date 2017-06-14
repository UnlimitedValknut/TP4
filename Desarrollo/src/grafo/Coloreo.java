package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Clase que colorea los nodos de un grafo. <br>
 */
public class Coloreo {
	/**
	 * Cantidad de nodos del grafo. <br>
	 */
	private int cantidadNodos;
	/**
	 * Cantidad de aristas del grafo. <br>
	 */
	private int cantidadAristas;
	/**
	 * Lista de nodos. <br>
	 */
	private List<Nodo> nodos;
	/**
	 * Matriz simétrica del gráfo. <br>
	 */
	private MatrizSimetrica matrizSimetrica;
	/**
	 * Cantidad de colores del grafo. <br>
	 */
	private int cantidadDeColores;

	public Coloreo(MatrizSimetrica matrizSimetrica) {
		this.matrizSimetrica = matrizSimetrica;
		this.nodos = new ArrayList<Nodo>();
		this.cantidadNodos = matrizSimetrica.getPosiciones();
		this.cantidadAristas = matrizSimetrica.getCantidadAristas();
		for (int i = 0; i < this.cantidadNodos; i++) {
			nodos.add(new Nodo(i, 0, 0));
		}
		for (int i = 0; i < this.cantidadNodos; i++) {
			for (int j = i + 1; j < this.cantidadNodos; j++) {
				if (matrizSimetrica.getMatrizSimetrica(i, j) == true) {
					nodos.get(i).setGrado(nodos.get(i).getGrado() + 1);
					nodos.get(j).setGrado(nodos.get(j).getGrado() + 1);
				}
			}
		}
	}

	public void aleatorioSecuencial() {
		Collections.shuffle(this.nodos);
		colorear();
	}

	public void matula() {
		Random rand = new Random();
		double numero;
		for (int i = 0; i < this.cantidadNodos; i++) {
			for (int j = i + 1; j < this.cantidadNodos; j++) {
				numero = rand.nextDouble();
				if (nodos.get(i).getGrado() > nodos.get(j).getGrado()) {
					Nodo auxiliar = nodos.get(i);
					nodos.set(i, nodos.get(j));
					nodos.set(j, auxiliar);
				} else {
					if (numero > 0.5) {
						if (nodos.get(i).getGrado() == nodos.get(j).getGrado()
								&& nodos.get(i).getNumero() < nodos.get(j).getNumero()) {
							Nodo auxiliar = nodos.get(i);
							nodos.set(i, nodos.get(j));
							nodos.set(j, auxiliar);
						}
					}
				}
			}
		}
		colorear();
	}

	public void welshPowell() {
		Random rand = new Random();
		double numero;
		for (int i = 0; i < this.cantidadNodos; i++) {
			for (int j = i + 1; j < this.cantidadNodos; j++) {
				numero = rand.nextDouble();
				if (nodos.get(i).getGrado() < nodos.get(j).getGrado()) {
					Nodo auxiliar = nodos.get(i);
					nodos.set(i, nodos.get(j));
					nodos.set(j, auxiliar);
				} else {
					if (numero > 0.5) {
						if (nodos.get(i).getGrado() == nodos.get(j).getGrado()
								&& nodos.get(i).getNumero() < nodos.get(j).getNumero()) {
							Nodo auxiliar = nodos.get(i);
							nodos.set(i, nodos.get(j));
							nodos.set(j, auxiliar);
						}
					}
				}
			}
		}
		colorear();
	}

	private void colorear() {
		int i, color;
		for (i = 0; i < this.cantidadNodos; i++) {
			color = 1;
			while (!sePuedeColorear(i, color)) {
				color++;
			}
			nodos.get(i).setColor(color);
			if (color > this.cantidadDeColores) {
				this.cantidadDeColores = color;
			}
		}
	}

	/**
	 * 
	 * @param n
	 * @param color
	 * @return
	 */
	private boolean sePuedeColorear(final int n, final int color) {
		int i = 0;
		if (nodos.get(n).getColor() != 0) { // si el nodo fue coloreado
			return false; // no puedo colorear
		}
		while (i < cantidadNodos) {
			if (nodos.get(i).getColor() == color) { // si el nodo a colorear es
													// adyacente a un nodo ya
													// pintado de ese
				if (esAdyacente(nodos.get(i), nodos.get(n))) // color, no lo
																// podrá
																// colorear
					return false;
			}
			i++;
		}
		return true;
	}

	/**
	 * Indica si un nodo es adyacente a otro. <br>
	 * 
	 * @param nodo1
	 *            Nodo. <br>
	 * @param nodo2
	 *            Supuesto nodo adyacente. <br>
	 * @return true si es adyacente, false de lo contrario. <br>
	 */
	private boolean esAdyacente(final Nodo nodo1, final Nodo nodo2) {
		return matrizSimetrica.getMatrizSimetrica(nodo1.getNumero(), nodo2.getNumero()) == true;
	}

	/**
	 * Establece el color de los nodos. <br>
	 * Lo inicializa en cero. <br>
	 */
	public void setearNodos() {
		for (Nodo nodo : nodos) {
			nodo.setColor(0);
		}
		this.cantidadDeColores = 0;
	}

	/**
	 * Devuelve la cantidad de nodos. <br>
	 * 
	 * @return Cantidad de nodos. <br>
	 */
	public int getCantidadNodos() {
		return cantidadNodos;
	}

	/**
	 * Establece la cantidad de nodos. <br>
	 * 
	 * @param cantidadNodos
	 *            Cantidad de nodos. <br>
	 */
	public void setCantidadNodos(final int cantidadNodos) {
		this.cantidadNodos = cantidadNodos;
	}

	/**
	 * Devuelve la cantidad de aristas. <br>
	 * 
	 * @return Cantidad de aristas. <br>
	 */
	public int getCantidadAristas() {
		return cantidadAristas;
	}

	/**
	 * Establece la cantidad de aristas. <br>
	 * 
	 * @param cantidadAristas
	 *            Cantidad de aristas. <br>
	 */
	public void setCantidadAristas(final int cantidadAristas) {
		this.cantidadAristas = cantidadAristas;
	}

	/**
	 * Devuelve la cantidad de colores. <br>
	 * 
	 * @return Cantidad de colores. <br>
	 */
	public int getCantidadDeColores() {
		return cantidadDeColores;
	}

	/**
	 * Establece la cantidad de colores. <br>
	 * 
	 * @param cantidadDeColores
	 *            Cantidad de colores. <br>
	 */
	public void setCantidadDeColores(final int cantidadDeColores) {
		this.cantidadDeColores = cantidadDeColores;
	}

	// public void printearColoreo() {
	// for (int i = 0; i < this.cantNodos; i++) {
	// System.out.print("Nodo:" + nodos.get(i).getNumero());
	// System.out.print(" Grado:" + nodos.get(i).getGrado());
	// System.out.println(" Color:" + nodos.get(i).getColor());
	// }
	// }
}
