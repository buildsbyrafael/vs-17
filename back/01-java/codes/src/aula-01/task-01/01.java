package Aula01.Task01;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int horaInicio, minutoInicio, horaFim, minutoFim;
        int duracaoHoras, duracaoMinutos;

        System.out.print("Hora Início: ");
        horaInicio = sc.nextInt();

        System.out.print("Minuto Início: ");
        minutoInicio = sc.nextInt();

        System.out.print("Hora Fim: ");
        horaFim = sc.nextInt();

        System.out.print("Minuto Fim: ");
        minutoFim = sc.nextInt();

        if (horaInicio == horaFim && minutoInicio == minutoFim) {
            System.out.println("Duração de: 24 h e 0 min.");
            sc.close();
            return;
        }

        if (minutoFim < minutoInicio) {
            minutoFim += 60;
            horaFim -= 1;
        }

        duracaoMinutos = minutoFim - minutoInicio;

        if (horaFim < horaInicio) {
            horaFim += 24;
        }

        duracaoHoras = horaFim - horaInicio;

        System.out.println("Duração de: " + duracaoHoras + " h e " + duracaoMinutos + " min.");

        sc.close();
    }
}