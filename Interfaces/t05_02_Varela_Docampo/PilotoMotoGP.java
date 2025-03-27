import java.time.LocalDate;

public class PilotoMotoGP extends Piloto {
    private int numPuntos;

    // Constructor
    public PilotoMotoGP(String nomeReal, String nomePila, LocalDate dataNacemento, String nomeEquipo, int numPuntos){
        super(nomeReal, nomePila, dataNacemento, nomeEquipo);
        this.setNumPuntos(numPuntos);
    }

    // Métodos
    public int getPuntos(){
        return this.getNumPuntos();
    }

    // Getters & Setters
    public int getNumPuntos() {
        return numPuntos;
    }
    public void setNumPuntos(int numPuntos) {
        this.numPuntos = numPuntos;
    }
}
