package modelo;

import modelo.excepcions.PrezoMenorZeroExcepcion;
import modelo.excepcions.StockMenorZeroExcepcion;

public abstract class Complemento extends Produto{
    // Constructores
    public Complemento(double prezo, String descricion, int stock) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion{
        super(prezo, descricion, stock);
    }
}
