import java.time.LocalDate;

public class PilotoF1 extends Piloto {
    public int victorias;
    public int voltasRapidas;
    public int polePos;

    // Constructor
    public PilotoF1(String nomeReal, String nomePila, LocalDate dataNacemento, String nomeEquipo, int victorias, int voltasRapidas, int polePos){
        super(nomeReal, nomePila, dataNacemento, nomeEquipo);
        this.setVictorias(victorias);
        this.setVoltasRapidas(voltasRapidas);
        this.setPolePos(polePos);
    }

    // Métodos
    @Override
    public int getPuntos(){
        return this.getVictorias()*25 + this.getVoltasRapidas() + this.getPolePos()*5;
    }

    // Getters & Setters
    public int getVictorias() {
        return victorias;
    }
    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }
    public int getVoltasRapidas() {
        return voltasRapidas;
    }
    public void setVoltasRapidas(int voltasRapidas) {
        this.voltasRapidas = voltasRapidas;
    }
    public int getPolePos() {
        return polePos;
    }
    public void setPolePos(int polePos) {
        this.polePos = polePos;
    }
}
