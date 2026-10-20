
package MetodoGauss;
// Mismo paquete para poder llamar a la clase Gauss

public class GaussJordan {
    // Clase principal del método Gauss‑Jordan

    public static void main(String[] args) {
        // Punto de inicio obligatorio del programa
        double[][] matriz = MetodoGauss.leerDatos();
        // Llamamos al método de lectura de la clase Gauss
        double[] solucion = gaussJordan(matriz);
        // Aplicamos el algoritmo completo de Gauss‑Jordan
        imprimirResultado(solucion);
        // Mostramos el resultado final
    }

    public static double[] gaussJordan(double[][] m) {
        // Método que completa el proceso de Gauss‑Jordan
        int n = m.length;
        // Obtenemos el número de filas
        MetodoGauss.eliminacionGauss(m);
        // Reutilizamos la triangulación superior de la clase Gauss

        for (int k = n - 1; k >= 0; k--) {
            // Recorremos filas desde la última hasta la primera
            double pivote = m[k][k];
            // Guardamos el valor del pivote actual
            for (int j = k; j <= n; j++) {
                // Recorremos columnas de la fila del pivote
                m[k][j] /= pivote;
                // Dividimos toda la fila para que el pivote sea 1
            }
            for (int i = 0; i < k; i++) {
                // Recorremos filas que están encima del pivote
                double factor = m[i][k];
                // Factor para anular el elemento de la columna k
                for (int j = k; j <= n; j++) {
                    // Recorremos columnas para modificar la fila
                    m[i][j] -= factor * m[k][j];
                    // Restamos para poner 0 encima del pivote
                }
            }
        }

        double[] x = new double[n];
        // Arreglo para guardar las soluciones
        for (int i = 0; i < n; i++) {
            x[i] = m[i][n];
            // Leemos la solución directamente de la última columna
        }
        return x;
        // Devolvemos el arreglo con las incógnitas
    }

    public static void imprimirResultado(double[] sol) {
        // Función para mostrar los resultados en consola
        System.out.println("\n--- Solución (Gauss‑Jordan) ---");
        // Título del resultado
        for (int i = 0; i < sol.length; i++) {
            // Bucle para recorrer cada incógnita
            System.out.printf("x%d = %.4f%n", i + 1, sol[i]);
            // Imprime cada valor con cuatro decimales
        }
    }
}
    
