package U3_Java.Probas;

import java.util.Scanner;

public class exer7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza un número");
        int num = scanner.nextInt();
        boolean primoCheck = true;
        for (int x = num-1; x > 1; x--){
            if (num % x == 0){
                primoCheck = false;
                break;
            }
        }
        if (primoCheck == true){
            System.out.println("Primo");
        }
        else{
            System.out.println("Non primo");
        }
        scanner.close();
    }
}
