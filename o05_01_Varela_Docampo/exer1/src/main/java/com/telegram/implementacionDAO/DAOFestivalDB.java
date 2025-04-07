package com.telegram.implementacionDAO;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.telegram.interfaceDAO.DAOFestival;
import com.telegram.miscUtil.engadirFestivales;
import com.telegram.modelo.Festival;
import com.telegram.modelo.Provincia;

public class DAOFestivalDB implements DAOFestival {
    
    // Aquí é onde está o ficheiro da base de datos
    private static final String URL_DB = "jdbc:sqlite:festivais.db";

    /**
     * Construtor da clase
     */
    public DAOFestivalDB() {
        // Se non existe o ficheiro da base de datos creao
        if (!existeBaseDeDatos()) {
            // Crear a base de datos e insertar os festivais se non existen
            System.out.println("Creando a base de datos");
            crearBaseDeDatos();
            System.out.println("Engadindo datos");
            insertarFestivaisSeNonExisten();
            System.out.println("Carga finalizada");
        }
        else {
            // System.out.println("Reiniciando a DB...");
            // File DBtxt = new File("festivais.db");
            // DBtxt.delete();
            // new DAOFestivalDB();
            System.out.println("Base de datos atopada");
        }
    }

    /**
     * Comproba que existe a base de datos
     * @return
     */
    private boolean existeBaseDeDatos() {
        File dbFile = new File("festivais.db");
        return dbFile.exists();
    }

    /**
     * Crea as táboas senón existen
     */
    private void crearBaseDeDatos() {
        String crearProvincias = "CREATE TABLE IF NOT EXISTS Provincias ("
                                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                                + "nome TEXT NOT NULL);";

        String crearFestivais = "CREATE TABLE IF NOT EXISTS Festivais ("
                                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                                + "nome TEXT NOT NULL, "
                                + "poboacion TEXT NOT NULL, "
                                + "provincia_id INTEGER NOT NULL, "
                                + "data_comenzo DATE NOT NULL, "
                                + "data_fin DATE NOT NULL, "
                                + "FOREIGN KEY (provincia_id) REFERENCES Provincias(id));";

        try {
            Connection conn = DriverManager.getConnection(URL_DB);
            Statement stmt = conn.createStatement();
            stmt.execute(crearProvincias);
            stmt.execute(crearFestivais);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Engade os datos se non existen
     */
    private void insertarFestivaisSeNonExisten() {
        // Inserir provincias
        String[] provincias = {"A Coruña", "Lugo", "Ourense", "Pontevedra"};
        try {
            Connection conn = DriverManager.getConnection(URL_DB);
            String inserirProvincia = "INSERT OR IGNORE INTO Provincias (nome) VALUES (?);";
            PreparedStatement ps = conn.prepareStatement(inserirProvincia);
            
            for (String provincia : provincias) {
                ps.setString(1, provincia);
                ps.executeUpdate();
            }

            String inserirFestivais = "INSERT OR IGNORE INTO Festivais (nome, poboacion, provincia_id, data_comenzo, data_fin) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement psF = conn.prepareStatement(inserirFestivais);
            ArrayList<Festival> festivales = engadirFestivales.getFestivales();
            // System.out.println("\nEngadindo datos...");
            for (Festival f:festivales) {
                psF.setString(1, f.getNome());
                psF.setString(2, f.getPoboacion());
                psF.setInt(3, this.getProv(f.getProvincia()));
                psF.setDate(4, new java.sql.Date(Date.from(f.getInicio().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()));
                psF.setDate(5, new java.sql.Date(Date.from(f.getFin().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime()));
                psF.executeUpdate();
                // System.out.println("Engadido "+ f.getNome() +", data - "+f.getInicio());
            }
            // System.out.println("Finalizado.\n");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private Integer getProv(Provincia prov){
        for(Map.Entry<Integer, Provincia> entry: Provincia.provinciasHM.entrySet()) {
            if(entry.getValue() == prov) {
                return entry.getKey();
            }
        }
        return 0;
    }

    @Override
    public List<Festival> getFestivales() {
        String select = "SELECT nome, poboacion, provincia_id, data_comenzo, data_fin FROM Festivais";
        ArrayList<Festival> festivais = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while (rs.next()){
                Provincia prov = null;
                prov = Provincia.provinciasHM.get(rs.getInt("provincia_id"));
                // REVIEW Esto pode que non funcione que non sei exactamente como se gardan as Dates na base de datos e a covnersión a Localdate é rara
                festivais.add(new Festival(rs.getString("nome"), rs.getString("poboacion"), prov, rs.getDate("data_comenzo", Calendar.getInstance()).toLocalDate(), rs.getDate("data_fin", Calendar.getInstance()).toLocalDate()));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return festivais;
    }

    @Override
    public Festival getProximoFestival() {
        Festival festival = null;
        LocalDate dataLim = LocalDate.of(2030, 1, 1);
        for (Festival f:this.getFestivales()){
            if (f.getInicio().isBefore(dataLim)){
                dataLim = f.getInicio();
                festival = f;
            }
        }
        return festival;
    }

    @Override
    public List<Festival> getFestivaisProvincia(Provincia provincia) {
        ArrayList<Festival> festivais = new ArrayList<>();
        for (Festival f:this.getFestivales()){
            if (f.getProvincia() == provincia){
                festivais.add(f);
            }
        }
        return festivais;
    }
}