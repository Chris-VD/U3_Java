package modelo;

public class Usuario {
    private String username;
    private String hash;

    // Constructor
    /**
     * Constructor de Usuario
     * @param username
     * @param hash
     */
    public Usuario(String username, String hash){
        this.setUername(username);
        this.setHash(hash);
    }


    // Getters & Setters
    public String getHash(){
        return hash;
    }
    public String getUsername(){
        return username;
    }
    public void setUername(String username){
        this.username = username;
    }
    public void setHash(String hash){
        this.hash = hash;
    }
}
