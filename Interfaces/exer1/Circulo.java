import java.lang.Math;

public class Circulo implements Figura{
    public int radio;
    public int X;
    public int Y;

    public Circulo(int radio, int X, int Y){
        this.setRadio(radio);
        this.setX(X);
        this.setY(Y);
    }
    public Circulo(int radio){
        this.setRadio(radio);
        this.setX(0);
        this.setY(0);
    }

    public double calcularArea(){
        return Math.PI * Math.pow(radio, 2);
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        if (radio < 0) this.radio = 0;
        else this.radio = radio;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        if (x < 0) this.X = 0;
        else this.X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        if (y < 0) this.Y = 0;
        else this.Y = y;
    }

    
}
