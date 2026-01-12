package model;

public class Droid extends Personagem {
    private int bateria;

    public Droid(){};
    
    public Droid(String nickname, int agilidade, int furtividade, int forca, int defesa, int vida) {
        super(nickname, agilidade, furtividade, forca, defesa, vida);

        this.bateria = 20;
    }

    public void atirarComBlaster() {
        int dano = this.getAgilidade() * 2 + (this.getForca() / 2); // dano com agilidade (precisão e velocidade)
        System.out.println(this.getNickname() + " dispara rapidamente, causando " + dano + " de dano!");
    }

    // Exclusivo do Droid: Poder de Agilidade
    public void ativarSobrecarga() {
        if (this.bateria >= 10) {
            this.bateria -= 10;
            int danoRapido = this.getAgilidade() * 3;
            System.out.println(this.getNickname() + " sobrecarrega seus servos motores e ataca com velocidade extrema!" + this.getNickname() + " dá " + danoRapido + " de dano!");
        } else {
            System.out.println(this.getNickname() + " não tem bateria o suficiente para sobrecarga.");
        }
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }
}


