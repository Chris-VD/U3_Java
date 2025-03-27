import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Deportista implements Comparable<Deportista>{
    protected static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyy");
    private String nomeReal;
    private String nomePila;
    private LocalDate dataNacemento;

    // Constructores
    public Deportista(String nomeReal, String nomePila, LocalDate dataNacemento) {
        this.setNomeReal(nomeReal);
        this.setNomePila(nomePila);
        this.setDataNacemento(dataNacemento);
    }

    // Métodos
    public int getIdade(){
        return LocalDate.now().getYear()-this.dataNacemento.getYear();
    }

    @Override
    public String toString(){
        return this.getNomePila()+": "+this.getIdade()+" anos.";
    }

    public int compareTo(Deportista dep){
        return this.getIdade() - dep.getIdade();
    }

    // Getters & Setters
    public String getNomeReal() {
        return nomeReal;
    }
    private void setNomeReal(String nomeReal) {
        this.nomeReal = nomeReal;
    }
    public String getNomePila() {
        return nomePila;
    }
    public void setNomePila(String nomePila) {
        this.nomePila = nomePila;
    }
    public LocalDate getDataNacemento() {
        return dataNacemento;
    }
    private void setDataNacemento(LocalDate dataNacemento) {
        this.dataNacemento = dataNacemento;
    }
}
