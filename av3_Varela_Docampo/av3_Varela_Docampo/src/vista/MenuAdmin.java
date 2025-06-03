package vista;

import controlador.XestorBasquet;
import modelo.Enums.RolesEnum;
import modelo.Excepcions.ConstrasinalInvalidoExcepcion;
import modelo.Excepcions.CorreoInvalidoExcepcion;
import modelo.Excepcions.CorreoRepetidoExcepcion;
import modelo.Excepcions.EquipoInvalidoExcepcion;

public class MenuAdmin extends Menu{

    @Override
    protected void mostrar(Object obj){
        mostrar();
    }

    @Override
    protected void mostrar() {

        boolean menuActivo = true;
        while (menuActivo) {
            // Menú
            this.printMessage("Menú Administrador");
            this.printMessage("\ta) Engadir equipo");
            this.printMessage("\tb) Dar de alta xogadores");
            this.printMessage("\tc) Ver xogadores libres");
            this.printMessage("\ts) Sair");
    
            // Collemos a opción
            String opcion = this.getString("\n\t> ");
            switch (opcion) {
    
                // Engadir equipo
                case "a" -> {
                    String nome = this.getString("Indicame o nome do equipo: ");
                    String cidade = this.getString("Indicame o nome da cidade: ");
                    try {
                        XestorBasquet.getInstance().rexistro(nome, cidade);
                    } catch (CorreoInvalidoExcepcion | ConstrasinalInvalidoExcepcion | CorreoRepetidoExcepcion
                            | EquipoInvalidoExcepcion e) {
                        printMessage(e.getMessage());
                    }
                }
    
                // Dar de alta xogadores
                case "b" -> {
                    String nome = this.getString("Indicame o nome do xogador: ");
                    String email = this.getString("Indicame o email do xogador: ");
                    String posicionOpcion = this.getString("Indica a posicion: b) Base e) Exterior i) Interior . Por defecto a selección é interior: ");
                    RolesEnum pos;
                    switch (posicionOpcion) {
                        case "b" -> {
                            pos = RolesEnum.BASE;
                        }
                        case "i" -> {
                            pos = RolesEnum.INTERIOR;
                        }
                        case "e" -> {
                            pos = RolesEnum.EXTERIOR;
                        }
                        default -> {
                            printMessage("Seleccionando valor por defecto.");
                            pos = RolesEnum.INTERIOR;
                        }
                    }
                    try {
                        XestorBasquet.getInstance().rexistro(nome, email, pos);
                    } catch (CorreoInvalidoExcepcion | ConstrasinalInvalidoExcepcion | CorreoRepetidoExcepcion
                            | EquipoInvalidoExcepcion e) {
                        printMessage(e.getMessage());
                    }
                }
    
                // Ver xogadores libres
                case "c" -> {
                    printMessage(XestorBasquet.getInstance().verXogadoresLibres());
                }
    
                // Sair
                case "s" -> {
                    this.printMessage("Saíndo do programa");
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
