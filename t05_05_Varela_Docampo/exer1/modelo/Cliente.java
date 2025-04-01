package modelo;

import modelo.excepcions.ConstrasinalInvalidoExcepcion;

public class Cliente extends Usuario{
    // constructor
    public Cliente(String username, String psswd) throws ConstrasinalInvalidoExcepcion{
        super(username, psswd);
    }
}
