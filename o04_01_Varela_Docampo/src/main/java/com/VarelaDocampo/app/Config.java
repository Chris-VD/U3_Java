package com.VarelaDocampo.app;

public class Config {
    private String language;

    // Este constructor non o podo definir porque se o fago, ó pasar os datos do json á clase dame erro,
    // o parser de Jackson pasa directamente os datos ó constructor predeterminado e se fas @override, non funciona
    /*
    public Config(String lang){
        this.setLanguage(lang);
    }
    */
    
    public void setLanguage(String lang){
        this.language = lang;
    }

    public String getLanguage(){
        return this.language;
    }
}
