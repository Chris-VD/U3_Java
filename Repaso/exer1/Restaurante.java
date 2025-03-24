package exer1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

public class Restaurante {
    private String cidade;
    private String telefono;
    private ArrayList<Reserva> reservas;
    public static DateTimeFormatter formatoPrincipal = DateTimeFormatter.ofPattern("d/M/yyyy");

    // Constructor
    public Restaurante(String cidade, String telefono){
        this.cidade = cidade;
        this.setTelefono(telefono);
        this.reservas = new ArrayList<>();
    }

    // Métodos
    public boolean addReserva(String nome, String dataRaw, Integer numero){
        LocalDate data = LocalDate.parse(dataRaw, formatoPrincipal);
        if(data.isAfter(LocalDate.now()) ||
            contarReservas(data) + numero > 20){
                return false;
            }
        else{
            Reserva novaReserva = new Reserva(nome, numero, data);
            reservas.add(novaReserva);
            return true;
        }
    }

    public int contarReservas(LocalDate data){
        int total = 0;
        ArrayList<Reserva> reservasMismoDia = getReservasMismoDia(data);
        for (Reserva reserva : reservasMismoDia){
            total += reserva.getNumero();
        }
        return total;
    }

    public Optional<LocalDate> buscarDiaLibre(){
        boolean diaLibre = true;
        for (LocalDate data = LocalDate.now(); data.isBefore(data.plusMonths(1));data.plusDays(1)){
            ArrayList<Reserva> reservasEnDia = this.getReservasMismoDia(data);
            diaLibre = true;
            for (Reserva reserva : reservasEnDia){
                if (!reserva.comprobarLibre()){
                    diaLibre = false;
                    break;
                }
            }
            if (diaLibre) break;
        }
        if (diaLibre) return Optional.of(LocalDate.now());
        else return Optional.empty();
    }

    // Getters & Setters
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList<Reserva> getReservas(){
        ArrayList<Reserva> reservasClone = new ArrayList<>();
        reservasClone = (ArrayList)reservas.clone();
        return reservasClone;
    }

    public ArrayList<Reserva> getReservasMismoDia(LocalDate data){
        ArrayList<Reserva> reservasMismoDia = new ArrayList<>();
        for (Reserva reserva : this.getReservas()){
            if (reserva.comprobarDia(data)){
                reservasMismoDia.add(reserva);
            }
        }
        return reservasMismoDia;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public String getCidade(){
        return this.cidade;
    }
}
