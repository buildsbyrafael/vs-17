package model;

public interface Atacavel {
    void receberDano(int dano);
    void atacar(Atacavel alvo);
    boolean estaVivo();
    String getNome();
    int getVida();
    int getForca();
}
