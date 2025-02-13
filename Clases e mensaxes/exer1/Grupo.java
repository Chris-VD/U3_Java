package exer1;

import java.time.LocalDate;

public class Grupo {
    private String nome;
    private int anoCreacion;
    private String pais;

    // Constructors
    /**
     * Crea o obxeto grupo con todos seus atributos
     * @param nome Nome do grupo (String)
     * @param anoCreacion Ano de creación do grupo (int)
     * @param pais País de creación do grupo (String)
     */
    public Grupo(String nome, int anoCreacion, String pais) {
        this.setNome(nome);
        this.setAnoCreacion(anoCreacion);
        this.setPais(pais);
    }

    // Métodos
    /**
     * Calcula e devolve os anos do grupo baseado no ano de creación e no ano actual
     * @return Os anos do grupo (int)
     */
    public int getIdade(){
        return LocalDate.now().getYear() - this.anoCreacion;
    }

    // Getters & Setters
    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoCreacion() {
        return anoCreacion;
    }

    private void setAnoCreacion(int anoCreacion) {
        this.anoCreacion = anoCreacion;
    }

    public String getPais() {
        return pais;
    }

    private void setPais(String pais) {
        this.pais = pais;
    }    
}