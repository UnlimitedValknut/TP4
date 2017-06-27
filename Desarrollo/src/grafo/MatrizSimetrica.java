package grafo;

/**
 * Clase que administra la matriz simétrica de un gráfo. <br>
 */
public class MatrizSimetrica {
	private int vec[];
	private int nodos;

	public MatrizSimetrica(int nodos) {
		vec = new int[nodos * (nodos - 1) / 2];
		this.nodos = nodos;
	}

	public int getNodos() {
		return nodos;
	}

	public void setNodos(int nodos) {
		this.nodos = nodos;
	}

	public int[] getVec() {
		return vec;
	}

	public void setVec(int[] vec) {
		this.vec = vec;
	}

	public void agregarAdyacencia(int i, int j) {
		vec[calcularPos(i, j)] = 1;
	}

	public void agregarAdyacenciaConCosto(int i, int j, int costo) {
		vec[calcularPos(i, j)] = costo;
	}

	public int verAdyacencia(int i, int j) {
		return vec[calcularPos(i, j)];
	}

	public boolean sonAdyacentes(int i, int j) {
		return vec[calcularPos(i, j)] == 1;
	}

	public boolean sonAdyacentesConCosto(int i, int j) {
		return vec[calcularPos(i, j)] != 9999;
	}

	public int calcularPos(int i, int j) {
		if (i > j)
			return (int) (j * nodos + i - (Math.pow(j, 2) + 3 * j + 2) / 2);
		else
			return (int) (i * nodos + j - (Math.pow(i, 2) + 3 * i + 2) / 2);
	}

	public void iniciarACostoMax() {
		for (int i = 0; i < nodos * (nodos - 1) / 2; i++)
			vec[i] = 9999;
	}

	public void mostrar() {
		for (int i = 0; i < nodos * (nodos - 1) / 2; i++) {
			if (i != 0 && i % 10 == 0)
				System.out.println();
			System.out.print(vec[i] + "  ");
		}
	}

	public void mostrarMatrizSimetrica() {
		for (int i = 0; i < nodos; i++) {
			for (int j = 0; j < nodos; j++) {
				if (i == j)
					System.out.print("9999 ");
				else
					System.out.print(verAdyacencia(i, j) + " ");
			}
			System.out.println();
		}
	}

	public String toString() {
		String vector = "";
		for (int i = 0; i < vec.length; i++) {
			vector += vec[i] + "  ";
		}
		return vector;
	}

	public static void main(String s[]) {
		MatrizSimetrica m = new MatrizSimetrica(4);

		m.agregarAdyacencia(0, 1);
		m.agregarAdyacencia(0, 2);
		m.agregarAdyacencia(1, 3);
		m.agregarAdyacencia(2, 3);

		System.out.println("VECTOR \n----------------");
		System.out.println(m);

		System.out.print(m.sonAdyacentes(0, 1) + "  ");
		System.out.print(m.sonAdyacentes(0, 2) + "  ");
		System.out.print(m.sonAdyacentes(0, 3) + "  ");
		System.out.print(m.sonAdyacentes(1, 2) + "  ");
		System.out.print(m.sonAdyacentes(1, 3) + "  ");
		System.out.print(m.sonAdyacentes(2, 3) + "  ");
	}

}