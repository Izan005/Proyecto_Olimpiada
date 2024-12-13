package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Izan López Mora
 * @version 1.0
 */
public class solution {

    static Scanner in = new Scanner(System.in);

    /**
     * Realiza el ejercicio segun los casos de prueba definidos en la clase main
     */
    public static void casoDePrueba() {

        int rep = 0; //Variable que almacenará el número de filas de la matriz a generar
        boolean valid = false;
        do { //Try catch que caza el error InputMismatchException cuando se introduce datos no int en la variable "rep"
            try {
                System.out.println("Introduce el número de filas a insertar:");
                rep = in.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Formato de datos incorrecto.");
                in.next();
            }
        } while (!valid);

        String matriz[][] = new String[rep][3]; //Matriz de "rep" filas y 3 columnas que almacenará los datos del ejercicio.

        rellenarMatriz(matriz); //Aplica rellenarMatriz a la matriz del ejercicio
        leerColumnasMatriz(matriz); //Aplica leerColumnasMatriz a la matriz del ejercicio
        System.out.println();

    } //casoDePrueba

    /**
     * Muestro la matriz
     * @param matriz
     */
    public static void leerColumnasMatriz(String[][] matriz) {

        for (int i = 0; i < matriz[0].length; i++) { //Bucle for que muestra columna por columna la matriz
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[j][i]);
            }
        }
    }

    /**
     * Relleno la matriz con el texto que requiere el programa
     * @param matriz
     * @return
     */

    public static String[][] rellenarMatriz(String[][] matriz) {
        String texto = ""; //Variable que almacenará el texto de cada fila de la matriz. Este texto tiene que ser únicamente de 3 caracteres
        for (int i = 0; i < matriz.length; i++) { //Bucle que recorre las filas de la matriz

            do { //Bucle que se repite cuando el texto por fila introducido supere los 3 caracteres
                System.out.println("Introduce fila " + (i+1) + ": ");
                texto = in.next();

                if (texto.length() != 3) {
                    System.out.println("Número de columnas introducidas incorrecto.");
                }
            } while (texto.length() != 3);

            String vector[] = texto.split(""); //Vector split que almacena la variable "texto"
            for (int j = 0; j < matriz[i].length; j++) { //Bucle que rellena cada fila de la matriz con el contenido del vector
                matriz[i][j] = vector[j];
            }
        }
        return matriz; //Regresamos la matriz rellena al método casoDePrueba.
    }

    /**
     * Clase main donde se solicitan la cantidad de casos de prueba a realizar en casosDePrueba
     * @param args
     */
    public static void main(String[] args) {

        boolean valid; //Booleano que valida la salida del programa
        int numCasos = 0; //Variable que almacena el número de casos de prueba introducidos por el usuario
        do { //Bucle que se repite mientras la variable "valid" sea null y "numCasos" sea menor que 1 o mayor que 20.
            valid = false;
            System.out.println("Introduce el número de casos a realizar [1-20]:");
            numCasos = comprobarCaso1();

            if (numCasos!= -1) { //Si el número de casos
                if (comprobarCaso2(numCasos) == -1) {
                    valid = true;
                }
            } else {
                valid = true;
            }

        }while (valid);

        for (int i = 0; i < numCasos; i++) { //Bucle que repite el método casoDePrueba "numCasos" veces.
            casoDePrueba();
        }
    }

    /**
     * Clase que realiza un try-catch que se activa cuando el número de casos no es int
     * @return
     */

    public static int comprobarCaso1(){
        int numCasos = 0; //Variable que almacena el número de casos de prueba introducidos por el usuario
        try { //Try catch que caza el error InputMismatchException cuando se introduce datos no int en la variable "numCasos".
            //Si el error se caza, el método devuelve un -1.
            return in.nextInt();
        }catch (InputMismatchException e) {
            in.nextLine();
            System.out.println("Formato incorrecto.");

            return -1;
        }
    }

    /**
     * Clase que comprueba que el número de casos se encuentra dentro del rango permitido [1-20]
     * @param numCasos
     * @return
     */
    public static int comprobarCaso2(int numCasos){

        if (numCasos < 1 || numCasos > 20) { //Si el número de casos se encuentra fuera del rango de 1-20 devuelve un -1
            System.out.println("El número de casos está fuera del rango de 1-20.");
            return -1;
        }
        return numCasos;
    }

    //main
} //class solution