package ViewModel.Commands;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import Model.Persistenta.LibrariePersistenta;
import ViewModel.VMManager;

import javax.swing.table.DefaultTableModel;
import java.util.TreeSet;

public class VizualizareListaCartiManager implements IComanda{
    private VMManager vmManager;
    public VizualizareListaCartiManager(VMManager vm){
        this.vmManager = vm;
    }

    @Override
    public void executa() {
        Object[] columns = new Object[]{"TITLU", "AUTOR", "DOMENIU", "DISPONIBILITATE", "EDITURA", "PRET"};
        int rowIndex = 0;
        CartePersistenta cp = new CartePersistenta();
        LibrariePersistenta lp = new LibrariePersistenta();
        String locatieLibrarie = vmManager.getListaLibrariicomboBox();
        int idLibrarie = lp.idLibrarieDupaLocatie(locatieLibrarie);
        TreeSet<Carte> lista = cp.listaCarti(idLibrarie);
        int noRows = lista.size();
        String [][] data = new String[noRows][6];
        for (Carte carte: lista)
        {
            data[rowIndex][0] = carte.getTitlu();
            data[rowIndex][1] = carte.getAutor();
            data[rowIndex][2] = carte.getDomeniu();
            data[rowIndex][3] = carte.getDisponibilitate();
            data[rowIndex][4] = carte.getEditura();
            data[rowIndex][5] = carte.getPret();

            rowIndex++;
        }

        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        vmManager.setModel(defaultTableModel);
    }
}
