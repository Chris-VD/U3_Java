package com.telegram.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Festival {
    public static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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

    // Métodos
    @Override
    public String toString(){
        return this.getNome()+": "+this.getPoboacion()+", "+this.getProvincia()+". Dende o "+this.getInicio().format(FORMATO)+" ata o "+this.getFin().format(FORMATO);
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
