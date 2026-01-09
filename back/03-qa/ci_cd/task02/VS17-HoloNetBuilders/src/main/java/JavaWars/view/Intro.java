package view;

import java.util.Scanner;

public class Intro {

    private static final String RESET_PADRAO = Cores.FUNDO_PRETO + Cores.BRANCO;

    private static void pausa(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void imprimirCentralizadoLento(String texto) {

        System.out.println(Cores.FUNDO_PRETO + Cores.AMARELO);

        String[] linhas = texto.split("\\R");
        for (String linha : linhas) {
            System.out.println(AsciiArt.centralizar(linha));
            System.out.flush();
            pausa(1000);
        }
    }

    public static void exibirLogo() {
        AsciiArt.exibirLogo();
    }

    public static void mostrar() {
        exibirLogo();
        pausa(1000);

          System.out.println("\n\n\n");

        String textoLongo = """
                Há muito tempo,
                em uma galáxia muito, muito distante...
                
                Tempos sombrios pairam sobre a galáxia.
                O pequeno GROGU, herdeiro de um poder raro e
                ancestral, foi sequestrado pela temida LADY NYX,
                uma feiticeira sombria que domina tecnologias
                proibidas e manipula a Força com intenções desconhecidas.
                
                Com Grogu mantido em um planeta oculto, a galáxia
                entra em desespero. Rumores dizem que Lady Nyx pretende
                usar seu pode para abrir portais através do tempo e 
                reescrever o destino da Ordem.
                
                Mas surge uma esperança.
                Você foi convocado para liderar uma jornada épica,
                atravessar mundos perigosos e enfrentar inimigos implacáveis.
                Mas antes de partir, uma decisão crucial deve ser tomada:
                
                ESCOLHA SEU CAMPEÃO.
                
                Um JEDI honrado?
                Um WOOKIE destemido?
                Ou um DROID de elite?
                
                O destino de Grogu — e de toda a galáxia —
                está agora em suas mãos.
                
                Prepare-se...
                
                A MISSÃO COMEÇA AGORA.""";

        imprimirCentralizadoLento(textoLongo);

        pausa(1500);

        System.out.println("\nPressione ENTER para começar sua jornada...\n"+ Cores.RESETAR);

        Scanner input = new Scanner(System.in);
        System.out.print(Cores.FUNDO_PRETO + Cores.BRANCO);
        System.out.print(" ".repeat(80));
        System.out.print("\r");
        input.nextLine();
    }

    private static void imprimirCentralizado(String texto) {
        String[] linhas = texto.split("\\R");
        for (String linha : linhas) {
            System.out.println(AsciiArt.centralizar(linha));
        }
        System.out.print(RESET_PADRAO);
    }
}
