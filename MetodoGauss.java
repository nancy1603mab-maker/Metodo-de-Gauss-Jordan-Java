
package MetodoGauss;

// Importamos Scanner para leer datos desde el teclado
import java.util.Scanner;

// Clase principal del programa
public class MetodoGauss {

    // Método main: punto de inicio obligatorio de ejecución
    public static void main(String[] args) {
        // Llama a la función que lee los valores de la matriz
        double[][] matriz = leerDatos();
        // Aplica la eliminación de Gauss a la matriz ingresada
        double[] solucion = eliminacionGauss(matriz);
        // Muestra los resultados en consola
        imprimirResultado(solucion);
    }

    // Función para leer el número de ecuaciones y la matriz aumentada
    public static double[][] leerDatos() {
        // Creamos el objeto para capturar lo que escribe el usuario
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa número de ecuaciones: ");
        // Guardamos la cantidad de ecuaciones
        int n = sc.nextInt();
        // Matriz aumentada: n filas, n+1 columnas (coeficientes + término independiente)
        double[][] matriz = new double[n][n + 1];

        System.out.println("Ingresa coeficientes y término independiente:");
        // Bucle para recorrer cada fila
        for (int i = 0; i < n; i++) {
            // Bucle para recorrer cada columna de la fila
            for (int j = 0; j <= n; j++) {
                matriz[i][j] = sc.nextDouble();
            }
        }
        // Cerramos el lector de teclado
        sc.close();
        // Devolvemos la matriz ya llena
        return matriz;
    }

    // Función que realiza la eliminación de Gauss y la sustitución hacia atrás
    public static double[] eliminacionGauss(double[][] m) {
        // Obtenemos la cantidad de filas de la matriz
        int n = m.length;

        // Etapa de eliminación: generar ceros debajo de cada pivote
        for (int k = 0; k < n - 1; k++) {               // k = índice del pivote actual
            for (int i = k + 1; i < n; i++) {           // i = filas debajo del pivote
                // Calculamos el factor para anular el elemento de la columna del pivote
                double factor = m[i][k] / m[k][k];
                // Modificamos todos los valores de la fila i
                for (int j = k; j <= n; j++) {
                    m[i][j] -= factor * m[k][j];
                }
            }
        }

        // Arreglo donde guardaremos las soluciones
        double[] x = new double[n];
        // Sustitución hacia atrás: calculamos desde la última fila hasta la primera
        for (int i = n - 1; i >= 0; i--) {
            double suma = 0;
            // Sumamos los términos con incógnitas ya conocidas
            for (int j = i + 1; j < n; j++) {
                suma += m[i][j] * x[j];
            }
            // Despejamos el valor de la incógnita xi
            x[i] = (m[i][n] - suma) / m[i][i];
        }
        // Devolvemos el arreglo con todas las soluciones
        return x;
    }

    // Función que imprime las soluciones en consola
    public static void imprimirResultado(double[] sol) {
        System.out.println("\n--- Solución del sistema ---");
        for (int i = 0; i < sol.length; i++) {
            // Mostramos cada valor con 4 decimales
            System.out.printf("x%d = %.4f%n", i + 1, sol[i]);
        }
    }
}

