package SC;
public class Xogador implements Comparable<Xogador>{
    private String nome;
    private int dorsal;

    // Constructores
    public Xogador(String nome, int dorsal){
        this.setNome(nome);
        this.setDorsal(dorsal);
    }

    // Métodos
    @Override
    public int compareTo(Xogador xog){
        return dorsal - xog.getDorsal();
    }

    @Override
    public String toString(){
        return getDorsal()+": "+getNome();
    }

    // Getters & Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
}
