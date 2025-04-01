package modelo;

import modelo.excepcions.ConstrasinalInvalidoExcepcion;
import utils.HashPassword;

public abstract class Usuario {
    private String username;
    private String hash;

    // Constructor
    /**
     * Constructor de Usuario
     * @param username
     * @param hash
     */
    public Usuario(String username, String psswd) throws ConstrasinalInvalidoExcepcion{
        this.setHash(psswd);
        this.setUername(username);
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
    public void setHash(String psswd) throws ConstrasinalInvalidoExcepcion{
        if (psswd.length() < 7) throw new ConstrasinalInvalidoExcepcion("O contrasinal debe conter máis de 7 caracterres.");
        this.hash = HashPassword.hashPassword(psswd);
    }
}
