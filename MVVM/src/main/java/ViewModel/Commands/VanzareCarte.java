package ViewModel.Commands;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import ViewModel.VMAngajat;

import javax.swing.*;
import java.util.TreeSet;

public class VanzareCarte implements IComanda{
    private VMAngajat vmAngajat;

    public VanzareCarte(VMAngajat vm){
        this.vmAngajat = vm;
    }

    @Override
    public void executa() {
        CartePersistenta cp = new CartePersistenta();
        String titlu = vmAngajat.getTitluTF();
        String autor = vmAngajat.getAutorTF();
        int disponibilitateCurenta = 0;
        TreeSet<Carte> lista = cp.listaCarti(vmAngajat.getIdLibrarie());
        for(Carte c : lista){
            if(c.getTitlu().equals(titlu) && c.getAutor().equals(autor)){
                disponibilitateCurenta = Integer.parseInt(c.getDisponibilitate());
            }
        }
        if(disponibilitateCurenta > 0){
            int nouaDisponibilitate = disponibilitateCurenta - 1;
            cp.actualizareCarte(titlu, autor, String.valueOf(nouaDisponibilitate));
        }else{
            JOptionPane.showMessageDialog(null, "Cartea nu mai este pe stoc!");
        }

    }
}
