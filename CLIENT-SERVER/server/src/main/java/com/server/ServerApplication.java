package com.server;
import com.server.BusinessLogic.*;

import com.server.Service.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args){
        Socket socket = new Socket();
        ServerSocket serverSocket=null;
        ObjectInputStream objectInputStream=null;
        ObjectOutputStream objectOutputStream=null;

        try {
            serverSocket = new ServerSocket(8080);
            socket = serverSocket.accept();
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());


            System.out.println("Starting server...");

            //Utilizarea sablonului Bridge
            ILogin loginA = new LoginImplementationA(objectOutputStream, objectInputStream);
            Abstractizare abstractizareLoginA = new AbstractizareLoginA(loginA);

            ILogin loginB = new LoginImplementationB();
            Abstractizare abstractizareLoginB = new AbstractizareLoginB(loginB);


            IAdmin admin = new AdminImplementation(objectOutputStream, objectInputStream);
            IAngajat angajat = new AngajatImplementation(objectOutputStream, objectInputStream);
            IManager manager = new ManagerImplementation(objectOutputStream, objectInputStream);


            while (true){
                String command= (String) objectInputStream.readObject();
                System.out.println(command);
                if(command.equals("LOGIN")){
                    abstractizareLoginA.operatie();
                    abstractizareLoginB.operatie();
                }
                if(command.equals("ADD_USER_ADMIN")){
                    admin.adaugareUtilizatorNou();
                }
                if(command.equals("DELETE_USER_ADMIN")){
                    admin.eliminareUtilizator();
                }
                if(command.equals("UPDATE_USER_ADMIN")){
                    admin.actualizareUtilizator();
                }
                if(command.equals("VIEW_LIST_ADMIN")){
                    admin.vizualizareListaUtilizatori();
                }
                if(command.equals("FILTER_AFTER_ROLE_ADMIN")){
                    admin.filtrareListaDupaRol();
                }
                if(command.equals("VIZUALIZARE_LISTA_CARTI_ANGAJAT")){
                    angajat.vizualizareListaCarti();
                }
                if(command.equals("FILTRARE_DUPA_DOMENIU_ANGAJAT")){
                    angajat.filtrareDupaDomeniu();
                }
                if(command.equals("FILTRARE_DUPA_DISPONIBILITATE_ANGAJAT")){
                    angajat.filtrareDupaDisponibilitate();
                }
                if(command.equals("FILTRARE_DUPA_EDITURA_ANGAJAT")){
                    angajat.filtrareDupaEditura();
                }
                if(command.equals("FILTRARE_DUPA_AUTOR_ANGAJAT")){
                    angajat.filtrareDupaAutor();
                }
                if(command.equals("FILTRARE_DUPA_PRET_ANGAJAT")){
                    angajat.filtrareDupaPret();
                }
                if(command.equals("CAUTARE_CARTE_DUPA_TITLU_ANGAJAT")){
                    angajat.cautareCarteDupaTitlu();
                }
                if(command.equals("VANZARE_CARTE_ANGAJAT")){
                    angajat.vanzareCarte();
                }
                if(command.equals("ADAUGARE_CARTE_ANGAJAT")){
                    angajat.adaugareCarte();
                }
                if(command.equals("STERGERE_CARTE_ANGAJAT")){
                    angajat.stergereCarte();
                }
                if(command.equals("ACTUALIZARE_CARTE_ANGAJAT")){
                    angajat.actualizareCarte();
                }
                if(command.equals("SALVARE_TXT_ANGAJAT")){
                    angajat.salvareTXT();
                }
                if(command.equals("SALVARE_JSON_ANGAJAT")){
                    angajat.salvareJSON();
                }
                if(command.equals("SALVARE_CSV_ANGAJAT")){
                    angajat.salvareCSV();
                }
                if(command.equals("SALVARE_XML_ANGAJAT")){
                    angajat.salvareXML();
                }
                if(command.equals("VIZUALIZARE_LISTA_MANAGER")){
                    manager.vizualizareLista();
                }
                if(command.equals("FILTRARE_DUPA_DOMENIU_MANAGER")){
                    manager.filtrareDupaDomeniu();
                }
                if(command.equals("FILTRARE_DUPA_DISPONIBILITATE_MANAGER")){
                    manager.filtrareDupaDisponibilitate();
                }
                if(command.equals("FILTRARE_DUPA_EDITURA_MANAGER")){
                    manager.filtrareDupaEditura();
                }
                if(command.equals("FILTRARE_DUPA_AUTOR_MANAGER")){
                    manager.filtrareDupaAutor();
                }
                if(command.equals("FILTRARE_DUPA_PRET_MANAGER")){
                    manager.filtrareDupaPret();
                }
                if(command.equals("CAUTARE_CARTE_DUPA_TITLU_MANAGER")){
                    manager.cautareCarteDupaTitlu();
                }
                if(command.equals("SALVARE_TXT_MANAGER")){
                    manager.salvareTXT();
                }
                if(command.equals("SALVARE_JSON_MANAGER")){
                    manager.salvareJSON();
                }
                if(command.equals("SALVARE_CSV_MANAGER")){
                    manager.salvareCSV();
                }
                if(command.equals("SALVARE_XML_MANAGER")){
                    manager.salvareXML();
                }
                if(command.equals("GENERARE_GRAFIC_MANAGER")){
                    manager.generareGrafic();
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
