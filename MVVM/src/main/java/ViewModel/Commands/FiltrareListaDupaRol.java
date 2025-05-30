package ViewModel.Commands;

import Model.Persistenta.UtilizatorPersistenta;
import Model.Utilizator;
import ViewModel.VMAdmin;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FiltrareListaDupaRol implements IComanda{
    private VMAdmin vmAdmin;

    public FiltrareListaDupaRol(VMAdmin vm){
        this.vmAdmin = vm;
    }

    @Override
    public void executa() {
        String rolFiltrare = vmAdmin.getRolComboBox();
        Object[] columns = new Object[]{"Username", "Password", "Role", "Salary", "Library"};
        int rowIndex = 0;
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        List<Utilizator> users = up.listaUtilizatori();
        int noRows = users.size();
        String [][] data = new String[noRows][5];
        for (Utilizator utilizator: users)
        {
            if(utilizator.getRol().equals(rolFiltrare)){
                data[rowIndex][0] = utilizator.getUsername();
                data[rowIndex][1] = utilizator.getParola();
                data[rowIndex][2] = utilizator.getRol();
                data[rowIndex][3] = utilizator.getSalariu();
                data[rowIndex][4] = utilizator.getLocatieLibrarie();

                rowIndex++;
            }
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        vmAdmin.setModel(defaultTableModel);
    }
}
