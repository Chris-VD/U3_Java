package arbores;

import java.util.ArrayList;
import java.util.Iterator;

public class IteradorABB<T extends Comparable<T>> implements Iterator<T>{
    private ArrayList<T> ordenada;
    private int pos;

    public IteradorABB(ArboreBinariaBusca<T> abb){
        this.ordenada = (ArrayList<T>) abb.recorridoInOrde();
        this.pos = 0;
    }

    @Override
    public boolean hasNext() {
        return pos < ordenada.size();
    }

    @Override
    public T next() {
        return ordenada.get(pos++);
    }
}
