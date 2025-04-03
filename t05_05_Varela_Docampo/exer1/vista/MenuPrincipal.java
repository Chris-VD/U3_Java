package vista;

import java.util.Optional;

import controlador.TendaMusica;
import modelo.Usuario;
import modelo.excepcions.ConstrasinalInvalidoExcepcion;
import modelo.excepcions.UsuarioRepetidoExcepcion;
import utils.RolesEnum;

public class MenuPrincipal extends Menu{
    @Override
    protected void mostrar(){
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
                    // Run menu admin
                    if (TendaMusica.getInstance().isAdmin(novoUser)) new MenuAdmin().run();
                    // Run menu user
                    else new MenuCliente().run();
                }
                case "b"->{
                    String user = this.getString("Introduza seu nome de usuario: ");
                    String pswd = this.getString("Introduza sua contrasinal: ");
                    String pswd2 = this.getString("Introduza sua contrasinal de novo: ");
                    boolean isAdmin = this.getBoolean("É este usuario un admin? (Y/N): ");
                    RolesEnum rol = isAdmin ? RolesEnum.ADMIN:RolesEnum.CLIENTE;
                    Optional<Usuario> novoUserRaw;
                    try {
                        novoUserRaw = TendaMusica.getInstance().rexistro(user, pswd, pswd2, rol);
                    } catch (UsuarioRepetidoExcepcion e) {
                        this.printMessage(e.getMessage());
                        continue;
                    } catch (ConstrasinalInvalidoExcepcion e) {        
                        this.printMessage(e.getMessage());
                        continue;
                    }
                    if (novoUserRaw.isEmpty()){
                        this.printMessage("O rexistro fallou, tente de novo.");
                        continue;
                    }
                    if (isAdmin) new MenuAdmin().run();
                    else new MenuCliente().run();
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
