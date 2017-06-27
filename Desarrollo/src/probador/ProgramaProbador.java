package probador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import grafo.Grafo;
import herramientas.EntradaSalida;

public class ProgramaProbador {
	// /**
	// * Matriz simétrica del gráfo. <br>
	// */
	// private MatrizSimetrica matrizSimetrica;
	// /**
	// * Nodos del gráfo. <br>
	// */
	// private ArrayList<Nodo> nodos;
	// /**
	// * Cantidad total de nodos del gráfo. <br>
	// */
	// private int cantNodos;
	// /**
	// * Cantidad total de aristas del gráfo. <br>
	// */
	// private int cantAristas;
	// /**
	// * Cantidad de nodos coloreados. <br>
	// */
	// private int cantNodosColoreo;
	// /**
	// * Cantidad de aristas coloreadas. <br>
	// */
	// private int cantAristasColoreo;
	// /**
	// * Cantidad de colores utilizados. <br>
	// */
	// private int cantColores;

	// /**
	// * Crea el programa que prueba el algoritmo de coloreo del grafo. <br>
	// *
	// * @param pathIn
	// * Dirección del archivo de entrada. <br>
	// * @param pathOut
	// * Dirección del archivo de salida. <br>
	// */
	// public ProgramaProbador(final String pathIn, final String pathOut) {
	// FileReader ent = null;
	// FileReader sal = null;
	// BufferedReader entrada = null;
	// BufferedReader salida = null;
	// String linea;
	// String[] data;
	// boolean bandera = false;
	// int fila, columna, pos = 0;
	// try {
	// ent = new FileReader(new File(pathIn));
	// entrada = new BufferedReader(ent);
	// while ((linea = entrada.readLine()) != null) {
	// data = linea.split(" ");
	// if (!bandera) {
	// this.cantNodos = Integer.parseInt(data[0]);
	// this.cantAristas = Integer.parseInt(data[1]);
	// this.matrizSimetrica = new MatrizSimetrica(this.cantNodos);
	// bandera = true;
	// } else {
	// fila = Integer.parseInt(data[0]);
	// columna = Integer.parseInt(data[1]);
	// matrizSimetrica.setMatrizSimetrica(fila, columna);
	// }
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// entrada.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// bandera = false;
	// try {
	// sal = new FileReader(new File(pathOut));
	// salida = new BufferedReader(sal);
	// while ((linea = salida.readLine()) != null) {
	// data = linea.split(" ");
	// if (!bandera) {
	// this.cantNodosColoreo = Integer.parseInt(data[0]);
	// this.cantColores = Integer.parseInt(data[1]);
	// this.cantAristasColoreo = Integer.parseInt(data[2]);
	// this.nodos = new ArrayList<>();
	// bandera = true;
	// } else {
	// pos = Integer.parseInt(data[0]);
	// int color = Integer.parseInt(data[1]);
	// this.nodos.add(new Nodo(pos, color, 0));
	// }
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// try {
	// salida.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }

	// /**
	// * Comprueba que lo obtenido con el programa probador coincida con la
	// salida
	// * esperada. <br>
	// *
	// * @return true si coincide el resultado, false de lo contrario. <br>
	// */
	// public boolean probador() {
	// int color, numero;
	// if (nodos.size() != matrizSimetrica.getPosiciones() || cantNodos !=
	// cantNodosColoreo
	// || cantAristas != cantAristasColoreo) {
	// return false;
	// }
	// for (int i = 0; i < nodos.size(); i++) {
	// color = nodos.get(i).getColor();
	// numero = nodos.get(i).getNumero();
	// for (int j = numero + 1; j < nodos.size(); j++) {
	// if (matrizSimetrica.getMatrizSimetrica(numero, j) == true && color ==
	// nodos.get(j).getColor()) {
	// return false;
	// }
	// }
	// }
	// return true;
	// }

	// public static void main(String[] args) {
	// System.out.println(Probador.coloreo("grafo.in", "coloreo.out"));
	// }

	public static boolean coloreo(String pathGrafo, String pathColoreo) {
		Grafo grafo = EntradaSalida.leerGrafoArch(pathGrafo);

		int listaColoresNodos[] = null;
		Set<Integer> codigoColor = new HashSet<Integer>(); // C�digo �nico.
		int cantNodosPintados = 0;
		int cantColoresPintados = 0;
		boolean esNodoPintado[] = null;

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File(pathColoreo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea = br.readLine();
			String datos[] = linea.split(" ");
			cantNodosPintados = Integer.parseInt(datos[0]);
			cantColoresPintados = Integer.parseInt(datos[1]);
			listaColoresNodos = new int[cantNodosPintados];
			esNodoPintado = new boolean[cantNodosPintados];

			for (int i = 0; (linea = br.readLine()) != null; i++) {
				/* Verifica que no haya m�s nodos que la cantidad de nodos. */
				if (i == cantNodosPintados) {
					System.out.println("Hay nodos de sobra.");
					return false;
				}

				/* Verifica que un nodo no aparezca dos veces en el coloreo. */
				datos = linea.split(" ");
				int nodoActual = Integer.parseInt(datos[0]);
				if (esNodoPintado[nodoActual]) {
					System.out.println("Nodo '" + nodoActual + "' pintado m�s de una vez.");
					return false;
				}
				esNodoPintado[nodoActual] = true;

				/* Verifica que cada nodo tenga un c�digo de color. */
				if (datos.length == 1) {
					System.out.println("Nodo '" + nodoActual + "' pintado sin color.");
					return false;
				}

				int colorActual = Integer.parseInt(datos[1]);
				listaColoresNodos[nodoActual] = colorActual;
				codigoColor.add(colorActual);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		/*
		 * Verifica que la cantidad de nodos del archivo coloreo coincida con la
		 * cantidad de nodos del archivo grafos.
		 */
		if (cantNodosPintados != grafo.cantidadNodos) {
			System.out.println("La cantidad de nodos del Grafo: " + cantNodosPintados
					+ ", no coincide con la cantidad de nodos pintados: " + grafo.cantidadNodos + ".");
			return false;
		}

		/*
		 * Verifica que si el archivo de coloreo dice que us� X cantidad de
		 * colores, se hayan pintando X colores distintos.
		 */
		if (cantColoresPintados != codigoColor.size()) {
			System.out.println("La cantidad de colores: " + cantColoresPintados
					+ ", no coincide con la cantidad de colores pintados: " + codigoColor.size() + ".");
			return false;
		}

		/* Verifica que todos los nodos est�n pintados. */
		for (int i = 0; i < esNodoPintado.length; i++)
			if (!esNodoPintado[i]) {
				System.out.println("No est�n pintados todos los nodos. Falta el nodo: " + i + ".");
				return false;
			}

		/* Verifica que no haya nodos adyacentes pintados del mismo color. */
		for (int i = 0; i < listaColoresNodos.length; i++)
			for (int j = i + 1; j < listaColoresNodos.length; j++)
				if (listaColoresNodos[i] == listaColoresNodos[j] && grafo.matrizSimetrica.esNodoAdyacenteCon(i, j)) {
					System.out.println("Nodos adyacentes (" + i + "," + j + ") pintados del mismo color.");
					return false;
				}
		return true;
	}

}
