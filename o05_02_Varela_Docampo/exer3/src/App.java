import arbores.ArboreBinariaBusca;

public class App {
    public static void main(String[] args) throws Exception {
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
