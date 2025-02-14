package exer2;

import java.util.HashMap;

public class Rexistro {
    private static HashMap<String, String> rexistros;

    public static void addRex(String nome, String hash){
        rexistros.put(nome, hash);
    }
}
