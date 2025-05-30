package com.server.BusinessLogic;
import Model.Librarie;
import Model.Persistenta.LibrariePersistenta;
import Model.Persistenta.UtilizatorPersistenta;
import Model.Utilizator;
import com.server.Service.ILogin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

//Clasa concreta a implementatorului
public class LoginImplementationA implements ILogin {
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;
    private final UtilizatorPersistenta up;
    private final LibrariePersistenta lp;

    public LoginImplementationA(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream){
        this.objectOutputStream=objectOutputStream;
        this.objectInputStream=objectInputStream;
        this.up= new UtilizatorPersistenta();
        this.lp = new LibrariePersistenta();
    }

    @Override
    public void login() {
        System.out.println("Implementator A: operație implementată.");
        try {
            Utilizator utilizatorDeCautatInBD = (Utilizator) objectInputStream.readObject();
            Utilizator utilizatorObtinutDinBD = this.up.cautareUtilizator(utilizatorDeCautatInBD);
            objectOutputStream.writeObject(utilizatorObtinutDinBD);

            String usernameUtilizatorLogat = utilizatorObtinutDinBD.getUsername();
            String locatieAngajatLogat = this.up.locatieUtilizator(usernameUtilizatorLogat);
            objectOutputStream.writeObject(locatieAngajatLogat);
            int id_librarie = this.up.idLibrarieAngajat(usernameUtilizatorLogat);
            objectOutputStream.writeObject(id_librarie);
            List<Librarie> listaLibrarii = lp.listaLibrarii();
            objectOutputStream.writeObject(listaLibrarii);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
