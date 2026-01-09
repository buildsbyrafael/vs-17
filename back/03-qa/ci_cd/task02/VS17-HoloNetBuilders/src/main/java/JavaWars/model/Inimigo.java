package model;

public class Inimigo implements Atacavel{

    private String nome;
    private int vida;
    private int forca;
    private Integer idInimigo;

    public Inimigo(String nome, int vida, int forca) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
    }


    @Override
    public void receberDano(int dano) {
        this.vida -= dano;
        if(this.vida < 0){
            this.vida =0;
        }else{
            System.out.println(this.nome+" recebeu "+dano+" de dano, sua vida está em "+this.vida);
        }
    }

    @Override
    public void atacar(Atacavel alvo) {
        System.out.println(this.nome+" atacou "+alvo.getNome()+" e deu "+this.forca+" de dano.");
        alvo.receberDano(this.forca);
    }

    public Integer getIdInimigo() { return idInimigo; }

    public void setIdInimigo(Integer idInimigo) { this.idInimigo = idInimigo; }

    @Override
    public boolean estaVivo() {
        return this.vida > 0;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public int getVida() {
        return this.vida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int dano) {
        this.forca = dano;
    }
}
