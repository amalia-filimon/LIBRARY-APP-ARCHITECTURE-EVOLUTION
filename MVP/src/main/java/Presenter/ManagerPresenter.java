package Presenter;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import Model.Persistenta.LibrariePersistenta;
import View.ManagerInterface;

import java.util.TreeSet;

public class ManagerPresenter {
    private ManagerInterface managerInterface;
    private LibrariePersistenta lp;
    private CartePersistenta cp;

    public ManagerPresenter(ManagerInterface managerInterface){
        this.managerInterface = managerInterface;
        this.lp = new LibrariePersistenta();
        this.cp = new CartePersistenta();
    }

    public TreeSet<Carte> listaCartiSortata(){
        String locatieLibrarie = this.managerInterface.getComboBox();
        int idLibrarie = lp.idLibrarieDupaLocatie(locatieLibrarie);
        return cp.listaCarti(idLibrarie);
    }

    public void vizualizareLista(){
        managerInterface.vizualizareListaCartiSortata(this.listaCartiSortata());
    }

    public void filtrareListaDomeniu(){
        managerInterface.filtrareDomeniu(this.listaCartiSortata());
    }
    public void filtrareListaDisponibilitate(){
        managerInterface.filtrareDisponibilitate(this.listaCartiSortata());
    }
    public void filtrareListaEditura(){
        managerInterface.filtrareEditura(this.listaCartiSortata());
    }
    public void filtrareListaAutor(){
        managerInterface.filtrareAutor(this.listaCartiSortata());
    }
    public void filtrareListaPret(){
        managerInterface.filtrarePret(this.listaCartiSortata());
    }
}
