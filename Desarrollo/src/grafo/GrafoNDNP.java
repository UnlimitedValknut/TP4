package grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Clase que administra y resuelve un gráfo no dirigido no ponderado. <br>
 */
public class GrafoNDNP {

	private int cantNodos;
	private int cantAristas;
	private int porcentaje;
	private int gradoMax;
	private int gradoMin;
	private MatrizSimetrica matSim;
	private int caminos[];

	public GrafoNDNP(int nodos) {
		this.cantNodos = nodos;
		matSim = new MatrizSimetrica(nodos);
		caminos = new int[nodos];
	}

	public GrafoNDNP() {
		this(0);
	}

	public GrafoNDNP(String ruta) {
		try {
			FileReader input = new FileReader(ruta);
			BufferedReader bufInput = new BufferedReader(input);
			String line;
			String datos[];
			line = bufInput.readLine();
			datos = line.split(" ");

			cantNodos = Integer.parseInt(datos[0]);
			// /**/System.out.print("Nodos: " + cantidadNodos + " ");

			cantAristas = Integer.parseInt(datos[1]);
			// /**/System.out.print("Cantidad de Aristas: " + cantidadAristas +
			// " ");

			porcentaje = Integer.parseInt(datos[2]);
			// /**/System.out.print("Porcentaje: " + porcentaje + " ");

			gradoMax = Integer.parseInt(datos[3]);
			// /**/System.out.print("Grado Max: " + gradoMax + " ");

			gradoMin = Integer.parseInt(datos[4]);
			// /**/System.out.println("Grado Min: " + gradoMin);

			caminos = new int[cantNodos];
			matSim = new MatrizSimetrica(cantNodos);

			matSim.iniciarACostoMax();

			for (int i = 0; i < cantAristas; i++) {
				line = bufInput.readLine();
				datos = line.split(" ");
				if (datos.length == 2)
					matSim.agregarAdyacencia(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]));
				else
					matSim.agregarAdyacenciaConCosto(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]),
							Integer.parseInt(datos[2]));
			}
			bufInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// DFS

	public void iniciarAFalse(boolean vec[], int origen) {
		for (int i = 0; i < cantNodos; i++)
			vec[i] = false;
		vec[origen] = true;
	}

	public int hayCiclo(int nodo, boolean adyVistos[], int origen) {
		int i = 0;
		int ciclo = 0;
		while (i < cantNodos) {
			if (i != origen) {
				if (adyVistos[i] == true && matSim.sonAdyacentes(nodo, i)) {
					ciclo = 1;
					break;
				}
			}
			i++;
		}
		return ciclo;
	}

	public int buscarAdyacente(int nodo, boolean adyVistos[]) {
		int i = 0;
		int adyacente = -1;
		while (i < cantNodos) {
			if (adyVistos[i] == false && matSim.sonAdyacentesConCosto(nodo, i)) // El
																				// nodo
																				// origen
																				// por
																				// la
																				// inicializacion
																				// ya
																				// esta
																				// en
																				// TRUE
																				// y
																				// nodo
																				// menor
																				// tiene
																				// valor
																				// 9999
			{
				adyVistos[i] = true;
				adyacente = i;
				break;
			}
			i++;
		}
		return adyacente;
	}

	public boolean todosVistos(boolean nodosVistos[]) {
		for (int i = 0; i < cantNodos; i++) {
			if (nodosVistos[i] == false)
				return false;
		}
		return true;
	}

	public boolean DFS(int origen) {
		Stack<Integer> pila = new Stack<Integer>();
		boolean nodosVistos[] = new boolean[cantNodos];
		int nodo;
		boolean esConexo;

		iniciarAFalse(nodosVistos, origen);
		pila.push(origen);
		System.out.println("Empiezo del nodo: " + origen);
		while (!pila.empty()) {
			nodo = pila.peek();
			for (int i = 0; i < cantNodos; i++) {
				nodo = buscarAdyacente(nodo, nodosVistos);
				if (nodo != -1) {
					nodosVistos[nodo] = true;
					pila.push(nodo);
					System.out.println("Visito el nodo: " + nodo);
				} else {
					System.out.println("Vuelvo del nodo: " + pila.peek());
					pila.pop();
					break;
				}
			}
		}
		esConexo = todosVistos(nodosVistos);
		return esConexo;
	}

	// BFS

	public void BFS(int origen) {
		LinkedList<Integer> cola = new LinkedList<Integer>();
		boolean nodosVistos[] = new boolean[cantNodos];
		int nodo;

		iniciarAFalse(nodosVistos, origen);
		System.out.println("Acolo el origen: " + origen);
		cola.add(origen);
		while (!cola.isEmpty()) {
			nodo = cola.peek();
			for (int i = 0; i < cantNodos; i++) {
				nodo = buscarAdyacente(nodo, nodosVistos);
				if (nodo != -1) {
					System.out.println("Acolo el nodo: " + nodo);
					cola.add(nodo);
					nodo = cola.peek();
				} else {
					System.out.println("Desacolo el nodo: " + cola.peek());
					cola.remove();
					break;
				}

			}
		}
	}
}
