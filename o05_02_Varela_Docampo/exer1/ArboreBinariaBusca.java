import java.util.ArrayList;
import java.util.List;

public class ArboreBinariaBusca<T extends Comparable<T>> implements Comparable<T>{
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
}