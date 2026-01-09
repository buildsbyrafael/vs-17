package model;

import exceptions.BancoDeDadosException;
import view.HistoriaView;

import java.util.Scanner;

public class Missao {

    private int id_missao;
    private int capitulo;
    private int ordem;
    private String nome;
    private String descricao;
    private String atributoNecessario;
    private int dificuldade;
    private TipoMissao tipo;

    private Recompensa recompensa;

    public Missao(int id, int cap, int ord, String nome, String desc, String atrib, int dif, TipoMissao tipo) {
        this.id_missao = id;
        this.capitulo = cap;
        this.ordem = ord;
        this.nome = nome;
        this.descricao = desc;
        this.atributoNecessario = atrib;
        this.tipo = tipo;
        this.dificuldade = dif;
        this.recompensa = new Recompensa("Item de Bônus", 5);
    }

    public void jogar(Personagem heroi, Dado dado, Atacavel inimigo, HistoriaView historiaView) throws BancoDeDadosException {
        Scanner sc = new Scanner(System.in);
        if (!heroi.estaVivo()) {
            historiaView.voceMorreu();
            return;
        }

        historiaView.iniciarMissao(this);
        System.out.println(this.getDescricao());

        switch (this.getTipo()) {
            case TESTE_DE_ATRIBUTO:
                historiaView.mostrarTesteAtributo(this);
                int bonus = heroi.getAtributoViaNome(this.atributoNecessario);

                int rolarNormal = dado.rolar();
                historiaView.mostrarResultadoDado(rolarNormal, bonus, atributoNecessario);
                int resultado = bonus + rolarNormal;

                if (resultado >= dificuldade) {
                    historiaView.mostrarSucessoTeste();
                    this.recompensa.oferecer(heroi, sc, historiaView);
                    Recompensa.LevelUp.levelUp(heroi);
                    System.out.println("🌟 LEVEL UP! 🌟 NíVEL: " + heroi.getNivel());
                } else {
                    historiaView.mostrarFalhaTeste();
                    Batalha batalha = new Batalha(heroi, inimigo, historiaView, this.recompensa);
                    batalha.iniciar();
                    if (heroi.estaVivo()) {
                        Recompensa.LevelUp.levelUp(heroi);
                        System.out.println("🌟 LEVEL UP! 🌟 NíVEL: " + heroi.getNivel());
                        descansoRapido(heroi, historiaView, sc);
                    }
                }
                break;

            case COMBATE_DIRETO:
                historiaView.mostrarCombateDireto();
                Batalha batalha = new Batalha(heroi, inimigo, historiaView, this.recompensa);
                batalha.iniciar();
                if (heroi.estaVivo()) {
                    Recompensa.LevelUp.levelUp(heroi);
                }
                descansoRapido(heroi, historiaView, sc);
                break;
            case BOSS_FINAL:
                historiaView.mostrarCombateDireto();
                Batalha batalhaFinal = new Batalha(heroi, inimigo, historiaView, this.recompensa);
                batalhaFinal.iniciar();
                if (heroi.estaVivo()) {
                    Recompensa.LevelUp.levelUp(heroi);
                }
                break;
        }

    }

    public void descansoRapido(Personagem heroi, HistoriaView historiaView, Scanner sc) {
        historiaView.descansoMenu();

        int opcao = 0;
        try {
            opcao = sc.nextInt();
        } catch (Exception e) {
            sc.next();
        }

        if (opcao == 1) {
            if (heroi instanceof Jedi) {
                ((Jedi) heroi).setPontosDeForca(20);
                historiaView.mostrarDescanso();
            } else if (heroi instanceof Droid) {
                ((Droid) heroi).setBateria(20);
                historiaView.mostrarDescanso();
            } else if (heroi instanceof Wookie) {
                ((Wookie) heroi).setFurtividade(20);
                historiaView.mostrarDescanso();
            }
        } else {
            historiaView.descansoIgnorado();
        }
    }

    // Getter e Setter pro final
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAtributoNecessario() {
        return atributoNecessario;
    }

    public void setAtributoNecessario(String atributoNecessario) {
        this.atributoNecessario = atributoNecessario;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getId_missao() {
        return id_missao;
    }

    public int getCapitulo() {
        return capitulo;
    }

    public int getOrdem() {
        return ordem;
    }

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public TipoMissao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMissao tipo) {
        this.tipo = tipo;
    }
}
