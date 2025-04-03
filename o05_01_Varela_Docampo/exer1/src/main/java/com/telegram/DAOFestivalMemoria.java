package com.telegram;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOFestivalMemoria implements DAOFestival{
    private ArrayList<Festival> festivales;

    public void engadirDatos(){
        festivales.add(new Festival("A Candeloria", "Lugo", Provincia.LUGO, LocalDate.of(2025, 4, 4), LocalDate.of(2025, 4, 5)));
        festivales.add(new Festival("Festival Jaleo!", "Santiago de Compostela", Provincia.ACORUÑA, LocalDate.of(2025, 4, 5), LocalDate.of(2025, 4, 5)));
        festivales.add(new Festival("Resurrection Fest", "Viveiro", Provincia.LUGO, LocalDate.of(2025, 6, 25), LocalDate.of(2025, 6, 28)));
        festivales.add(new Festival("Festival Internacional do Mundo Celta", "Ortigueira",
            Provincia.ACORUÑA, LocalDate.of(2025, 7, 9), LocalDate.of(2025, 7, 13)));
        festivales.add(new Festival("Arcanxo Festival", "Ponteareas", Provincia.PONTEVEDRA, LocalDate.of(2025, 7, 18), LocalDate.of(2025, 7, 19)));
        festivales.add(new Festival("Festival Noroeste Estrella Galicia", "A Coruña",
            Provincia.ACORUÑA, LocalDate.of(2025, 8, 7), LocalDate.of(2025, 8, 9)));
        festivales.add(new Festival("Festival de Ortigueira", "Ortigueira", Provincia.ACORUÑA, LocalDate.of(2025, 7, 9), LocalDate.of(2025, 7, 13)));
        festivales.add(new Festival("Festival da Luz", "Boimorto", Provincia.ACORUÑA, LocalDate.of(2025, 8, 21), LocalDate.of(2025, 8, 23)));
        festivales.add(new Festival("Festival da Canción de Sada", "Sada", Provincia.ACORUÑA, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 5)));
    }

    @Override
    public List<Festival> getFestivales() {
        return festivales;
    }

    @Override
    public Festival getProximoFestival() {
        Festival proximo = null;
        LocalDate data = LocalDate.of(2030, 1, 1);
        for (Festival f:festivales){
            if (f.getInicio().isBefore(data)){
                proximo = f;
                data = f.getInicio();
            }
        }
        return proximo;
    }

    @Override
    public List<Festival> getFestivaisProvincia(Provincia provincia) {
        ArrayList<Festival> festProv = new ArrayList<>();
        for (Festival f:festivales){
            if (f.getProvincia() == provincia) festProv.add(f);
        }
        return festProv;
    }
}
