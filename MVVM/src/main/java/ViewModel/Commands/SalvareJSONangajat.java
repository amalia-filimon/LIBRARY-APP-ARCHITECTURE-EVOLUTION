package ViewModel.Commands;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import ViewModel.VMAngajat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

public class SalvareJSONangajat implements IComanda{
    private VMAngajat vmAngajat;

    public SalvareJSONangajat(VMAngajat vm){
        this.vmAngajat = vm;
    }

    @Override
    public void executa() {
        CartePersistenta cp = new CartePersistenta();
        TreeSet<Carte> lista = cp.listaCarti(vmAngajat.getIdLibrarie());
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(new File("situatie_carti_angajat.json"), lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
