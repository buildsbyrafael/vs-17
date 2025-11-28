package Aula02.Task02;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int CAPACIDADE_MAX = 100;

        String[] listaNomes = new String[CAPACIDADE_MAX];
        int[] listaQuantidades = new int[CAPACIDADE_MAX];
        double[] listaPrecos = new double[CAPACIDADE_MAX];

        int totalCadastrados = 0;
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

                if (totalCadastrados == CAPACIDADE_MAX) {
                    System.out.println("\nLimite Máximo de Produtos!");
                    continue;
                }

                for (int i = 0; i < CAPACIDADE_MAX; i++) {
                    if (listaNomes[i] == null) {
                        System.out.print("\nNome do Produto: ");
                        listaNomes[i] = scanner.nextLine();

                        System.out.print("Quantidade: ");
                        listaQuantidades[i] = scanner.nextInt();

                        System.out.print("Preço: ");
                        listaPrecos[i] = scanner.nextDouble();
                        scanner.nextLine();

                        totalCadastrados++;
                        System.out.println("\nProduto Cadastrado!");
                        break;
                    }
                }

            } else if (opcao == 2) {
                System.out.println("\n-- Listar Estoque --");
                System.out.println("\nID | Nome             | Quantidade | Preço");
                System.out.println("\n-----------------------------------------\n");

                boolean temProduto = false;

                for (int i = 0; i < CAPACIDADE_MAX; i++) {
                    if (listaNomes[i] != null) {
                        System.out.printf("%d  |  %-14s  | %3d  | R$ %.2f \n",
                                i, listaNomes[i], listaQuantidades[i], listaPrecos[i]);

                        temProduto = true;
                    }
                }

                if (!temProduto) {
                    System.out.println("Nenhum Produto Cadastrado!");
                }

            } else if (opcao == 3) {
                System.out.println("\n-- Buscar Produto --");

            } else if (opcao == 4) {
                System.out.println("\n-- Vender --");

                if (totalCadastrados == 0) {
                    System.out.println("\nNenhum Produto Cadastrado!");
                } else {
                    System.out.print("\nNome do Produto: ");
                    String nomeBusca = scanner.nextLine();

                    boolean achouProduto = false;

                    for (int i = 0; i < CAPACIDADE_MAX; i++) {
                        if (listaNomes[i] != null && listaNomes[i].equals(nomeBusca)) {
                            achouProduto = true;

                            System.out.println("\nEstoque Atual: " + listaQuantidades[i]);
                            System.out.print("\nQuantidade de Venda: ");
                            int qtdVenda = scanner.nextInt();
                            scanner.nextLine();

                            if (listaQuantidades[i] >= qtdVenda) {
                                listaQuantidades[i] -= qtdVenda;
                                System.out.println("\nVenda Realizada! Novo Estoque: " + listaQuantidades[i]);
                            } else {
                                System.out.println("\nEstoque Insuficiente!");
                            }
                        }
                    }

                    if (!achouProduto) {
                        System.out.println("\nNão Encontrado!");
                    }
                }

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
