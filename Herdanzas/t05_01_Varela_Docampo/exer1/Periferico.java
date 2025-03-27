
import java.util.ArrayList;

import ernums.Conector;

public abstract class Periferico extends Produto{
    private ArrayList<Conector> conectores;
    
    // Constructores
    public Periferico(String marca, String modelo, double prezo){
        super(marca, modelo, prezo);
        this.conectores = new ArrayList<>();
    }

    // Métodos
    public void addConector(Conector conector){
        this.conectores.add(conector);
    }

    public String getConectoresString(){
        String result = "";
        for (Conector c:conectores){
            result += c.name() +" ";
        }
        return result;
    }
}
