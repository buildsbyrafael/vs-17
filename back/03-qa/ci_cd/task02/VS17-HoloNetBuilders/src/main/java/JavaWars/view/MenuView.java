package view;

import model.Personagem;

import java.util.List;
import java.util.Scanner;

public class MenuView {

    private static final int LARGURA_PADRAO = 80;
    private static final String RESET = Cores.FUNDO_PRETO + Cores.BRANCO;

    public void prepararInput() {
        System.out.print(Cores.FUNDO_PRETO + Cores.BRANCO);
        System.out.print(" ".repeat(LARGURA_PADRAO));
        System.out.print("\r");
    }

    public int lerOpcao(Scanner scanner) {
        prepararInput();
        System.out.print("Digite sua opção: \n");
        return scanner.nextInt();
    }

    private void mostrarSeparador(String caractere, String cor) {
        System.out.print(cor);
        System.out.println(caractere.repeat(LARGURA_PADRAO));
        System.out.print(RESET);
    }

    private void centralizarTexto(String texto, String cor) {
        int padding = (LARGURA_PADRAO - texto.length()) / 2;
        System.out.print(cor);
        System.out.printf("%" + (padding + texto.length()) + "s\n", texto);
        System.out.print(RESET);
    }

    public void mostrarBoasVindas() {
        mostrarSeparador("=", Cores.AMARELO);
        centralizarTexto("BEM-VINDO À JAVAWARS! 🚀 ", Cores.AMARELO);
        mostrarSeparador("=", Cores.AMARELO);
        System.out.println(RESET);
        centralizarTexto("Agora é com você, Padawan!", Cores.BRANCO);
        centralizarTexto("Escolha com sabedoria seu herói para cumprir a missão:", Cores.BRANCO);
    }

    public void mostrarOpcoesJogo() {
        System.out.println(RESET);
        mostrarSeparador("-", Cores.AMARELO);
        centralizarTexto("O RESGATE DE GROGU!", Cores.AMARELO);
        mostrarSeparador("-", Cores.AMARELO);
        System.out.print(Cores.CIANO);
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1 - Iniciar novo Jogo");
        System.out.println("2 - Carregar Jogo");
        System.out.println("3 - Remover Jogo");
        System.out.println("4 - Sair");
        System.out.print(RESET);
        mostrarSeparador("-", Cores.AMARELO);
    }

    public void mostrarOpcoesHerois(List<Personagem> opcoesDeHeroi) {
        System.out.println(RESET);
        centralizarTexto("\n--- OPÇÕES DE HERÓI ---\n", Cores.BRANCO);
        System.out.printf("  -%-3s | %-16s | %-5s | %-9s | %-11s | %-5s | %-6s | %-5s\n",
                  "  No.", "Classe", "Nível", "Agilidade", "Furtividade", "Força", "Defesa", "Vida");
        mostrarSeparador("-", Cores.BRANCO);

        int i = 1;
        for (Personagem p : opcoesDeHeroi) {
            String nomeDaClasse = p.getClass().getSimpleName();

            System.out.printf(  Cores.CIANO + "%-3d" + RESET + " | " + Cores.CIANO + "%-16s" + RESET + " | %-5d | %-9d | %-11d | %-5d | %-6d | " + Cores.VERDE + "%-5d\n" + RESET,
                    i++,
                    nomeDaClasse,
                    p.getNivel(),
                    p.getAgilidade(),
                    p.getFurtividade(),
                    p.getForca(),
                    p.getDefesa(),
                    p.getVida()
            );
        }
        mostrarSeparador("-", Cores.BRANCO);
    }

    public void mostrarAvisoNenhumJogoCriado() {
        centralizarTexto("Ainda não há jogos criados! Crie um novo!", Cores.ROXO);
    }

    public void mostrarMenuCarregar() {
        mostrarSeparador("=", Cores.AMARELO);
        centralizarTexto("--- ESCOLHA UM PERSONAGEM SALVO ---", Cores.AMARELO);
        mostrarSeparador("=", Cores.AMARELO);
    }

