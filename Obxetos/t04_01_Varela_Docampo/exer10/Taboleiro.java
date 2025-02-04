public class Taboleiro{
    @SuppressWarnings("FieldMayBeFinal")
    private int[][] taboleiro;
    private int casillas = 0;

    /**
     * Crea o taboleiro das dimensións especificadas, podería modificar o programa principal e algúns toques de este para que
     * podeiras xogar cas dimensións que queiras pero paso
     * @param num Número de filas e columnas, o taboleiro sempre vai ser un cadrado
     */
    public Taboleiro(int num){
        taboleiro = new int[num][num];
    }

    /**
     * Marca o cadrado seleccionado polo usuario
     * @param info int array que contén ->
     *  -info[0] é a fila seleccionada
     *  -info[1] é a columna seleccionada
     *  -info[2] é o xogador que marcou o cadrado
     * @return
     *  -true se a casilla se marcou demaneira correcta
     *  -false se a casilla xa estaba marcada de antemán (non se fan cambios nese caso)
     */
    public boolean marcarCadrado(int col, int fil, int xogador){
        if(taboleiro[col][fil] == 0){
            taboleiro[col][fil] = xogador;
            casillas++;
            return true;
        }
        else return false;
    }

    public String mostrarTaboleiro(){
        String taboleiroFull = "";
        String show = "";
        for(int c = 1; c <= this.taboleiro.length; c++){taboleiroFull = taboleiroFull + "\tC" + c;}
        taboleiroFull = taboleiroFull + "\n";
        for(int i = 0; i < this.taboleiro.length; i++){
            taboleiroFull=taboleiroFull + "F" + (i+1);
            for(int j = 0; j < this.taboleiro.length; j++){
                switch (taboleiro[i][j]) {
                    case 0 -> show = "-";
                    case 1 -> show = "X";
                    case 2 -> show = "O";
                }
                taboleiroFull = taboleiroFull + "\t" + show;
            }
            taboleiroFull = taboleiroFull + "\n";
        }
        return taboleiroFull;
    }

    /**
     * Comproba se hay algún tres en raia, multiplica os valores de cada fila, columna e diagonal por separado
     * @return
     * Devolve un array de Booleans "check" ->
     *  -check[0] é o estado do xogo, sendo true se hai algún gañador, false se non e null se hai empate
     *  -check[1] é o xogador que gañou, false se é o xogador 1, true se é o xogador 2 e null se hai empate
     */
    public Boolean checkWin(){
        Boolean check;
        int mult;
        for(int[] fila : taboleiro){
            mult = 1;
            for(int i = 0; i < fila.length; i++){
                mult = mult * fila[i];
            }
            check = checkTER(mult);
            if (check == true) return check;
        }
        for(int i = 0; i < taboleiro.length; i++){
            mult = 1;
            for (int[] fila : taboleiro) {
                mult = mult * fila[i];
            }
            check = checkTER(mult);
            if (check == true) return check;
        }
        mult = 1;
        for(int i = 0; i < taboleiro.length; i++){
            mult = mult * taboleiro[i][i];
        }
        check = checkTER(mult);
        if (check == true) return check;
        mult = 1;
        for(int i = 0; i < taboleiro.length; i++){
            mult = mult * taboleiro[i][taboleiro.length - 1 - i];
        }
        check = checkTER(mult);
        if (check == true) return check;
        if(casillas == Math.pow(taboleiro.length, 2)){
            check = null;
        }
        return check;
    }

    /**
     * Función chamada por checkWin(), asigna os valores de check[], comproba o estado do xogo
     * @param mult Valor da multiplicación feita en checkWin() ->
     *  -Se o resultado é 0, a sección non ten un tres en raia
     *  -Se o resultado é 1, a sección ten un tres en raia do xogador 1
     *  -Se o resultado é 8, a sección ten un tres en raia do xogador 2
     * @return array de Boolean "check", que ten toda a información sobre o estado do xogo
     */
    private Boolean checkTER(int mult){
        Boolean check;
        switch (mult) {
            case 1 -> {
                check = true;
            }
            case 8 -> {
                check = true;
            }
            default -> {
                check = false;
            }
        }
        return check;
    }

    public int[][] getTaboleiro() {
        return taboleiro;
    }
    
}