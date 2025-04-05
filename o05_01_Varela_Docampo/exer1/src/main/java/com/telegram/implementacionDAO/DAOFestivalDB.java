package com.telegram.implementacionDAO;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

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
            ps = conn.prepareStatement(inserirFestivais);
            ArrayList<Festival> festivales = engadirFestivales.getFestivales();

            for (Festival f:festivales) {
                // FIXME provincia_id? tipo de datos para as datas?
                ps.setString(1, f.getNome(), f.getPoboacion(), prov_id, f.getInicio(), f.getFin());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
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
                switch (rs.getInt("provincia_id")) {
                    case 1 ->{
                        prov = Provincia.ACORUÑA;
                    }
                    case 2 ->{
                        prov = Provincia.LUGO;
                    }
                    case 3 ->{
                        prov = Provincia.OURENSE;
                    }
                    case 4 ->{
                        prov = Provincia.PONTEVEDRA;
                    }
                }
                // FIXME Esto pode que non funcione que non sei exactamente como se gardan as Dates na base de datos e a covnersión a Localdate é rara
                festivais.add(new Festival(rs.getString("nome"), rs.getString("poboacion"), prov, (LocalDate) rs.getDate("data_comenzo", null).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), rs.getDate("data_fin", null).toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
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