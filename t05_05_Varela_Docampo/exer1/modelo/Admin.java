package modelo;

import modelo.excepcions.ConstrasinalInvalidoExcepcion;
import utils.RolesEnum;

public class Admin extends Cliente{
    // Constructor
    public Admin(String username, String psswd, RolesEnum rol) throws ConstrasinalInvalidoExcepcion{
        super(username, psswd, rol);
    }
}
