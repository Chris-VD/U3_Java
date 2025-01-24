import java.util.Scanner;
import java.util.Random;

public class exer1 {
    public static void main(String[] args) {
        // Inicializamos o scanner e o random
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Gardamos o número de atacantes e defensores
        System.out.println("Introduza o número de atacantes:");
        int atacantes = scanner.nextInt();
        System.out.println("Introduza o número de defensores:");
        int defensores = scanner.nextInt();

        // Definimos outras variables
        boolean gameOver = false;  
        int numDadosA, numDadosD;
        
        // Aquí empeza o xogo
        while(true){
            // O número máximo de dados que temos é 3, polo que se algún xogador ten máis tropas debemos reducir o número de tiradas
            if(atacantes >= 3){
                numDadosA = 3;}
            else{
                numDadosA = atacantes;
            }
            if(defensores >= 3){
                numDadosD = 3;
            }
            else{
                numDadosD = defensores;
            }

            // Creamos os vectores
            int[] atacantesOrdenado = new int[numDadosA];
            int[] defensoresOrdenado = new int[numDadosD];

            // Asignámolles os números aleatorios
            for(int i = 0; i<atacantesOrdenado.length; i++){
                atacantesOrdenado[i] = random.nextInt(6) + 1;
            }
            for(int i = 0; i<defensoresOrdenado.length; i++){
                defensoresOrdenado[i] = random.nextInt(6) + 1;
            }

            // Ordenamos ambos vectores
            for(int i = 0; i<atacantesOrdenado.length-1; i++){
                // Comprobamos se o v1 é maior ó v2, e se é así intercambiámolos e comezamos de novo
                if(atacantesOrdenado[i] < atacantesOrdenado[i+1]){
                    int temp = atacantesOrdenado[i+1];
                    atacantesOrdenado[i+1] = atacantesOrdenado[i];
                    atacantesOrdenado[i] = temp;
                    i = -1;
                }
            }
            for(int i = 0; i<defensoresOrdenado.length-1; i++){
                if(defensoresOrdenado[i] < defensoresOrdenado[i+1]){
                    int temp = defensoresOrdenado[i+1];
                    defensoresOrdenado[i+1] = defensoresOrdenado[i];
                    defensoresOrdenado[i] = temp;
                    i = -1;
                }
            }

            // Mostramos por pantalla os valores dos atacantes e defensores
            System.out.println();
            System.out.println("Atacantes:");
            for(int atacante:atacantesOrdenado){
                System.out.print(atacante+"\t");
            }
            System.out.println("\nDefensores:");
            for(int defensor:defensoresOrdenado){
                System.out.print(defensor+"\t");
            }
            System.out.println();

            // Comprobamos se os atacantes teñen menos dados que os defensores ou vice versa, e gardamos a variable menor
            int menor;
            if(numDadosA<numDadosD){
                menor = numDadosA;
            }
            else{
                menor = numDadosD;
            }

            // Comprobamos parella por parella para ver se os atacantes ou defensores gañan
            // Como xa gardamos a variable menor, i nunca estará fora de rango
            for(int i = 0;i<menor;i++){
                if(defensoresOrdenado[i] >= atacantesOrdenado[i]){
                    atacantes--;
                }
                else{
                    defensores--;
                }
                // Se calquera dos bandos chega a 0, rompemos o bucle e indicamos o game over
                if(defensores == 0 || atacantes == 0){
                    gameOver = true;
                    break;
                }
            }

            // Mostramos por pantalla os defensores e atacantes restantes
            System.out.println("Número de atacantes restantes: "+atacantes+"\nNúmero de defensores restantes: "+defensores);

            // Comprobamos o game over
            if(gameOver == true){
                break;
            }
        }
        if(defensores==0){
            System.out.println("Os atacantes gañaron!");
        }
        else if(atacantes==0){
            System.out.println("Os defensores gañaron!");
        }
        scanner.close();
    }
}
