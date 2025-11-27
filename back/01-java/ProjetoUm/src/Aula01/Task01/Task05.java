package Aula01.Task01;

import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int total, brancos, nulos, validos;
        double percBrancos, percNulos, percValidos;

        System.out.print("Digite o Total de Eleitores: ");
        total = entrada.nextInt();

        System.out.print("Digite o Número de Votos Brancos: ");
        brancos = entrada.nextInt();

        System.out.print("Digite o Número de Votos Nulos: ");
        nulos = entrada.nextInt();

        System.out.print("Digite o Número de Votos Válidos: ");
        validos = entrada.nextInt();

        percBrancos = (brancos * 100.0) / total;
        percNulos = (nulos * 100.0) / total;
        percValidos = (validos * 100.0) / total;

        System.out.println("\n");
        System.out.println("Percentual de Brancos: " + percBrancos + "%.");
        System.out.println("Percentual de Nulos: " + percNulos + "%.");
        System.out.println("Percentual de Válidos: " + percValidos + "%.");

        entrada.close();
    }
}
