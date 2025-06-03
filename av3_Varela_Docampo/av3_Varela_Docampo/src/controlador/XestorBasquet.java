package controlador;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

import modelo.Admin;
import modelo.Base;
import modelo.Equipo;
import modelo.Exterior;
import modelo.Interior;
import modelo.LoginInterfaz;
import modelo.Xogador;
import modelo.Enums.ProvinciasEnum;
import modelo.Enums.RolesEnum;
import modelo.Excepcions.ConstrasinalInvalidoExcepcion;
import modelo.Excepcions.CorreoInexistente;
import modelo.Excepcions.CorreoInvalidoExcepcion;
import modelo.Excepcions.CorreoRepetidoExcepcion;
import modelo.Excepcions.EquipoInvalidoExcepcion;
import modelo.Excepcions.XogadorNonLibreExcepcion;
import modelo.Excepcions.XogadoresCheosExcepcion;
import utils.Utils;

public class XestorBasquet implements Serializable{
    // Para gardar os datos en archivo binario
    public static final String FILENAME = "datos.bin";
    private static final long serialVersionUID = 1L;

    // Instancia da propia clase que será única
    private static XestorBasquet INSTANCE;

    // Atributos da clase
    private HashMap<String, LoginInterfaz> logins; // Array con todos os posible slogins (tanto usuarios como equipos)
    private ArrayList<Xogador> xogadores;
    private ArrayList<Equipo> equipos;

    // O constructor privado non permite que se xere un constructor por defecto
    private XestorBasquet(){
        // Inicializamos os atributos da clase
        this.logins = new HashMap<>();
        this.xogadores = new ArrayList<>();
        this.equipos = new ArrayList<>();
        engadirDatos();
    }

