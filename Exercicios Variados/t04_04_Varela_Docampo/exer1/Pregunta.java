package exer1;

import java.util.ArrayList;

public class Pregunta {
    // Cada pregutna ten o texto da pregunta, a lista de respostas
    // e o número de veces que a rpegunta foi respondida, que fai falta para calcular o porcentaxe
    private String pregunta;
    private ArrayList<Resposta> respostas;
    private double numVecesRespondida = 0;

    // Constructors
    Pregunta(String pregunta){
        this.setPregunta(pregunta);
        this.respostas = new ArrayList<Resposta>();
    }

    // Métodos
    // Engade unha resposta á pregunta
    public void addResposta(Resposta resposta){
        this.respostas.add(resposta);
        // Tamén asgina esta pregutna á resposta correspondente
        resposta.setPregunta(this);
    }

    // Cando se selecciona unha resposta...
    public void selecResposta(int selec){
        // Manda unha mensaxe á respota dicindo que foi escollida
        this.respostas.get(selec).respostaSeleccionada();
        // Tamén engade un ás veces que a pregunta foi respondida
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
    /**
     * Devolve un clon da lista de respostas para que non se poida modificar o obseto orixinal
     * @return ArrayList<Resposta>, lista das respostas
     */
    public ArrayList<Resposta> getRespostas(){
        ArrayList<Resposta> tempListaRespostas;
        // Comproba que haxa respostas por se acaso
        if(respostas.size()!=0) tempListaRespostas = (ArrayList<Resposta>)respostas.clone();
        else tempListaRespostas = null;
        return tempListaRespostas;
    }

    public double getNumVecesRespondida(){
        return this.numVecesRespondida;
    }
}
