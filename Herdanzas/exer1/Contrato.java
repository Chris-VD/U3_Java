public class Contrato {
    private static int contador;
    private int numero;
    private String nome;
    private String apelidos;
    private int salarioBrutoAnual;
    private double IRPF;

    // Constructor
    public Contrato(String nome, String apelidos, int salarioBrutoAnual, double IRPF){
        this.setNome(nome);
        this.setApelidos(apelidos);
        this.setSalarioBrutoAnual(salarioBrutoAnual);
        this.setIRPF(IRPF);
        contador++;
        this.numero = contador;
    }

    // Métodos
    public double getSalarioNetoAnual(){
        return this.salarioBrutoAnual * ((100-this.IRPF)/100);
    }

    public double getSalarioMensualNeto(){
        return this.getSalarioNetoAnual()/12;
    }

    @Override
    public String toString(){
        return this.getNome()+": "+this.getApelidos()+", "+this.getNome()+". Salario mensual: "+this.getSalarioMensualNeto();
    }

    // Getters & Setters
    public int getNumero() {
        return numero;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getApelidos() {
        return apelidos;
    }
    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }
    public int getSalarioBrutoAnual() {
        return salarioBrutoAnual;
    }
    public void setSalarioBrutoAnual(int salarioBrutoAnual) {
        if (salarioBrutoAnual < 0) this.salarioBrutoAnual = 0;
        else this.salarioBrutoAnual = salarioBrutoAnual;
    }
    public double getIRPF() {
        return IRPF;
    }
    public void setIRPF(double IRPF) {
        if (IRPF < 0) this.IRPF = 0;
        else this.IRPF = IRPF;
    }
}
