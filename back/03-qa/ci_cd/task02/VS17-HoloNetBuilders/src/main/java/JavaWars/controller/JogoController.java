package controller;

import exceptions.BancoDeDadosException;
import model.*;
import repository.MissaoRepository;
import view.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import repository.PersonagemRepository;

public class JogoController {

    private Scanner input;
    private Personagem heroi;
    private Dado dado;
    private MenuView viewMenu;
    private HistoriaView viewHistoria;
    private PersonagemRepository pr = new PersonagemRepository();
    private MissaoRepository missaoRepository = new MissaoRepository();
    private MissaoController mc = new MissaoController();

    public JogoController() {
        this.input = new Scanner(System.in);
        this.dado = new Dado();
        this.viewMenu = new MenuView();
        this.viewHistoria = new HistoriaView();
    }

    public void jogar() throws BancoDeDadosException {
        Personagem heroiEscolhido = null;

        Musica.playLoop();
        Intro.mostrar();

        System.out.print("\u001B[0m");

        Musica.setVolume(-15.0f);

        int escolhaMenu = 0;

        List<Personagem> personagensCriados = new ArrayList<>();

        personagensCriados = pr.listar();

        do {

            resetarVida(personagensCriados);

            viewMenu.mostrarOpcoesJogo();

            escolhaMenu = viewMenu.lerOpcao(input);

            if (escolhaMenu == 1) {
                viewMenu.mostrarBoasVindas();

                Jedi heroiJedi = new Jedi("", 8, 4, 9, 8, 60);
                Wookie heroiWookie = new Wookie("", 3, 9, 11, 5, 60);
                Droid heroiDroid = new Droid("", 11, 1, 5, 12, 60);

                List<Personagem> opcoesDeHeroi = new ArrayList<>();
                opcoesDeHeroi.add(heroiJedi);
                opcoesDeHeroi.add(heroiWookie);
                opcoesDeHeroi.add(heroiDroid);

                viewMenu.mostrarOpcoesHerois(opcoesDeHeroi);
                int escolha = -1;
                while (escolha < 1 || escolha > opcoesDeHeroi.size()) {
                    viewMenu.digiteNumeroDoHeroi();
                    if (input.hasNextInt()) {
                        escolha = viewMenu.lerOpcao(input);
                        input.nextLine();
                        if (escolha >= 1 && escolha <= opcoesDeHeroi.size()) {
                            if (escolha == 1) {
                                heroiEscolhido = new Jedi("", 8, 4, 9, 8, 60);
                            } else if (escolha == 2) {
                                heroiEscolhido = new Wookie("", 3, 9, 11, 5, 60);
                            } else if (escolha == 3) {
                                heroiEscolhido = new Droid("", 11, 1, 5, 12, 60);
                            }
                        } else {
                            viewMenu.mostrarErroIndice();
                        }
                    } else {
                        viewMenu.mostrarErroIndice();
                        input.next();
                    }
                }
                if (heroiEscolhido != null) {

                    viewMenu.mostrarHeroiEscolhido(heroiEscolhido);

                    viewMenu.solicitarNickname();

                    String nicknameUsuario = input.nextLine();

                    String nomeFormatado = formatarNome(nicknameUsuario);

                    heroiEscolhido.setNickname(nomeFormatado);

                    pr.adicionar(heroiEscolhido);

                    viewMenu.mostrarProntoParaMissao(heroiEscolhido);
                    
                    mc.iniciarJogo(heroiEscolhido, viewHistoria, missaoRepository ,dado);
                }
            } else if (escolhaMenu == 2) {

                if (personagensCriados.isEmpty()) {
                    viewMenu.mostrarAvisoNenhumJogoCriado();
                    continue;
                } else {
                    viewMenu.mostrarMenuCarregar();
                    personagensCriados.stream()
                            .max(Comparator.comparingInt(Personagem::getNivel))
                            .ifPresent(p -> viewMenu.mostrarHeroiMaisForte(p));

                    viewMenu.listarMenuCarregar(personagensCriados);
                    int heroiSalvo = viewMenu.lerOpcao(input);
                    input.nextLine();
                    int indiceReal = heroiSalvo - 1;
                    if (indiceReal >= 0 && indiceReal < personagensCriados.size()) {
                        heroiEscolhido = personagensCriados.get(indiceReal);
                        viewMenu.mostrarSucessoCarregamento(heroiEscolhido.getNome());
                        mc.iniciarJogo(heroiEscolhido, viewHistoria, missaoRepository ,dado);
                    } else {
                        viewMenu.mostrarErroIndice();
                    }
                }
            } else if (escolhaMenu == 3) {
                if (personagensCriados.isEmpty()) {
                    viewMenu.mostrarAvisoNenhumJogoCriado();
                    continue;
                }
                viewMenu.mostrarMenuExcluir(personagensCriados);
                int idDigitado = input.nextInt();
                input.nextLine();
                Personagem personagemParaRemover = null;
                for (Personagem p : personagensCriados) {
                    if (p.getIdPersonagem() == idDigitado) {
                        personagemParaRemover = p;
                        break;
                    }
                }
                if (personagemParaRemover != null) {
                    boolean excluiu = pr.remover(idDigitado);
                    if (excluiu) {
                        personagensCriados.remove(personagemParaRemover);
                        viewMenu.mostrarSucessoExclusao();
                    }
                } else {
                    viewMenu.mostrarErroIndice();
                }
                continue;
            }

            Musica.stop();

        } while (escolhaMenu != 4);

    }
    private static String formatarNome(String entrada) {
        if (entrada == null || entrada.trim().isEmpty()) {
            return "Viajante Desconhecido";
        }

        String[] palavras = entrada.trim().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                nomeFormatado.append(Character.toUpperCase(palavra.charAt(0)));
                nomeFormatado.append(palavra.substring(1).toLowerCase());
                nomeFormatado.append(" ");
            }
        }
        return nomeFormatado.toString().trim();
    }

    private static void resetarVida(List<Personagem> listaPersonagens){
        for(Personagem p : listaPersonagens){
            p.setVida(60);
        }
    }
}
