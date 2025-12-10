package Aula01.Task01;

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a Temperatura (ºC): ");
        double celsiusTemperature = sc.nextDouble();

        double fahrenheitTemperature = (celsiusTemperature * 9 / 5) + 32;

        System.out.println(fahrenheitTemperature + " °F.");

        sc.close();
    }
}