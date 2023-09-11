package com.campusdual.ejercicio3;

import java.util.Scanner;

public class NumerosPrimos {
    public static void main(String[] args) {
        // Inicializa num con el número que quieres evaluar
        int numero;
        System.out.println("Escribe un numero");
        Scanner teclado = new Scanner(System.in);
        numero = teclado.nextInt(); // Puedes cambiar este valor

        switch (numero) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 11:
            case 13:
            case 17:
            case 19:
                System.out.println(numero + " es un número primo.");
                break;
            default:
                System.out.println(numero + " no es un número primo.");
                break;
        }
    }
}

