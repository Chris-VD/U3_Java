package modelo;

import modelo.excepcions.ConstrasinalInvalidoExcepcion;

public class Admin extends Cliente{
    // Constructor
    public Admin(String username, String psswd) throws ConstrasinalInvalidoExcepcion{
        super(username, psswd);
    }
}
