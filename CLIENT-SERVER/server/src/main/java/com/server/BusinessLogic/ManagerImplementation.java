package com.server.BusinessLogic;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import Model.Persistenta.LibrariePersistenta;
import com.server.Service.IManager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.TreeSet;

public class ManagerImplementation implements IManager {
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;
    private final CartePersistenta cp;
    private final LibrariePersistenta lp;

    public ManagerImplementation(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream){
        this.objectOutputStream=objectOutputStream;
        this.objectInputStream=objectInputStream;
        this.cp = new CartePersistenta();
        this.lp = new LibrariePersistenta();
    }

    @Override
    public void vizualizareLista() {
        try {
            String locatieLibrarie = (String) objectInputStream.readObject();
            int idLibrarie = lp.idLibrarieDupaLocatie(locatieLibrarie);
            TreeSet<Carte> listaCarti = cp.listaCarti(idLibrarie);
            objectOutputStream.writeObject(listaCarti);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filtrareDupaDomeniu() {
        try {
            List<Carte> lista = cp.listaCartiTotala();
            objectOutputStream.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filtrareDupaDisponibilitate() {
        try {
            List<Carte> lista = cp.listaCartiTotala();
            objectOutputStream.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filtrareDupaEditura() {
        try {
            List<Carte> lista = cp.listaCartiTotala();
            objectOutputStream.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filtrareDupaAutor() {
        try {
            List<Carte> lista = cp.listaCartiTotala();
            objectOutputStream.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filtrareDupaPret() {
        try {
            List<Carte> lista = cp.listaCartiTotala();
            objectOutputStream.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cautareCarteDupaTitlu() {
        try {
            List<Carte> lista = cp.listaCartiTotala();
            objectOutputStream.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvareTXT() {
        try {
            List<Carte> lista = cp.listaCartiTotala();
            objectOutputStream.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvareCSV() {
        try {
            List<Carte> lista = cp.listaCartiTotala();
            objectOutputStream.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvareJSON() {
        try {
            List<Carte> lista = cp.listaCartiTotala();
            objectOutputStream.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvareXML() {
        try {
            List<Carte> lista = cp.listaCartiTotala();
            objectOutputStream.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generareGrafic() {
        try {
            List<Carte> lista = cp.listaCartiTotala();
            objectOutputStream.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
