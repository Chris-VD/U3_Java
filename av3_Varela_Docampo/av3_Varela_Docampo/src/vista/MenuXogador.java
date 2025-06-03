package vista;

import controlador.XestorBasquet;
import modelo.Xogador;
import modelo.Excepcions.EquipoInvalidoExcepcion;
import modelo.Excepcions.XogadorNonLibreExcepcion;
import modelo.Excepcions.XogadoresCheosExcepcion;

public class MenuXogador extends Menu{
    private Xogador xogador;

    protected void mostrar(Object obj){
        Xogador xogador = (Xogador) obj;
        this.xogador = xogador;
        mostrar();
    }

    @Override
    protected void mostrar() {

        boolean menuActivo = true;
        while (menuActivo) {
            // Menú
            this.printMessage("Menú Xogador");
            this.printMessage("\ta) Ver ofertas");
            this.printMessage("\tb) Aceptar oferta dun equipo");
            this.printMessage("\ts) Sair");
    
            // Collemos a opción
            String opcion = this.getString("\n\t> ");
            switch (opcion) {
    
                // Ver ofertas
                case "a" -> {
                    printMessage(XestorBasquet.getInstance().verOfertas(xogador));
                }
    
                // Aceptar oferta
                case "b" -> {
                    String nome = this.getString("Indaca o nome do equipo");
                    String cidade = this.getString("Indica a cidade do equipo");
                    try {
                        XestorBasquet.getInstance().aceptarOferta(xogador, nome, cidade);
                    } catch (XogadorNonLibreExcepcion | EquipoInvalidoExcepcion | XogadoresCheosExcepcion e) {
                        printMessage(e.getMessage());
                    }
                }
    
                // Sair
                case "s" -> {
                    this.printMessage("Saíndo o menú principal");
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
