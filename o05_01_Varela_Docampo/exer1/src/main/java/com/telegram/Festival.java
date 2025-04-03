package com.telegram;

import java.time.LocalDate;

public class Festival {
    private String nome;
    private String poboacion;
    private Provincia provincia;
    private LocalDate inicio;
    private LocalDate fin;
    
    // Constructores
    public Festival(String nome, String poboacion, Provincia provincia, LocalDate inicio, LocalDate fin) {
        this.nome = nome;
        this.poboacion = poboacion;
        this.provincia = provincia;
        this.inicio = inicio;
        this.fin = fin;
    }

    // Getters & Setters
    public String getNome() {
        return nome;
    }
    public String getPoboacion() {
        return poboacion;
    }
    public Provincia getProvincia() {
        return provincia;
    }
    public LocalDate getInicio() {
        return inicio;
    }
    public LocalDate getFin() {
        return fin;
    }
}
