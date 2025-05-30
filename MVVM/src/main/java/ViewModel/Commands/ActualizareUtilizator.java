package ViewModel.Commands;

import Model.Persistenta.UtilizatorPersistenta;
import ViewModel.VMAdmin;

public class ActualizareUtilizator implements IComanda{
    private VMAdmin vmAdmin;
    public ActualizareUtilizator(VMAdmin vm){
        this.vmAdmin = vm;
    }

    @Override
    public void executa() {
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        String username = vmAdmin.getUsernameTF();
        String salariu = vmAdmin.getSalaryTF();
        up.actualizareUtilizator(username, salariu);
    }
}
