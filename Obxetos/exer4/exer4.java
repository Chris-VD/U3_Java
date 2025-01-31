package exer4;

public class exer4 {
    public static void main(String[] args) {
        Empregado empregado1 = new Empregado("55026812R","Manuel", "Varela", "López", 1500);
        System.out.println(empregado1.getDni());
        empregado1.setDni("55026811R");
        System.out.println(empregado1.getApelidos()+" "+ empregado1.getNome()+" con "+empregado1.getDni()+" ten un salario neto de "+empregado1.getSalarioNeto()+"€");
    }    
}
