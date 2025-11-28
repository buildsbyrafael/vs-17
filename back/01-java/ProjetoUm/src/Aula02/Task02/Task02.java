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
                        System.out.println("\nProduto Cadastrado! ID: " + (i + 1));
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
                        System.out.printf("%d  |  %-14s  | %3d  | R$ %.2f\n",
                                i + 1, listaNomes[i], listaQuantidades[i], listaPrecos[i]);
                        temProduto = true;
                    }
                }

                if (!temProduto) {
                    System.out.println("Nenhum Produto Cadastrado!");
                }

            } else if (opcao == 3) {
                System.out.println("\n-- Buscar Produto --");
                System.out.print("\nNome do Produto: ");
                String nomeBusca = scanner.nextLine();

                boolean achou = false;
                for (int i = 0; i < CAPACIDADE_MAX; i++) {
                    if (listaNomes[i] != null && listaNomes[i].equalsIgnoreCase(nomeBusca)) {
                        System.out.println("\nProduto Encontrado!");
                        System.out.println("\nID: " + (i + 1));
                        System.out.println("Nome: " + listaNomes[i]);
                        System.out.println("Quantidade: " + listaQuantidades[i]);
                        System.out.printf("Preço: R$ %.2f\n", listaPrecos[i]);
                        achou = true;
                        break;
                    }
                }

                if (!achou) {
                    System.out.println("\nNão Encontrado!");
                }

            } else if (opcao == 4) {
                System.out.println("\n-- Vender --");

                if (totalCadastrados == 0) {
                    System.out.println("\nNenhum Produto Cadastrado!");
                } else {
                    System.out.print("\nNome do Produto: ");
                    String nomeBusca = scanner.nextLine();

                    boolean achouProduto = false;
                    for (int i = 0; i < CAPACIDADE_MAX; i++) {
                        if (listaNomes[i] != null && listaNomes[i].equalsIgnoreCase(nomeBusca)) {
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
                            break;
                        }
                    }

                    if (!achouProduto) {
                        System.out.println("\nNão Encontrado!");
                    }
                }

            } else if (opcao == 5) {
                System.out.println("\n-- Remover Produto --");

                if (totalCadastrados == 0) {
                    System.out.println("\nNenhum Produto Cadastrado!");
                } else {
                    System.out.print("\nNome do Produto: ");
                    String nomeBusca = scanner.nextLine();

                    boolean removido = false;
                    for (int i = 0; i < CAPACIDADE_MAX; i++) {
                        if (listaNomes[i] != null && listaNomes[i].equalsIgnoreCase(nomeBusca)) {
                            listaNomes[i] = null;
                            listaQuantidades[i] = 0;
                            listaPrecos[i] = 0;
                            totalCadastrados--;
                            System.out.println("\nProduto Removido com Sucesso! ID: " + (i + 1));
                            removido = true;
                            break;
                        }
                    }

                    if (!removido) {
                        System.out.println("\nProduto Não Encontrado!");
                    }
                }

            } else if (opcao == 6) {
                System.out.println("\n-- Relatório --");

                double totalValorEstoque = 0.0;
                int totalItensEstoque = 0;
                boolean temProduto = false;

                for (int i = 0; i < CAPACIDADE_MAX; i++) {
                    if (listaNomes[i] != null) {
                        totalValorEstoque += listaQuantidades[i] * listaPrecos[i];
                        totalItensEstoque += listaQuantidades[i];
                        temProduto = true;
                    }
                }

                if (temProduto) {
                    System.out.println("\nResumo: ");
                    System.out.println("\nQuantidade Total (Itens Físicos): " + totalItensEstoque);
                    System.out.printf("Valor Total (Patrimônio): R$ %.2f\n", totalValorEstoque);
                } else {
                    System.out.println("\nEstoque Vazio!");
                }

            } else if (opcao == 7) {
                System.out.println("\nSaindo...");

            } else {
                System.out.println("\nOpção Inválida!");
            }

        } while (opcao != 7);

        scanner.close();
    }
}