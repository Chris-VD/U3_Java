package vista;

import java.util.Optional;

import controlador.TendaMusica;
import modelo.Usuario;
import modelo.excepcions.ConstrasinalInvalidoExcepcion;
import modelo.excepcions.UsuarioRepetidoExcepcion;

public class MenuPrincipal extends Menu{
    @Override
    protected void mostrar() throws UsuarioRepetidoExcepcion, ConstrasinalInvalidoExcepcion{
        this.printMessage("Benvido á tenda de musica de santiago");
        boolean principal = true;
        while (principal){
            this.printMessage("Que desexa facer?\na) Entrar con conta existente\nb) Rexistrar conta nova\ns) Sair");
            String opc = this.getString("> ");
            switch (opc) {
                case "a"->{
                    String user = this.getString("Introduza seu nome de usuario: ");
                    String pswd = this.getString("Introduza sua contrasinal: ");
                    Optional<Usuario> novoUserRaw = TendaMusica.getInstance().login(user, pswd);
                    Usuario novoUser;
                    if (novoUserRaw.isEmpty()){
                        this.printMessage("O usuario ou a contraseña non son correctos, tente de novo.");
                        continue;
                    }
                    else{
                        novoUser = novoUserRaw.get();
                    }
                    // FIXME
                    // Run menu admin
                    if (TendaMusica.getInstance().isAdmin(novoUser)) ;
                    // Run menu user
                    else ;
                }
                case "b"->{
                    String user = this.getString("Introduza seu nome de usuario: ");
                    String pswd = this.getString("Introduza sua contrasinal: ");
                    String pswd2 = this.getString("Introduza sua contrasinal de novo: ");
                    boolean isAdmin = this.getBoolean("É este usuario un admin? (Y/N): ");
                    Optional<Usuario> novoUserRaw = TendaMusica.getInstance().rexistro(user, pswd, pswd2, isAdmin);
                    Usuario novoUser;
                    if (novoUserRaw.isEmpty()){
                        this.printMessage("O rexistro fallou, tente de novo.");
                        continue;
                    }
                    else{
                        novoUser = novoUserRaw.get();
                    }
                    // FIXME
                    if (isAdmin) ;
                    else ;
                }
                case "s"->{
                    this.printMessage("Saindo do programa...");
                    principal = false;
                }
                default->{
                    this.printMessage("Opción inválida, tente de novo.");
                }
            }
        }
    }
}
