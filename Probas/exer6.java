package U3_Java.Probas;

import java.util.Scanner;

public class exer6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza un número do 1-7");
        int num = scanner.nextInt();
        if(num < 1 || num > 7){
            System.out.println("Número inválido");
            System.exit(0);
        }
        String dia;
        System.out.println(num);
        switch(num){
            case 1:
                dia = "Luns";
                break;
            case 2:
                dia = "Martes";
                break;
            case 3:
                dia = "Mércores";
                break;
            case 4:
                dia = "Xoves";
                break;
            case 5:
                dia = "Venres";
                break;
            case 6:
                dia = "Sábado";
                break;
            case 7:
                dia = "Domingo";
                break;
            default:
                dia = "ERRO";
                break;
        }
        System.out.println("O día é "+dia);
        scanner.close();
    }
}