    public void listarMenuCarregar(List<Personagem> listaPersonagens) {
        System.out.print(Cores.AMARELO);
        System.out.printf("  %-3s | %-16s | %-16s | %-5s | %-6s | %-5s | %-5s\n",
                  "No.", "Nome", "Classe", "Nível", "Agi.", "For.", "Vida");
        System.out.print(RESET);
        mostrarSeparador("-", Cores.CIANO);

        int i = 1;
        for (Personagem p : listaPersonagens) {
            String nomeDaClasse = p.getClass().getSimpleName();

            System.out.printf(Cores.CIANO + "  %-3d" + RESET + " | " + Cores.CIANO + "%-16s" + RESET + " | %-16s | %-5d | %-6d | %-5d | " + Cores.VERDE + "%-5d\n" + RESET,
                    i++,
                    p.getNickname(),
                    nomeDaClasse,
                    p.getNivel(),
                    p.getAgilidade(),
                    p.getForca(),
                    p.getVida()
            );
        }
        mostrarSeparador("-", Cores.CIANO);
        System.out.print(Cores.CIANO);
        System.out.println("  Digite o número (No.) do personagem para carregar: \n");
        System.out.print(RESET);
    }

    public void mostrarHeroiMaisForte(Personagem p) {
        System.out.print(Cores.AMARELO);
        System.out.println("  👑 Seu herói mais forte é: " + p.getNickname() + " (Classe: " + p.getClass().getSimpleName() + " Nível: " + p.getNivel() + ")");
        System.out.print(RESET);
    }

    public void mostrarSucessoCarregamento(String nome) {
        System.out.print(Cores.VERDE);
        System.out.println( nome + " foi carregado com sucesso.");
        System.out.print(RESET);
    }

    public void mostrarMenuExcluir(List<Personagem> listaPersonagens) {
        System.out.println("\n");
        mostrarSeparador("-", Cores.VERMELHO);
        centralizarTexto("--- ESCOLHA UM PERSONAGEM PARA EXCLUIR ---", Cores.VERMELHO);
        mostrarSeparador("-", Cores.VERMELHO);

        System.out.printf(" %-3s | %-16s | %-16s | %-5s | %-6s | %-5s | %-5s\n",
                "  ID", "Nome", "Classe", "Nível", "Agi.", "For.", "Vida");
        mostrarSeparador("-", Cores.AMARELO);

        for (Personagem p : listaPersonagens) {
            String nomeDaClasse = p.getClass().getSimpleName();

            System.out.printf( Cores.CIANO + "%-3d" + RESET + " | " + Cores.CIANO + "%-16s" + RESET + " | %-16s | %-5d | %-6d | %-5d | " + Cores.VERDE + "%-5d\n" + RESET,
                    p.getIdPersonagem(),
                    p.getNickname(),
                    nomeDaClasse,
                    p.getNivel(),
                    p.getAgilidade(),
                    p.getForca(),
                    p.getVida()
            );
        }
        System.out.print(Cores.VERMELHO + "\n  Digite o ID do personagem para excluir: " + RESET);
    }

    public void mostrarSucessoExclusao() {
        System.out.println(Cores.VERDE + "  Foi excluído permanentemente." + Cores.RESETAR);
    }

    public void mostrarErroIndice() {
        System.out.println(Cores.VERMELHO + "  Número inválido! Tente novamente." + Cores.RESETAR);
    }

    public void mostrarProntoParaMissao(Personagem heroiEscolhido) {
        mostrarSeparador("=", Cores.VERDE);
        centralizarTexto("Herói pronto para a missão!", Cores.VERDE);
        centralizarTexto(Cores.VERDE + "Classe: ", Cores.BRANCO + heroiEscolhido.getClass().getSimpleName());
        centralizarTexto(Cores.VERDE + "Nickname: ", Cores.BRANCO + heroiEscolhido.getNickname());
        mostrarSeparador("=", Cores.VERDE);
    }

    public void solicitarNickname() {
        System.out.print("\n  Agora escolha um Nickname para o seu herói: \n");
    }

    public void digiteNumeroDoHeroi() {
        System.out.print("\n  Digite o número do herói (1, 2 ou 3): \n");
    }

    public void mostrarHeroiEscolhido(Personagem heroiEscolhido) {
        System.out.println("\n  Você escolheu o herói da classe: " + Cores.CIANO + heroiEscolhido.getClass().getSimpleName() + Cores.RESETAR);
    }
}
