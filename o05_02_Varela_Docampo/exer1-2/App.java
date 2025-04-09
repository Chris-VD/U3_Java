public class App {
    public static void main(String[] args){
        ArboreBinariaBusca<Xogador> abb = new ArboreBinariaBusca<>();
        abb.engadirElemento(new Xogador("Lionel Messi", 10));
        abb.engadirElemento(new Xogador("Cristian Ronaldo", 7));
        abb.engadirElemento(new Xogador("Neymar Jr.", 11));
        abb.engadirElemento(new Xogador("Kylian Mbappé", 19));
        abb.engadirElemento(new Xogador("Zlatan Ibrahimović", 8));
        abb.engadirElemento(new Xogador("Robert Lewandowski", 9));
        abb.engadirElemento(new Xogador("Sergio Ramos", 4));
        abb.engadirElemento(new Xogador("Kevin De Bruyne", 17));
        abb.engadirElemento(new Xogador("Mohamed Salah", 21));
        abb.engadirElemento(new Xogador("Erling Haaland", 99));

        for (Xogador xog:abb.recorridoInOrde()){
            System.out.println(xog.toString());
        }

        System.out.println();

        for(Xogador xogador:abb) {
            System.out.println(xogador);
        }
    }
}
