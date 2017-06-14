package herramientas;

import java.util.Comparator;

import grafo.Nodo;

/**
 * Compara los números de dos nodos. <br>
 */
public class ComparadorDeNumeros implements Comparator<Nodo> {
	/**
	 * Compara dos nodos. <br>
	 */
	@Override
	public int compare(Nodo arg0, Nodo arg1) {
		Integer numeroUno = arg0.getNumero();
		Integer numeroDos = arg1.getNumero();
		return numeroUno.compareTo(numeroDos);
	}
}
