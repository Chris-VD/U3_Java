import java.util.ArrayList;

import abstracts.*;
import classes.*;
import ernums.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Estruturas de datos
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        ArrayList<Componhente> componhentes = new ArrayList<Componhente>();
        ArrayList<Periferico> perifericos = new ArrayList<Periferico>();
        ArrayList<Procesador> procesadores = new ArrayList<Procesador>();
        ArrayList<PlacaBase> placasbase = new ArrayList<PlacaBase>();
        ArrayList<MemoriaRam> memorias = new ArrayList<MemoriaRam>();
        ArrayList<Monitor> monitores = new ArrayList<Monitor>();
        ArrayList<Teclado> teclados = new ArrayList<Teclado>();

        // Procesadores
        Procesador amd = new Procesador("AMD", "7600X", 219.99, Zocalo.AM5, 6);
        Procesador intel = new Procesador("Intel", "i5-12400F", 117.99, Zocalo.LGA1700, 6);
        produtos.add(amd);
        produtos.add(intel);
        componhentes.add(amd);
        componhentes.add(intel);
        procesadores.add(amd);
        procesadores.add(intel);

        // Placas base
        PlacaBase msi = new PlacaBase("MSI", "MAG B650 TOMAHAWK", 189.99, Zocalo.AM5);
        PlacaBase asus = new PlacaBase("ASUS", "PRIME B760-PLUS", 125.99, Zocalo.LGA1700);
        produtos.add(msi);
        produtos.add(asus);
        componhentes.add(msi);
        componhentes.add(asus);
        placasbase.add(msi);
        placasbase.add(asus);

        //Memorias RAM
        MemoriaRam acer = new MemoriaRam("ACER", "Predator Vesta II", 125.99, 6, 16);
        MemoriaRam corsair = new MemoriaRam("Corsair", "Corsair Vengeance", 139.98, 6.4, 16);
        produtos.add(acer);
        produtos.add(corsair);
        componhentes.add(acer);
        componhentes.add(corsair);
        memorias.add(acer);
        memorias.add(corsair);

        //Monitores
        Monitor alurin = new Monitor("Alurin", "CoreVision", 84.99, 23.8);
        alurin.addConector(Conector.HDMI);
        alurin.addConector(Conector.VGA);
        Monitor aoc = new Monitor("AOC", "C27G4ZXE", 169.99, 27);
        aoc.addConector(Conector.DisplayPort);
        produtos.add(alurin);
        produtos.add(aoc);
        perifericos.add(alurin);
        perifericos.add(aoc);
        monitores.add(alurin);
        monitores.add(aoc);

        // Teclados
        Teclado pccom = new Teclado("PcCom", "Essential Combo Low Profile", 13.99);
        pccom.addConector(Conector.USB);
        Teclado tempest = new Teclado("Tempest", "Oblivion", 25.39);
        tempest.addConector(Conector.PS2);
        produtos.add(pccom);
        produtos.add(tempest);
        perifericos.add(pccom);
        perifericos.add(tempest);
        teclados.add(pccom);
        teclados.add(tempest);

        //Imprimimos as listas
        App.imprimirLista(produtos);
        App.imprimirLista(componhentes);
        App.imprimirLista(perifericos);
        App.imprimirLista(procesadores);
        App.imprimirLista(placasbase);
        App.imprimirLista(memorias);
        App.imprimirLista(monitores);
        App.imprimirLista(teclados);
    }

    @SuppressWarnings("rawtypes")
    private static void imprimirLista(ArrayList lista) {
        for(Object obj: lista){
            System.out.println(obj);
        }
        System.out.println("----------");
    }

}