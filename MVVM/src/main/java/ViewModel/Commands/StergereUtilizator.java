package ViewModel.Commands;

import Model.Persistenta.UtilizatorPersistenta;
import ViewModel.VMAdmin;

public class StergereUtilizator implements IComanda{
    private VMAdmin vmAdmin;

    public StergereUtilizator(VMAdmin vm){
        this.vmAdmin = vm;
    }

    @Override
    public void executa() {
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        String username = vmAdmin.getUsernameTF();
        up.stergereUtilizator(username);
    }
}
