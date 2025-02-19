package com.VarelaDocampo.app;

import java.util.HashMap;

public class Frase {
    private String id;
    private HashMap<String, String> frases;

    // Constructors
    public Frase(String id){
        this.frases = new HashMap<String, String>();
    }

    // Métodos
    public void engadirTraducion(String lingua, String frase){
        this.frases.put(lingua, frase);
    }

    // Getters & Setters
    public String getId(){
        return this.id;
    }
}
