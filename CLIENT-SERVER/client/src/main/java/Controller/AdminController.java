package Controller;

import Connection.ProxyServer;
import Iterator.Colectie;
import Iterator.ColectieConcreta;
import Iterator.Iterator;
import Model.Librarie;
import Model.Utilizator;
import Model.UtilizatorBuilder;
import View.AdministratorUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminController {
    private AdministratorUI adminUI;
    private ProxyServer proxyServer;

    public AdminController(List<Librarie> listaLibrarii){
        this.adminUI = new AdministratorUI(listaLibrarii);
        this.proxyServer = ProxyServer.getInstance();

        adminUI.getCheckBoxRomana().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Romana.csv");
            }
        });

        adminUI.getCheckBoxEngleza().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Engleza.csv");
            }
        });

        adminUI.getCheckBoxSpaniola().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Spaniola.csv");
            }
        });

        adminUI.getCheckBoxFranceza().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Franceza.csv");
            }
        });

        adminUI.getAdaugatiUtilizatorulButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adaugareUtilizatorNou();
            }
        });

        adminUI.getStergetiUtilizatorulButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminareUtilizator();
            }
        });

        adminUI.getActualizatiSalariulButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizareUtilizator();
            }
        });

        adminUI.getVizualizareBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vizualizareListaUtilizatori();
            }
        });

        adminUI.getFilterTheListBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrareListaDupaRol();
            }
        });
    }

    public void setareLimba(String path){
        String line = "";
        String csvSeparator = ",";
        List<String> butoane = new ArrayList<>();
        List<String> etichete = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // citeste capul tabelului
            String headerLine = br.readLine();
            String[] headers = headerLine.split(csvSeparator);

            // parcurge linii de date
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSeparator);

                // afiseaza mesaje pentru fiecare coloana
                for (int i = 0; i < headers.length; i++) {
                    String header = headers[i];
                    String value = values[i];

                    if (header.equals("Butoane")) {
                        if(!value.equals("null"))
                            butoane.add(value);
                    } else if (header.equals("Etichete")) {
                        if(!value.equals("null"))
                            etichete.add(value);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        if(!butoane.isEmpty()){
            adminUI.setAdaugatiUtilizatorulButton(butoane.get(1));
            adminUI.setStergetiUtilizatorulButton(butoane.get(2));
            adminUI.setActualizatiSalariulButton(butoane.get(3));
            adminUI.setVizualizareBtn(butoane.get(4));
            adminUI.setFilterTheListBtn(butoane.get(5));
        }
        if(!etichete.isEmpty()){
            adminUI.setTitleLbl(etichete.get(4));
            adminUI.setLanguageLbl(etichete.get(5));
            adminUI.setAddUserLbl(etichete.get(6));
            adminUI.setUsernameLbl(etichete.get(7));
            adminUI.setPasswordLbl(etichete.get(8));
            adminUI.setRoleLbl(etichete.get(9));
            adminUI.setSalaryLbl(etichete.get(10));
            adminUI.setLocationLbl(etichete.get(11));
            adminUI.setStergereUserLbl(etichete.get(12));
            adminUI.setActualizareLbl(etichete.get(13));
            adminUI.setVizualizareLbl(etichete.get(14));
            adminUI.setFilterLbl(etichete.get(15));
        }
    }

    public void adaugareUtilizatorNou(){
        String username = adminUI.getUsernameTF();
        String parola = adminUI.getPasswordTF();
        String rol = adminUI.getRoleComboBox();
        String salariu = adminUI.getSalaryTF();
        String locatieLibrarie = adminUI.getComboBox();

        //am construit obiectul Utilizator folosind sablonul Builder creat
        Utilizator u = new UtilizatorBuilder().setUsername(username).setParola(parola).setRol(rol).setSalariu(salariu).setLocatieLibrarie(locatieLibrarie).build();
        proxyServer.sendObject("ADD_USER_ADMIN");
        proxyServer.sendObject(u);
    }

    public void eliminareUtilizator(){
        String username = adminUI.getUsernameTF();
        proxyServer.sendObject("DELETE_USER_ADMIN");
        proxyServer.sendObject(username);
    }

    public void actualizareUtilizator(){
        String username = adminUI.getUsernameTF();
        String salariu = adminUI.getSalaryTF();
        proxyServer.sendObject("UPDATE_USER_ADMIN");
        proxyServer.sendObject(username);
        proxyServer.sendObject(salariu);
    }

    public void vizualizareListaUtilizatori(){
        //aici am folosit sablonul Iterator implementat
        proxyServer.sendObject("VIEW_LIST_ADMIN");
        List<Utilizator> listaUtilizatori = (List<Utilizator>) proxyServer.receiveData();
        Colectie colectie = new ColectieConcreta(listaUtilizatori);
        Iterator iterator = colectie.getIterator();
        JTextArea textArea = adminUI.getTextArea();
        textArea.setText("");
        int i = 1;
        while (iterator.hasNext()) {
            Object element = iterator.next();
            textArea.append(i + "." + element + "\n");
            i++;
        }
    }

    public void filtrareListaDupaRol(){
        String rolFiltrare = adminUI.getRoleComboBox();
        JTextArea textArea = adminUI.getTextArea();
        textArea.setText("");
        proxyServer.sendObject("FILTER_AFTER_ROLE_ADMIN");
        List<Utilizator> users = (List<Utilizator>) proxyServer.receiveData();
        int i = 0;
        for (Utilizator u: users)
        {
            if(u.getRol().equals(rolFiltrare)){
                textArea.append(i + ". Username: " + u.getUsername() + ", Password: " + u.getParola() + ", Role: " + u.getRol() + ", Salary: " + u.getSalariu() + ", Locatie Librarie: " + u.getLocatieLibrarie() + "\n");
                i++;
            }
        }
    }

}
