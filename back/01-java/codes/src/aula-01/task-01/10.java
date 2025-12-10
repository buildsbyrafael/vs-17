package Aula01.Task01;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("== CALCULADORA ==");
        System.out.println("Escolha a Operação:");
        System.out.println("1 - Adição");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("5 - Área do Círculo");
        System.out.println("6 - Área do Retângulo");
        System.out.println("7 - Área do Triângulo");
        System.out.println("8 - Diâmetro do Círculo");

        System.out.print("\nDigite a Opção: ");
        int opcao = sc.nextInt();

        double resultado;

        switch(opcao) {
            case 1:
                System.out.print("Digite o Número 1: ");
                double a1 = sc.nextDouble();
                System.out.print("Digite o Número 2: ");
                double b1 = sc.nextDouble();
                resultado = a1 + b1;
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                System.out.print("Digite o Número 1: ");
                double a2 = sc.nextDouble();
                System.out.print("Digite o Número 2: ");
                double b2 = sc.nextDouble();
                resultado = a2 - b2;
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                System.out.print("Digite o Número 1: ");
                double a3 = sc.nextDouble();
                System.out.print("Digite o Número 2: ");
                double b3 = sc.nextDouble();
                resultado = a3 * b3;
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                System.out.print("Digite o Número 1: ");
                double a4 = sc.nextDouble();
                System.out.print("Digite o Número 2: ");
                double b4 = sc.nextDouble();
                if(b4 == 0) {
                    System.out.println("Erro: Divisão por Zero!");
                } else {
                    resultado = a4 / b4;
                    System.out.println("Resultado: " + resultado);
                }
                break;

            case 5:
                System.out.print("Digite o Raio: ");
                double raio = sc.nextDouble();
                double pi = 3.14159;
                resultado = pi * raio * raio;
                System.out.println("Área do Círculo: " + resultado);
                break;

            case 6:
                System.out.print("Digite a Base: ");
                double base = sc.nextDouble();
                System.out.print("Digite a Altura: ");
                double altura = sc.nextDouble();
                resultado = base * altura;
                System.out.println("Área do Retângulo: " + resultado);
                break;

            case 7:
                System.out.print("Digite a Base: ");
                double baseT = sc.nextDouble();
                System.out.print("Digite a Altura: ");
                double alturaT = sc.nextDouble();
                resultado = (baseT * alturaT) / 2;
                System.out.println("Área do Triângulo: " + resultado);
                break;

            case 8:
                System.out.print("Digite o Raio: ");
                double raioD = sc.nextDouble();
                resultado = 2 * raioD;
                System.out.println("Diâmetro do Círculo: " + resultado);
                break;

            default:
                System.out.println("Opção Inválida!");
        }

        sc.close();
    }
}