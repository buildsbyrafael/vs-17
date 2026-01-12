package model;

public abstract class Personagem implements Atacavel{

    private Integer idPersonagem;
    private String nickname;
    private int nivel;
    private int agilidade;
    private int furtividade;
    private int forca;
    private int defesa;
    private int vida;
    private int vidaMaxima;
    private int estamina;

    public Personagem(){};

    public Personagem(String nickname, int agilidade, int furtividade ,int forca, int defesa, int vida) {
        this.nickname = nickname;
        this.nivel = 1;
        this.agilidade = agilidade;
        this.furtividade = furtividade;
        this.forca = forca;
        this.defesa = defesa;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.estamina = 20;
    }

    public void descansar() {
        this.estamina = 20;
        System.out.println(this.getNickname() + " descansou e recuperou toda sua energia!");
    }

    public Integer getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(Integer idPersonagem) {
        this.idPersonagem = idPersonagem;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getFurtividade() {
        return furtividade;
    }

    public void setFurtividade(int furtividade) {
        this.furtividade = furtividade;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setVida(int vida){this.vida = vida;}

    public int getVidaMaxima(){return vidaMaxima;}

    public int getEstamina() { return estamina;}

    public void setEstamina(int estamina) {this.estamina = estamina;}

    public void setVidaMaxima (int novaVidaMaxima) {
        int limiteMaximoDoJogo = 150;

        if (novaVidaMaxima > limiteMaximoDoJogo) {
            this.vidaMaxima = limiteMaximoDoJogo;
            System.out.println("\n🛡️ Você atingiu o potencial máximo de vitalidade (" + limiteMaximoDoJogo + " HP)!");
        }
    }

    @Override
    public void receberDano(int dano) {
        int danoTotal = dano - this.defesa;
        if(this.defesa > dano){
            danoTotal = 0;
            System.out.println(this.nickname+" bloqueou todo o dano.");
        }else{
            this.vida -= danoTotal;
            System.out.println(this.nickname+" foi atacado e recebeu "+danoTotal+" de dano. (Sua defesa bloqueou "+this.defesa+" de dano).");
        }
    }

    @Override
    public void atacar(Atacavel alvo) {
         int ataqueTotal = this.forca;
        System.out.println(this.nickname+" atacou "+alvo.getNome() + " e deu "+ataqueTotal+" de dano.");
        alvo.receberDano(ataqueTotal);
    }

    @Override
    public boolean estaVivo() {
        return this.vida > 0;
    }

    @Override
    public String getNome() {
        return this.nickname;
    }

    @Override
    public int getVida() {
        return this.vida;
    }

    public int getAtributoViaNome(String atributoNecessario) {
        if (atributoNecessario == null) return 0;

        String atributo = atributoNecessario.toLowerCase();

        switch (atributo) {
            case "agilidade":
                return this.getAgilidade();
            case "forca":
                return this.getForca();
            case "furtividade":
                return this.getFurtividade();
            case "defesa":
                return this.getDefesa();
            case "inteligência":
                return this.getNivel(); // Usa o nível como inteligência
            default:
                System.out.println("ERRO: Atributo [" + atributo + "] não encontrado!1");
                return 0;
        }
    }
}