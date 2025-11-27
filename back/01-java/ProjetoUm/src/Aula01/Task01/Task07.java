package Aula01.Task01;

import java.util.Scanner;

public class Task07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantidade de Alunos: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        String[] nomes = new String[quantidade];
        double[] media = new double[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\n-- Aluno " + (i + 1) + " --");

            System.out.print("Nome: ");
            nomes[i] = sc.nextLine();

            System.out.print("Nota da 1ª Prova: ");
            double nota1 = sc.nextDouble();

            System.out.print("Nota da 2ª Prova: ");
            double nota2 = sc.nextDouble();

            System.out.print("Nota da 3ª Prova: ");
            double nota3 = sc.nextDouble();
            sc.nextLine();

            media[i] = (nota1 + nota2 + nota3) / 3;
        }

        System.out.println("\n== MÉDIA DOS ALUNOS ==");
        for (int i = 0; i < quantidade; i++) {
            System.out.printf("Aluno: %s - Média: %.2f\n", nomes[i], media[i]);
        }

        sc.close();
    }
}