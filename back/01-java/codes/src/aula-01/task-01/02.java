package Aula01.Task01;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o Número: ");
        int numero = sc.nextInt();

        switch (numero % 2) {
            case 0:
                System.out.println("O Número é Par.");
                break;

            default:
                System.out.println("O número é Ímpar.");
        }

        sc.close();
    }
}
