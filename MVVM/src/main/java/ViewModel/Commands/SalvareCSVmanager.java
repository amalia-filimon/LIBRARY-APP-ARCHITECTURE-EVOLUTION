package ViewModel.Commands;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import ViewModel.VMAngajat;
import ViewModel.VMManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

public class SalvareCSVmanager implements IComanda{
    private VMManager vmManager;

    public SalvareCSVmanager(VMManager vm){
        this.vmManager = vm;
    }

    @Override
    public void executa() {
        CartePersistenta cp = new CartePersistenta();
        List<Carte> lista = cp.listaCartiTotala();
        String separator = ",";
        String fileName = "situatie_carti_manager.csv";

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
