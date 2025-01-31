package exer4;

public class Empregado {
    private String dni;
    private String nome;
    private String apel1;
    private String apel2;
    private int salarioB;
    public static final int IRPF = 15;

    private boolean checkDni(String dni){
        if (dni.length()!=9) return false;
        int numeros = Integer.parseInt(dni.substring(0, dni.length()-1));
        int suma;
        do { 
            suma = numeros%10;
            numeros = numeros%10;
        } while (numeros > 0);
        int resto = suma%23;
        String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        String letra = letras[resto];
        if (dni.substring(dni.length()-1, dni.length()) != letra) return false;
        else return true;
    }

    public Empregado(String dni, String nome, String apel1, String apel2, int salarioB) {
        if (checkDni(dni) == true) this.dni = dni;
        else this.dni = "DNI inválido";
        this.nome = nome;
        this.apel1 = apel1;
        this.apel2 = apel2;
        this.salarioB = salarioB;
    }

    public Empregado(String dni, String nome, String apel1, int salarioB){
        this(dni, nome, apel1, null, salarioB);
    }

    public Empregado(String nome, String apel1, int salarioB){
        this(null, nome, apel1, null, salarioB);
    }

    public String getDni() {
        if (this.dni == "Inválido" || this.dni == null) return "Sen información";
        else return dni;
    }

    public void setDni(String dni) {
        if (checkDni(dni) == true) this.dni = dni;
        else this.dni = "Inválido";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApel1() {
        return apel1;
    }

    public void setApel1(String apel1) {
        this.apel1 = apel1;
    }

    public String getApel2() {
        return apel2;
    }

    public void setApel2(String apel2) {
        this.apel2 = apel2;
    }

    public int getSalarioB() {
        return salarioB;
    }

    public void setSalarioB(int salarioB) {
        this.salarioB = salarioB;
    }

    public static int getIrpf() {
        return IRPF;
    }

    public String getApelidos(){
        return this.apel1+" "+this.apel2;
    }
    
    public int getSalarioNeto(){
        return this.salarioB + this.salarioB*IRPF/100;
    }
}
