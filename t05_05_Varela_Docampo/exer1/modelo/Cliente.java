package modelo;

import modelo.excepcions.ConstrasinalInvalidoExcepcion;
import utils.RolesEnum;

public class Cliente extends Usuario{
    // constructor
    public Cliente(String username, String psswd, RolesEnum rol) throws ConstrasinalInvalidoExcepcion{
        super(username, psswd, rol);
    }
}
