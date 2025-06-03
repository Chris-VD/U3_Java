package modelo;

import java.util.regex.Pattern;

import modelo.Excepcions.ConstrasinalInvalidoExcepcion;
import modelo.Excepcions.CorreoInvalidoExcepcion;
import utils.Utils;

public abstract class Usuario implements LoginInterfaz{
    public static Pattern regexCorreo = Pattern.compile("[^@]+@[^@]+\\.[a-zA-Z]{2,}");

    private String correo;
    private String hash;

    public Usuario(String correo, String psswd) throws CorreoInvalidoExcepcion, ConstrasinalInvalidoExcepcion{
        this.setCorreo(correo);
        this.setHash(psswd);
    }

    public String getCorreo(){
        return correo;
    }
    public String getHash(){
        return hash;
    }

    protected void setCorreo(String correo) throws CorreoInvalidoExcepcion{
        if (!regexCorreo.matcher(correo).matches()) throw new CorreoInvalidoExcepcion("O correo introducido non é válido.");
        this.correo = correo;
    }
    protected void setHash(String psswd) throws ConstrasinalInvalidoExcepcion{
        //if (psswd.length() < 8) throw new ConstrasinalInvalidoExcepcion("O contrasinal é inválido.");
        this.hash = Utils.hashPassword(psswd);
    }
}
