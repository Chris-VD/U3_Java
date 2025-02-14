package exer1;

public class Resposta {
    // Cada resposta ten o texto da resposta, a pregunta á que pertenece e un contador co número de veces que foi seleccionada
    private String resposta;
    private Pregunta pregunta;
    private double numVecesSeleccionada;

    // Constructors
    Resposta(String resposta){
        this.setResposta(resposta);
    }

    // Métodos
    // Cando se responde a unha pregunta, o método Pregunta.selecResposta() manda á respota seleccionada
    // este mensaxe para poder engadir un ó ocntador de veces respondida
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

    /**
     * Devolve o porcentaxe de veces que a respota foi sleccionada, este calcúlase co número de veces seleccionada da pregunta
     * e o número d eveces que a pregunta foi respondida
     * @return String, porcentaxe de resposta da pregunta
     */
    public String getPorcentaxeSeleccion(){
        return String.valueOf(Math.round(this.numVecesSeleccionada / this.pregunta.getNumVecesRespondida() * 100));
    }
}
