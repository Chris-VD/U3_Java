
import ernums.Zocalo;

public class PlacaBase extends Componhente{
    private Zocalo zocalo;

    // COnstructores
    public PlacaBase(String marca, String modelo, double prezo, Zocalo zocalo){
        super(marca, modelo, prezo);
        this.zocalo = zocalo;
    }

    // Métodos
    @Override
    public String toString(){
        return "Placa base "+super.toString()+" con socket "+getZocalo();
    }

    // Getters & Setters
    public Zocalo getZocalo(){
        return this.zocalo;
    }
}
