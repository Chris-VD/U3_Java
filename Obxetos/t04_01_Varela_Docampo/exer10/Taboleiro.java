public class Taboleiro{
    private static int[][] taboleiro;
    private static int casillas = 0;

    public Taboleiro(int num){
        taboleiro = new int[num][num];
    }

    public void marcarCadrado(int[] info){
        taboleiro[info[0]][info[1]] = info[2];
        casillas++;
    }

    public Boolean[] checkWin(){
        Boolean[] check = new Boolean[2];
        int mult;
        for(int[] columna : taboleiro){
            mult = 1;
            for(int i = 0; i < columna.length; i++){
                mult = mult * columna[i];
            }
            check = checkTER(mult);
            if (check[0] == true) return check;
        }
        for(int i = 0; i < taboleiro.length; i++){
            mult = 1;
            for(int[] fila : taboleiro){
                mult = mult * fila[i];
            }
            check = checkTER(mult);
            if (check[0] == true) return check;
        }
        mult = 1;
        for(int i = 0; i < taboleiro.length; i++){
            mult = mult * taboleiro[i][i];
            check = checkTER(mult);
            if (check[0] == true) return check;
        }
        for(int i = 0; i < taboleiro.length; i++){
            mult = mult * taboleiro[i][taboleiro.length - 1 - i];
            check = checkTER(mult);
            if (check[0] == true) return check;
        }
        if(casillas == Math.pow(taboleiro.length, 2)){
            check[0] = null;
        }
        return check;
    }

    private Boolean[] checkTER(int mult){
        Boolean[] check = new Boolean[2];
        switch (mult) {
            case 1:
                check[0] = true;
                check[1] = false;
                break;
            case 8:
                check[0] = true;
                check[1] = true;
                break;
            default:
                check[0] = false;
                check[1] = null;
                break;
        }
        return check;
    }
}