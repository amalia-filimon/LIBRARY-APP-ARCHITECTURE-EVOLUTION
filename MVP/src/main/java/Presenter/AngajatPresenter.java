package Presenter;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import Model.Persistenta.UtilizatorPersistenta;
import View.AngajatInterface;

import java.util.TreeSet;

public class AngajatPresenter {
    private AngajatInterface angajatInterface;
    private CartePersistenta cp;

    public AngajatPresenter(AngajatInterface angajatInterface){
        this.angajatInterface = angajatInterface;
        this.cp = new CartePersistenta();
    }

    public TreeSet<Carte> listaCartiSortata(){
        int idLibrarie = this.angajatInterface.getIdLibrarie();
        return cp.listaCarti(idLibrarie);
    }

    public void vizualizareListaSortata(){
        angajatInterface.vizualizareListaCartiSortata(this.listaCartiSortata());
    }

    public void filtrareListaDomeniu(){
        angajatInterface.filtrareDomeniu(this.listaCartiSortata());
    }
    public void filtrareListaDisponibilitate(){
        angajatInterface.filtrareDisponibilitate(this.listaCartiSortata());
    }
    public void filtrareListaEditura(){
        angajatInterface.filtrareEditura(this.listaCartiSortata());
    }
    public void filtrareListaAutor(){
        angajatInterface.filtrareAutor(this.listaCartiSortata());
    }
    public void filtrareListaPret(){
        angajatInterface.filtrarePret(this.listaCartiSortata());
    }

    public void adaugareCarteNoua(){
        String titlu = angajatInterface.getTitluTFCRUD();
        String autor = angajatInterface.getAutorTFCRUD();
        String domeniu = angajatInterface.getDomeniuTFCRUD();
        String disponibilitate = angajatInterface.getDisponibilitateTFCRUD();
        String editura = angajatInterface.getEdituraTFCRUD();
        String pret = angajatInterface.getPretTFCRUD();

        Carte c = new Carte(titlu, autor, domeniu, disponibilitate, editura, pret);
        int idLibrarie = this.angajatInterface.getIdLibrarie();
        cp.adaugareCarte(c, idLibrarie);
    }

    public void stergereCarte(){
        String titlu = angajatInterface.getTitluTFCRUD();
        String autor = angajatInterface.getAutorTFCRUD();

        int idLibrarie = this.angajatInterface.getIdLibrarie();
        cp.stergereCarte(titlu, autor, idLibrarie);
    }

    public void actualizareCarte(){
        //se va actualiza disponibilitatea
        String titlu = angajatInterface.getTitluTFCRUD();
        String autor = angajatInterface.getAutorTFCRUD();
        String actualizarea = angajatInterface.getDisponibilitateTFCRUD();
        cp.actualizareCarte(titlu, autor, actualizarea);

    }
}
