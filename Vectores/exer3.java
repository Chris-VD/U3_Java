package U3_Java.Vectores;

import java.util.Scanner;

public class exer3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza o número de columnas");
        int num_columnas = scanner.nextInt();
        System.out.println("Introduza o número de filas");
        int num_filas = scanner.nextInt();
        int[][] matriz = new int[num_filas][num_columnas];
        for(int i = 0; i < matriz.length; i++){
            System.out.println("Introduza os valores dunha columna");
            for(int j = 0; j < matriz[i].length; j++){
                int new_num = scanner.nextInt();
                matriz[i][j] = new_num;
            }
        }
        for(int i = 0; i < matriz.length; i++){
            System.out.println();
            for(int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j]+" ");
            }
        }
        System.out.println();
        System.out.println("Suma de cada columna:");
        for(int i = 0; i < matriz[0].length; i++){
            int sum_col = 0;
            for(int j = 0; j < matriz.length; j++){
                sum_col = sum_col + matriz[j][i];
            }
            System.out.println(sum_col);
        }
        System.out.println("Suma de cada fila:");
        for(int i = 0; i < matriz.length; i++){
            int sum_fil = 0;
            for(int j = 0; j < matriz[0].length; j++){
                sum_fil = sum_fil + matriz[i][j];
            }
            System.out.println(sum_fil);
        }
        scanner.close();
    }
}
