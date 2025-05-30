package ViewModel.Commands;

import Model.Persistenta.UtilizatorPersistenta;
import Model.Utilizator;
import ViewModel.VMAdmin;
import javafx.collections.ObservableList;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VizualizareListaUtilizatori implements IComanda{
    private VMAdmin vmAdmin;

    public VizualizareListaUtilizatori(VMAdmin vm){
        this.vmAdmin = vm;
    }

    @Override
    public void executa() {
        Object[] columns = new Object[]{"USERNAME", "PASSWORD", "ROLE", "SALARY", "LIBRARY"};
        int rowIndex = 0;
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        List<Utilizator> users = up.listaUtilizatori();
        int noRows = users.size();
        String [][] data = new String[noRows][5];
        for (Utilizator utilizator: users)
        {
            data[rowIndex][0] = utilizator.getUsername();
            data[rowIndex][1] = utilizator.getParola();
            data[rowIndex][2] = utilizator.getRol();
            data[rowIndex][3] = utilizator.getSalariu();
            data[rowIndex][4] = utilizator.getLocatieLibrarie();

            rowIndex++;
        }

        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        vmAdmin.setModel(defaultTableModel);
    }
}
