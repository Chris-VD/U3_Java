import java.util.Scanner;
import java.util.Random;

public class exer1 {
    public static void main(String[] args) {
        // Creamos as variables e vectores e todo eso
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvido ó buscaminas.");
        System.out.println("Introduza o número de filas do campo de mias");
        int rowNumber = scanner.nextInt();

        System.out.println("Introduza o número de columnas do campo de minas");
        int columnNumber = scanner.nextInt();

        System.out.println("Introduza o número de minas");
        int numMines = scanner.nextInt();

        // Comprobamos que non haxa máis minas que xadrados
        if (numMines > rowNumber * columnNumber){
            System.out.println("Número de minas inválido, cerrando programa");
            System.exit(0);
        }
        
        // Estos dous arrays só están pa mostrar as filas e columnas (F1, F2, C1, C2...)
        String[] rows = new String[rowNumber];
        String[] columns = new String[columnNumber];

        // Esta é a amtriz que se lle mostra ó xogador
        String[][] field = new String[rowNumber][columnNumber];
        // Esta matriz contén as posicións das minas
        boolean[][] mines = new boolean[rowNumber][columnNumber];
        // Esta matriz conten os números correspondentes a cada cadrado, sendo un 9 a posición das minas
        int[][] numbers = new int[rowNumber][columnNumber];
        // Son consciente que podería ter feito esto sen a matriz "mines" xa que na matriz "numbers" xa represento as bombas como 9, pero deume por facelo así

        // Cando lle toque xogar ó usuario deberá introducir 3 valores, a fila, a columna, e a acción a tomar (Mostrar, marcar ou cancelar)
        int[] playerSelec = new int[3];

        // Comprobadores
        boolean winCheck = false;
        boolean gameOver = false;

        // Enechemos os vectores e matrices todos cos seus correspondentes valores
        for(int i = 1; i<rows.length+1; i++){
            rows[i-1] = "F"+ i;
        }
        for(int i = 1; i<columns.length+1; i++){
            columns[i-1] = "C"+ i;
        }
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j< field[i].length; j++){
                field[i][j] = "-";
            }
        }

        // Asignamos as minas
        for(int i = 0; i < mines.length; i++){
            for(int j = 0; j< mines[i].length; j++){
                mines[i][j] = false;
            }
        }
        int minesRem = numMines;
        while (minesRem > 0) {
            // Seleccionamos un número random de filas e columnas, comprobamos se ese cadrado está libre e se é así asignámoslle unha mina
            int randRow = random.nextInt(rowNumber);
            int randCol = random.nextInt(columnNumber);
            if(mines[randRow][randCol] != true){
                // Cada vez que asignamos unha mina restámoslle un ó valor "minesRem" ata que este sexa 0
                mines[randRow][randCol] = true;
                minesRem--;
            }
        }

        // Enchemos a matriz dos números
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j< numbers[i].length; j++){
                // Imos cadrado por cadrado, comprobando todos os cadrados dos seus alrededores
                /*
                    *   *   *
                    *   X   *
                    *   *   *
                */
                // Contamos cantas minas encontramos ó redor de cada cadrado, ese será seu número
                // Se nun cadrado hay unha mina, o número asignado será 9
                // Antes de comprobar os cadrados en si, comprobamos se existe dito cadrado
                // Como non sei facer nin try{} nin catch{} teño que facer a comprobación mannualmente
                int minesXSquare = 0;
                if(mines[i][j] == true){
                    numbers[i][j] = 9;
                    continue;
                }
                // Dereita
                if(j+1 <= mines[i].length-1 && mines[i][j+1] == true){
                    minesXSquare++;
                }
                // Esquerda
                if(j-1 >= 0 && mines[i][j-1] == true){
                    minesXSquare++;
                }
                // Arriba
                if(i+1 <= mines.length-1 && mines[i+1][j] == true){
                    minesXSquare++;
                }
                // Abaixo
                if(i-1 >= 0 && mines[i-1][j] == true){
                    minesXSquare++;
                }
                // ArD
                if(i+1 <= mines.length-1 && j+1 <= mines[i].length-1 && mines[i+1][j+1] == true){
                    minesXSquare++;
                }
                // ArE
                if(i+1 <= mines.length-1 && j-1 >= 0 && mines[i+1][j-1] == true){
                    minesXSquare++;
                }
                // AbD
                if(i-1 >= 0 && j+1 <= mines[i].length-1 && mines[i-1][j+1] == true){
                    minesXSquare++;
                }
                // AbE
                if(i-1 >= 0 && j-1 >= 0 && mines[i-1][j-1] == true){
                    minesXSquare++;
                }
                numbers[i][j] = minesXSquare;
            }
        }

        while (true) {
            // Esta secuencia mostra todo o campo de minas por pantalla coas súas coordenadas, ben feitiño
            for(int j = 0; j < columns.length; j++){
                System.out.print("\t"+columns[j]);
            }
            System.out.println();
            for(int i = 0; i < field.length; i++){
                System.out.print(rows[i]+"\t");
                for(int j = 0; j < field[i].length; j++){
                    System.out.print(field[i][j]+"\t");
                }
                System.out.println();
            }
            /*
        // Mapa das minas
            for(int i = 0; i < mines.length; i++){
                System.out.println("\t");
                for(int j = 0; j< mines[i].length; j++){
                    System.out.print(mines[i][j]+"\t");
                }
            }

        // Mapa dos números
            System.out.println();
            for(int i = 0; i < numbers.length; i++){
                System.out.println("\t");
                for(int j = 0; j< numbers[i].length; j++){
                    System.out.print(numbers[i][j]+"\t");
                }
            }
            System.out.println();
            */
            // Game Over check
            if(gameOver == true){
                System.out.println("\n\t\t\tGAME OVER\n");
                break;
            }
            // Win check
            if(winCheck == true){
                System.out.println("\n\t\t\tWIN\n");
                break;
            }

            // Turno do usuario
            System.out.println();
            System.out.println("Fila:");
            int userRow = scanner.nextInt();
            if(userRow < 0 || userRow > rowNumber){
                System.out.println("Valor inválido");
                continue;
            }
            userRow--;
            System.out.println("Columna");
            int userCol = scanner.nextInt();
            if(userCol < 0 || userCol > columnNumber){
                System.out.println("Valor inválido");
                continue;
            }
            userCol--;
            System.out.println("Acción (1: Mostrar / 0: Marcar / Outro número: Cancelar)");
            int userAcc = scanner.nextInt();
            if(userAcc < 0 || userAcc > 1){
                System.out.println("Cancelando");
                continue;
            }
            playerSelec[0] = userRow;
            playerSelec[1] = userCol;
            playerSelec[2] = userAcc;

            // Comprobador
            /*
            playerSelec =  [fila, columnna, acción]
            acción:
            1 = mostrar
            0 = marcar
            */
            // As comprobacións son as seguintes:
            /*
                Se o usuario mostra un cadrado con mina, perde
                Se o usuario mostra un cadrado sen mina, dito cadrado substitúese polo seu número
                Se o usuario marca un cadrado, pónselle unha "F" (Flag) a dito cadrado
                Se o usuario marca un cadrado que xa te unha "F", quítaselle dita "F"
                Se o usuario mostra un cadrado que xa estaba comtrado de antes, revélanse todos os cadrados que o rodean, a excepción dos que estean marcados cunha "F"
            */
            if(playerSelec[2] == 1 && mines[playerSelec[0]][playerSelec[1]] == true && field[playerSelec[0]][playerSelec[1]] == "-"){
                gameOver = true;
            }
            else if(playerSelec[2] == 1 && mines[playerSelec[0]][playerSelec[1]] == false && field[playerSelec[0]][playerSelec[1]] == "-"){
                field[playerSelec[0]][playerSelec[1]] = Integer.toString(numbers[playerSelec[0]][playerSelec[1]]);
            }
            else if(playerSelec[2] == 0 && field[playerSelec[0]][playerSelec[1]] == "-"){
                field[playerSelec[0]][playerSelec[1]] = "F";
            }
            else if(playerSelec[2] == 0 && field[playerSelec[0]][playerSelec[1]] == "F"){
                field[playerSelec[0]][playerSelec[1]] = "-";
            }
            else if((playerSelec[2] == 1 && field[playerSelec[0]][playerSelec[1]] != "-") || (numbers[playerSelec[0]][playerSelec[1]] == 0)){
                // Son as mesmas comprobacións que se fan para asginar os números, pero esta vez se hai algunha mina e seu cadrado non está marcado
                // cunha "F", o usuario perdeu
                // Coma antes, primeiro comprobamos se o cadrado existe, se é así, comprobamos que non teña unha "F", e se non a ten, revelamos o número do cadrado
                // Dereita
                if(playerSelec[1]+1 <= mines[playerSelec[0]].length-1 && field[playerSelec[0]][playerSelec[1]+1] != "F"){
                    field[playerSelec[0]][playerSelec[1]+1] = Integer.toString(numbers[playerSelec[0]][playerSelec[1]+1]);
                    if(numbers[playerSelec[0]][playerSelec[1]+1] == 9 && field[playerSelec[0]][playerSelec[1]+1] == "-"){
                        gameOver = true;
                    }
                }
                // Esquerda
                if(playerSelec[1]-1 >= 0 && field[playerSelec[0]][playerSelec[1]-1] != "F"){
                    field[playerSelec[0]][playerSelec[1]-1] = Integer.toString(numbers[playerSelec[0]][playerSelec[1]-1]);
                    if(numbers[playerSelec[0]][playerSelec[1]-1] == 9 && field[playerSelec[0]][playerSelec[1]-1] == "-"){
                        gameOver = true;
                    }
                }
                // Arriba
                if(playerSelec[0]+1 <= mines.length-1 && field[playerSelec[0]+1][playerSelec[1]] != "F"){
                    field[playerSelec[0]+1][playerSelec[1]] = Integer.toString(numbers[playerSelec[0]+1][playerSelec[1]]);
                    if(numbers[playerSelec[0]+1][playerSelec[1]] == 9 && field[playerSelec[0]+1][playerSelec[1]] == "-"){
                        gameOver = true;
                    }
                }
                // Abaixo
                if(playerSelec[0]-1 >= 0 && field[playerSelec[0]-1][playerSelec[1]] != "F"){
                    field[playerSelec[0]-1][playerSelec[1]] = Integer.toString(numbers[playerSelec[0]-1][playerSelec[1]]);
                    if(numbers[playerSelec[0]-1][playerSelec[1]] == 9 && field[playerSelec[0]-1][playerSelec[1]] == "-"){
                        gameOver = true;
                    }
                }
                // ArD
                if(playerSelec[0]+1 <= mines.length-1 && playerSelec[1]+1 <= mines[playerSelec[0]].length-1 && field[playerSelec[0]+1][playerSelec[1]+1] != "F"){
                    field[playerSelec[0]+1][playerSelec[1]+1] = Integer.toString(numbers[playerSelec[0]+1][playerSelec[1]+1]);
                    if(numbers[playerSelec[0]+1][playerSelec[1]+1] == 9 && field[playerSelec[0]+1][playerSelec[1]+1] == "-"){
                        gameOver = true;
                    }
                }
                // ArE
                if(playerSelec[0]+1 <= mines.length-1 && playerSelec[1]-1 >= 0 && field[playerSelec[0]+1][playerSelec[1]-1] != "F"){
                    field[playerSelec[0]+1][playerSelec[1]-1] = Integer.toString(numbers[playerSelec[0]+1][playerSelec[1]-1]);
                    if(numbers[playerSelec[0]+1][playerSelec[1]-1] == 9 && field[playerSelec[0]+1][playerSelec[1]-1] == "-"){
                        gameOver = true;
                    }
                }
                // AbD
                if(playerSelec[0]-1 >= 0 && playerSelec[1]+1 <= mines[playerSelec[0]].length-1 && field[playerSelec[0]-1][playerSelec[1]+1] != "F"){
                    field[playerSelec[0]-1][playerSelec[1]+1] = Integer.toString(numbers[playerSelec[0]-1][playerSelec[1]+1]);
                    if(numbers[playerSelec[0]-1][playerSelec[1]+1] == 9 && field[playerSelec[0]-1][playerSelec[1]+1] == "-"){
                        gameOver = true;
                    }
                }
                // AbE
                if(playerSelec[0]-1 >= 0 && playerSelec[1]-1 >= 0 && field[playerSelec[0]-1][playerSelec[1]-1] != "F"){
                    field[playerSelec[0]-1][playerSelec[1]-1] = Integer.toString(numbers[playerSelec[0]-1][playerSelec[1]-1]);
                    if(numbers[playerSelec[0]-1][playerSelec[1]-1] == 9 && field[playerSelec[0]-1][playerSelec[1]-1] == "-"){
                        gameOver = true;
                    }
                }
            }
            else{
                System.out.println("Inválido");
            }

            // Win check
            winCheck = true;
            // Para comprobar se o usuario acabou, miramos que todos os cadrados que non sexan minas estean revelados
            for(int i = 0; i < numbers.length; i++){
                for(int j = 0; j< numbers[i].length; j++){
                    // Se hai algún cadrado que non sexa unha mina sen revelar, o usuario continua xogando
                    if(numbers[i][j] != 9 && (field[i][j] == "-" || field[i][j] == "F")){
                        winCheck = false;
                        break;
                    }
                }
                if (winCheck == false){
                    break;
                }
            }
        }
        scanner.close();
    }
}