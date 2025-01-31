package concesionario;
import utils.TipoCombustible;

public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private TipoCombustible tipoCombustible;
    private double velocidade;
    private static int NumeroTotalVehiculos = 0;
    private static int VelocidadeMaxima = 120;

    // Methods
    public static boolean checkMatricula(String matricula){
        if (matricula.length() != 7) return false;
        String numeros = matricula.substring(0, 4);
        String consonantes = matricula.substring(4, 7);
        if (consonantes.matches("[A-Z]") || consonantes.contains("A") || consonantes.contains("E") || consonantes.contains("I")
            || consonantes.contains("O") || consonantes.contains("U")) return false;
        return (numeros.matches("[0-9]+"));
    }

    private void cambioVelocidade(int novaVel){
        this.velocidade = this.velocidade + novaVel;
        if(this.velocidade < 0) this.velocidade = 0;
        if(this.velocidade > VelocidadeMaxima) this.velocidade = VelocidadeMaxima;
    }

    public void acelerar(){
        this.cambioVelocidade(10);
    }

    public void acelerar(int velodicade){
        this.cambioVelocidade(velodicade);
    }

    public void decelerar(){
        this.cambioVelocidade(-10);
    }

    public void decelerar(int velocidade){
        this.cambioVelocidade(velocidade * -1);
    }

    // Constructors
    public Vehiculo(String matricula, String marca, String modelo, TipoCombustible tipoCombustible, double velocidade) {
        if (checkMatricula(matricula) == true) this.matricula = matricula;
        else this.matricula = "0000XXX";
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.velocidade = velocidade;
        NumeroTotalVehiculos ++;
    }

    public Vehiculo(String matricula, String marca, String modelo, TipoCombustible tipoCombustible) {
        this(matricula, marca, modelo, tipoCombustible, 0);
    }
    
    public Vehiculo(String matricula, String marca, String modelo) {
        this(matricula, marca, modelo, TipoCombustible.GASOLINA);
    }

    // Getters & Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (checkMatricula(matricula) == true) this.matricula = matricula;
        else this.matricula = "0000XXX";
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

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public static int getNumeroTotalVehiculos() {
        return NumeroTotalVehiculos;
    }

    public static int getVelocidadeMaxima() {
        return VelocidadeMaxima;
    }

    public static void setVelocidadeMaxima(int VelocidadeMaxima) {
        Vehiculo.VelocidadeMaxima = VelocidadeMaxima;
    }
}
