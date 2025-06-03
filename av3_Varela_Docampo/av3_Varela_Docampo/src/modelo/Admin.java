package modelo;

import modelo.Enums.RolesEnum;
import modelo.Excepcions.ConstrasinalInvalidoExcepcion;
import modelo.Excepcions.CorreoInvalidoExcepcion;

public class Admin extends Usuario{
    public Admin(String correo, String psswd) throws CorreoInvalidoExcepcion, ConstrasinalInvalidoExcepcion{
        super(correo, psswd);
    }

    public RolesEnum getRol(){
        return RolesEnum.ADMIN;
    }
}
