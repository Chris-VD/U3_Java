import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Hotel {
    public static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String nome;
    private ArrayList<Habitacion> habitacions;
    private HashMap<String, Habitacion> habitacionsNumero;
    private int numeroHabitacions;

    // Constructor
    public Hotel(String nome){
        this.setNome(nome);
        this.habitacions = new ArrayList<>();
        this.habitacionsNumero = new HashMap<>();
        this.numeroHabitacions = 0;
    }

    // Métodos
    /**
     * Engade unha habitación ó hotel
     * @param numero
     * @param tipo
     * @param prezo
     * @return boolean -> true se se engadiu correctamente e false se non
     * O de que devolva true ou false como tal non é necesario e soese facer tirande excepciones pero como non as demos
     * era ou facer esto ou engadir unha variable nova que comprobase se se engadiu ou non
     */
    public boolean addHabitacion(String numero, char tipo, double prezo){
        for(Habitacion habitacion : habitacions){
            if(habitacion.getNumero() == numero) return false;
        }
        if(tipo != 'i' && tipo != 'd' && tipo != 't') return false;
        if(prezo <= 0) return false;

        Habitacion novaHabitacion = new Habitacion(numero, tipo, prezo);
        novaHabitacion.setHotel(this);
        habitacions.add(novaHabitacion);
        habitacionsNumero.put(numero, novaHabitacion);
        numeroHabitacions++;
        return true;
    }

    /**
     * Busca se hai algunha habitación libre coas especificacións introducidas
     * @param entradaRaw
     * @param saidaRaw
     * @param tipo
     * @return Optional -> vacío se non hai habitacións libres e un arraylist se si que as hai
     */
    public Optional<ArrayList<Habitacion>> buscadorHabitacion(String entradaRaw, String saidaRaw, char tipo){
        LocalDate entrada = LocalDate.parse(entradaRaw, formato);
        LocalDate saida = LocalDate.parse(saidaRaw, formato);
        ArrayList<Habitacion> habitacionsEncontradas = new ArrayList<>();

        if(entrada.isAfter(saida)) return Optional.empty();

        for(Habitacion habitacion : habitacions){
            if(habitacion.checkLibreEntreData(entrada, saida) && habitacion.getTipo() == tipo) habitacionsEncontradas.add(habitacion);
        }

        if(habitacionsEncontradas.size() != 0) return Optional.of(habitacionsEncontradas);
        else return Optional.empty();
    }

    /**
     * Engade unha reserva dunha habitación ó hotel
     * @param numero
     * @param nome
     * @param entradaRaw
     * @param saidaRaw
     * @return boolean -> true se se engadiu e false se non
     * As comprobacións que se fan para engadir a reserva están divididas entre este método e o da clase Habitacion
     */
    public boolean addReserva(String numero, String nome, String entradaRaw, String saidaRaw){

        if(!habitacionsNumero.keySet().contains(numero)) return false;
        Habitacion habitacionAReservar = habitacionsNumero.get(numero);

        LocalDate entrada = LocalDate.parse(entradaRaw, formato);
        LocalDate saida = LocalDate.parse(saidaRaw, formato);
        if(entrada.isAfter(saida)) return false;

        return habitacionAReservar.addReserva(nome, entrada, saida);
    }

    /**
     * Devolve o porcentaxe (1.0-0.0) das hbaitacións ocupadas nun día específico
     * @param dataRaw
     * @return
     */
    public double getPorcentaxeOcupa(String dataRaw){
        int habitacionsOcupadas = 0;
        LocalDate data = LocalDate.parse(dataRaw, formato);

        if(this.numeroHabitacions == 0) return 0;

        for(Habitacion habitacion : habitacions){
            if(!habitacion.checkLibreDia(data)) habitacionsOcupadas += 1;
        }

        return habitacionsOcupadas / numeroHabitacions;
    }

    // Getters & Setters
    public String getNome() {
        return nome;
    }
    // Privado xa que non me interesa que poidan cambiarlle o nome dende app
    private void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve un clon da lista por seguridade
     * @return un clon ArrayList<Habitacion>
     */
    public ArrayList<Habitacion> getHabitacions() {
        @SuppressWarnings("unchecked")
        ArrayList<Habitacion> copia = (ArrayList<Habitacion>)this.habitacions.clone();
        return copia;
    }
}
