package probador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import grafo.GrafoNDNP;

public class ProgramaProbador {

	public static boolean coloreo(String pathGrafo, String pathColoreo) {
		GrafoNDNP grafo = new GrafoNDNP(pathGrafo);

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
		if (cantNodosPintados != grafo.getVectorNodos().length) {
			System.out.println("La cantidad de nodos del Grafo: " + cantNodosPintados
					+ ", no coincide con la cantidad de nodos pintados: " + grafo.getVectorNodos().length + ".");
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
				if (listaColoresNodos[i] == listaColoresNodos[j]
						&& grafo.getMatrizSimetrica().esNodoAdyacenteCon(i, j)) {
					System.out.println("Nodos adyacentes (" + i + "," + j + ") pintados del mismo color.");
					return false;
				}
		return true;
	}

}
