package ViewModel.Commands;

import Model.Persistenta.CartePersistenta;
import ViewModel.VMAngajat;

public class ActualizareCarte implements IComanda{
    private VMAngajat vmAngajat;

    public ActualizareCarte(VMAngajat vm){
        this.vmAngajat = vm;
    }

    @Override
    public void executa() {
        //se va actualiza disponibilitatea
        CartePersistenta cp = new CartePersistenta();
        String titlu = vmAngajat.getTitluTF();
        String autor = vmAngajat.getAutorTF();
        String actualizarea = vmAngajat.getDisponibilitateTF();
        cp.actualizareCarte(titlu, autor, actualizarea);
    }
}
