package com.campusdual.ejercicio2;

import java.util.Scanner;

public class AnhoBisiesto {
    public static void main(String[] args) {
        int bisiesto;
        System.out.println("Escribe un año");
        Scanner teclado = new Scanner(System.in);
        bisiesto = teclado.nextInt();
        if (bisiesto %4 == 0){

            if (bisiesto %100 == 0 && bisiesto %400 != 0){
                System.out.println("Este año no es bisiesto");
            }else{
                System.out.println("Este año es bisiesto");}
        }else{
                System.out.println("Este año no es bisiesto");
            }
    }
}