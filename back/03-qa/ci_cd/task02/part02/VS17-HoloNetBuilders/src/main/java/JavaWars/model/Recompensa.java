package model;

import exceptions.BancoDeDadosException;
import repository.PersonagemRepository;
import view.HistoriaView;

import java.util.Scanner;

public class Recompensa {

    private String nome;
    private int valorBonus;
    private PersonagemRepository pr = new PersonagemRepository();

    public Recompensa(String nome, int valorBonus) {
        this.nome = nome;
        this.valorBonus = valorBonus;
    }

    public class LevelUp {
        public static void levelUp(Personagem heroi) {
            heroi.setNivel(heroi.getNivel() + 1);

            int novoTeto = heroi.getVidaMaxima() + 15;
            heroi.setVida(novoTeto);
        }
    }

    public boolean aplicarRecompensa(Personagem alvo, String atributo, HistoriaView historiaView) throws BancoDeDadosException {
        System.out.println("\n----------------------------------------------");
        System.out.println("Recompensa: " + this.nome + " (+" + this.valorBonus + ").");
        System.out.println(alvo.getIdPersonagem());
        boolean aplicacaoBemSucedida = true;

        switch (atributo.toLowerCase()) {
            case "agilidade": {
                int novoValor = alvo.getAgilidade() + this.valorBonus;
                String nomeAtributo = "AGILIDADE";
                alvo.setAgilidade(novoValor);
                pr.editar(alvo.getIdPersonagem(), alvo);
                historiaView.bonusAplicado(nomeAtributo, alvo.getNickname(), novoValor);
                break;
            }

            case "furtividade": {
                int novoValor = alvo.getFurtividade() + this.valorBonus;
                String nomeAtributo = "FURTIVIDADE";
                alvo.setFurtividade(novoValor);
                pr.editar(alvo.getIdPersonagem(), alvo);
                historiaView.bonusAplicado(nomeAtributo, alvo.getNickname(), novoValor);
                break;
            }

            case "forca": {
                int novoValor = alvo.getForca() + this.valorBonus;
                String nomeAtributo = "FORÇA";
                alvo.setForca(novoValor);
                pr.editar(alvo.getIdPersonagem(), alvo);
                historiaView.bonusAplicado(nomeAtributo, alvo.getNickname(), novoValor);
                break;
            }

            case "defesa": {
                int novoValor = alvo.getDefesa() + this.valorBonus;
                String nomeAtributo = "DEFESA";
                alvo.setDefesa(novoValor);
                pr.editar(alvo.getIdPersonagem(), alvo);
                historiaView.bonusAplicado(nomeAtributo, alvo.getNickname(), novoValor);
                break;
            }

            case "vida":
                if (alvo.getVida() >= alvo.getVidaMaxima()) {
                    historiaView.vidaMaxima(alvo.getNickname(), alvo.getVidaMaxima());
                    return false;
                }

                int vidaAtual = alvo.getVida();
                int vidaMaxima = alvo.getVidaMaxima();
                int curaReal = Math.min(this.valorBonus, vidaMaxima - vidaAtual);

                alvo.setVida(vidaAtual + curaReal);
                pr.editar(alvo.getIdPersonagem(), alvo);
                historiaView.restauracaoVida(curaReal, alvo.getVida(), vidaMaxima);
                break;

            default:
                historiaView.atributoInvalido();
                aplicacaoBemSucedida = false;
                break;
        }

        System.out.println("----------------------------------------------");
        return aplicacaoBemSucedida;
    }

    public void oferecer(Personagem heroi, Scanner input, HistoriaView historiaView) throws BancoDeDadosException {

        historiaView.mostrarRecompensa(this.getNome());

        String[] atributos = {"agilidade", "furtividade", "forca", "defesa", "vida"};
        boolean sucesso = false;

        while (!sucesso) {
            historiaView.menuRecompensa(heroi);

            if (input.hasNextInt()) {
                int escolha = input.nextInt();
                input.nextLine();

                if (escolha >= 1 && escolha <= 5) {
                    String atributoEscolhido = atributos[escolha - 1];
                    sucesso = this.aplicarRecompensa(heroi, atributoEscolhido, historiaView);
                } else {
                    historiaView.opcaoInvalida();
                }
            } else {
                historiaView.opcaoValida2();
                input.next();
            }
        }
    }

    public String getNome() {
        return nome;
    }
}