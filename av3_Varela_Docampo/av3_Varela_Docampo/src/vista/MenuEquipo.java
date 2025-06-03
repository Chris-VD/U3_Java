package vista;

import controlador.XestorBasquet;
import modelo.Equipo;
import modelo.Excepcions.CorreoInexistente;
import modelo.Excepcions.CorreoInvalidoExcepcion;
import modelo.Excepcions.XogadorNonLibreExcepcion;

public class MenuEquipo extends Menu{
    private Equipo equipo;

    protected void mostrar(Object object){
        Equipo equipo = (Equipo) object;
        this.equipo = equipo;
        mostrar();
    }

    @Override
    protected void mostrar() {

        boolean menuActivo = true;
        while (menuActivo) {
            // Menú
            this.printMessage("Menú Equipo");
            this.printMessage("\ta) Ver xogadores equipo");
            this.printMessage("\tb) Ver xogadores libres");
            this.printMessage("\tc) Facer oferta xogador");
            this.printMessage("\td) Xogar partido");
            this.printMessage("\ts) Sair");
    
            // Collemos a opción
            String opcion = this.getString("\n\t> ");
            switch (opcion) {
    
                // Ver xogadores equipo
                case "a" -> {
                    printMessage(XestorBasquet.getInstance().verXogadoresEquipo(equipo));
                }
    
                // Ver xogadores libres
                case "b" -> {
                    printMessage(XestorBasquet.getInstance().verXogadoresLibres());
                }
    
                // Facer oferta a xogador
                case "c" -> {
                    String email = this.getString("Introduce o email do xogador:");
                    try {
                        XestorBasquet.getInstance().facerOferta(equipo, email);
                    } catch (XogadorNonLibreExcepcion | CorreoInexistente | CorreoInvalidoExcepcion e) {
                        printMessage(e.getMessage());
                    }
                }
    
                // Xogar partido
                case "d" -> {
                    XestorBasquet.getInstance().xogarPartido(equipo);
                }
    
                // Sair
                case "s" -> {
                    this.printMessage("Saíndo ao menú principal");
                    menuActivo = false;
                }
    
                // Opcion por defecto
                default -> {
                    this.printMessage("Elixe unha opcion correcta");
    
                }
    
            }
        }
    }
}
