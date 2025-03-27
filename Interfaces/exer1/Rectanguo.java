public class Rectanguo implements Figura{
    private int base;
    private int altura;

    public Rectanguo(int base, int altura){
        this.setBase(base);
        this.setAltura(altura);
    }

    public double calcularArea(){
        return this.altura * this.base;
    }

    public void setBase(int base){
        if (base < 0) this.base = 0;
        else this.base = base;
    }

    public void setAltura(int altura){
        if (altura < 0) this.altura = 0;
        else this.altura = altura;
    }

    public int getBase(){
        return this.base;
    }

    public int getAltura(){
        return this.altura;
    }
}
