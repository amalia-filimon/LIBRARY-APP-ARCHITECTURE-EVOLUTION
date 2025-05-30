package View;

import Model.Carte;
import com.sun.source.tree.Tree;

import java.util.TreeSet;

public interface AngajatInterface {
    int getIdLibrarie();
    void vizualizareListaCartiSortata(TreeSet<Carte> lista);
    void filtrareDomeniu(TreeSet<Carte> lista);
    void filtrareDisponibilitate(TreeSet<Carte> lista);
    void filtrareEditura(TreeSet<Carte> lista);
    void filtrareAutor(TreeSet<Carte> lista);
    void filtrarePret(TreeSet<Carte> lista);
    String getTitluTFCRUD();
    String getAutorTFCRUD();
    String getDomeniuTFCRUD();
    String getDisponibilitateTFCRUD();
    String getEdituraTFCRUD();
    String getPretTFCRUD();
}
