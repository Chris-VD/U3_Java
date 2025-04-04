package com.telegram.implementacionDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.telegram.interfaceDAO.DAOFestival;
import com.telegram.miscUtil.engadirFestivales;
import com.telegram.modelo.Festival;
import com.telegram.modelo.Provincia;

public class DAOFestivalMemoria implements DAOFestival{
    private ArrayList<Festival> festivales;

    public DAOFestivalMemoria(){
        this.festivales = engadirFestivales.getFestivales();
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
