# Método de Gauss‑Jordan en Java
## Lenguaje utilizado
Java SE 8 o superior
## Explicación Breve de la estructura 
El proyecto usa estructura modular para separar tareas en dos clases:
-  MetodoGauss.java : contiene la lectura de datos y la función de triangulación gaussiana, que se reutiliza.
-  GaussJordan.java : es la clase principal, llama a las funciones de la otra clase y completa el algoritmo hacia atrás, además de mostrar el resultado. 
Así no se repite código, es más fácil de corregir y cada parte cumple una sola función.
## Pasos para compilar y ejecutar
1. Guardar los archivos `MetodoGauss.java` y `GaussJordan.java`, en la misma carpeta 
2. Se abre la terminal, para navegar hasta la carpeta 
3. Se compilan ambos archivos 
4. Ejecuta el programa principal
5.Introduce los datos que se le iden 
6.Te dara el resultado de lo que ingresaste 
## Ejemplo:
Ingresa n�mero de ecuaciones: 2
Ingresa coeficientes y t�rmino independiente:
5 6 7
2 -3 8
--- Soluci�n (Gauss?Jordan) ---
x1 = 2.5556
x2 = -0.9630
