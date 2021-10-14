package com.company;

public class Casilla {
    int posicioFila;
    int posicioColumna;
    boolean mina;
    int numMinasAlrededor;
    boolean bandera;
    boolean tapado;


    public Casilla(int posicioFila, int posicioColumna) {
        this.posicioFila = posicioFila;
        this.posicioColumna = posicioColumna;
    }

    public int getPosicioFila() {
        return posicioFila;
    }

    public void setPosicioFila(int posicioFila) {
        this.posicioFila = posicioFila;
    }

    public int getPosicioColumna() {
        return posicioColumna;
    }

    public void setPosicioColumna(int posicioColumna) {
        this.posicioColumna = posicioColumna;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public int getNumMinasAlrededor() {
        return numMinasAlrededor;
    }

    public void setNumMinasAlrededor() {
        this.numMinasAlrededor = numMinasAlrededor;
    }

    public void incrementarNumMinasAlrededor() {
        this.numMinasAlrededor++;
    }

    public boolean isBandera() {
        return bandera;
    }
    public void setBandera(boolean bandera){
        this.bandera = bandera;
    }

    public boolean isTapado() {
        return tapado;
    }
    public void setTapado(boolean tapado) {
        this.tapado = tapado;

    }
}

