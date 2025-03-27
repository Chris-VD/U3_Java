public class Cliente implements Comparable<Cliente> {
    private String nome;
    private String DNI;
    private int idade;
    private double salario;

    public Cliente(String nome, String DNI, int idedae, double salario){
        this.setDNI(DNI);
        this.setIdade(idedae);
        this.setNome(nome);
        this.setSalario(salario);
    }

    @Override
    public String toString(){
        return this.getDNI() + " " + this.getNome() + ". Idade: " + this.getIdade() + ". Soldo: " + this.getSalario();
    }

    @Override
    public boolean equals(Object obj){
        Cliente cli = (Cliente) obj;
        return cli.DNI.equals(this.getDNI());
    }

    @Override
    public int compareTo(Cliente cliente){
        return this.getDNI().compareTo(cliente.getDNI());
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dNI) {
        DNI = dNI;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    
}