import controlador.TendaMusica;
import modelo.excepcions.ConstrasinalInvalidoExcepcion;
import modelo.excepcions.ISBNInvalidoExcepcion;
import modelo.excepcions.PrezoMenorZeroExcepcion;
import modelo.excepcions.StockMenorZeroExcepcion;
import modelo.excepcions.UsuarioRepetidoExcepcion;
import utils.EnumInstrumentos;
import utils.EnumSaxofons;
import vista.MenuPrincipal;

public class App {
    public static void main(String[] args) throws ConstrasinalInvalidoExcepcion, PrezoMenorZeroExcepcion, StockMenorZeroExcepcion, ISBNInvalidoExcepcion, UsuarioRepetidoExcepcion {
        TendaMusica.getInstance().rexistro("Admin", "adminpswd", "adminpswd", true);
        TendaMusica.getInstance().rexistro("Cliente", "clientepswd", "clientepswd", false);
        TendaMusica.getInstance().engadirFrauta(20, "Frauta exemplo", 10, "Marca1", "Modelo1", false);
        TendaMusica.getInstance().engadirSaxofon(50, "Saxofón exemplo", 1, "Marca1", "Modelo2", EnumSaxofons.ALTO);
        TendaMusica.getInstance().engadirTrombon(100, "Trombón exemplo", 2, "Marca2", "Modelo1", true);
        TendaMusica.getInstance().engadirEstoxo(10, "Estoxo exemplo", 20, EnumInstrumentos.FRAUTA, "Marca3");
        TendaMusica.getInstance().engadirLibro(20, "Libro exemplo", 0, "Libro1", "0061964360");
        new MenuPrincipal().run();
    }
}