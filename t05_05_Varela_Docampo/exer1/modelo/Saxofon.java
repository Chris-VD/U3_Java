package modelo;

import modelo.excepcions.PrezoMenorZeroExcepcion;
import modelo.excepcions.StockMenorZeroExcepcion;
import utils.EnumSaxofons;

public class Saxofon extends Instrumento{
    private EnumSaxofons tipo;

    // Constructores
    public Saxofon(double prezo, String descricion, int stock, String marca, String modelo, EnumSaxofons tipo) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion{
        super(prezo, descricion, stock, marca, modelo);
        this.tipo = tipo;
    }

    // Metodos
    public String toString(){
        return "Saxofón: "+this.tipo+". "+super.toString();
    }

    // Getters & Setters 
    public EnumSaxofons getTipo(){
        return tipo;
    }
}
