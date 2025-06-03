package modelo;

import modelo.Enums.RolesEnum;
import modelo.Excepcions.ConstrasinalInvalidoExcepcion;
import modelo.Excepcions.CorreoInvalidoExcepcion;
import utils.Utils;

public class Exterior extends Xogador{
    private long mediaPuntos;

    public Exterior(String nome, String correo, String psswd) throws CorreoInvalidoExcepcion, ConstrasinalInvalidoExcepcion{
        super(nome, correo, RolesEnum.EXTERIOR, psswd);
        this.mediaPuntos = 0;
    }

    public void xogarPartido(){
        int puntos = Utils.xerarRando(30, 0);
        mediaPuntos = ((mediaPuntos * getPartidos()) + puntos) / (getPartidos() + 1);
        numPartidos += 1;
        this.puntos = 0.75*mediaPuntos;
    }
}
