package ViewModel.Commands;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import ViewModel.VMAngajat;
import ViewModel.VMManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

public class SalvareJSONmanager implements IComanda{
    private VMManager vmManager;

    public SalvareJSONmanager(VMManager vm){
        this.vmManager = vm;
    }

    @Override
    public void executa() {
        CartePersistenta cp = new CartePersistenta();
        List<Carte> lista = cp.listaCartiTotala();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(new File("situatie_carti_manager.json"), lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
