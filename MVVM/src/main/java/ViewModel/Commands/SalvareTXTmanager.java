package ViewModel.Commands;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import ViewModel.VMAngajat;
import ViewModel.VMManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.TreeSet;

public class SalvareTXTmanager implements IComanda{
    private VMManager vmManager;
    public SalvareTXTmanager(VMManager vm){
        this.vmManager = vm;
    }

    @Override
    public void executa() {
        CartePersistenta cp = new CartePersistenta();
        List<Carte> lista = cp.listaCartiTotala();

        try (PrintWriter writer = new PrintWriter(new File("situatie_carti_manager.txt"))) {
            for (Carte c : lista) {
                writer.println(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
