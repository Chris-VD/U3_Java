package com.telegram.modelo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telegram.implementacionDAO.DAOFestivalDB;
import com.telegram.implementacionDAO.DAOFestivalMemoria;
import com.telegram.interfaceDAO.DAOFestival;

public class BotFestivais extends TelegramLongPollingBot{
    private static final String usernmae = "RobertoRobotoBot";
    private static final String token = "7260634668:AAE4H4G_LDZh2aVe000hXLsrLLyLwLt4KBc";
    private DAOFestival daoFest;

    // Constructores
    public BotFestivais(){
        super(token);

        String option = "";
        try {   
            ObjectMapper objectMapper = new ObjectMapper();
            String config = FileUtils.readFileToString(new File("config.json"), StandardCharsets.UTF_8);
            JsonNode jsonNode = objectMapper.readTree(config);
            option = jsonNode.get("data_source").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (option.equals("db")) this.daoFest = new DAOFestivalDB();
        else this.daoFest = new DAOFestivalMemoria();
    }

    // Métodos
    public void onUpdateReceived(Update update){
        System.out.println("\nMensaxe: " + update.getMessage().getText());
        String[] mensaxes = update.getMessage().getText().split(" ");
        String comando = mensaxes[0];
        try {
            switch (comando) {
                case "/ver" ->{
                    System.out.println("Ver!");
                    execute(new SendMessage(String.valueOf(update.getMessage().getChatId()), this.verTodos()));
                }
                case "/proximo" ->{
                    System.out.println("Próximo!");
                    execute(new SendMessage(String.valueOf(update.getMessage().getChatId()), this.verProximo()));
                }
                case "/provincia" ->{
                    System.out.println("Provincia!");
                    if (mensaxes.length <= 1 || mensaxes[1].length() <= 1){
                        execute(new SendMessage(String.valueOf(update.getMessage().getChatId()), this.verComandos()));
                    }
                    execute(new SendMessage(String.valueOf(update.getMessage().getChatId()), this.verFestProv(String.valueOf(mensaxes[1].charAt(1)))));
                }
                default ->{
                    System.out.println("Default!");
                    execute(new SendMessage(String.valueOf(update.getMessage().getChatId()), this.verComandos()));
                }
            }
        } catch (TelegramApiException e) {
            System.out.println("Erro!");
        }
    }

    public String verFestProv(String prov){
        Provincia provincia = Provincia.ACORUÑA;
        HashMap<String, Provincia> provinciasHM = new HashMap<>(){{
            put("c", Provincia.ACORUÑA);
            put("l", Provincia.LUGO);
            put("o", Provincia.OURENSE);
            put("p", Provincia.PONTEVEDRA);
        }};
        provincia = provinciasHM.get(prov);
        String resultado = "Fetivales de "+provincia+"\n";
        for (Festival f:daoFest.getFestivaisProvincia(provincia)){
            resultado += "-"+f.toString()+"\n";
        }
        return resultado;
    }

    public String verProximo(){
        return daoFest.getProximoFestival().toString();
    }

    public String verTodos(){
        String result = "Todos os festivais rexistrados:\n";
        // int i = 0;
        // System.out.println("Inicio -> "+result);
        for (Festival f:daoFest.getFestivales()){    
            // System.out.println("\tIteración -> "+i++);
            result += "-"+f.toString()+"\n";
        }
        // System.out.println("Fin -> "+result);
        return result;
    }

    public String verComandos(){
        String comandos = "Listaxe de todos os comandos:\n";
        Path path = Paths.get("src\\main\\java\\com\\telegram\\miscUtil\\comandos.txt");
        try {
            comandos = Files.readString(path);
        } catch (IOException e) {
            comandos = "Erro lendo o archivo de comandos...";
        }
        return comandos;
    }

    // Getters & Setters
    public String getBotUsername() {
        return usernmae;
    }
    public String getBotToken() {
        return token;
    }
}
