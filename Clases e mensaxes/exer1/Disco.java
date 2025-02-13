package exer1;

public class Disco {
    private String titulo;
    private int anoSalida;
    private Grupo grupo;
    private int numeroCancions;

    // COnstructors
    /**
     * Crea o obxeto disco con todos seus atributos
     * @param titulo Título do disco (String)
     * @param anoSalida Ano de salida do disco (int)
     * @param grupo Grupo que creou o disco (Grupo)
     * @param numeroCancions Número d ecancións do disco (int)
     */
    public Disco(String titulo, int anoSalida, Grupo grupo, int numeroCancions) {
        this.setTitulo(titulo);
        this.setAnoSalida(anoSalida);
        this.setGrupo(grupo);
        this.setNumeroCancions(numeroCancions);
    }

    //Métodos
    /**
     * Método que calcula os anos que tiña o grupo cando publicaron o disco
     * @return Anos do grupo cando publicaron o disco
     */
    public int anosGrupo(){
        return this.anoSalida - this.grupo.getAnoCreacion();
    }

    // Getters & Setters
    public String getTitulo() {
        return titulo;
    }
    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getAnoSalida() {
        return anoSalida;
    }
    private void setAnoSalida(int anoSalida) {
        this.anoSalida = anoSalida;
    }
    public Grupo getGrupo() {
        return grupo;
    }
    private void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    public int getNumeroCancions() {
        return numeroCancions;
    }
    private void setNumeroCancions(int numeroCancions) {
        this.numeroCancions = numeroCancions;
    }   
}