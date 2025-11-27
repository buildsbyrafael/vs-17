package Aula02.Task02;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int CAPACIDADE_MAX = 100;

        String[] listaNomes = new String[CAPACIDADE_MAX];
        int[] listaQuantidades = new int[CAPACIDADE_MAX];
        double[] listaPrecos = new double[CAPACIDADE_MAX];

        int opcao;

        do {
            System.out.println("\n== MERCADINHO ==\n");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Estoque");
            System.out.println("3 - Buscar Produto");
            System.out.println("4 - Vender (Atualizar Estoque)");
            System.out.println("5 - Remover Produto");
            System.out.println("6 - Relatório de Valores");
            System.out.println("7 - Sair");

            System.out.print("\nEscolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("\n-- Cadastrar Produto --");

            } else if (opcao == 2) {
                System.out.println("\n-- Listar Estoque --");

            } else if (opcao == 3) {
                System.out.println("\n-- Buscar Produto --");

            } else if (opcao == 4) {
                System.out.println("\n-- Vender --");

            } else if (opcao == 5) {
                System.out.println("\n-- Remover Produto --");

            } else if (opcao == 6) {
                System.out.println("\n-- Relatório --");

            } else if (opcao == 7) {
                System.out.println("\nSaindo...");

            } else {
                System.out.println("\nOpção Inválida!");
            }

        } while (opcao != 7);

        scanner.close();
    }
}