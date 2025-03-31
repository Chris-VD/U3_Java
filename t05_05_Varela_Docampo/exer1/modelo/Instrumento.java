package modelo;

import modelo.excepcions.PrezoMenorZeroExcepcion;
import modelo.excepcions.StockMenorZeroExcepcion;

public abstract class Instrumento extends Produto{
    public String marca;
    public String modelo;

    // Constructores
    public Instrumento(double prezo, String descricion, int stock, String marca, String modelo) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion{
        super(prezo, descricion, stock);
        this.marca = marca;
        this.modelo = modelo;
    }

    // Getters & Stters
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
}
