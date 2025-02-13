package exer1;

import java.util.ArrayList;

public class Cuestionario {
    private ArrayList<Pregunta> cuestionario;

    Cuestionario(){
        this.cuestionario = new ArrayList<>();
    }

    public void add(Pregunta pregunta){
        this.cuestionario.add(pregunta);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Pregunta> getCuestionario(){
        ArrayList<Pregunta> cuestionarioTemp;
        cuestionarioTemp = (ArrayList<Pregunta>)this.cuestionario.clone();
        return cuestionarioTemp;
    }
}
