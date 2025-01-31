package exer2;

public class Coche{
    private String marca;
    private String modelo;
    private String cor;
    private int pasaxeiros;

    public Coche(String marca, String modelo, String cor, int pasaxeiros) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.pasaxeiros = pasaxeiros;
    }

    public Coche(String marca, String modelo, String cor){
        this(marca, modelo, cor, 5);
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public int getPasaxeiros() {
        return pasaxeiros;
    }
    public void setPasaxeiros(int pasaxeiros) {
        this.pasaxeiros = pasaxeiros;
    }

    
}