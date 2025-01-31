package exer3;

public class Rectangulo {
    private double alto;
    private double longo;

    public Rectangulo(double alto, double longo) {
        this.alto = alto;
        this.longo = longo;
    }

    public double getalto() {
        return alto;
    }
    public void setalto(double alto) {
        this.alto = alto;
    }
    public double getLongo() {
        return longo;
    }
    public void setLongo(double longo) {
        this.longo = longo;
    }

    public double perimetro(){
        double perimetro = this.alto * 2 + this.longo * 2;
        return perimetro;
    }
    public double area(){
        double area = this.alto * this.longo;
        return area;
    }
}
