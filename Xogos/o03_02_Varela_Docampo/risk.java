import java.util.Scanner;
import java.util.Random;
public class risk {
    public static void main(String[] args) {Scanner scanner = new Scanner(System.in);Random random = new Random();
        System.out.println("Introduza o número de atacantes:");int atacantes = scanner.nextInt();
        System.out.println("Introduza o número de defensores:");int defensores = scanner.nextInt();
        boolean gameOver = false;int numDadosA, numDadosD;
        while(true){
            if(atacantes >= 3){numDadosA = 3;}
            else{ numDadosA = atacantes;}
            if(defensores >= 3){numDadosD = 3;}
            else{numDadosD = defensores; }
            int[] atacantesOrdenado = new int[numDadosA]; int[] defensoresOrdenado = new int[numDadosD];
            for(int i = 0; i<atacantesOrdenado.length; i++){atacantesOrdenado[i] = random.nextInt(6) + 1;}
            for(int i = 0; i<defensoresOrdenado.length; i++){ defensoresOrdenado[i] = random.nextInt(6) + 1;}
            for(int i = 0; i<atacantesOrdenado.length-1; i++){// Comprobamos se o v1 é maior ó v2, e se é así intercambiámolos e comezamos de novo
                if(atacantesOrdenado[i] < atacantesOrdenado[i+1]){
                    int temp = atacantesOrdenado[i+1];
                    atacantesOrdenado[i+1] = atacantesOrdenado[i];
                    atacantesOrdenado[i] = temp;
                    i = -1;}}
            for(int i = 0; i<defensoresOrdenado.length-1; i++){
                if(defensoresOrdenado[i] < defensoresOrdenado[i+1]){
                    int temp = defensoresOrdenado[i+1];
                    defensoresOrdenado[i+1] = defensoresOrdenado[i];
                    defensoresOrdenado[i] = temp;
                    i = -1;}}
            System.out.println();System.out.println("Atacantes:");
            for(int atacante:atacantesOrdenado){System.out.print(atacante+"\t");}
            System.out.println("\nDefensores:");
            for(int defensor:defensoresOrdenado){System.out.print(defensor+"\t");}System.out.println();
            int menor;
            if(numDadosA<numDadosD){menor = numDadosA; }
            else{menor = numDadosD; }
            for(int i = 0;i<menor;i++){
                if(defensoresOrdenado[i] >= atacantesOrdenado[i]){atacantes--;}
                else{ defensores--;}
                if(defensores == 0 || atacantes == 0){gameOver = true;
                    break;}}
            System.out.println("Número de atacantes restantes: "+atacantes+"\nNúmero de defensores restantes: "+defensores);
            if(gameOver == true){break;}}
        if(defensores==0){System.out.println("Os atacantes gañaron!");}
        else if(atacantes==0){System.out.println("Os defensores gañaron!");}
        scanner.close();}}