    // Metodo publico e estatico para poder acceder aos métodos da clase
    public static XestorBasquet getInstance(){
        //Se inda non se accedeu, inicializase
        if(INSTANCE == null) {
            try {
                Optional<XestorBasquet> lectura = load();
                if (lectura.isEmpty()){
                    INSTANCE = new XestorBasquet();
                    save();
                }
                else {
                    INSTANCE = lectura.get();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return INSTANCE;
    }

    // Gardado e carga de datos
    public static void save(){
        try{
            FileOutputStream ficheiro = new FileOutputStream(FILENAME);
            ObjectOutputStream obxeto = new ObjectOutputStream(ficheiro);
            obxeto.writeObject(INSTANCE);
            obxeto.close();
            ficheiro.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Optional<XestorBasquet> load(){
        try{
            FileInputStream ficheiro = new FileInputStream(FILENAME);
            ObjectInputStream obxeto = new ObjectInputStream(ficheiro);
            XestorBasquet xestor = (XestorBasquet) obxeto.readObject();
            obxeto.close();
            ficheiro.close();
            return Optional.of(xestor);
        } catch(Exception e){
            return Optional.empty();
        }
    }

    // Esto permite que non se clone o obxecto
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    // Para engadir datos ó crear a instancia
    public void engadirDatos(){
        Admin novoAdmin = null;
        try {
            novoAdmin = new Admin("admin@fgb.gal", "fgb");   
        } catch (Exception e) {} // Fagoo tan xenérico porque nunca vai saltar a excepción ó ser datos controlados os que se insertan, no rexistro normal non é así
        this.logins.put(novoAdmin.getCorreo(), novoAdmin);
    }

    // Metodos da clase
    public boolean comprobarCorreoExiste(String correo){
        for (String c: logins.keySet()){
            if (correo.equals(c)) return true;
        }
        return false;
    }

    public Optional<LoginInterfaz> login(String correo, String psswd){
        String hash = Utils.hashPassword(psswd);
        for(String c:logins.keySet()){
            if(correo.equals(c)){
                if(logins.get(c).getHash().equals(hash)) return Optional.of(logins.get(c));
            }
        }
        return Optional.empty();
    }

    // Rexistro xeral
    public Optional<LoginInterfaz> rexistro(String nome, String correo, String psswd, String cidade, RolesEnum pos)
        throws CorreoInvalidoExcepcion, ConstrasinalInvalidoExcepcion, CorreoRepetidoExcepcion, EquipoInvalidoExcepcion {
        if(pos != null && comprobarCorreoExiste(correo)) throw new CorreoRepetidoExcepcion("O correo "+correo+" xa está en uso");
        LoginInterfaz novoLogin;
        if (pos == RolesEnum.BASE) novoLogin = new Base(nome, correo, psswd);
        else if (pos == RolesEnum.INTERIOR) novoLogin = new Interior(nome, correo, psswd);
        else if (pos == RolesEnum.EXTERIOR) novoLogin = new Exterior(nome, correo, psswd);
        else {
            HashMap<String, ProvinciasEnum> infoCSV = getInfoCSV();
            for(Equipo equipo:equipos){
                if (equipo.getNome() == nome && equipo.getProvinciaRaw() == infoCSV.get(cidade)) throw new EquipoInvalidoExcepcion("O equipo con nome "+nome+" de "+cidade+" xa existe.");
            }
            novoLogin = new Equipo(nome, cidade, "fgb",infoCSV.get(cidade));
            logins.put(novoLogin.getCorreo(), novoLogin);
            equipos.add((Equipo)novoLogin);
            return Optional.of(novoLogin);
        }
        logins.put(novoLogin.getCorreo(), novoLogin);
        xogadores.add((Xogador)novoLogin);
        save();
        return Optional.of(novoLogin);
    }
    // Rexistro xogador
    public Optional<LoginInterfaz> rexistro(String nome, String correo, RolesEnum pos)
        throws CorreoInvalidoExcepcion, ConstrasinalInvalidoExcepcion, CorreoRepetidoExcepcion, EquipoInvalidoExcepcion{
        return rexistro(nome, correo, "abc123.", null, pos);
    }
    // Rexistro equipo
    public Optional<LoginInterfaz> rexistro(String nome, String cidade)
        throws CorreoInvalidoExcepcion, ConstrasinalInvalidoExcepcion, CorreoRepetidoExcepcion, EquipoInvalidoExcepcion{
        return rexistro(nome, null, "fgb", cidade, null);
    }

    // Facer oferta
    public void facerOferta(Equipo equipo, String correo)
    throws XogadorNonLibreExcepcion, CorreoInexistente, CorreoInvalidoExcepcion{
        if (!comprobarCorreoExiste(correo)) throw new CorreoInexistente("O correo "+correo+" non existe ou non está rexistrado.");
        RolesEnum rol = logins.get(correo).getRol();
        if (rol != RolesEnum.BASE && rol != RolesEnum.EXTERIOR && rol != RolesEnum.INTERIOR)
            throw new CorreoInvalidoExcepcion("O correo "+correo+" non é dun xogador existente."); // Ten que haber maneira mellor de facer esto pero que pereza en verdade, se lle engadira algun novo atributo sería tirado pq instanceof non furula pero bue
        Xogador xogador = (Xogador) logins.get(correo);
        if (xogador.getEquipo() != null) throw new XogadorNonLibreExcepcion("O xogador "+xogador.getNome()+" non está libre.");
        xogador.engadirOferta(equipo);
        save();
    }

    // Aceptar oferta
    public void aceptarOferta(Xogador xogador, String nome, String cidade)
    throws XogadorNonLibreExcepcion, EquipoInvalidoExcepcion, XogadoresCheosExcepcion{
        if (xogador.getEquipo() != null) throw new XogadorNonLibreExcepcion("Xa pertences a un equipo");
        for (Equipo equipo:equipos){
            if (equipo.getCidade().equals(cidade) && equipo.getNome().equals(nome)) {
                xogador.setEquipo(equipo);
                save();
                return;
            }
        }
        throw new EquipoInvalidoExcepcion("O equipo que intentas aceptar non existe, introduza de novo os datos");
    }

    // Xogar partido
    public void xogarPartido(Equipo equipo){
        equipo.xogarPartido();
        save();
    }

    // Xogadores libres
    public String verXogadoresLibres(){
        return xogadores.stream()
                        .filter(xogador -> xogador.getEquipo() == null)
                        .sorted((x1, x2) -> {
                            if (x1.getNome().equals(x2.getNome())) return x1.getPuntos() > x2.getPuntos() ? 1:-1;
                            else return x1.getNome().compareTo(x2.getNome());
                        }) // Este sorted xa debería pilla como criterio o compareTo que está definido en Xogador pero engadinlle o comparator por si acaso
                        .map(xogador -> xogador.toString())
                        .collect(Collectors.joining("\n"));
    }

    // Xogadores de equipo
    public String verXogadoresEquipo(Equipo equipo){
        return equipo.getXogadores().stream()
                                    .map(xogador -> xogador.toString())
                                    .collect(Collectors.joining("\n"));
    }

    // Ver ofertas
    public String verOfertas(Xogador xogador){
        return xogador.getOfertas().stream()
                                    .map(equipo->equipo.toString())
                                    .collect(Collectors.joining("\n"));
    }

    public HashMap<String, ProvinciasEnum> getInfoCSV(){
        String rutaFicheiro = "lib/provincias.csv";
        HashMap<String, ProvinciasEnum> datos = new HashMap<>();
        // Try con resources
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaFicheiro))) {
            reader.readLine(); // Saltamos a prieira liña
            String liña;
            while ((liña = reader.readLine()) != null) {
                // Separar a liña en campos usando a coma como delimitador
                String[] campos = liña.split(",");
                ProvinciasEnum prov;
                switch (campos[1]) {
                    case "A Coruña" ->{
                        prov = ProvinciasEnum.ACORUNA;
                    }
                    case "Lugo" ->{
                        prov = ProvinciasEnum.LUGO;
                    }
                    case "Pontevedra" ->{
                        prov = ProvinciasEnum.PONTEVEDRA;
                    }
                    case "Ourense" ->{
                        prov = ProvinciasEnum.OURENSE;
                    }
                    default -> {
                        prov = ProvinciasEnum.ACORUNA;
                    }
                }
                datos.put(campos[0], prov);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
}
