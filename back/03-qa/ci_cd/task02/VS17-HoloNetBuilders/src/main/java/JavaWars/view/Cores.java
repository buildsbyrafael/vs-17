package view;

public class Cores {
    public static final String RESETAR = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String ROXO = "\u001B[35m";
    public static final String CIANO = "\u001B[36m";
    public static final String BRANCO = "\u001B[37m";
    public static final String FUNDO_PRETO = "\u001B[40m";

    private static final String TEMA_PADRAO = FUNDO_PRETO + BRANCO;

    public static void imprimirJogo(String mensagem) {
        System.out.println(TEMA_PADRAO + mensagem + RESETAR);
    }

    public static void imprimirCustom(String formato, String mensagem) {
        System.out.println(formato + mensagem + RESETAR);
    }
}
