package com.server.BusinessLogic;

import Model.Persistenta.LibrariePersistenta;
import Model.Persistenta.UtilizatorPersistenta;
import Model.Utilizator;
import com.server.Service.IAdmin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AdminImplementation implements IAdmin {
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;
    private final UtilizatorPersistenta up;

    public AdminImplementation(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream){
        this.objectOutputStream=objectOutputStream;
        this.objectInputStream=objectInputStream;
        this.up= new UtilizatorPersistenta();
    }

    @Override
    public void adaugareUtilizatorNou() {
        try {
            Utilizator u = (Utilizator) objectInputStream.readObject();
            up.adaugareUtilizator(u);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminareUtilizator() {
        try {
            String username = (String) objectInputStream.readObject();
            up.stergereUtilizator(username);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizareUtilizator() {
        try {
            String username = (String) objectInputStream.readObject();
            String salary = (String) objectInputStream.readObject();
            up.actualizareUtilizator(username, salary);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void vizualizareListaUtilizatori() {
        try {
            objectOutputStream.writeObject(up.listaUtilizatori());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void filtrareListaDupaRol() {
        try {
            objectOutputStream.writeObject(up.listaUtilizatori());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
