package Aula01.Task01;

import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o Nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite o Salário Mensal: ");
        double salarioMensal = sc.nextDouble();

        System.out.print("Digite o Número de Meses Trabalhados (1 a 12): ");
        int mesesTrabalhados = sc.nextInt();

        double salarioAnual = salarioMensal * mesesTrabalhados;

        System.out.println("\n");
        System.out.println("Funcionário: " + nome);
        System.out.println("Salário anual: R$ " + salarioAnual);

        sc.close();
    }
}