package exer1;

import java.util.ArrayList;

public class Cuestionario {
    // A clase Cuestionario so é un ArrayList de Preguntas
    private ArrayList<Pregunta> cuestionario;

    // Constructor
    Cuestionario(){
        this.cuestionario = new ArrayList<>();
    }

    // Métodos
    /**
     * Método para engadir Pregunta ó Cuestionario
     * @param pregunta Pregutna a engadir
     */
    public void add(Pregunta pregunta){
        this.cuestionario.add(pregunta);
    }

    // Getter
    @SuppressWarnings("unchecked")
    /**
     * Devolve un clonado da lista de preguntas, para que non poida modificar o obxeto orixinal
     * @return ArrayList<Pregunta>, lista das preguntas
     */
    public ArrayList<Pregunta> getCuestionario(){
        ArrayList<Pregunta> cuestionarioTemp;
        cuestionarioTemp = (ArrayList<Pregunta>)this.cuestionario.clone();
        return cuestionarioTemp;
    }
}
