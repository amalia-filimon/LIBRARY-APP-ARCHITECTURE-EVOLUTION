package ViewModel.Commands;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import ViewModel.VMAngajat;

import javax.swing.table.DefaultTableModel;
import java.util.TreeSet;

public class FiltrareDupaAutor implements IComanda{
    private VMAngajat vmAngajat;

    public FiltrareDupaAutor(VMAngajat vm){
        this.vmAngajat = vm;
    }


    @Override
    public void executa() {
        String autorDeCautat = vmAngajat.getAutorTF();
        Object[] columns = new Object[]{"TITLU", "AUTOR", "DOMENIU", "DISPONIBILITATE", "EDITURA", "PRET"};
        int rowIndex = 0;
        CartePersistenta cp = new CartePersistenta();
        TreeSet<Carte> lista = cp.listaCarti(vmAngajat.getIdLibrarie());
        int noRows = lista.size();
        String [][] data = new String[noRows][6];
        for (Carte carte: lista)
        {
            if(carte.getAutor().equals(autorDeCautat)){
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
        vmAngajat.setModel(defaultTableModel);
    }
}
