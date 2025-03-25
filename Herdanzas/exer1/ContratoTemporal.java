import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ContratoTemporal extends Contrato{
    public static final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyy");
    public int duracionContrato;
    public LocalDate inicioContrato;

    // Constructor
    public ContratoTemporal(String nome, String apelidos, int salarioBrutoAnual, double IRPF, int duracionContrato, LocalDate inicioContrato){
        super(nome, apelidos, salarioBrutoAnual, IRPF);
        this.setDuracionContrato(duracionContrato);
        this.setInicioContrato(inicioContrato);
    }

    // Métodos
    public LocalDate getFinContrato(){
        return this.inicioContrato.plus(this.getDuracionContrato(), ChronoUnit.MONTHS);
    }

    @Override
    public double getSalarioMensualNeto(){
        return (this.getSalarioNetoAnual()/12);
    }

    @Override
    public String toString(){
        return super.toString()+". Contratado dende "+this.inicioContrato.format(formatoData)+" ata "+this.getFinContrato().format(formatoData);
    }

    // Getters & Setters
    public int getDuracionContrato() {
        return duracionContrato;
    }
    public void setDuracionContrato(int duracionContrato) {
        if (duracionContrato > 6) this.duracionContrato = 6;
        else this.duracionContrato = duracionContrato;
    }
    public LocalDate getInicioContrato() {
        return inicioContrato;
    }
    public void setInicioContrato(LocalDate inicioContrato) {
        this.inicioContrato = inicioContrato;
    }
}
