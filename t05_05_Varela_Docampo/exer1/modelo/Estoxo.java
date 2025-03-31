package modelo;

import modelo.excepcions.PrezoMenorZeroExcepcion;
import modelo.excepcions.StockMenorZeroExcepcion;
import utils.EnumInstrumentos;

public class Estoxo extends Complemento{
    private EnumInstrumentos instrumento;
    private String marca;

    // Constructores
    public Estoxo(double prezo, String descricion, int stock, EnumInstrumentos instrumentos, String marca) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion{
        super(prezo, descricion, stock);
        this.instrumento = instrumentos;
        this.marca = marca;
    }

    // Metodos
    @Override
    public String toString(){
        return "Estoxo "+this.marca+" para "+this.instrumento+" :"+super.toString();
    }

    // Getters & Setters
    public String getMarca(){
        return marca;
    }
    public EnumInstrumentos getInstrumento(){
        return instrumento;
    }
}
