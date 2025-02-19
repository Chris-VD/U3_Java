package com.VarelaDocampo.app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;

public class App {
    public static void main(String[] args) throws IOException {

        HashMap<String, Frase> frases = new HashMap<String, Frase>();

        CsvMapper mapper = new CsvMapper();
        File csvFile = new File("L:\\Programacion\\U3_Java\\o04_01_Varela_Docampo\\src\\main\\java\\com\\VarelaDocampo\\app\\linguas.csv");

        MappingIterator<ArrayList<String>> it = mapper
            .readerForListOf(String.class)
            .with(CsvParser.Feature.WRAP_AS_ARRAY)
            .readValues(csvFile);
        
        List<ArrayList<String>> all = it.readAll();

        for(ArrayList<String> lista:all){
            int i = 0;
            Frase novaFrase = null;
            for(String elemento:lista){
                i++;
                if(i==1){
                    novaFrase = new Frase(elemento);
                    continue;
                }
                novaFrase.engadirTraducion(elemento, elemento);
            }
            System.out.println();
        }
    }
}
