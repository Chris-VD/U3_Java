package com.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotFestivais extends TelegramLongPollingBot{
    private static final String usernmae = "RobertoRobotoBot";
    private static final String token = "7260634668:AAE4H4G_LDZh2aVe000hXLsrLLyLwLt4KBc";
    private DAOFestival daoFest;

    // Constructores
    public BotFestivais(){
        super(token);
        this.daoFest = new DAOFestivalMemoria();
    }

    // Métodos
    public void onUpdateReceived(Update update){
        System.out.println(update.getMessage().getText());
        try {
            execute(new SendMessage(String.valueOf(update.getMessage().getChatId()), "Dixeches "+update.getMessage().getText()));
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }

    // Getters & Setters
    public String getBotUsername() {
        return usernmae;
    }
    public String getBotToken() {
        return token;
    }
}
