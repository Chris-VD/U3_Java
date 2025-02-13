package exer1;

import java.util.ArrayList;

public class Pregunta {
    private String pregunta;
    private ArrayList<Resposta> respostas;
    private int numRespostas = 0;
    private double numVecesRespondida = 0;

    // Constructors
    Pregunta(String pregunta){
        this.setPregunta(pregunta);
        this.respostas = new ArrayList<Resposta>();
    }

    // Métodos
    public void addResposta(Resposta resposta){
        this.respostas.add(resposta);
        resposta.setPregunta(this);
        this.numRespostas++;
    }

    public void selecResposta(int selec){
        this.respostas.get(selec).respostaSeleccionada();
        this.numVecesRespondida++;
    }

    // Getters & Setters
    private void setPregunta(String pregunta){
        this.pregunta = pregunta;
    }

    public String getPregunta(){
        return this.pregunta;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Resposta> getRespostas(){
        ArrayList<Resposta> tempListaRespostas;
        if(respostas.size()!=0) tempListaRespostas = (ArrayList<Resposta>)respostas.clone();
        else tempListaRespostas = null;
        return tempListaRespostas;
    }

    public int getNumRespostas(){
        return this.numRespostas;
    }

    public double getNumVecesRespondida(){
        return this.numVecesRespondida;
    }
}
