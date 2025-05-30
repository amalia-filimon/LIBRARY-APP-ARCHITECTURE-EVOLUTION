package com.server.BusinessLogic;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import Model.Persistenta.UtilizatorPersistenta;
import com.server.Service.IAngajat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;

public class AngajatImplementation implements IAngajat {
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;
    private final CartePersistenta cp;

    public AngajatImplementation(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream){
        this.objectOutputStream=objectOutputStream;
        this.objectInputStream=objectInputStream;
        this.cp = new CartePersistenta();
    }

    @Override
    public void vizualizareListaCarti() {
        try {
            int id_librarie = (int) objectInputStream.readObject();
            TreeSet<Carte> listaCarti = cp.listaCarti(id_librarie);
            objectOutputStream.writeObject(listaCarti);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filtrareDupaDomeniu() {
        try {
            int id_librarie = (int) objectInputStream.readObject();
            TreeSet<Carte> listaCarti = cp.listaCarti(id_librarie);
            objectOutputStream.writeObject(listaCarti);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filtrareDupaDisponibilitate() {
        try {
            int id_librarie = (int) objectInputStream.readObject();
            TreeSet<Carte> listaCarti = cp.listaCarti(id_librarie);
            objectOutputStream.writeObject(listaCarti);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filtrareDupaEditura() {
        try {
            int id_librarie = (int) objectInputStream.readObject();
            TreeSet<Carte> listaCarti = cp.listaCarti(id_librarie);
            objectOutputStream.writeObject(listaCarti);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filtrareDupaAutor() {
        try {
            int id_librarie = (int) objectInputStream.readObject();
            TreeSet<Carte> listaCarti = cp.listaCarti(id_librarie);
            objectOutputStream.writeObject(listaCarti);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filtrareDupaPret() {
        try {
            int id_librarie = (int) objectInputStream.readObject();
            TreeSet<Carte> listaCarti = cp.listaCarti(id_librarie);
            objectOutputStream.writeObject(listaCarti);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cautareCarteDupaTitlu() {
        try {
            int id_librarie = (int) objectInputStream.readObject();
            TreeSet<Carte> listaCarti = cp.listaCarti(id_librarie);
            objectOutputStream.writeObject(listaCarti);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void vanzareCarte() {
        try {
            int id_librarie = (int) objectInputStream.readObject();
            TreeSet<Carte> listaCarti = cp.listaCarti(id_librarie);
            objectOutputStream.writeObject(listaCarti);

            String titlu = (String) objectInputStream.readObject();
            String autor = (String) objectInputStream.readObject();
            String nouaDisponibilitate = (String) objectInputStream.readObject();
            cp.actualizareCarte(titlu, autor, nouaDisponibilitate);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void adaugareCarte() {
        try {
            Carte c = (Carte) objectInputStream.readObject();
            int idLibrarie = (int) objectInputStream.readObject();
            cp.adaugareCarte(c, idLibrarie);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stergereCarte() {
        try {
            String titlu = (String) objectInputStream.readObject();
            String autor = (String) objectInputStream.readObject();
            int idLibrarie = (int) objectInputStream.readObject();
            cp.stergereCarte(titlu, autor, idLibrarie);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizareCarte() {
        try {
            String titlu = (String) objectInputStream.readObject();
            String autor = (String) objectInputStream.readObject();
            String actualizarea = (String) objectInputStream.readObject();
            cp.actualizareCarte(titlu, autor, actualizarea);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvareTXT() {
        try {
            int idLibrarie = (int) objectInputStream.readObject();
            TreeSet<Carte> lista = cp.listaCarti(idLibrarie);
            objectOutputStream.writeObject(lista);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvareJSON() {
        try {
            int idLibrarie = (int) objectInputStream.readObject();
            TreeSet<Carte> lista = cp.listaCarti(idLibrarie);
            objectOutputStream.writeObject(lista);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvareCSV() {
        try {
            int idLibrarie = (int) objectInputStream.readObject();
            TreeSet<Carte> lista = cp.listaCarti(idLibrarie);
            objectOutputStream.writeObject(lista);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void salvareXML() {
        try {
            int idLibrarie = (int) objectInputStream.readObject();
            TreeSet<Carte> lista = cp.listaCarti(idLibrarie);
            objectOutputStream.writeObject(lista);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
