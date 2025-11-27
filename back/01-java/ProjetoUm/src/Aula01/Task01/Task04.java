package Aula01.Task01;

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int anoChegada = 1500;
        int mediaGeracao = 28;

        System.out.print("Ano Atual: ");
        int anoAtual = sc.nextInt();

        int anosPassados = anoAtual - anoChegada;
        int geracoes = anosPassados / mediaGeracao;

        System.out.println(geracoes + " Gerações.");

        sc.close();
    }
}