package View;

import Model.Carte;

import java.util.TreeSet;

public interface ManagerInterface {
    String getComboBox();
    void vizualizareListaCartiSortata(TreeSet<Carte> lista);
    void filtrareDomeniu(TreeSet<Carte> lista);
    void filtrareDisponibilitate(TreeSet<Carte> lista);
    void filtrareEditura(TreeSet<Carte> lista);
    void filtrareAutor(TreeSet<Carte> lista);
    void filtrarePret(TreeSet<Carte> lista);
}
