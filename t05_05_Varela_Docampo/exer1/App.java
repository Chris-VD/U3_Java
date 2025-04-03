import modelo.excepcions.ConstrasinalInvalidoExcepcion;
import modelo.excepcions.ISBNInvalidoExcepcion;
import modelo.excepcions.PrezoMenorZeroExcepcion;
import modelo.excepcions.StockMenorZeroExcepcion;
import modelo.excepcions.UsuarioRepetidoExcepcion;
import vista.MenuPrincipal;

public class App {
    public static void main(String[] args) throws ConstrasinalInvalidoExcepcion, PrezoMenorZeroExcepcion, StockMenorZeroExcepcion, ISBNInvalidoExcepcion, UsuarioRepetidoExcepcion {
                new MenuPrincipal().run();
    }
}