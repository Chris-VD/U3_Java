import java.time.LocalDate;
import java.util.ArrayList;

public class App{
    public static void main(String[] args){
        ArrayList<Contrato> listaContratos = new ArrayList<>();
        ContratoIndefinido novoConIndef = new ContratoIndefinido("Charles", "Foster Kane", 35000, 18, false);
        ContratoIndefinido novoConIndef2 = new ContratoIndefinido("Rick", "Blaine", 60000, 25, true);
        ContratoTemporal novoConTemp = new ContratoTemporal("Cool", "Hand Luke", 10000, 6, 4, LocalDate.of(2025, 1, 12));
        ContratoEnPracticas novoConPrac = new ContratoEnPracticas("Harrison", "Smith", 15000, 2, "Desenvolvemento de Aplicacións Web");

        listaContratos.add(novoConIndef);
        listaContratos.add(novoConIndef2);
        listaContratos.add(novoConTemp);
        listaContratos.add(novoConPrac);

        for (Contrato c:listaContratos){
            System.err.println(c.toString());
        }
    }
}