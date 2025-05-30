package ViewModel.Commands;

import Model.Persistenta.CartePersistenta;
import ViewModel.VMAngajat;

public class StergereCarte implements IComanda{
    private VMAngajat vmAngajat;

    public StergereCarte(VMAngajat vm){
        this.vmAngajat = vm;
    }

    @Override
    public void executa() {
        CartePersistenta cp = new CartePersistenta();
        String titlu = vmAngajat.getTitluTF();
        String autor = vmAngajat.getAutorTF();

        int idLibrarie = this.vmAngajat.getIdLibrarie();
        cp.stergereCarte(titlu, autor, idLibrarie);
    }
}
