import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {

    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static void main(String[] Args){

        Cliente novoCliente = new Cliente("Ana", "12345678A", 25, 1500.50);
        clientes.add(novoCliente);
        novoCliente = new Cliente("Xoán", "87654321B", 30, 1800.75);
        clientes.add(novoCliente);
        novoCliente = new Cliente("Marta", "11223344C", 28, 2000);
        clientes.add(novoCliente);
        novoCliente = new Cliente("Pedro", "44332211D", 35, 2500.25);
        clientes.add(novoCliente);
        novoCliente = new Cliente("Laura", "99887766E", 22, 1600.60);
        clientes.add(novoCliente);
        novoCliente = new Cliente("Carlos", "55667788F", 40, 2200.1);
        clientes.add(novoCliente);
        novoCliente = new Cliente("Sabela", "66778899G", 27, 1700.80);
        clientes.add(novoCliente);

        Collections.sort(clientes);
        imprimirLista();
        Collections.sort(clientes, new CompararPorNome());
        imprimirLista();
        Collections.sort(clientes, new Comparator<Cliente>() {
            public int compare(Cliente cl1, Cliente cl2){
                return cl1.getIdade() - cl2.getIdade();
            }
        });
        imprimirLista();
    }

    public static void imprimirLista(){
        for (Cliente c:clientes){
            System.out.println(c.toString());
        }
        System.out.println("---------------------------");
    }
}
