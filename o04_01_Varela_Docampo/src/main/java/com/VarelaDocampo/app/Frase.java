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
    /**
     * engade a traducción da frase no idioma especificado
     * @param lingua idioma especificado
     * @param frase valor da frase en dito idioma
     * o idima especificado será a clave do diccionario e a traducción será o valor
     */
    public void engadirTraducion(String lingua, String frase){
        this.frases.put(lingua, frase);
    }

    // Getters & Setters
    public String getId(){
        return this.id;
    }
    public String get(String id){
        return this.frases.get(id);
    }
}
