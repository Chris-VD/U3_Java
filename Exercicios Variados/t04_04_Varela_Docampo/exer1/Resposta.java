package exer1;

public class Resposta {
    private String resposta;
    private Pregunta pregunta;
    private double numVecesSeleccionada;

    // Constructors
    Resposta(String resposta){
        this.setResposta(resposta);
    }

    // Métodos
    public void respostaSeleccionada(){
        this.numVecesSeleccionada++;
    }

    // Getters & Setters
    private void setResposta(String resposta){
        this.resposta = resposta;
    }

    public String getResposta(){
        return this.resposta;
    }

    public void setPregunta(Pregunta pregunta){
        this.pregunta = pregunta;
    }

    public String getPorcentaxeSeleccion(){
        return String.valueOf(Math.round(this.numVecesSeleccionada / this.pregunta.getNumVecesRespondida() * 100));
    }
}
