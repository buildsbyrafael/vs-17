package model;

public class Wookie extends Personagem {
    private int pontosDeFurtividade;

    public Wookie(){};

    public Wookie(String nickname, int agilidade, int furtividade, int forca, int defesa, int vida) {
        super(nickname, agilidade, furtividade, forca, defesa, vida);

        this.pontosDeFurtividade = 20;
    }

    public void atacarComFurtividade() {
        int dano = (this.getFurtividade() * 2) + this.getAgilidade(); // Furtividade pesa mais (x2), agilidade ajuda
        System.out.println(this.getNickname() + " surge das sombras e ataca!");
    }

    // Exclusivo do Wookie: Poder de furtividade
    public void usarEmboscada() {
        if (this.pontosDeFurtividade >= 10) {
            this.pontosDeFurtividade -= 10;
            int danoCritico = this.getFurtividade() * 3;
            System.out.println(this.getNickname() + " prepara uma armadilha perfeita!");
        } else {
            System.out.println(this.getNickname() + " está sendo visto, não pode usar a emboscada!");
        }
    }

    public int getPontosDeFurtividade() {
        return pontosDeFurtividade;
    }

    public void setPontosDeFurtividade(int pontosDeFurtividade) {
        this.pontosDeFurtividade = pontosDeFurtividade;
    }
}

