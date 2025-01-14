package U3_Java.Probas;

import java.util.Scanner;

public class exer5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza un número");
        int primeiro = scanner.nextInt();
        System.out.println("Introduza outro número");
        int segundo = scanner.nextInt();
        System.out.println("Introduza un último número");
        int terceiro = scanner.nextInt();
        while (true){
            if (primeiro > segundo && primeiro > terceiro){
                System.out.println(primeiro);
                primeiro = 0;
            }
            else if(segundo > primeiro && segundo > terceiro){
                System.out.println(segundo);
                segundo = 0;
            }
            else if(terceiro > primeiro && terceiro > segundo){
                System.out.println(terceiro);
                terceiro = 0;
            }
            else if(primeiro == segundo && segundo == terceiro){
                break;
            }
        }
        scanner.close();
    }
}
