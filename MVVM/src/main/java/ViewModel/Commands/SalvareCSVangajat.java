package ViewModel.Commands;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import View.AngajatView;
import ViewModel.VMAngajat;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class SalvareCSVangajat implements IComanda{
    private VMAngajat vmAngajat;

    public SalvareCSVangajat(VMAngajat vm){
        this.vmAngajat = vm;
    }

    @Override
    public void executa() {
        CartePersistenta cp = new CartePersistenta();
        TreeSet<Carte> lista = cp.listaCarti(vmAngajat.getIdLibrarie());
        String separator = ",";
        String fileName = "situatie_carti_angajat.csv";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("TITLU,AUTOR,DOMENIU,DISPONIBILITATE,EDITURA,PRET").append("\n");
            for (Carte c : lista) {
                writer.append(c.getTitlu()).append(separator)
                        .append(c.getAutor()).append(separator)
                        .append(c.getDomeniu()).append(separator)
                        .append(c.getDisponibilitate()).append(separator)
                        .append(c.getEditura()).append(separator)
                        .append(c.getPret()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
