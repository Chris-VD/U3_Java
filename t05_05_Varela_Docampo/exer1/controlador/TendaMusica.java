package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import modelo.Admin;
import modelo.Cliente;
import modelo.Complemento;
import modelo.Estoxo;
import modelo.Frauta;
import modelo.Instrumento;
import modelo.Libro;
import modelo.Produto;
import modelo.Saxofon;
import modelo.Trombon;
import modelo.Usuario;
import modelo.excepcions.ConstrasinalInvalidoExcepcion;
import modelo.excepcions.ISBNInvalidoExcepcion;
import modelo.excepcions.IdentificadorInvalidoExcepcion;
import modelo.excepcions.PrezoMenorZeroExcepcion;
import modelo.excepcions.StockAEliminarInvalido;
import modelo.excepcions.StockInsuficienteExcepcion;
import modelo.excepcions.StockMenorZeroExcepcion;
import modelo.excepcions.UsuarioRepetidoExcepcion;
import utils.EnumInstrumentos;
import utils.EnumSaxofons;
import utils.HashPassword;

public class TendaMusica {
    // Instancia do singleton
    public static TendaMusica INSTANCE;

    private HashMap<String, Usuario> usuarios;
    private ArrayList<Admin> admins;
    private ArrayList<Cliente> clientes;

    private HashMap<String, Produto> produtos;
    private ArrayList<Instrumento> instrumentos;
    private ArrayList<Complemento> complementos;
    private ArrayList<Frauta> frautas;
    private ArrayList<Saxofon> saxofons;
    private ArrayList<Trombon> trombons;
    private ArrayList<Libro> libros;
    private ArrayList<Estoxo> estoxos;

