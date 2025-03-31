package modelo;

import modelo.excepcions.PrezoMenorZeroExcepcion;
import modelo.excepcions.StockMenorZeroExcepcion;

public class Trombon extends Instrumento{
    private boolean transpositor;

    // Constructores
    public Trombon(double prezo, String descricion, int stock, String marca, String modelo, boolean transpositor) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion{
        super(prezo, descricion, stock, marca, modelo);
        this.transpositor = transpositor;
    }

    // Metodos
    public String toString(){
        String x = transpositor ? "Si" : "No";
        return "Trombón: Transpositor "+x+". "+super.toString();
    }

    // Getters & Setters
    public boolean getTranspositor(){
        return transpositor;
    }
}
