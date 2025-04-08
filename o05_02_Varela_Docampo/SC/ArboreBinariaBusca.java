package SC;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArboreBinariaBusca<T extends Comparable<T>> implements Comparable<T>, Iterable<T>{
    private T nodo;
    private ArboreBinariaBusca<T> left;
    private ArboreBinariaBusca<T> right;

    public void engadirElemento(T elemento){
        if (nodo == null) this.nodo = elemento;
        else if (elemento.compareTo(nodo) < 0) {
            if (left == null) left = new ArboreBinariaBusca<>();
            left.engadirElemento(elemento);
        }
        else if (elemento.compareTo(nodo) > 0) {
            if (right == null) right = new ArboreBinariaBusca<>();
            right.engadirElemento(elemento);
        }
    }

    @Override
    public int compareTo(T x) {
        if (nodo.equals(x)) return 0;
        else return (char)nodo - (char)x;
    }

    public List<T> recorridoInOrde(){
        List<T> ordenado = new ArrayList<>();
        if (left != null)  ordenado = left.recorridoInOrde();
        ordenado.add(nodo);
        if (right != null) for (T elemento:right.recorridoInOrde()) ordenado.add(elemento);
        return ordenado;
    }

    @Override
    public Iterator<T> iterator() {
        // "Type safety: The expression of type IteradorABB needs unchecked conversion to conform to Iterator<T>Java(16777748)"
        // "IteradorABB is a raw type. References to generic type IteradorABB<T> should be parameterizedJava(16777788)"
        // Nin me vou molestar
        Iterator<T> iterador = new IteradorABB<T>(this);
        return iterador;
    }
}