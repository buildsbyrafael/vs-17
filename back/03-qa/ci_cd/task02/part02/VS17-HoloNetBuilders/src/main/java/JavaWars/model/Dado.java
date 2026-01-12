package model;

import view.HistoriaView;

import java.util.Random;

public class Dado {
    private int lados;
    private HistoriaView historiaView;

    public Dado() {
        this.lados = 6;
    }

    public Dado(int lados) {
        if (lados < 6) {
            historiaView.erroDado();
            this.lados = 6;
        } else {
            this.lados = lados;
        }
    }

    public int rolar() {
        Random random = new Random();
        return random.nextInt(this.lados) + 1;
    }

    public int getLados() {
        return lados;
    }

    public void setLados(int lados) {
        if (this.lados < 6) {
            historiaView.erroDado();
            this.lados = 6;
        } else {
            this.lados = lados;
        }
    }
}
