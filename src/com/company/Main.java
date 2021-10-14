package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int files = 0;
        int columnes = 0;
        int mines = 0;
        String nombre;

        TableroBuscaminas tablero;
        System.out.println("---");
        System.out.println("Introduce tu nombre: ");
        Scanner pollo = new Scanner(System.in);
        nombre = pollo.nextLine();


        System.out.println("Indica la dificultat a la que es vol jugar " + nombre + ":" +
                "\n 1 Facil" +
                "\n 2 Medio" +
                "\n 3 Dificil" +
                "\n 4 Personalitzat");
        Scanner scanner = new Scanner(System.in);System.out.println("Introdueix el numero de files");
        int dificultat = scanner.nextInt();

        switch (dificultat) {

            case 1:
                System.out.println("Dificultat Facil");
                tablero = new TableroBuscaminas(8, 8, 10);
                tablero.imprimirTablero();
                System.out.println("---");
                //tablero.imprimirPistas();
                tablero.JugarPartidaCoord();
                break;
            case 2:
                System.out.println("Dificultat Medio");
                tablero = new TableroBuscaminas(16, 16, 40);
                tablero.imprimirTablero();
                System.out.println("---");
                //tablero.imprimirPistas();
                tablero.JugarPartidaCoord();
                break;
            case 3:
                System.out.println("Dificultat Dificil");
                tablero = new TableroBuscaminas(16, 30, 99);
                tablero.imprimirTablero();
                System.out.println("---");
                // tablero.imprimirPistas();
                tablero.JugarPartidaCoord();
                break;
            case 4:
                System.out.println("Dificultat Personalizada");
                System.out.println("Introdueix el numero de files");
                files = scanner.nextInt();
                System.out.println("Introdueix el numero de columnes");
                columnes = scanner.nextInt();
                System.out.println("Introdueix el numero de mines");
                mines = scanner.nextInt();
                tablero = new TableroBuscaminas(files, columnes, mines);
                tablero.imprimirTablero();
                System.out.println("---");
                //tablero.imprimirPistas();
                break;
        }



    }
}

