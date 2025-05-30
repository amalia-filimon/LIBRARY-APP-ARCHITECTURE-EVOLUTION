package ViewModel.Commands;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import ViewModel.VMAngajat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.TreeSet;

public class SalvareTXTangajat implements IComanda{
    private VMAngajat vmAngajat;
    public SalvareTXTangajat(VMAngajat vm){
        this.vmAngajat = vm;
    }

    @Override
    public void executa() {
        CartePersistenta cp = new CartePersistenta();
        TreeSet<Carte> lista = cp.listaCarti(vmAngajat.getIdLibrarie());

        try (PrintWriter writer = new PrintWriter(new File("situatie_carti_angajat.txt"))) {
            for (Carte c : lista) {
                writer.println(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
