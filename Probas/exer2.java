package U3_Java.Probas;

import java.util.Scanner;

public class exer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce túa idade actual: ");
        int idade = scanner.nextInt();
        scanner.close();
        int anoNacemento = 2025 - idade;
        System.out.println("Naceches no "+anoNacemento);
    }
}
