package classes;
import abstracts.Periferico;

public class Monitor extends Periferico{
    private double pulgadas;

    public Monitor(String marca, String modelo, double prezo, double pulgadas){
        super(marca, modelo, prezo);
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString(){
        return "Monitor "+super.toString()+" con "+this.getPulgadas()+" pulgadas e conectores: "+this.getConectoresString();
    }

    public double getPulgadas(){
        return this.pulgadas;
    }
}
