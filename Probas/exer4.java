package U3_Java.Probas;

import java.util.Scanner;

public class exer4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza unha cantidade de segundos");
        int segundos = scanner.nextInt();
        double minutos = segundos/60;
        double horas = minutos/60;
        System.out.println(segundos+" segundos son "+minutos+" minutos, ou "+horas+" horas.");
        scanner.close();
    }
}
