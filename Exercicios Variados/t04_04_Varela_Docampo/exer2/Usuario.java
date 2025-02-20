package exer2;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
        this.setHash(HashPassword.hashPassword(hash));
        // Como ó ingresr un usuario novo a lista de tarefas está caleira, fago unha nove en vez de mandar unha valeira ó chamar ó constructor
        this.tarefas = new ArrayList<Tarefa>();
    }

    // Métodos
    /**
     * Devolve unha lista de tarefas que están pasadas (a data límite xa pasou e non están completadas)
     * @return ArrayList<Tarefa>
     */
    public ArrayList<Tarefa> getPasadas(){
        ArrayList<Tarefa> pasadas = new ArrayList<>();
        for(Tarefa tarefa: this.tarefas){
            boolean isAfter = tarefa.getLimite().isBefore(LocalDateTime.now());
            boolean isPending = !tarefa.isCompletada();
            if(isAfter && isPending) pasadas.add(tarefa);
        }
        return pasadas;
    }
    
    /**
     * Devolve unha lista de tarefas que están pasadas (a data límite xa pasou e non están completadas)
     * @return ArrayList<Tarefa>
     */
    public ArrayList<Tarefa> get48H(){
        ArrayList<Tarefa> t48h = new ArrayList<>();
        ArrayList<Tarefa> pendientes = this.getPendientes();
        for(Tarefa tarefa: pendientes){
            boolean isBefore = tarefa.getLimite().isBefore(LocalDateTime.now().plus(2, ChronoUnit.DAYS));
            if(isBefore) t48h.add(tarefa);
        }
        return t48h;
    }

    /**
     * Devolve unha lista de tarefas que están pendientes (a data límite non pasou e están pendientes)
     * @return ArrayList<Tarefa>
     */
    public ArrayList<Tarefa> getPendientes(){
        ArrayList<Tarefa> pendientes = new ArrayList<>();
        for(Tarefa tarefa: this.tarefas){
            boolean isAfter = tarefa.getLimite().isAfter(LocalDateTime.now());
            boolean isPending = !tarefa.isCompletada();
            if(isAfter && isPending) pendientes.add(tarefa);
        }
        return pendientes;
    }

    /**
     * Devolve unha lista de tarefas que están completadas
     * @return ArrayList<Tarefa>
     */
    public ArrayList<Tarefa> getCompletadas(){
        ArrayList<Tarefa> completadas = new ArrayList<>();
        for(Tarefa tarefa: this.tarefas){
            if(tarefa.isCompletada()) completadas.add(tarefa);
        }
        return completadas;
    }

     /**
     * Comproba que un contrasinal sexa válida
     * @param psw contrasinal a comprobar
     * @return boolean, true se é válida
     */
    public static boolean checkValidPsw(String pswS){
        char[] psw = pswS.toCharArray();
        // booleans que fan as comprobacións
        boolean maiuscula = false;
        boolean minuscula = false;
        boolean numero = false;
        // imos caracter por caracter comprobando que teña mínimo
        for(char c:psw){
            // unha maiúscula
            if (!maiuscula && ((int)c >= 65 && (int)c <= 90)){
                maiuscula = true;
                continue;
            }
            // unha minúscula
            if (!minuscula && ((int)c >= 97 && (int)c <= 122)){
                minuscula = true;
                continue;
            }
            // un número
            if (!numero && ((int)c >= 48 && (int)c <= 57)){
                numero = true;
            }
        }
        // devolve os booleans, so será true se todos son true
        return (numero && minuscula && maiuscula);
    }

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
        return this.hash;
    }

    private void setHash(String hash) {
        this.hash = hash;
    }
    
}
