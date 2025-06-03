package vista;

import java.util.Optional;

import controlador.XestorBasquet;
import modelo.Equipo;
import modelo.LoginInterfaz;
import modelo.Xogador;
import modelo.Enums.RolesEnum;

public class MenuPrincipal extends Menu{

    @Override
    protected void mostrar(Object obj){
        mostrar();
    }

    @Override
    protected void mostrar() {

        boolean menuActivo = true;
        while (menuActivo) {
            // Menú
            this.printMessage("Menú Principal");
            this.printMessage("\ta) Iniciar sesión");
            this.printMessage("\ts) Sair");
    
            // Collemos a opción
            String opcion = this.getString("\n\t> ");
            switch (opcion) {
    
                // Iniciar Sesion
                case "a" -> {
                    String email = this.getString("Introduza un nome de usuario: ");
                    String password = this.getString("Introduza o contrasinal: ");
                    Optional<LoginInterfaz> login = XestorBasquet.getInstance().login(email, password);
                    if (login.isEmpty()) {
                        printMessage("Login fallido, tente de novo.");
                        break;
                    }
                    RolesEnum rol = login.get().getRol();
                    if (rol == RolesEnum.ADMIN) new MenuAdmin().run(null);
                    else if (rol == RolesEnum.BASE || rol == RolesEnum.INTERIOR || rol == RolesEnum.EXTERIOR) new MenuXogador().run((Xogador)login.get());
                    else if (rol == RolesEnum.EQUIPO) new MenuEquipo().run((Equipo)login.get());
                    else printMessage("Erro");
                }
    
                // Sair
                case "s" -> {
                    this.printMessage("Saíndo do programa");
                    menuActivo = false;
                }
    
                // Opcion por defecto
                default -> this.printMessage("Elixe unha opcion correcta");
            }
        }
    }
}
