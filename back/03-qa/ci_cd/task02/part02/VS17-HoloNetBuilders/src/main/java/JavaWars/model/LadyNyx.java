package model;

public class LadyNyx extends Inimigo {
    public LadyNyx(String nome, int vidaBase, int danoBase) {
        super(nome, vidaBase * 2, danoBase + 5);
    }

    @Override
    public void receberDano(int dano) {
        int danoReduzido = (int) (dano * 0.7);

        System.out.println("👑 " + this.getNome() + " é a CHEFE! O dano foi reduzido de " + dano + " para " + danoReduzido + " (Resistência da Força Sombria).");

        super.receberDano(danoReduzido);

    }
}
