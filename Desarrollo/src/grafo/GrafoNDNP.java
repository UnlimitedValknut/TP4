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
			// /**/System.out.print("Nodos: " + cantNodos + " ");

			cantAristas = Integer.parseInt(datos[1]);
			// /**/System.out.print("Cantidad de Aristas: " + cantAristas +
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

	// DIJKSTRA

	public void iniciarCaminos(int origen) {
		for (int i = 0; i < cantNodos; i++) {
			if (i != origen)
				caminos[i] = (int) matSim.verAdyacencia(origen, i);
		}
		caminos[origen] = 9999;
	}

	public int buscarMenor(int origen, boolean nodosVisto[]) // En el vector
																// de
																// caminos
																// el nodo
																// origen
																// tiene
																// asignado
																// el valor
																// maximo
	{
		int nodoMenor = origen;
		for (int i = 0; i < cantNodos; i++) {
			if (nodosVisto[i] == false && caminos[nodoMenor] > caminos[i])
				nodoMenor = i;
		}
		return nodoMenor;
	}

	public boolean hayCaminoMasCorto(int menor, int adyacente) // SI EL
																// CAMINO
																// DEL MENOR
																// AL
																// ADYACENTE
																// ES MAS
																// CORTO QUE
																// DEL
																// ORIGEN AL
																// DIRECTO,
																// DEVUELVE
																// TRUE
	{
		int control = caminos[menor] + matSim.verAdyacencia(menor, adyacente);
		if (control < caminos[adyacente])
			return true;
		return false;
	}

	public void iniciarPredecesor(int predecesor[], int origen) {
		for (int i = 0; i < cantNodos; i++)
			predecesor[i] = origen;
		predecesor[origen] = -1;
	}

	public void mostrarCaminos(int origen, int predecesor[]) {
		System.out.println("\nCosto de los caminos desde nodo " + origen + " : ");
		for (int i = 0; i < cantNodos; i++) {
			if (i != origen)
				System.out.println("Nodo: " + i + " -  Costo: " + caminos[i] + " - Predecesor: " + predecesor[i]);
		}
	}

	public void dijkstra(int origen) {
		int adyacente;
		int menor;
		boolean nodosVisto[] = new boolean[cantNodos];
		boolean nodosAdy[] = new boolean[cantNodos];
		int predecesor[] = new int[cantNodos];

		iniciarAFalse(nodosVisto, origen);
		iniciarAFalse(nodosAdy, origen);
		iniciarCaminos(origen);
		iniciarPredecesor(predecesor, origen);

		for (int i = 0; i < cantNodos - 1; i++) {
			menor = buscarMenor(origen, nodosVisto);
			if (menor != origen) // si menor = a origen quiere decir que ya
									// analizo todos los nodos
			{
				for (int j = 0; j < cantNodos; j++) {
					adyacente = buscarAdyacente(menor, nodosAdy);
					if (adyacente != -1) // si adyacente es igual a -1
											// quiere decir que ya analizo
											// todos los adyacentes
					{
						if (hayCaminoMasCorto(menor, adyacente)) {
							caminos[adyacente] = caminos[menor] + matSim.verAdyacencia(menor, adyacente);
							predecesor[adyacente] = menor;
						}
						nodosAdy[adyacente] = true;
					} else
						break;

				}
				iniciarAFalse(nodosAdy, origen);
				nodosVisto[menor] = true;
			} else
				break;
		}
		mostrarCaminos(origen, predecesor);
	}

	// FLOYD

	public int evaluarValor(int w, int fil, int col) {
		if (matSim.verAdyacencia(fil, col) > matSim.verAdyacencia(fil, w) + matSim.verAdyacencia(w, col))
			return matSim.verAdyacencia(fil, w) + matSim.verAdyacencia(w, col);
		else
			return matSim.verAdyacencia(fil, col);
	}

	public void floyd() {
		for (int w = 0; w < cantNodos; w++) {
			for (int fil = 0; fil < cantNodos; fil++) {
				if (fil == w) {
					fil++;
					if (fil == cantNodos)
						break;
				}

				for (int col = 0; col < cantNodos; col++) {
					while (col == w || col == fil)
						col++;
					if (col >= cantNodos)
						break;

					matSim.agregarAdyacenciaConCosto(fil, col, evaluarValor(w, fil, col));
				}
			}
		}
		matSim.mostrarMatrizSimetrica();
	}

	// WARSHALL

	public void mostrarMatriz(byte mat[][]) {
		for (int f = 0; f < cantNodos; f++) {
			for (int c = 0; c < cantNodos; c++) {
				System.out.print(mat[f][c] + " ");
			}
			System.out.println();
		}
	}

	public void generarMatrizDeWarshall(byte matWar[][]) {
		for (int f = 0; f < cantNodos; f++) {
			for (int c = 0; c < cantNodos; c++) {
				if (f != c) {
					if (matSim.verAdyacencia(f, c) != 9999)
						matWar[f][c] = 1;
					else
						matWar[f][c] = 0;
				}

			}
		}
	}

	public byte evaluarCamino(byte matWar[][], int w, int f, int c) {
		return (byte) (matWar[f][c] + (matWar[f][w] * matWar[w][c]));
	}

	public void warshall() // CON CICLOS FOR (TAMBIEN SE PODRIA HACER CON
							// WHILE)
	{
		byte matWar[][] = new byte[cantNodos][cantNodos];
		generarMatrizDeWarshall(matWar);
		System.out.println("Antes");
		mostrarMatriz(matWar);
		for (int w = 0; w < cantNodos; w++) {
			for (int fil = 0; fil < cantNodos; fil++) {
				if (fil == w) {
					fil++;
					if (fil == cantNodos)
						break;
				}

				for (int col = 0; col < cantNodos; col++) {
					while (col == w || col == fil)
						col++;
					if (col >= cantNodos)
						break;
					if (matWar[fil][col] == 0)
						matWar[fil][col] = evaluarCamino(matWar, w, fil, col);
				}
			}
		}
		System.out.println("Despues");
		mostrarMatriz(matWar);
	}

	// PRIM

	public int inicioVectores(ArrayList<String> arbol, ArrayList<Integer> nodosVistos,
			ArrayList<Integer> nodosRestantes) {
		// Busco la arista mas barata
		int nodoA = 0;
		int nodoB = 0;
		int costo = Integer.MAX_VALUE;
		for (int i = 0; i < cantNodos; i++) {
			for (int j = i + 1; j < cantNodos; j++) {
				if (matSim.verAdyacencia(i, j) < costo) {
					costo = matSim.verAdyacencia(i, j);
					nodoA = i;
					nodoB = j;
				}
			}
		}
		nodosVistos.add(nodoA);
		nodosVistos.add(nodoB);
		arbol.add(nodoA + "-" + nodoB);
		// Cargo el vector de nodos restantes
		for (int i = 0; i < cantNodos; i++)
			if (i != nodoA && i != nodoB)
				nodosRestantes.add(i);

		return costo;
	}

	public int prim(ArrayList<String> arbol) {
		int costoMinimo = 0;
		int nodoA = 0;
		int nodoB = 0;
		int costo = Integer.MAX_VALUE;
		ArrayList<Integer> nodosVistos = new ArrayList<Integer>();
		ArrayList<Integer> nodosRestantes = new ArrayList<Integer>();

		costoMinimo += inicioVectores(arbol, nodosVistos, nodosRestantes);

		while (nodosRestantes.size() > 0) {
			costo = Integer.MAX_VALUE;
			for (int i = 0; i < nodosVistos.size(); i++) {
				for (int j = 0; j < nodosRestantes.size(); j++) {
					if (matSim.sonAdyacentesConCosto(nodosVistos.get(i), nodosRestantes.get(j))) {
						if (matSim.verAdyacencia(nodosVistos.get(i), nodosRestantes.get(j)) < costo) {
							costo = matSim.verAdyacencia(nodosVistos.get(i), nodosRestantes.get(j));
							nodoA = nodosVistos.get(i);
							nodoB = nodosRestantes.get(j);
						}
					}
				}
			}
			arbol.add(nodoA + "-" + nodoB);
			nodosVistos.add(nodoB);
			nodosRestantes.remove((Integer) nodoB);
			costoMinimo += costo;
		}
		return costoMinimo;
	}

	public static void mostrarArbol(ArrayList<String> arbol) {
		Iterator<String> iterador = arbol.iterator();
		while (iterador.hasNext()) {
			String arista = iterador.next();
			System.out.println(arista);
		}
	}

	public static void main(String[] args) {
		String COSTO = "PruebaNoDirigidoConCosto";
		GrafoNDNP grafoConCosto = new GrafoNDNP("In/" + COSTO + ".in");

		// System.out.println("\n\tGRAFO CON COSTO\n\t--------------");
		//
		// System.out.print("\tDijkstra: \n\t---------");
		// grafoConCosto.dijkstra(0);
		//
		// System.out.println("\n\tFloyd: \n\t------");
		// grafoConCosto.floyd();
		//
		// System.out.println("\n\tWarshall: \n\t---------");
		// grafoConCosto.warshall();
		//
		// System.out.println("\n\tRecorro con DFS: \n\t---------------");
		// System.out.println("Es conexo: " + grafoConCosto.DFS(0));
		//
		// System.out.println("\n\tRecorro con BFS: \n\t---------------");
		// grafoConCosto.BFS(0);
		//
		//
		// String SINCOSTO = "PruebaNoDirigidoSinCosto";
		// GrafoNDNP grafoSinCosto = new GrafoNDNP( "In/" +
		// SINCOSTO + ".in");
		//
		// System.out.println("\n\n\tGRAFO SIN COSTO\n\t--------------");
		//
		// System.out.print("\tDijkstra: \n\t---------");
		// grafoSinCosto.dijkstra(0);
		//
		// System.out.println("\n\tFloyd: \n\t------");
		// grafoSinCosto.floyd();
		//
		// System.out.println("\n\tWarshall: \n\t---------");
		// grafoSinCosto.warshall();
		//
		// // No usar DFS , BFS y PRIM despues de FLOYD porque modifica la
		// matriz original
		//
		// System.out.println("\n\tRecorro con DFS: \n\t---------------");
		// System.out.println("Es conexo: " + grafoSinCosto.DFS(0));
		//
		// System.out.println("\n\tRecorro con BFS: \n\t---------------");
		// grafoSinCosto.BFS(0);

		System.out.println("\tPrim: \n\t----");
		ArrayList<String> arbol = new ArrayList<String>();
		System.out.println("Costo del arbol: " + grafoConCosto.prim(arbol));
		mostrarArbol(arbol);

	}
}