    // Constructores
    private TendaMusica(){
        usuarios = new HashMap<>();
        admins = new ArrayList<>();
        clientes = new ArrayList<>();
        produtos = new HashMap<>();
        instrumentos = new ArrayList<>();
        complementos = new ArrayList<>();
        frautas = new ArrayList<>();
        saxofons = new ArrayList<>();
        trombons = new ArrayList<>();
        libros = new ArrayList<>();
        estoxos = new ArrayList<>();
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

    public Optional<Usuario> login(String user, String psswd){
        String hash = HashPassword.hashPassword(psswd);
        for(String u:usuarios.keySet()){
            if(user.equals(u)){
                if(usuarios.get(u).getHash().equals(hash)) return Optional.of(usuarios.get(u));
            }
        }
        return Optional.empty();
    }

    public Optional<Usuario> rexistro(String user, String psswd, String psswd2, boolean admin) throws UsuarioRepetidoExcepcion, ConstrasinalInvalidoExcepcion{
        comprobarUsername(user);
        if (!psswd.equals(psswd2)) return Optional.empty();
        if (admin) {
            Admin novoUser = new Admin(user, psswd);
            admins.add(novoUser);
            engadirUsuario(novoUser);
            return Optional.of(novoUser);
        }
        else {
            Cliente novoUser = new Cliente(user, psswd);
            clientes.add(novoUser);
            engadirUsuario(novoUser);
            return Optional.of(novoUser);
        }
    }

    public boolean isAdmin(Usuario user){
        return admins.contains(user);
    }

    // Para engadir produtos
    public void engadirEstoxo(double prezo, String descricion, int stock, EnumInstrumentos instrumentos, String marca) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion{
        Estoxo novoProd = new Estoxo(prezo, descricion, stock, instrumentos, marca);
        produtos.put(novoProd.getId(), novoProd);
        complementos.add(novoProd);
        estoxos.add(novoProd);
    }
    public void engadirLibro(double prezo, String descricion, int stock, String titulo, String ISBN) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion, ISBNInvalidoExcepcion{
        Libro novoProd = new Libro(prezo, descricion, stock, titulo, ISBN);
        produtos.put(novoProd.getId(), novoProd);
        complementos.add(novoProd);
        libros.add(novoProd);
    }
    public void engadirFrauta(double prezo, String descricion, int stock, String marca, String modelo, boolean pds) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion{
        Frauta novoProd = new Frauta(prezo, descricion, stock, marca, modelo, pds);
        produtos.put(novoProd.getId(), novoProd);
        instrumentos.add(novoProd);
        frautas.add(novoProd);
    }
    public void engadirSaxofon(double prezo, String descricion, int stock, String marca, String modelo, EnumSaxofons tipo) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion{
        Saxofon novoProd = new Saxofon(prezo, descricion, stock, marca, modelo, tipo);
        produtos.put(novoProd.getId(), novoProd);
        instrumentos.add(novoProd);
        saxofons.add(novoProd);
    }
    public void engadirTrombon(double prezo, String descricion, int stock, String marca, String modelo, boolean transpositor) throws PrezoMenorZeroExcepcion, StockMenorZeroExcepcion{
        Trombon novoProd = new Trombon(prezo, descricion, stock, marca, modelo, transpositor);
        produtos.put(novoProd.getId(), novoProd);
        instrumentos.add(novoProd);
        trombons.add(novoProd);
    }

    //Para ver produtos
    public String mostrarLista(ArrayList<Produto> lista){
        String resultado = "";
        for (Produto p:lista){
            resultado += p.toString()+"\n";
        }
        return resultado;
    }
    public String mostrarProdutos(){
        ArrayList<Produto> listaMostrar = new ArrayList<>(produtos.values());
        return mostrarLista(listaMostrar);
    }
    public String mostrarComplementos(){
        ArrayList<Produto> listaMostrar = new ArrayList<>(complementos);
        return mostrarLista(listaMostrar);
    }
    public String mostrarInstrumentos(){
        ArrayList<Produto> listaMostrar = new ArrayList<>(instrumentos);
        return mostrarLista(listaMostrar);
    }
    public String mostrarEstoxos(){
        ArrayList<Produto> listaMostrar = new ArrayList<>(estoxos);
        return mostrarLista(listaMostrar);
    }
    public String mostrarLibros(){
        ArrayList<Produto> listaMostrar = new ArrayList<>(libros);
        return mostrarLista(listaMostrar);
    }
    public String mostrarFrautas(){
        ArrayList<Produto> listaMostrar = new ArrayList<>(frautas);
        return mostrarLista(listaMostrar);
    }
    public String mostrarSaxofons(){
        ArrayList<Produto> listaMostrar = new ArrayList<>(saxofons);
        return mostrarLista(listaMostrar);
    }
    public String mostrarTrombons(){
        ArrayList<Produto> listaMostrar = new ArrayList<>(trombons);
        return mostrarLista(listaMostrar);
    }

    public String mostrarProdId(String idProd) throws IdentificadorInvalidoExcepcion{
        if (!produtos.keySet().contains(idProd)) throw new IdentificadorInvalidoExcepcion("O produto co ID "+idProd+" non existe.");
        return produtos.get(idProd).toString();
    }
    
    public void engadirStock(String idProd, int stock) throws IdentificadorInvalidoExcepcion{
        mostrarProdId(idProd);
        produtos.get(idProd).engadirStock(stock);
    }

    public void eliminarStock(String idProd, int stock) throws IdentificadorInvalidoExcepcion, StockAEliminarInvalido{
        mostrarProdId(idProd);
        produtos.get(idProd).eliminarStock(stock);
    }

    public void comprarProduto(String idProd) throws IdentificadorInvalidoExcepcion, StockAEliminarInvalido, StockInsuficienteExcepcion{
        mostrarProdId(idProd);
        if (produtos.get(idProd).getStock() == 0) throw new StockInsuficienteExcepcion("O produto con ID "+idProd+" non ten suficiente stock para realizar a compra.");
        produtos.get(idProd).eliminarStock(1);
    }

    // Getters & Setters
    public static TendaMusica getInstance(){
        //Se inda non se accedeu, inicializase
        if(INSTANCE == null) {
            INSTANCE = new TendaMusica();
        }
        return INSTANCE;
    }
}
