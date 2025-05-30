package Model;

import java.util.ArrayList;
import java.util.List;

public class Subiect {
    protected List<Observer> listaObs;

    public Subiect() {
        this.listaObs = new ArrayList<>();
    }

    public void adaugare(Observer obs) {
        this.listaObs.add(obs);
    }

    public void stergere(Observer obs) {
        this.listaObs.remove(obs);
    }

    public void notificare() {
        for (Observer obs : this.listaObs) {
            obs.actualizare(this);
        }
    }
}
