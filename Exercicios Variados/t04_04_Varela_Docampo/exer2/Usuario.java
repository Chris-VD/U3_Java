package exer2;

import java.util.ArrayList;

public class Usuario {
    // Cada usuario ten un nome, alias, lista de tarefas e un hash (contrasinal cifrado)
    private String nome;
    private String alias;
    private ArrayList<Tarefa> tarefas;
    private String hash;

    // Constructor
    public Usuario(String nome, String alias, String hash) {
        this.setNome(nome);
        this.setAlias(alias);
        this.setHash(hash);
        // Como ó ingresr un usuario novo a lista de tarefas está caleira, fago unha nove en vez de mandar unha valeira ó chamar ó constructor
        this.tarefas = new ArrayList<Tarefa>();
    }

    // Métodos
    /**
     * Engade unha tarefa á lista de tarefas do usuario
     * @param tarefa Tarefa a engadir
     */
    public void addTarefas(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    // Getters & Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlias() {
        return alias;
    }

    private void setAlias(String alias) {
        this.alias = alias;
    }

    @SuppressWarnings("unchecked")
    /**
     * En vez de mandar a lista a secas, mando unha copia para que o usuario non poida modificala directamente
     * @return Copia da lista de tarefas
     */
    public ArrayList<Tarefa> getTarefas() {
        ArrayList<Tarefa> tempTarefas;
        if (this.tarefas.size() != 0) tempTarefas = (ArrayList<Tarefa>)tarefas.clone();
        else tempTarefas = null;
        return tempTarefas;
    }

    public String getHash() {
        return hash;
    }

    private void setHash(String hash) {
        this.hash = hash;
    }
    
}
