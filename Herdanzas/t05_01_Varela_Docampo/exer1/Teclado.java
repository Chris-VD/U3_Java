

public class Teclado extends Periferico {
    public Teclado(String marca, String modelo, double prezo){
        super(marca, modelo, prezo);
    }

    @Override
    public String toString(){
        return "Teclado "+super.toString()+" con conectores: "+this.getConectoresString();
    }
}
