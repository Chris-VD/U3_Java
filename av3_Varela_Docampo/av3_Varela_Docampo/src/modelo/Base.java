package modelo;

import modelo.Enums.RolesEnum;
import modelo.Excepcions.ConstrasinalInvalidoExcepcion;
import modelo.Excepcions.CorreoInvalidoExcepcion;
import utils.Utils;

public class Base extends Xogador{
    private long mediaAsistencias;

    public Base(String nome, String correo, String psswd) throws CorreoInvalidoExcepcion, ConstrasinalInvalidoExcepcion{
        super(nome, correo, RolesEnum.BASE, psswd);
        this.mediaAsistencias = 0;
    }

    /**
     * Como a puntuación calcúlase a partir da media podemos facer esto.
     * Se se calculase despóis de cada partido como un total sería diferente, faríase o cálculo de puntos
     * despóis de cada partido e sumaríase a un total.
     */
    public void xogarPartido(){
        int asistencias = Utils.xerarRando(12, 0);
        mediaAsistencias = ((mediaAsistencias * getPartidos()) + asistencias) / (getPartidos() + 1);
        numPartidos += 1;
        this.puntos = 2*mediaAsistencias;
    }
}
