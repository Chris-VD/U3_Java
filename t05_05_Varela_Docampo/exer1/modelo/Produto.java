package modelo;

import modelo.excepcions.PrezoMenorZeroExcepcion;
import modelo.excepcions.StockAEliminarInvalido;
import modelo.excepcions.StockMenorZeroExcepcion;

public abstract class Produto {
    private static int contador;
    private static final double IVE = 0.21;

    private String id;
    private double prezo;
    private double prezoIVE;
    private int stock;
    private String descricion;

    // Constructor
    public Produto(double prezo, String descricion, int stock) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion{
        this.descricion = descricion;
        this.setStock(stock);
        this.setPrezos(prezo);
        this.setId();
    }

    // Métodos
    public void eliminarStock(int stockAEliminar) throws StockAEliminarInvalido{
        if (this.stock < stockAEliminar) throw new StockAEliminarInvalido("O stock a eliminar é maior ó stock actual.\nStock actual: "+this.stock);
    }

    public void engadirStock(int stockAEngadir){
        this.stock += stockAEngadir;
    }

    @Override
    public String toString(){
        return "Prezo con IVE: "+this.prezoIVE+"€ ; Prezo sen IVE: "+this.prezo+"€ ; Stock: "+this.stock+" unidades ; Descrición: "+this.descricion+".";
    }

    // Getters & Setters
    private void setId(){
        contador += 1;
        this.id = String.valueOf(contador);
    }
    private void setPrezos(double prezo) throws PrezoMenorZeroExcepcion{
        if (prezo < 0) throw new PrezoMenorZeroExcepcion("O prezo "+prezo+" non é válido.");
        this.prezo = prezo;
        this.prezoIVE = prezo * (1 - IVE);
    }
    public void setStock(int stock) throws StockMenorZeroExcepcion{
        if (stock < 0) throw new StockMenorZeroExcepcion("O stock dun produto non pode ser negativo.");
    }
    public static int getContador() {
        return contador;
    }
    public static double getIve() {
        return IVE;
    }
    public String getId() {
        return id;
    }
    public double getPrezo() {
        return prezo;
    }
    public double getPrezoIVE() {
        return prezoIVE;
    }
    public int getStock() {
        return stock;
    }
    public String getDescricion() {
        return descricion;
    }
}
