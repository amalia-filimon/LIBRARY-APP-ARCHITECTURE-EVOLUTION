package Iterator;

import Model.Utilizator;

import java.util.List;

public class IteratorConcret implements Iterator{
    private List<Utilizator> utilizatori;
    private int index;

    public IteratorConcret(List<Utilizator> utilizatori) {
        this.utilizatori = utilizatori;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < utilizatori.size();
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Object element = utilizatori.get(index);
            index++;
            return element;
        }
        return null;
    }
}
