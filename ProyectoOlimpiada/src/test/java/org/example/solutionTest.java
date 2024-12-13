package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
class solutionTest {

    @Test
    void comprobarCaso1() {
        //Simulamos la introducción de caracteres con una variable string
        String simulacion = "popopo";
        System.setIn(new ByteArrayInputStream(simulacion.getBytes()));

        //Guardamos la salida por consola con el método ByteArrayOutputStream
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));


        //Llamamos al método que procesa la entrada
        int resultado = solution.comprobarCaso1();

        //Se verifica el valor devuelto. En este caso se espera un -1
        assertEquals(-1, resultado);

        //Verificamos que el mensaje de error esparado se ha impreso en pantalla
        String salidaEsperada = "ormato incorrecto.";
        // assertEquals(salidaEsperada, salida.toString().trim());
        assertTrue(salida.toString().trim().contains(salidaEsperada));
    }

    @Test
    void casoDePrueba() {
    }

    @Test
    void leerColumnasMatriz() {
    }

    @Test
    void rellenarMatriz() {
    }



    @Test
    void comprobarCaso2() {
    }
}