package com.VarelaDocampo.app;

public class Config {
    private String language;

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
