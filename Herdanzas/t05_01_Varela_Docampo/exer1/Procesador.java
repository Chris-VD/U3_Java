
import ernums.Zocalo;

public class Procesador extends Componhente{
    private Zocalo zocalo;
    private int numeroCores;

    // Constructores
    public Procesador(String marca, String modelo, double prezo, Zocalo zocalo, int numeroCores){
        super(marca, modelo, prezo);
        this.zocalo = zocalo;
        this.numeroCores = numeroCores;
    }

    // Métodos
    @Override
    public String toString(){
        return "Procesador "+super.toString()+" con "+getNumeroCores()+" e socket "+this.getZocalo();
    }

    //Getters & Setters
    public Zocalo getZocalo(){
        return this.zocalo;
    }
    public int getNumeroCores(){
        return this.numeroCores;
    }
}
