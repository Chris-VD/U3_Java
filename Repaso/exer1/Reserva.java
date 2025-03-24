package exer1;

import java.time.LocalDate;

public class Reserva {
    private String nome;
    private Integer numero;
    private LocalDate fecha;

    // Constructor
    public Reserva(String nome, Integer numero, LocalDate fecha) {
        this.nome = nome;
        this.numero = numero;
        this.fecha = fecha;
    }

    // Métodos
    public boolean comprobarDia(LocalDate data){
        return data.equals(this.fecha);
    }

    public boolean comprobarLibre(){
        return numero == 0;
    }

    // Getters & Setters
    public String getNome() {
        return nome;
    }
    public Integer getNumero() {
        return numero;
    }
    public LocalDate getFecha() {
        return fecha;
    }
}
