package com.telegram.interfaceDAO;

import java.util.List;

import com.telegram.modelo.Festival;
import com.telegram.modelo.Provincia;

public interface DAOFestival {
    List<Festival> getFestivales();
    Festival getProximoFestival();
    List<Festival> getFestivaisProvincia(Provincia provincia);
}
