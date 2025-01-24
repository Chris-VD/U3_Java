import java.util.Scanner;
import java.util.Random;

public class minesweeper {
    public static void main(String[] args) {Random random = new Random();Scanner scanner = new Scanner(System.in);
        System.out.println("Benvido ó buscaminas.");
        System.out.println("Introduza o número de filas do campo de mias"); int rowNumber = scanner.nextInt();
        System.out.println("Introduza o número de columnas do campo de minas");int columnNumber = scanner.nextInt();
        System.out.println("Introduza o número de minas");int numMines = scanner.nextInt();
        if (numMines > (rowNumber * columnNumber - 1)){ System.out.println("Número de minas inválido, cerrando programa");
            System.exit(0);}
        int RawRowNumber = rowNumber+2; int RawColumnNumber = columnNumber+2;
        int[] rows = new int[rowNumber]; int[] columns = new int[columnNumber];
        String[][] field = new String[RawRowNumber][RawColumnNumber]; boolean[][] mines = new boolean[RawRowNumber][RawColumnNumber]; int[][] numbers = new int[RawRowNumber][RawColumnNumber];
        int[] playerSelec = new int[3];
        boolean winCheck = false; boolean gameOver = false;boolean firstTurn = true;int userRow, userCol, userAcc;
        for(int i = 1; i<rows.length+1; i++){rows[i-1] = i;}
        for(int i = 1; i<columns.length+1; i++){columns[i-1] = i;}
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j< field[i].length; j++){field[i][j] = "-";}}
        for(int j = 0; j < columns.length; j++){System.out.print("\tC"+columns[j]);}
        System.out.println();
        for(int i = 1; i < field.length-1; i++){System.out.print("F"+i+"\t");
            for(int j = 1; j < field[0].length-1; j++){System.out.print(field[i][j]+"\t");}
            System.out.println();}
        while(true){System.out.println();
            System.out.println("Fila:");
            userRow = scanner.nextInt();
            if(userRow <= 0 || userRow > rowNumber){System.out.println("Valor inválido");
                continue;}
            userRow--; System.out.println("Columna"); userCol = scanner.nextInt();
            if(userCol <= 0 || userCol > columnNumber){System.out.println("Valor inválido");
                continue;}
            userCol--;System.out.println("Acción (1: Mostrar / 0: Marcar / Outro número: Cancelar)");userAcc = scanner.nextInt();
            if(userAcc < 0 || userAcc > 1){System.out.println("Cancelando");
                continue;}
            playerSelec[0] = userRow+=1;playerSelec[1] = userCol+=1;playerSelec[2] = userAcc;
            firstTurn = true; break;}
        for(int i = 0; i < mines.length; i++){
            for(int j = 0; j< mines[i].length; j++){mines[i][j] = false; }}
        int minesRem = numMines;
        while (minesRem > 0) {int randRow = random.nextInt(rowNumber)+1;int randCol = random.nextInt(columnNumber)+1;
            if(mines[randRow][randCol] != true){mines[randRow][randCol] = true;
                if(randRow == playerSelec[0] && randCol == playerSelec[1]){mines[randRow][randCol] = false;}
                else{minesRem--;}}}
        for(int i = 1; i < numbers.length-1; i++){
            for(int j = 1; j< numbers[i].length-1; j++){int minesXSquare = 0;
                if(mines[i][j] == true){numbers[i][j] = 9;
                    continue;}
                for(int x = -1; x<=1;x++){
                    for(int y = -1; y<=1; y++){
                        if(mines[i+x][j+y] == true){minesXSquare++;}}}
                numbers[i][j] = minesXSquare;}}
        while (true) {
            if(gameOver == true){
                for(int i = 1; i < field.length-1; i++){
                    for(int j = 1; j < field[i].length-1; j++){
                        if(field[i][j] != "F" && numbers[i][j] == 9){
                            if(numbers[i][j] == 9){field[i][j] = "X";}
                            else{field[i][j] = Integer.toString(numbers[i][j]);}}}}}
            if(firstTurn==false){
                for(int j = 0; j < columns.length; j++){System.out.print("\tC"+columns[j]);}
                System.out.println();
                for(int i = 1; i < field.length-1; i++){System.out.print("F"+i+"\t");
                    for(int j = 1; j < field[0].length-1; j++){System.out.print(field[i][j]+"\t");}
                    System.out.println();}}
            if(gameOver == true){System.out.println("\n\t\t\tGAME OVER\n");
                break;}
            if(winCheck == true){System.out.println("\n\t\t\tWIN\n");
                break;}
            if(firstTurn == false){System.out.println();System.out.println("Fila:");userRow = scanner.nextInt();
                if(userRow <= 0 || userRow > rowNumber){System.out.println("Valor inválido");
                    continue;}
                userRow--;System.out.println("Columna");userCol = scanner.nextInt();
                if(userCol <= 0 || userCol > columnNumber){System.out.println("Valor inválido");
                    continue;}
                userCol--;System.out.println("Acción (1: Mostrar / 0: Marcar / Outro número: Cancelar)");userAcc = scanner.nextInt();
                if(userAcc < 0 || userAcc > 1){System.out.println("Cancelando");
                    continue;}
                playerSelec[0] = userRow+=1;playerSelec[1] = userCol+=1;playerSelec[2] = userAcc;}
            if(playerSelec[2] == 1 && mines[playerSelec[0]][playerSelec[1]] == true && field[playerSelec[0]][playerSelec[1]] == "-"){gameOver = true;}
            else if(playerSelec[2] == 1 && mines[playerSelec[0]][playerSelec[1]] == false && field[playerSelec[0]][playerSelec[1]] == "-"){field[playerSelec[0]][playerSelec[1]] = Integer.toString(numbers[playerSelec[0]][playerSelec[1]]);}
            else if(playerSelec[2] == 0 && field[playerSelec[0]][playerSelec[1]] == "-"){field[playerSelec[0]][playerSelec[1]] = "F";}
            else if(playerSelec[2] == 0 && field[playerSelec[0]][playerSelec[1]] == "F"){field[playerSelec[0]][playerSelec[1]] = "-";}
            else if((playerSelec[2] == 1 && field[playerSelec[0]][playerSelec[1]] != "-") || (numbers[playerSelec[0]][playerSelec[1]] == 0)){
                for(int x = -1; x<=1;x++){
                    for(int y = -1; y<=1; y++){
                        if(field[playerSelec[0]+x][playerSelec[1]+y] != "F"){
                            if(numbers[playerSelec[0]+x][playerSelec[1]+y] == 9 && field[playerSelec[0]+x][playerSelec[1]+y] == "-"){gameOver = true;}
                            field[playerSelec[0]+x][playerSelec[1]+y] = Integer.toString(numbers[playerSelec[0]+x][playerSelec[1]+y]); }}}}
            else{System.out.println("Inválido");}
            winCheck = true;
            for(int i = 1; i < numbers.length-1; i++){
                for(int j = 1; j< numbers[i].length-1; j++){
                    if(numbers[i][j] != 9 && (field[i][j] == "-" || field[i][j] == "F")){winCheck = false;break;}}
                if (winCheck == false){break;}}
            if(firstTurn == true){firstTurn = false;}}
        scanner.close();}}