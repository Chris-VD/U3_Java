package exer4;

import arbores.ArboreBinariaBusca;

/**
 * Class App
 */
public class App {
    public static void main(String[] args) {
        ArboreBinariaBusca<String> novaABB = new ArboreBinariaBusca<>();
        novaABB.engadirElemento("Messi");
        novaABB.engadirElemento("Ronaldo");
        novaABB.engadirElemento("Neymar");
        novaABB.engadirElemento("Haaland");
        novaABB.engadirElemento("Mbappé");
        novaABB.engadirElemento("Ibrahimovic");
        novaABB.engadirElemento("Lewandowsky");
        novaABB.engadirElemento("Ramos");
        novaABB.engadirElemento("De Bruyne");
        novaABB.engadirElemento("Salah");
        
        for (String xogador:novaABB){
            System.out.println(xogador);
        }
    }
}
