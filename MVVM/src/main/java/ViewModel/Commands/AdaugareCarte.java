package ViewModel.Commands;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import ViewModel.VMAngajat;

public class AdaugareCarte implements IComanda{
    private VMAngajat vmAngajat;

    public AdaugareCarte(VMAngajat vm){
        this.vmAngajat = vm;
    }

    @Override
    public void executa() {
        CartePersistenta cp = new CartePersistenta();
        String titlu = vmAngajat.getTitluTF();
        String autor = vmAngajat.getAutorTF();
        String domeniu = vmAngajat.getDomeniuTF();
        String disponibilitate = vmAngajat.getDisponibilitateTF();
        String editura = vmAngajat.getEdituraTF();
        String pret = vmAngajat.getPretTF();

        Carte c = new Carte(titlu, autor, domeniu, disponibilitate, editura, pret);
        int idLibrarie = this.vmAngajat.getIdLibrarie();
        cp.adaugareCarte(c, idLibrarie);

    }
}
