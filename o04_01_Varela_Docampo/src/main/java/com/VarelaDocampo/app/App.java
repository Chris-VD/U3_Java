package com.VarelaDocampo.app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;

@SuppressWarnings("unused")
public class App {
    public static void main(String[] args) throws IOException {
        
        ArrayList<String> linguas = new ArrayList<>() {{add("gal"); add("esp"); add("eng");}};
        HashMap<String, Frase> frases = new HashMap<String, Frase>();

        Config config = new Config();
        config.setLanguage("gal");
        ObjectMapper oMapper = new ObjectMapper();
        File jsonFile = new File("L:\\Programacion\\U3_Java\\o04_01_Varela_Docampo\\src\\main\\java\\com\\VarelaDocampo\\app\\config.json");
        config = oMapper.readValue(jsonFile, Config.class);

        CsvMapper mapper = new CsvMapper();
        File csvFile = new File("L:\\Programacion\\U3_Java\\o04_01_Varela_Docampo\\src\\main\\java\\com\\VarelaDocampo\\app\\linguas.csv");
        MappingIterator<ArrayList<String>> it = mapper
            .readerForListOf(String.class)
            .with(CsvParser.Feature.WRAP_AS_ARRAY)
            .readValues(csvFile);   
        List<ArrayList<String>> all = it.readAll();

        for(ArrayList<String> fila:all){
            int i = 0;
            Frase novaFrase = null;
            for(String elemento:fila){
                i++;
                if(i==1){
                    if(elemento == "id") break;
                    novaFrase = new Frase(elemento);
                    frases.put(elemento, novaFrase);
                    continue;
                }
                novaFrase.engadirTraducion(linguas.get(i-2), elemento);
            }
        }

        /*
        for(Map.Entry<String, Frase> entry:frases.entrySet()){
            System.out.println(entry.getKey());
            for(String id:linguas){
                System.out.println("\t"+id+" - "+entry.getValue().get(id));
            }
        }
        */
    
        System.out.println(frases.get("saudo").get(config.getLanguage()));
        boolean programa = true;
        while(programa){
            Scanner scanner = new Scanner(System.in);
            System.out.println(frases.get("menuInicio").get(config.getLanguage())+"\na)"+
            frases.get("cambiarLingua").get(config.getLanguage())+"\nb)"+frases.get("sair").get(config.getLanguage()));
            char opc = scanner.nextLine().charAt(0);
            switch (opc) {
                case 'a'->{
                    while (true) {
                        System.out.println(frases.get("seleccionaLingua").get(config.getLanguage())+"\n\ta)gal\n\tb)esp\n\tc)eng");
                        opc = scanner.nextLine().charAt(0);
                        switch (opc) {
                            case 'a' ->{config.setLanguage("gal"); }
                            case 'b' ->{ config.setLanguage("esp");}
                            case 'c' ->{ config.setLanguage("eng"); }
                            default->{
                                System.out.println(frases.get("opcionInvalida").get(config.getLanguage()));
                                continue;
                            }
                        }
                        break;
                    }
                }
                
                case 'b' ->{
                    System.out.println(frases.get("despedida").get(config.getLanguage()));
                    scanner.close();
                    programa = false;
                }

                default ->{
                    System.out.println(frases.get("opcionInvalida").get(config.getLanguage()));
                }
            }
        }
    }
}
