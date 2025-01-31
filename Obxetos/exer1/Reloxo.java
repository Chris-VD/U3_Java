package exer1;

public class Reloxo {
    private String marca;
    private String modelo;
    private int prezo;
    private boolean analoxico;

    Reloxo(String marca, String modelo, int prezo, boolean analoxico){
        this.marca = marca;
        this.modelo = modelo;
        this.prezo = prezo;
        this.analoxico = analoxico;
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
    public int getPrezo() {
        return prezo;
    }
    public void setPrezo(int prezo) {
        this.prezo = prezo;
    }
    public boolean isAnaloxico() {
        return analoxico;
    }
    public void setAnaloxico(boolean analoxico) {
        this.analoxico = analoxico;
    }
}
