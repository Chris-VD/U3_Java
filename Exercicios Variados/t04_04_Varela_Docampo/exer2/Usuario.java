package exer2;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String alias;
    private ArrayList<Tarefa> tarefas;
    private String hash;
    public Usuario(String nome, String alias, ArrayList<Tarefa> tarefas, String hash) {
        this.nome = nome;
        this.alias = alias;
        this.tarefas = tarefas;
        this.hash = hash;
    }
    
}
