import java.util.Scanner;

public class exer2 {
    /*
    Exercicio 5. Implanta un xogo de Tres en Raia en Java utilizando arrays bidimensionais para representar o taboleiro de xogo.
    O programa debe permitir que dous xogadores humanos xoguen entre eles alternando quendas ata que un deles consiga gañar ou que o taboleiro quede completo, resultando nun empate.
    Utiliza un vector bidimensional 3x3 de enteiros para representar o taboleiro.
    Inicialmente, cada posición do taboleiro debe estar baleira, representada cun 0 no vector.
    Alterna entre os dous xogadores, representados polos números 1 e 2.
    Amosa o taboleiro despois de cada movemento. Os espazos baleiros represéntaos con - e os xogadores con X para o xogador 1 e O para o xogador 2.
    Verifica e amosa unha mensaxe cando un xogador gaña ou se hai un empate se se encheron todos os ocos.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] taboleiro = new String[4][4];
        taboleiro[0][0] = " ";
        for(int i = 1; i < taboleiro.length; i++){
            taboleiro[i][0] = "F"+i;
            taboleiro[0][i] = "C"+i;
            for(int j = 1; j < taboleiro.length; j++){
                taboleiro[i][j] = "-";
            }
        }
        int numX = 0;
        int num0 = 0;
        int turnos = 0;
        while(true){
            for (int i = 0; i < taboleiro.length; i++){
                for (int j = 0; j < taboleiro.length; j++){
                    if (taboleiro[i][j] == "X"){
                        numX++;
                    }
                    else if (taboleiro[i][j] == "0"){
                        num0++;
                    }
                }
                if (numX == 3){
                    System.out.println("Gañou o xogador 1");
                    scanner.close();
                    System.exit(0);
                }
                else if (num0 == 3){
                    System.out.println("Gañou o xogador 2");
                    System.exit(0);
                }
                else{
                    numX = 0;
                    num0 = 0;
                }
            }
            for (int i = 0; i < taboleiro.length; i++){
                for (int j = 0; j < taboleiro.length; j++){
                    if (taboleiro[j][i] == "X"){
                        numX++;
                    }
                    else if (taboleiro[j][i] == "0"){
                        num0++;
                    }
                }
                if (numX == 3){
                    System.out.println("Gañou o xogador 1");
                    System.exit(0);
                }
                else if (num0 == 3){
                    System.out.println("Gañou o xogador 2");
                    System.exit(0);
                }
                else{
                    numX = 0;
                    num0 = 0;
                }
            }
            for (int i = 1; i < taboleiro.length; i++){
                if (taboleiro[i][i] == "X"){
                    numX++;
                }
                else if(taboleiro[i][i] == "0"){
                    num0++;
                }
            }
            System.out.println(numX);
            if (numX == 3){
                System.out.println("Gañou o xogador 1");
                System.exit(0);
            }
            else if (num0 == 3){
                System.out.println("Gañou o xogador 2");
                System.exit(0);
            }
            else{
                numX = 0;
                num0 = 0;
            }
            for (int i = 1; i < taboleiro.length; i++){
                if (taboleiro[taboleiro.length - i][i] == "X"){
                    numX++;
                }
                else if(taboleiro[taboleiro.length - i][i] == "0"){
                    num0++;
                }
            }
            if (numX == 3){
                System.out.println("Gañou o xogador 1");
                System.exit(0);
            }
            else if (num0 == 3){
                System.out.println("Gañou o xogador 2");
                System.exit(0);
            }
            else{
                numX = 0;
                num0 = 0;
            }
            if (turnos == 9){
                System.out.println();
                System.out.println("Empate");
                System.exit(0);
            }

            for(int i = 0; i < taboleiro.length; i++){
                System.out.println();
                for(int j = 0; j < taboleiro[i].length; j++){
                    System.out.print(taboleiro[i][j]+"\t");
                }
            }
            System.out.println();
            while(true){
                System.out.println("\t Xogador 1");
                System.out.println("Columna");
                int xogador1C = scanner.nextInt();
                System.out.println("Fila");
                int xogador1F = scanner.nextInt();
                if (taboleiro[xogador1F][xogador1C] == "-"){
                    taboleiro[xogador1F][xogador1C] = "X";
                    break;
                }
                else{
                    System.out.println("Posición inválida.");
                    continue;
                }
            }
            turnos ++;
            for(int i = 0; i < taboleiro.length; i++){
                System.out.println();
                for(int j = 0; j < taboleiro[i].length; j++){
                    System.out.print(taboleiro[i][j]+"\t");
                }
            }

            for (int i = 0; i < taboleiro.length; i++){
                for (int j = 0; j < taboleiro.length; j++){
                    if (taboleiro[i][j] == "X"){
                        numX++;
                    }
                    else if (taboleiro[i][j] == "0"){
                        num0++;
                    }
                }
                if (numX == 3){
                    System.out.println("Gañou o xogador 1");
                    System.exit(0);
                }
                else if (num0 == 3){
                    System.out.println("Gañou o xogador 2");
                    System.exit(0);
                }
                else{
                    numX = 0;
                    num0 = 0;
                }
            }
            for (int i = 0; i < taboleiro.length; i++){
                for (int j = 0; j < taboleiro.length; j++){
                    if (taboleiro[j][i] == "X"){
                        numX++;
                    }
                    else if (taboleiro[j][i] == "0"){
                        num0++;
                    }
                }
                if (numX == 3){
                    System.out.println("Gañou o xogador 1");
                    System.exit(0);
                }
                else if (num0 == 3){
                    System.out.println("Gañou o xogador 2");
                    System.exit(0);
                }
                else{
                    numX = 0;
                    num0 = 0;
                }
            }
            for (int i = 1; i < taboleiro.length; i++){
                if (taboleiro[i][i] == "X"){
                    numX++;
                }
                else if(taboleiro[i][i] == "0"){
                    num0++;
                }
            }
            if (numX == 3){
                System.out.println("Gañou o xogador 1");
                System.exit(0);
            }
            else if (num0 == 3){
                System.out.println("Gañou o xogador 2");
                System.exit(0);
            }
            else{
                numX = 0;
                num0 = 0;
            }
            for (int i = 1; i < taboleiro.length; i++){

                if (taboleiro[taboleiro.length - i][i] == "X"){
                    numX++;
                }
                else if(taboleiro[taboleiro.length - i][i] == "0"){
                    num0++;
                }
            }
            if (numX == 3){
                System.out.println("Gañou o xogador 1");
                System.exit(0);
            }
            else if (num0 == 3){
                System.out.println("Gañou o xogador 2");
                System.exit(0);
            }
            else{
                numX = 0;
                num0 = 0;
            }
            if (turnos == 9){
                System.out.println();
                System.out.println("Empate");
                System.exit(0);
            }

            System.out.println();
            while(true){
                System.out.println("\t Xogador 2");
                System.out.println("Columna");
                int xogador2C = scanner.nextInt();
                System.out.println("Fila");
                int xogador2F = scanner.nextInt();
                if (taboleiro[xogador2F][xogador2C] == "-"){
                    taboleiro[xogador2F][xogador2C] = "0";
                    break;
                }
                else{
                    System.out.println("Posición inválida.");
                    continue;
                }
            }
            turnos ++;
        }
    }
}
