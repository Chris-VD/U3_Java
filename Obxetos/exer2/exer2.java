package exer2;

public class exer2 {
    public static void main(String[] args) {
        Coche coche1 = new Coche("Seat", "Ibiza", "Vermello");
        Coche coche2 = new Coche("Seat", "Leon", "Negro", 3);
        System.out.println(coche1.getMarca()+" "+coche1.getModelo()+": "+coche1.getCor());
        System.out.println(coche2.getMarca()+" "+coche2.getModelo()+": "+coche2.getCor());
        coche2.setCor("Azul");
        System.out.println(coche2.getMarca()+" "+coche2.getModelo()+": "+coche2.getCor());
    }    
}
