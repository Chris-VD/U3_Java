public class Factura {
    private static int contador;
    private int numero;
    private String DNI;
    private double cantidade;

    // Constructor
    public Factura(String DNI, double cantidade) throws ExcepcionDNIInvalido, ExcepcionNumeroNegativo{
        this.setCantidade(cantidade);
        this.setDNI(DNI);
        this.setNumero();
    }

    // Métodos
    @Override
    public String toString(){
        return this.getNumero()+": "+this.getDNI()+" -> "+this.getCantidade()+"€";
    }

    // Getters & Setters
    public int getNumero() {
        return numero;
    }
    private void setNumero() {
        contador++;
        this.numero = contador;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dNI) throws ExcepcionDNIInvalido{
        if (!ExcepcionDNIInvalido.comprobarDNI(dNI)) throw new ExcepcionDNIInvalido("O DNI é inválido");
        else this.DNI = dNI;
    }
    public double getCantidade() {
        return cantidade;
    }
    public void setCantidade(double cantidade) throws ExcepcionNumeroNegativo{
        if (cantidade < 0) throw new ExcepcionNumeroNegativo("A cantidade non pode ser negativa");
        else this.cantidade = cantidade;
    }
    
}
