/**
 * Copyright (C) 2024, Angel Pastaz, Ruth Rueda
 * (Grupo 11) Suma de Matrices
 * Version 1.0
 */

import java.util.Scanner;
import java.util.Random;

public class SumaMatriz {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Suma de dos matrices: ");
        int ordenMatriz = validarEntero(scanner, ">>Ingrese el orden de las matrices: ");
        while(ordenMatriz <= 0){
            System.out.println("El orden no debe ser negativo o cero.\n");
            ordenMatriz = validarEntero(scanner, ">>Ingrese el orden de las matrices: ");
        }
        
        // Se inicia el temporizador
        long tiempoInicio = System.nanoTime();

        int[][] matriz1 = generarMatrizAleatoria(ordenMatriz);
        int[][] matriz2 = generarMatrizAleatoria(ordenMatriz);
        
        System.out.println("Matriz 1:");
        imprimirMatriz(matriz1);
        System.out.println("Matriz 2:");
        imprimirMatriz(matriz2);
        
        int[][] matrizSuma = sumarMatrices(matriz1, matriz2);
        
        // Finaliza el temporizador
        long tiempoFinal = System.nanoTime();
        
        // Se imprime la matriz suma
        System.out.println("Matriz suma:");
        imprimirMatriz(matrizSuma);

        // Calcula el tiempo transcurrido
        long tiempoTranscurrido = tiempoFinal - tiempoInicio;
        // Convierte el tiempo a segundos
        double milisegundos = (double) tiempoTranscurrido / 1_000_000.0;
        System.out.println("Tiempo de ejecución: " + milisegundos + " milisegundos");
        
        scanner.close();
    }
    
    public static int validarEntero(Scanner scanner, String mensaje) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                break;
            } else {
                System.out.println("Error! Debe ingresar un número entero mayor a cero.\n");
                scanner.next();
            }
        }
        return numero;
    }

    public static int[][] generarMatrizAleatoria(int ordenMatriz) {
        Random random = new Random();
        int[][] matriz = new int[ordenMatriz][ordenMatriz];
        
        for (int i = 0; i < ordenMatriz; i++) {
            for (int j = 0; j < ordenMatriz; j++) {
                matriz[i][j] = random.nextInt(100 + 100 + 1) -100;
            }
        }
        return matriz;
    }
    
    public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
        int n = matriz1.length;
        int[][] resultado = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        
        return resultado;
    }
    
    public static void imprimirMatriz(int[][] matriz) {
        int n = matriz.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}