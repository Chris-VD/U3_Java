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
    /**
     * Comproba que a matrícula sexa válida, método chamado polos constructores e setters
     * @param matricula A matrícula a comprobar
     * @return
     *  -true se a matrícula é válida
     *  -fase se non o é
     */
    public static boolean checkMatricula(String matricula){
        if (matricula.length() != 7) return false;
        String numeros = matricula.substring(0, 4);
        String consonantes = matricula.substring(4, 7);
        if (!consonantes.matches("[A-Z]+") || consonantes.contains("A") || consonantes.contains("E") || consonantes.contains("I")
            || consonantes.contains("O") || consonantes.contains("U")) return false;
        return (numeros.matches("[0-9]+"));
    }

    /**
     * Engade velocidade ó vehículo, se esta é menor que 0, ponlle 0 e se é maior á velocidade máxima, ponlle a velocidade máxima
     * Método chamado por outros métodos cando o usuario queira cambiar a velocidade
     * @param novaVel Cantidade de velocidade a engadir, pode ser negativa
     */
    private void cambioVelocidade(int novaVel){
        this.velocidade = this.velocidade + novaVel;
        if(this.velocidade < 0) this.velocidade = 0;
        if(this.velocidade > VelocidadeMaxima) this.velocidade = VelocidadeMaxima;
    }

    /**
     * Engade 10 á velocidade do vehículo
     */
    public void acelerar(){
        this.cambioVelocidade(10);
    }

    /**
     * Engade x velocidade ó vehículo
     * @param velodicade Cantidade de velocidade a engadir, pode ser negativa
     */
    public void acelerar(int velodicade){
        this.cambioVelocidade(velodicade);
    }

    /**
     * Quitalle 10 á velocidade do vehículo
     */
    public void decelerar(){
        this.cambioVelocidade(-10);
    }

    /**
     * Quítalle x velocidade ó vehículo
     * @param velocidade Cantidade de velocidade a quitar, se esta é negativa, a velocidade engadirase (Dende un punto de vista físico ten sentido)
     */
    public void decelerar(int velocidade){
        this.cambioVelocidade(velocidade * -1);
    }

    // Constructors
    /**
     * Construe o obxeto con todas as súas variables
     * @param matricula A matrícula do vehículo
     * @param marca A marca do vehículo
     * @param modelo O modelo do vehículo
     * @param tipoCombustible O tipo de combustible do vehículo
     * @param velocidade A velocidade do vehículo
     */
    public Vehiculo(String matricula, String marca, String modelo, TipoCombustible tipoCombustible, double velocidade) {
        if (checkMatricula(matricula) == true) this.matricula = matricula;
        else this.matricula = "0000XXX";
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = tipoCombustible;
        this.velocidade = velocidade;
        NumeroTotalVehiculos ++;
    }

    /**
     * Contrue o obeto cando non se especifica a velocidade á que vai, está ponse por defecto a 0
     * @param matricula A matrícula do vehículo
     * @param marca A marca do vehículo
     * @param modelo O modelo do vehículo
     * @param tipoCombustible O tipo de combustible do vehículo
     */
    public Vehiculo(String matricula, String marca, String modelo, TipoCombustible tipoCombustible) {
        this(matricula, marca, modelo, tipoCombustible, 0);
    }
    
    /**
     * Construe o obxeto cando non se especifican nin a velocidade nin o tipo de combustible
     * A velocidade por defecto será 0 e o tipo de combistible gasolina
     * @param matricula A matrícula do vehículo
     * @param marca A marca do vehículo
     * @param modelo O modelo do vehículo
     */
    public Vehiculo(String matricula, String marca, String modelo) {
        this(matricula, marca, modelo, TipoCombustible.GASOLINA);
    }

    // Getters & Setters
    public String getMatricula() {
        return matricula;
    }

    /**
     * Antes de asignar a matrícula, comproba que sexa válida
     * Se non o é, asignará o valor por feceto "0000XXX"
     * @param matricula A matrícula do vehículo
     */
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
