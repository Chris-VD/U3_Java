package U3_Java.Vectores;

import java.util.Scanner;

public class exer1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza cantos número decimales quere: ");
        int num = scanner.nextInt();
        double[] decimales = new double[num];
        System.out.println("Introduza un a un os decimales que desexa");
        for(int i = 0; i < decimales.length; i++){
            double new_dec = scanner.nextDouble();
            decimales[i] = new_dec;
        }
        System.out.println("Esta é a lista de decimales que introduciches en orde contraria:");
        for(int i = decimales.length - 1; i >= 0; i--){
            System.out.println(decimales[i]);
        }
        scanner.close();
    }
}
