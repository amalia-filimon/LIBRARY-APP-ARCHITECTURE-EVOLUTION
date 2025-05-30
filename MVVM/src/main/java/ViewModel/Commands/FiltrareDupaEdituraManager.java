package ViewModel.Commands;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import ViewModel.VMManager;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FiltrareDupaEdituraManager implements IComanda{
    private VMManager vmManager;
    public FiltrareDupaEdituraManager(VMManager vm){
        vmManager = vm;
    }

    @Override
    public void executa() {
        String edituraDeCautat = vmManager.getEdituraTF();
        Object[] columns = new Object[]{"TITLU", "AUTOR", "DOMENIU", "DISPONIBILITATE", "EDITURA", "PRET"};
        int rowIndex = 0;
        CartePersistenta cp = new CartePersistenta();
        List<Carte> lista = cp.listaCartiTotala();
        int noRows = lista.size();
        String [][] data = new String[noRows][6];
        for (Carte carte: lista)
        {
            if(carte.getEditura().equals(edituraDeCautat)){
                data[rowIndex][0] = carte.getTitlu();
                data[rowIndex][1] = carte.getAutor();
                data[rowIndex][2] = carte.getDomeniu();
                data[rowIndex][3] = carte.getDisponibilitate();
                data[rowIndex][4] = carte.getEditura();
                data[rowIndex][5] = carte.getPret();

                rowIndex++;
            }
        }

        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        vmManager.setModel(defaultTableModel);
    }
}
