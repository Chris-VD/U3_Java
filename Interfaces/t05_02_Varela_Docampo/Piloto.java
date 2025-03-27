import java.time.LocalDate;

public abstract class Piloto extends Deportista{
    private String nomeEquipo;

    // Constructor
    public Piloto(String nomeReal, String nomePila, LocalDate dataNacemento, String nomeEquipo){
        super(nomeReal, nomePila, dataNacemento);
        this.setNomeEquipo(nomeEquipo);
    }

    // Metodos
    public int getPuntos(){return 0;};

    @Override
    public String toString(){
        return super.toString()+" Equipo: "+this.getNomeEquipo()+" - Puntos: "+this.getPuntos();
    }

    // Getters & Setters
    public String getNomeEquipo() {
        return nomeEquipo;
    }
    public void setNomeEquipo(String nomeEquipo) {
        this.nomeEquipo = nomeEquipo;
    }
}
