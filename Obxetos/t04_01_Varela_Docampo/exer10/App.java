import java.util.Scanner;

public class App {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Taboleiro novo_taboleiro = new Taboleiro(3);
        int[][] taboleiro = novo_taboleiro.getTaboleiro();
        int xogador = 1;
        int col, fil;
        Boolean check;
        boolean marcado;
        while(true){
            if (xogador>2) xogador=1;
            System.out.println(novo_taboleiro.mostrarTaboleiro());
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
            marcado = novo_taboleiro.marcarCadrado(col-1, fil-1, xogador);
            if (marcado == false){
                System.out.println("Non podes marcar esa casilla!");
                continue;
            }
            check = novo_taboleiro.checkWin();
            if (check == null || check == true) break;
            xogador++;
        }
        System.out.println(novo_taboleiro.mostrarTaboleiro());
        if (check == null) System.out.println("Empate!");
        else System.out.println("Gañou o xogador "+xogador+"!");
        scanner.close();
    }
}