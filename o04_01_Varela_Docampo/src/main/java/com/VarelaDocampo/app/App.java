package com.VarelaDocampo.app;

// Imports de java
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
//import java.util.Map;

// Imposrts de Jackson
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;

public class App {
    public static void main(String[] args) throws IOException {
        // Array das diferentes linguas en order, para poder gardasr as frases co seu idima
        ArrayList<String> linguas = new ArrayList<>() {{add("gal"); add("esp"); add("eng");}};
        // Diccionario das frases, a clave é o código da frase
        HashMap<String, Frase> frases = new HashMap<String, Frase>();

        // Para ler o .json, non teño nin idea de como funciona pero básicamente pasame o valor gardado en config.json á clase config
        Config config = new Config();
        config.setLanguage("gal");
        ObjectMapper oMapper = new ObjectMapper();
        File jsonFile = new File("L:\\Programacion\\U3_Java\\o04_01_Varela_Docampo\\src\\main\\java\\com\\VarelaDocampo\\app\\config.json");
        config = oMapper.readValue(jsonFile, Config.class);

        // Para leer o csv, sei inda menos que fai pero básicamente gardame cada liña do csv nunha lista, e cada frase separaa en elementos que se gardan noutra arraylist
        CsvMapper mapper = new CsvMapper();
        File csvFile = new File("L:\\Programacion\\U3_Java\\o04_01_Varela_Docampo\\src\\main\\java\\com\\VarelaDocampo\\app\\linguas.csv");
        MappingIterator<ArrayList<String>> it = mapper
            .readerForListOf(String.class)
            .with(CsvParser.Feature.WRAP_AS_ARRAY)
            .readValues(csvFile);   
        List<ArrayList<String>> all = it.readAll();

        // Recorremos a lista de frases
        for(ArrayList<String> fila:all){
            // definimos un contador para ver cal é a primeira palabra de cada liña (que será o identificador)
            int i = 0;
            // Reservamos o espazo para a frase
            Frase novaFrase = null;
            // Recorremos cada liña elemento por elemento
            for(String elemento:fila){
                i++;
                // Se é o primeiro elemento, gardámolo como o identificador
                if(i==1){
                    if(elemento == "id") break;
                    novaFrase = new Frase(elemento);
                    frases.put(elemento, novaFrase);
                    continue;
                }
                // Se non é o primeiro elemento, gardámolo dentro do diccionario das frases xunto co seu idioma
                novaFrase.engadirTraducion(linguas.get(i-2), elemento);
            }
        }

        /*
        // Para mostrar os contidos de todas as frases, non vale pa nada máis
        for(Map.Entry<String, Frase> entry:frases.entrySet()){
            System.out.println(entry.getKey());
            for(String id:linguas){
                System.out.println("\t"+id+" - "+entry.getValue().get(id));
            }
        }
        */
    
        // Tendo as frases gardadas no diccionario, para poder chegar ó seu valor fainos falta únicamente o identificador
        // Dentro do HashMap frases, o identificador é a clave, unha vez facemos o .get(id), devólvenos o obxeto Frase
        // Dentro de cada Frase chamamos ó método .get(lang_id), onde lang_id será o código do idioma, e esto devolve o valor da frase no idima seleccionado
        // Así funcionan todos os out.prints do programa
        System.out.println(frases.get("saudo").get(config.getLanguage()));
        // booleano para comprobar que o programa continue
        boolean programa = true;

        while(programa){
            // Comezamos o scanner
            Scanner scanner = new Scanner(System.in);
            System.out.println(frases.get("menuInicio").get(config.getLanguage())+"\na)"+
            frases.get("cambiarLingua").get(config.getLanguage())+"\nb)"+frases.get("sair").get(config.getLanguage()));
            char opc = scanner.nextLine().charAt(0);

            switch (opc) {

                // Cambiar o idioma
                case 'a'->{
                    while (true) {
                        System.out.println(frases.get("seleccionaLingua").get(config.getLanguage())+"\n\ta)gal\n\tb)esp\n\tc)eng");
                        opc = scanner.nextLine().charAt(0);
                        switch (opc) {
                            // Dependendo da seleccion do usuario cambiamos o idioma do obxeto config ó seleccionada
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
                
                // Marchar
                case 'b' ->{
                    System.out.println(frases.get("despedida").get(config.getLanguage()));
                    scanner.close();
                    programa = false;
                }

                // Opción inválida
                default ->{
                    System.out.println(frases.get("opcionInvalida").get(config.getLanguage()));
                }
            }
        }
    }
}
