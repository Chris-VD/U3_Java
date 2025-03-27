import java.util.ArrayList;

public class App {
    public static void main(String[] args){
        ArrayList<Figura> figuras = new ArrayList<>();
        Rectanguo novoRectanguo = new Rectanguo(5, 6);
        Circulo novCirculo = new Circulo(7);
        figuras.add(novCirculo);
        figuras.add(novoRectanguo);

        for (Figura f:figuras){
            System.out.println(f.calcularArea());
        }
    }
}
