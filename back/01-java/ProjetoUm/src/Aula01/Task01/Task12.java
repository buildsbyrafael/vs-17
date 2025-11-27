package Aula01.Task01;

import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Preço do Livro: ");
        double preco = sc.nextDouble();

        System.out.print("Quantidade de Livros: ");
        int quantidade = sc.nextInt();

        double total = preco * quantidade;

        if (total > 100) {
            total = total * 0.95;
        }

        System.out.printf("Valor Final: R$ %.2f\n", total);

        sc.close();
    }
}