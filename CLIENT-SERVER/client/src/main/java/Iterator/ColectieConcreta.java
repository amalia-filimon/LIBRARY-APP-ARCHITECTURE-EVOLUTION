package Iterator;

import Model.Utilizator;

import java.util.List;

public class ColectieConcreta implements Colectie{
    private List<Utilizator> utilizatori;

    public ColectieConcreta(List<Utilizator> utilizatori) {
        this.utilizatori = utilizatori;
    }

    @Override
    public Iterator getIterator() {
        return new IteratorConcret(utilizatori);
    }
}
