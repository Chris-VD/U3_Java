package modelo;

import modelo.excepcions.ConstrasinalInvalidoExcepcion;
import utils.HashPassword;
import utils.RolesEnum;

public abstract class Usuario {
    private String username;
    private String hash;
    private RolesEnum rol;

    // Constructor
    /**
     * Constructor de Usuario
     * @param username
     * @param hash
     */
    public Usuario(String username, String psswd, RolesEnum rol) throws ConstrasinalInvalidoExcepcion{
        this.setHash(psswd);
        this.setUername(username);
        this.rol = rol;
    }

    // Getters & Setters
    public String getHash(){
        return hash;
    }
    public String getUsername(){
        return username;
    }
    public RolesEnum getRol(){
        return rol;
    }
    public void setUername(String username){
        this.username = username;
    }
    public void setHash(String psswd) throws ConstrasinalInvalidoExcepcion{
        if (psswd.length() < 7) throw new ConstrasinalInvalidoExcepcion("O contrasinal debe conter máis de 7 caracterres.");
        this.hash = HashPassword.hashPassword(psswd);
    }
}
