package model;

public class Jedi extends Personagem {
    private int pontosDeForca; //Energia para usar poderes

    public Jedi(){};

    public Jedi(String nickname, int agilidade, int furtividade, int forca, int defesa, int vida) {
        super(nickname, agilidade, furtividade, forca, defesa, vida);

        this.pontosDeForca = 20;
    }

    // Exclusivo do Jedi: Poder de força
    public void usarEmpurraoDaForca() {
        if (this.pontosDeForca >= 10) {
            this.pontosDeForca -= 10;
            System.out.println(this.getNickname() + " usa a força para empurrar o inimigo!");
        } else {
            System.out.println(this.getNickname() + " não tem concentração suficiente na força.");
        }
    }

    public void atacarComSabre() {
        int dano = this.getForca() * 2 + this.getAgilidade();
        System.out.println(this.getNickname() + " ataca com seu sabre, causando " + dano + " de dano!");
    }

    public int getPontosDeForca() {
        return pontosDeForca;
    }

    public void setPontosDeForca(int pontosDeForca) {
        this.pontosDeForca = pontosDeForca;
    }
}
