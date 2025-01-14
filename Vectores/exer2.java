package U3_Java.Vectores;

import java.util.Scanner;

public class exer2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lista = {3, 5 ,7, 2, 9};
        while(true){
            for(int num:lista){
                System.out.print(num+" ");
            }
            System.out.println("Introduza un índice para borrar da lista");
            int indice = scanner.nextInt();
            if(indice > lista.length - 1){
                System.out.println("Erro");
                continue;
            }
            System.out.println(lista[indice]);
            if (lista.length == 1){
                System.out.println("Fin");
                break;
            }
            int[] nova_lista = new int[lista.length-1];
            int x = 0;
            for(int i = 0; i < lista.length; i++){
                if (i != indice){
                    nova_lista[x] = lista[i];
                    x++;
                }
            }
            lista = nova_lista;
        }
        scanner.close();
    }
}
