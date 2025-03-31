package modelo;

import modelo.excepcions.PrezoMenorZeroExcepcion;
import modelo.excepcions.StockMenorZeroExcepcion;

public class Frauta extends Instrumento{
    public boolean pds;
    
    // Constuctores
    public Frauta(double prezo, String descricion, int stock, String marca, String modelo, boolean pds) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion{
        super(prezo, descricion, stock, marca, modelo);
        this.pds = pds;
    }

    // Metodos
    @Override
    public String toString(){
        return "Frauta: "+super.toString();
    }

    // Getters & Setters
    public boolean getPds(){
        return pds;
    }
}
