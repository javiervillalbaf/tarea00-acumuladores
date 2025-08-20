package acumuladores;

public class Acumuladores {
	
	public static boolean estaVacia(int[][] mat) {
		return mat.length == 0;
	}
	
	public static boolean esMultiplo(int num1, int num2) {
		return num1 % num2 == 0;
	}
	
	public static boolean todosMultiplosFila(int[] fila, int num) {
		boolean todosMultiplos = true;
		for (int i = 0; i < fila.length; i++) {
			todosMultiplos = todosMultiplos && esMultiplo(fila[i],num);
		}
		return todosMultiplos;
	}
	
	public static boolean estaContenidoFila(int num, int[] fila) {
		boolean estaContenido = false;
		for (int i = 0; i < fila.length; i++) {
			estaContenido = estaContenido || num == fila[i];
		}
		return estaContenido;
	}
	
	public static boolean hayInterseccionEnUnaFila(int[] fila1, int[] fila2) {
		boolean hayInterseccion = false;
		for(int i = 0; i < fila1.length ; i++) {
			hayInterseccion = hayInterseccion || estaContenidoFila(fila1[i], fila2);
		}
		return hayInterseccion;
	}
	
	public static int sumaElementosColumna(int[][] mat, int nColum) {
		int sumaColumna = 0;
		for (int i = 0; i < mat.length; i++) {
			sumaColumna += mat[i][nColum];
		}
		return sumaColumna;
	}
	
	public static int sumaElementosFila(int[] fila) {
		int sumaFila = 0;
		for (int i = 0; i < fila.length; i++) {
			sumaFila += fila[i];
		}
		return sumaFila;
	}
	
	public static boolean estaContenidoColumna(int num, int[][] mat, int nColum) {
		boolean estaContenido = false;
		for (int i = 0; i < mat.length; i++) {
			estaContenido = estaContenido || num == mat[i][nColum];
		}
		return estaContenido;
	}
	
	public static boolean hayInterseccionEnUnaColumna(int[][] mat1, int[][] mat2, int nColum) {
		boolean hayInterseccion = false; 
		for (int i = 0; i < mat1.length; i++) {
			hayInterseccion = hayInterseccion || estaContenidoColumna( mat1[i][nColum], mat2, nColum);
		}
		return hayInterseccion;
	}
	
 	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) { 
		if (estaVacia(mat) || num <= 0) {
			return false;
		}
		boolean todosMultiplosAlgunaFila = false;
		for (int i = 0; i < mat.length; i++) {
			todosMultiplosAlgunaFila = todosMultiplosAlgunaFila || todosMultiplosFila(mat[i],num);
		}
		return todosMultiplosAlgunaFila;
	}
	
	public boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) {
		if (estaVacia(mat1) || estaVacia(mat2) || mat1.length != mat2.length) {
			return false;
		}
		boolean hayInterseccionPorFila = true;
		for (int i = 0; i < mat1.length; i++) {
			hayInterseccionPorFila = hayInterseccionPorFila && hayInterseccionEnUnaFila(mat1[i], mat2[i]);
		}
		return hayInterseccionPorFila;
	}
	
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) {
		if (estaVacia(mat) || nColum > mat.length || nColum < 0 ) {
			return false;
		}
		boolean algunaFilaMayorQueColumna = false;
		for (int i = 0; i < mat.length; i++) {
			algunaFilaMayorQueColumna = algunaFilaMayorQueColumna || sumaElementosFila(mat[i]) > sumaElementosColumna(mat, nColum);
		}
		return algunaFilaMayorQueColumna;
	}
	
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) {
		if (estaVacia(mat1) || estaVacia(mat2) || mat1[0].length != mat2[0].length) {
			return false;
		}
		boolean hayInterseccionPorColumna = true;
		for (int i = 0; i < mat1[0].length; i++) {
			hayInterseccionPorColumna = hayInterseccionPorColumna && hayInterseccionEnUnaColumna(mat1, mat2, i);
		}
		
		return hayInterseccionPorColumna;
	}
}
