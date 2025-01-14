package U3_Java.Probas;

import java.util.Scanner;

public class exer3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double prezoMaza = 3.5;
        double prezoLaranxa = 1.6;
        System.out.println("Cantos kilos de mazás queres?");
        double kiloMazas = scanner.nextDouble();
        System.out.println("Cantos kilos de laranxas queres?");
        double kiloLaranxas = scanner.nextDouble();
        double total = kiloMazas * prezoMaza + kiloLaranxas + prezoLaranxa;
        System.out.println("O total é "+total+" euros");
        scanner.close();
    }
}
