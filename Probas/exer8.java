package U3_Java.Probas;

import java.util.Scanner;

public class exer8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduz aun número");
        int num = scanner.nextInt();
        if (num < 0){
            System.out.println("Erro");
            System.exit(0);
        }
        int raizAprox = 0;
        for (int x = 1; x < (num/2); x++){
            int nextTry = (x+1) * (x+1);
            if (nextTry > num){
                raizAprox = x;
                break;
            }
        }
        System.out.println("A raíz aproximada de "+num+" é "+raizAprox);
        scanner.close();
    }
}
