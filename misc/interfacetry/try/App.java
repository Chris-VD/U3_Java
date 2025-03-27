import java.util.ArrayList;

public class App{  
    public static void main(String[] args){
        CocheE electrico = new CocheE();
        CocheG gasolina = new CocheG();
        ArrayList<Coche> coches = new ArrayList<>();
        coches.add(electrico);
        coches.add(gasolina);

        for (Coche c:coches){
            if (c instanceof ICocheG){
                ((CocheG)c).gasolina();
            }
            else System.out.println("Non son gasolinax");
        }
    }
}