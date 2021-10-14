package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class TableroBuscaminas {
    Casilla[][] casillas;
    int numFilas;
    int numColumnas;
    int numMinas;
    boolean LoseWin;
    ArrayList<Casilla> listCasilla = new ArrayList<>(8);
    String banderaP;

    public TableroBuscaminas(int numFilas, int numColumnas, int numMinas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;
        inicioCasillas();
    }

    public void inicioCasillas() {
        casillas = new Casilla[this.numFilas][this.numColumnas];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new Casilla(i, j);
            }
        }
        generarMinas();
    }

    private void generarMinas() {
        int minasGeneradas = 0;
        while (minasGeneradas != numMinas) {
            int posicioTemporalFila = (int) (Math.random() * casillas.length);
            int posicioTemporalColumna = (int) (Math.random() * casillas[0].length);
            if (!casillas[posicioTemporalFila][posicioTemporalColumna].isMina()) {
                casillas[posicioTemporalFila][posicioTemporalColumna].setMina(true);
                minasGeneradas++;
            }
        }
    }

    public ArrayList<Casilla> ObtCasillasAlrededor(int coordenadaX, int coordenadaY) {
        ArrayList<Casilla> listCasilla = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < casillas.length; i++) {
            int posicioTemporalFila = coordenadaX;
            int posicioTemporalColumna = coordenadaY;

            switch (i) {
                case 0:
                    posicioTemporalFila--;

                    break; //Arriba
                case 1:
                    posicioTemporalFila--;
                    posicioTemporalColumna++;
                    break; //Arriba Derecha
                case 2:
                    posicioTemporalColumna++;
                    break; //Derecha
                case 3:
                    posicioTemporalColumna++;
                    posicioTemporalFila++;
                    break; //Abajo Derecha
                case 4:
                    posicioTemporalFila++;
                    break; //Abajo
                case 5:
                    posicioTemporalFila++;
                    posicioTemporalColumna--;
                    break; //Abajo Izquierda
                case 6:
                    posicioTemporalColumna--;
                    break; //Izquierda
                case 7:
                    posicioTemporalFila--;
                    posicioTemporalColumna--;
                    break; //Izquierda Arriba
            }
            if (posicioTemporalFila >= 0 && posicioTemporalFila < this.casillas.length
                    && posicioTemporalColumna >= 0 && posicioTemporalColumna < this.casillas[0].length) {
                listCasilla.add(this.casillas[posicioTemporalFila][posicioTemporalColumna]);
                if(this.casillas[posicioTemporalFila][posicioTemporalColumna].isMina()) {
                    counter++;
                }
            }
            casillas[coordenadaX][coordenadaY].numMinasAlrededor = counter;
            destaparCasillasExpansion(coordenadaX,coordenadaY);
        }
        return listCasilla;

    }

    public void imprimirTablero() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].isBandera() == true){
                    System.out.print(casillas[i][j].isTapado() ? "[" + casillas[i][j].numMinasAlrededor + "]" : "[P]");
                }else {
                    System.out.print(casillas[i][j].isTapado() ? "[" + casillas[i][j].numMinasAlrededor + "]" : "[X]");
                }
                //casillas[i][j].isMina() ?  " *" : " X";

            }
            System.out.println("");

        }
    }
    //true win
    //lose false
    public void destaparCasillasExpansion (int posicioTemporalFila, int posicioTemporalColumna) {
        ArrayList<Casilla> listaCasilla = listCasilla;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].isTapado() && casillas[i][j].numMinasAlrededor == 0 ) {
                    for(int x = 0; x <  listaCasilla.size() ; x++) {
                        if (posicioTemporalFila >= 0 && posicioTemporalFila < this.casillas.length
                                && posicioTemporalColumna >= 0 && posicioTemporalColumna < this.casillas[0].length) {
                            if (casillas[posicioTemporalFila][posicioTemporalColumna].numMinasAlrededor == 0) {
                                casillas[posicioTemporalFila][posicioTemporalColumna].setTapado(false);
                            }
                        }


                    }

                }
            }
        }
    }

    public void JugarPartidaCoord () {
        int coordenadaX;
        int coordenadaY;
        int option;
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        while(LoseWin == false) {
            System.out.println("Introduce coordenadas X: ");
            coordenadaX = scanner1.nextInt();
            coordenadaX --;
            System.out.println("Introduce coordenadas y: ");
            coordenadaY = scanner2.nextInt();
            coordenadaY --;
            System.out.println("¿Quieres destapar o poner una bandera? Destapar.1 Bandera.2");
            option = scanner3.nextInt();
            if( option == 2){
                casillas[coordenadaX][coordenadaY].setBandera(true);
                imprimirTablero();
            }
            casillas[coordenadaX][coordenadaY].tapado = true;
            ObtCasillasAlrededor(coordenadaX,coordenadaY);
            imprimirTablero();


            if(casillas[coordenadaX][coordenadaY].isMina()){
                LoseWin = true;
                System.out.println("¡HAS PERDIDO!");
            }else{
                ObtCasillasAlrededor(coordenadaX,coordenadaY);
            }
            JugarPartidaCoord();
        }
    }
}

