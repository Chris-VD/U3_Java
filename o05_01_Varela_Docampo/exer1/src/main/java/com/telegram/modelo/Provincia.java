package com.telegram.modelo;

import java.util.HashMap;

public enum Provincia {
    ACORUÑA,
    LUGO,
    PONTEVEDRA,
    OURENSE;

    public static final HashMap<Integer, Provincia> provinciasHM = new HashMap<Integer, Provincia>(){{
        put(1,Provincia.ACORUÑA);
        put(2,Provincia.LUGO);
        put(3,Provincia.OURENSE);
        put(5,Provincia.PONTEVEDRA);
    }};
}

