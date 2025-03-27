import java.util.Comparator;

public class CompararPorNome implements Comparator<Cliente> {
    public int compare(Cliente ob1, Cliente ob2){
        return ob1.getNome().compareTo(ob2.getNome());
    }
}