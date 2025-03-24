import java.time.LocalDate;

public class Reserva {
    private String identificador;
    /*
     * Como o identificador ten que ser único, ocurriuseme que este sexa unha combinación do número da habitación xunto ca fecha da reserva xa que a mema habitación 
     * nunca vai a ter e mesma fecha de reserva dúas veces. Esto fai que sexa único en cada hotel e poderíase facer que fose único entre todos os hoteles á vez
     * se ademáis do número da habitación e fecha poderíamos engadir o nome do hotel -> habitacion.getHotel.getNome()+" "+habitacion.getNumero()+" "+entrada.format(Hotel.formato)
     */
    private Habitacion habitacion;
    private String nome;
    private LocalDate entrada;
    private LocalDate saida;

    // Constructor
    public Reserva(String nome, LocalDate entrada, LocalDate saida){
        this.nome = nome;
        this.entrada = entrada;
        this.saida = saida;
    }

    //Getters & Setters
    public String getIdenntificador(){
        return identificador;
    }
    public Habitacion getHabitacion(){
        return habitacion;
    }
    /**
     * O único especial deste setter é que tamén crea o identificador
     */
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
        this.identificador = habitacion.getNumero()+" "+entrada.format(Hotel.formato);
    }
    public String getNome() {
        return nome;
    }
    public LocalDate getEntrada() {
        return entrada;
    }
    public LocalDate getSaida() {
        return saida;
    }
}
