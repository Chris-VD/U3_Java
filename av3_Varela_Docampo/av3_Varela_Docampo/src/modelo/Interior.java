package modelo;

import modelo.Enums.RolesEnum;
import modelo.Excepcions.ConstrasinalInvalidoExcepcion;
import modelo.Excepcions.CorreoInvalidoExcepcion;
import utils.Utils;

public class Interior extends Xogador{
    private long mediaRebotes;

    public Interior(String nome, String correo, String psswd) throws CorreoInvalidoExcepcion, ConstrasinalInvalidoExcepcion{
        super(nome, correo, RolesEnum.INTERIOR, psswd);
        this.mediaRebotes = 0;
    }

    public void xogarPartido(){
        int rebotes = Utils.xerarRando(15, 0);
        mediaRebotes = ((mediaRebotes * getPartidos()) + rebotes) / (getPartidos() + 1);
        numPartidos += 1;
        this.puntos = 1.5*mediaRebotes;
    }
}
