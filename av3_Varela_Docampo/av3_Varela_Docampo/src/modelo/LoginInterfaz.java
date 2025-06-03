package modelo;

import java.io.Serializable;

import modelo.Enums.RolesEnum;

public interface LoginInterfaz extends Serializable{
    public String getCorreo();
    public String getHash();
    public RolesEnum getRol();
}
