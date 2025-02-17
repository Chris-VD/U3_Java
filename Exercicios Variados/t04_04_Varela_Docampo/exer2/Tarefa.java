package exer2;

import java.time.LocalDateTime;

public class Tarefa {
    // Cada tarefa te un nome, descrición, data límite, data engadida e un boolean que comproba se está feita ou non
    private boolean completada = false;
    private String nome;
    private String descricion;
    private LocalDateTime limite;
    private LocalDateTime engadida;

    // Cosntructors
    public Tarefa(String nome, String descricion, LocalDateTime limite) {
        this.setNome(nome);
        this.setLimite(limite);
        this.setDescricion(descricion);
        // En vez de pedir a data engadida ó chamar ó constructor, asígnolla aquí
        this.engadida = LocalDateTime.now();
    }

    // Métodos
    /**
     * Comproba se a tarefa está completada ou non
     * @return boolean
     */
    public boolean isCompletada() {
        return this.completada;
    }
    /**
     * Cambia o estado da tarefa de completa a incompleta e viceversa
     */
    public void changeCompletada() {
        this.completada = !this.completada;
    }

    // Getters & Setters
    private void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public LocalDateTime getLimite() {
        return this.limite;
    }
    private void setLimite(LocalDateTime limite) {
        this.limite = limite;
    }
    public String getDescricion(){
        return this.descricion;
    }
    private void setDescricion(String descricion){
        this.descricion = descricion;
    }
    public LocalDateTime getEngadida(){
        return this.engadida;
    }
}
