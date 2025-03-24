import java.time.LocalDate;
import java.util.ArrayList;

public class Habitacion {
    private String numero; // Gárdoo como String pq non o vou modificar en ningún momento pero como tal é un número
    private char tipo; // i -> individual, d -> doble, t -> triple
    private Hotel hotel;
    private double prezo;
    private ArrayList<Reserva> reservas;

    // Constructor
    public Habitacion(String numero, char tipo, double prezo){
        this.numero = numero;
        this.tipo = tipo;
        this.prezo = prezo;
        this.reservas = new ArrayList<>();
    }

    // Métodos
    /**
     * Comproba se a habitación está libre no día introducido
     * @param data día no que queremos comprobar se a habitación está libre
     * @return boolean -> true se está libre e false se non
     */
    public boolean checkLibreDia(LocalDate data){
        for(Reserva reserva : reservas){
            if(data.isEqual(reserva.getEntrada())) return false;
            if(data.isAfter(reserva.getEntrada()) && data.isBefore(reserva.getSaida())) return false;
        }
        return true;
    }

    /**
     * Comproba se a habitación está libre nun intervalo de tempo
     * @param entrada
     * @param saida
     * @return boolean -> true se está libre e false se non
     */
    public boolean checkLibreEntreData(LocalDate entrada, LocalDate saida){
        for(Reserva reserva : reservas){
            if(reserva.getSaida().equals(entrada) || reserva.getEntrada().equals(saida)) continue; // alguén pode sair o mesmo día que outra persoa entre, polo que se os valores de
            // saida e entrada de duas reservas diferentes son o mesmo non hai problema
            else if(entrada.isBefore(reserva.getEntrada()) && saida.isAfter(reserva.getEntrada())) return false; // X--I--X--I || X--I--I--X
            else if(entrada.isBefore(reserva.getSaida()) && saida.isAfter(reserva.getSaida())) return false; // I--X--I--X || X--I--I--X
            else if(entrada.isAfter(reserva.getEntrada()) && saida.isBefore(reserva.getSaida())) return false; // I--X--X--I
        }
        return true;
    }

    /**
     * Engade unha reserva á lista de reservas
     * @param nome
     * @param entrada
     * @param saida
     * @return boolean -> true se se reservou e false se non
     */
    public boolean addReserva(String nome, LocalDate entrada, LocalDate saida){
        if(!this.checkLibreEntreData(entrada, saida)) return false;

        Reserva novaReserva = new Reserva(nome, entrada, saida);
        novaReserva.setHabitacion(this);
        reservas.add(novaReserva);
        return true;
    }

    // Getters & Setters
    public void setHotel(Hotel hotel){
        this.hotel = hotel;
    }
    public String getNumero() {
        return numero;
    }
    // Poderíase modificar para que en vez de devolver "i" devolvese "individual" cun switch simple pero non lle vexo o uso nesta app
    public char getTipo() {
        return tipo;
    }
    // Non se usa en ningún lado pero podería ser útil dentro de reserva para facer o identificador, xa o explico ahí
    public Hotel getHotel() {
        return hotel;
    }
    public double getPrezo() {
        return prezo;
    }
}
