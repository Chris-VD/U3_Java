package modelo;

import java.util.ArrayList;

import modelo.Enums.RolesEnum;
import modelo.Excepcions.ConstrasinalInvalidoExcepcion;
import modelo.Excepcions.CorreoInvalidoExcepcion;
import modelo.Excepcions.XogadoresCheosExcepcion;

public abstract class Xogador extends Usuario implements Comparable<Xogador>{
    private RolesEnum rol;
    private String nome;
    private Equipo equipo;
    private ArrayList<Equipo> ofertas;
    
    protected int numPartidos;
    protected double puntos;

    public Xogador(String nome, String correo, RolesEnum pos, String psswd) throws CorreoInvalidoExcepcion, ConstrasinalInvalidoExcepcion{
        super(correo, psswd);
        this.rol = pos;
        this.nome = nome;
        this.numPartidos = 0;
        this.puntos = 0;
        this.equipo = null;
        this.ofertas = new ArrayList<>();
        this.setHash(psswd);
    }

    public void engadirOferta(Equipo equipo){
        ofertas.add(equipo);
    }

    @Override
    public int compareTo(Xogador xogador){
        if (this.getNome().equals(xogador.getNome())) return this.getPuntos() > xogador.getPuntos() ? 1:-1;
        else return this.getNome().compareTo(xogador.getNome());
    }

    @Override
    public String toString(){
        return getNome() + " | " + getCorreo() + " | " + getPos();
    }
    public abstract void xogarPartido();

    public void setEquipo(Equipo equipo) throws XogadoresCheosExcepcion{
        equipo.engadirxogador(this);
        this.equipo = equipo;
        ofertas = new ArrayList<>();
    }
    public ArrayList<Equipo> getOfertas(){
        return ofertas;
    }
    public Equipo getEquipo(){
        return equipo;
    }
    public int getPartidos(){
        return numPartidos;
    }
    public double getPuntos(){
        return puntos;
    }
    public String getNome(){
        return nome;
    }
    public RolesEnum getRol(){
        return rol;
    }
    public String getPos(){
        String pos;
        switch (rol){
            case RolesEnum.BASE -> {
                pos = "Base";
            }
            case RolesEnum.EXTERIOR -> {
                pos = "Exterior";
            }
            case RolesEnum.INTERIOR -> {
                pos = "Interior";
            }
            default -> {
                pos = "None";
            }
        }
        return pos;
    }
}
