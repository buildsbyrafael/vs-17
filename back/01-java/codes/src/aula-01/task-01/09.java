package Aula01.Task01;

import java.util.Scanner;

public class Task09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra;

        System.out.println("== TRADUTOR ==");
        System.out.println("Digite 'Sair' Para Encerrar.");

        do {
            System.out.print("\nDigite a Palavra: ");
            palavra = sc.nextLine();

            switch (palavra.toLowerCase()) {
                case "cachorro":
                    System.out.println("Dog");
                    break;
                case "cidade":
                    System.out.println("City");
                    break;
                case "feliz":
                    System.out.println("Happy");
                    break;
                case "triste":
                    System.out.println("Sad");
                    break;

                case "dog":
                    System.out.println("Cachorro");
                    break;
                case "city":
                    System.out.println("Cidade");
                    break;
                case "happy":
                    System.out.println("Feliz");
                    break;
                case "sad":
                    System.out.println("Triste");
                    break;

                case "sair":
                    System.out.println("Encerrando o Tradutor...");
                    break;

                default:
                    System.out.println("Esse idioma não é Válido.");
                    break;
            }

        } while (!palavra.equalsIgnoreCase("Sair"));

        sc.close();
    }
}