import java.util.Scanner;

public class App {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Taboleiro novo_taboleiro = new Taboleiro(3);
        int[][] taboleiro = Taboleiro.getTaboleiro();
        int xogador = 1;
        int col, fil;
        int[] info = new int[3];
        Boolean[] check = new Boolean[2];
        boolean marcado;
        String show = "-";
        while(true){
            if (xogador>2) xogador=1;
            for(int c = 1; c<=taboleiro.length;c++){System.out.print("\tC"+c);}
            System.out.print("\n");
            for(int i = 0; i < taboleiro.length; i++){
                System.out.print("F"+(i+1));
                for(int j = 0; j < taboleiro.length; j++){
                    switch (taboleiro[i][j]) {
                        case 0 -> show = "-";
                        case 1 -> show = "X";
                        case 2 -> show = "O";
                    }
                    System.out.print("\t"+show);
                }
                System.out.print("\n");
            }
            System.out.println("Xogador "+xogador+", introduza a casilla a marcar");
            while(true){
                System.out.println("Fila: ");
                col = scanner.nextInt();
                System.out.println("Columna: ");
                fil = scanner.nextInt();
                if(col > taboleiro.length || col <= 0 || fil <= 0 || fil > taboleiro.length){
                    System.out.println("Valor inválido");
                    continue;
                }
                break;
            }
            info[0] = col;
            info[1] = fil;
            info[2] = xogador;
            marcado = novo_taboleiro.marcarCadrado(info);
            if (marcado == false){
                System.out.println("Non podes marcar esa casilla!");
                continue;
            }
            check = novo_taboleiro.checkWin();
            if (check[0] == null || check[0] == true) break;
            xogador++;
        }
        for(int c = 1; c<=taboleiro.length;c++){System.out.print("\tC"+c);}
        System.out.print("\n");
        for(int i = 0; i < taboleiro.length; i++){
            System.out.print("F"+(i+1));
            for(int j = 0; j < taboleiro.length; j++){
                switch (taboleiro[i][j]) {
                    case 0 -> show = "-";
                    case 1 -> show = "X";
                    case 2 -> show = "O";
                }
                System.out.print("\t"+show);
            }
            System.out.print("\n");
        }
        if (check[0] == null) System.out.println("Empate!");
        else System.out.println("Gañou o xogador "+xogador+"!");
        scanner.close();
    }
}
