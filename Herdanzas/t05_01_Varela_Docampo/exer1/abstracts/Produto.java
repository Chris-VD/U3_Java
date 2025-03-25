package abstracts;
public abstract class Produto {
    private String marca;
    private String modelo;
    private double prezo;

    // Constructores
    public Produto(String marca, String modelo, double prezo){
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPrezo(prezo);
    }

    // Métodos
    @Override
    public String toString(){
        return this.getMarca()+" "+this.getModelo()+" Prezo: "+this.getPrezo()+"€";
    }

    @Override
    public boolean equals(Object obj){
        Produto object = (Produto) obj;
        if (this.modelo == object.getModelo() && this.marca == object.getMarca()) return true;
        else return false;
    }

    // Getters & Setters
    public String getMarca() {
        return marca;
    }
    private void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    private void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public double getPrezo() {
        return prezo;
    }
    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }
}
