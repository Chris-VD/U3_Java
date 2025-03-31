package controlador;

import java.util.HashMap;
import java.util.Optional;

import modelo.Usuario;
import modelo.excepcions.UsuarioRepetidoExcepcion;

public class TendaMusica {
    // Instancia do singleton
    public static TendaMusica INSTANCE;

    private HashMap<String, Usuario> usuarios;

    // Constructores
    private TendaMusica(){
        usuarios = new HashMap<>();
    }
    public static TendaMusica getInstance(){
        //Se inda non se accedeu, inicializase
        if(INSTANCE == null) {
            INSTANCE = new TendaMusica();
        }
        return INSTANCE;
    }

    // Métodos
    // Prohibir a clonación
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void engadirUsuario(Usuario user){
        usuarios.put(user.getUsername(), user);
    }

    public void comprobarUsername(String username) throws UsuarioRepetidoExcepcion{
        for (String u: usuarios.keySet()){
            if (username.equals(u)) throw new UsuarioRepetidoExcepcion("O usuario "+username+" xa está en uso");
        }
    }

    public Optional<Usuario> login(String user, String hash){
        for(String u:usuarios.keySet()){
            if(user.equals(u)){
                if(usuarios.get(u).getHash().equals(hash)) return Optional.of(usuarios.get(u));
            }
        }
        return Optional.empty();
    }
}
