package Controller;

import Model.Persistenta.LibrariePersistenta;
import Model.Persistenta.UtilizatorPersistenta;
import Model.Utilizator;
import View.AdministratorUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminController {
    private AdministratorUI adminUI = null;
    private UtilizatorPersistenta up = null;
    private LibrariePersistenta lp = null;
    public AdminController(){
        lp = new LibrariePersistenta();
        up = new UtilizatorPersistenta();
        adminUI = new AdministratorUI(lp.listaLibrarii());

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

        Utilizator u = new Utilizator(username, parola, rol, salariu, locatieLibrarie);
        up.adaugareUtilizator(u);
    }

    public void eliminareUtilizator(){
        String username = adminUI.getUsernameTF();
        up.stergereUtilizator(username);
    }

    public void actualizareUtilizator(){
        String username = adminUI.getUsernameTF();
        String salariu = adminUI.getSalaryTF();
        up.actualizareUtilizator(username, salariu);
    }

    public void vizualizareListaUtilizatori(){
        List<Utilizator> listaUtilizatori = up.listaUtilizatori();
        JTextArea textArea = adminUI.getTextArea();
        textArea.setText("");
        int i = 1;
        for(Utilizator u : listaUtilizatori){
            textArea.append(i + ". Username: " + u.getUsername() + ", Password: " + u.getParola() + ", Role: " + u.getRol() + ", Salary: " + u.getSalariu() + ", Locatie Librarie: " + u.getLocatieLibrarie() + "\n");
            i++;
        }
    }

    public void filtrareListaDupaRol(){
        String rolFiltrare = adminUI.getRoleComboBox();
        JTextArea textArea = adminUI.getTextArea();
        textArea.setText("");
        List<Utilizator> users = up.listaUtilizatori();
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
