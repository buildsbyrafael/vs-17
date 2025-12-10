package Aula01.Task01;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Produto: ");
        String produto = sc.nextLine();

        System.out.print("Preço: ");
        double preco = sc.nextDouble();

        System.out.println("\nPromoção: " + produto);

        for (int quantidade = 1; quantidade <= 10; quantidade++) {
            double descontoPercentual = quantidade * 5;
            if (descontoPercentual > 50) {
                descontoPercentual = 50;
            }

            double precoUnitario = preco * (1 - descontoPercentual / 100);

            double total = precoUnitario * quantidade;

            System.out.printf("%d x R$ %.2f = R$ %.2f\n", quantidade, precoUnitario, total);
        }

        sc.close();
    }
}