package exer3;

public class exer3 {
    public static void main(String[] args) {
        Rectangulo rectangulo1 = new Rectangulo(7.5,3);
        Rectangulo rectangulo2 = new Rectangulo(10,5);

        System.out.println("Perímetros: "+rectangulo1.perimetro()+", "+rectangulo2.perimetro());
        System.out.println("Área: "+rectangulo1.area()+", "+rectangulo2.area());
    }
}
