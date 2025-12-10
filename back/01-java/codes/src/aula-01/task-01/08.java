package Aula01.Task01;

import java.util.Scanner;

public class Task08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int CAPACIDADE_MAX = 100;

        String[] nomes = new String[CAPACIDADE_MAX];
        String[] descricoes = new String[CAPACIDADE_MAX];
        double[] precos = new double[CAPACIDADE_MAX];
        int[] estoques = new int[CAPACIDADE_MAX];

        int totalCadastrados = 0;
        int opcao;

        do {
            System.out.println("\n== MENU ==\n");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Aplicar Desconto");
            System.out.println("3 - Exibir Produto");
            System.out.println("4 - Exibir Todos os Produtos");
            System.out.println("5 - Sair");

            System.out.print("\nEscolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                if (totalCadastrados == CAPACIDADE_MAX) {
                    System.out.println("\nLimite Máximo de Produtos!");
                    continue;
                }

                System.out.print("\nNome: ");
                nomes[totalCadastrados] = sc.nextLine();

                System.out.print("Descrição: ");
                descricoes[totalCadastrados] = sc.nextLine();

                System.out.print("Preço: ");
                precos[totalCadastrados] = sc.nextDouble();

                System.out.print("Estoque: ");
                estoques[totalCadastrados] = sc.nextInt();
                sc.nextLine();

                totalCadastrados++;
                System.out.println("\nProduto Cadastrado!");

            } else if (opcao == 2) {
                if (totalCadastrados == 0) {
                    System.out.println("\nNenhum Produto Cadastrado!");
                    continue;
                }

                System.out.print("\nNúmero do Produto (1 a " + totalCadastrados + "): ");
                int n = sc.nextInt();
                if (n < 1 || n > totalCadastrados) {
                    System.out.println("\nProduto Inválido!");
                    continue;
                }

                System.out.print("\nPercentual de Desconto: ");
                double perc = sc.nextDouble();
                precos[n - 1] = precos[n - 1] - (precos[n - 1] * perc / 100);
                System.out.println("\nDesconto Aplicado!");

            } else if (opcao == 3) {
                if (totalCadastrados == 0) {
                    System.out.println("\nNenhum Produto Cadastrado!");
                    continue;
                }

                System.out.print("\nNúmero do Produto (1 a " + totalCadastrados + "): ");
                int n = sc.nextInt();
                if (n < 1 || n > totalCadastrados) {
                    System.out.println("\nProduto Inválido!");
                    continue;
                }

                int idx = n - 1;
                System.out.println("\n-- Produto " + n + " --");
                System.out.println("\nNome: " + nomes[idx]);
                System.out.println("Descrição: " + descricoes[idx]);
                System.out.println("Preço: R$ " + precos[idx]);
                System.out.println("Estoque: " + estoques[idx]);

            } else if (opcao == 4) {
                if (totalCadastrados == 0) {
                    System.out.println("\nNenhum Produto Cadastrado!");
                    continue;
                }

                System.out.println("\n-- Todos os Produtos --");
                for (int i = 0; i < totalCadastrados; i++) {
                    System.out.println("\n-- Produto " + (i + 1) + " --");
                    System.out.println("\nNome: " + nomes[i]);
                    System.out.println("Descrição: " + descricoes[i]);
                    System.out.println("Preço: R$ " + precos[i]);
                    System.out.println("Estoque: " + estoques[i]);
                }

            } else if (opcao == 5) {
                System.out.println("\nSaindo...");

            } else {
                System.out.println("\nOpção Inválida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}