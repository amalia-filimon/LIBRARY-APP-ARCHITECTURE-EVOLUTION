package ViewModel.Commands;

import Model.Persistenta.UtilizatorPersistenta;
import Model.Utilizator;
import ViewModel.VMAdmin;

public class AdaugareUtilizator implements IComanda{
    private VMAdmin vmAdmin;

    public AdaugareUtilizator(VMAdmin vm){
        this.vmAdmin = vm;
    }

    @Override
    public void executa() {
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        String username = vmAdmin.getUsernameTF();
        String parola = vmAdmin.getPasswordTF();
        String rol = vmAdmin.getRolComboBox();
        String salariu = vmAdmin.getSalaryTF();
        String locatieLibrarie = vmAdmin.getLocatieLibrarieComboBox();

        Utilizator u = new Utilizator(username, parola, rol, salariu, locatieLibrarie);
        up.adaugareUtilizator(u);
    }
}
