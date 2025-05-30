package Controller;

import Model.Carte;
import Model.Persistenta.LibrariePersistenta;
import Model.Persistenta.UtilizatorPersistenta;
import Model.Utilizator;
import View.LoginUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LoginController {
    private LoginUI loginUI = null;
    private UtilizatorPersistenta up = null;
    private LibrariePersistenta lp = null;

    public LoginController(){
        loginUI = new LoginUI();
        lp = new LibrariePersistenta();
        up = new UtilizatorPersistenta();

        loginUI.getCheckBoxRomana().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Romana.csv");
            }
        });

        loginUI.getCheckBoxEngleza().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Engleza.csv");
            }
        });

        loginUI.getCheckBoxSpaniola().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Spaniola.csv");
            }
        });

        loginUI.getCheckBoxFranceza().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Franceza.csv");
            }
        });

        loginUI.getLoginBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginUI.getLoginSubiect().notificare();
            }
        });

        loginUI.getLoginSubiect().adaugare(o -> {
            email();
            login();
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
            loginUI.setLoginBtn(butoane.get(0));
        }
        if(!etichete.isEmpty()){
            loginUI.setTitleLbl(etichete.get(0));
            loginUI.setLanguageLbl(etichete.get(1));
            loginUI.setUsernameLbl(etichete.get(2));
            loginUI.setPassword(etichete.get(3));
        }
    }

    public void login(){
        String username = loginUI.getUsername();
        String parola = loginUI.getPassword();
        Utilizator utilizatorDeCautatInBD = new Utilizator(username, parola, null);
        Utilizator utilizatorObtinutDinBD = this.up.cautareUtilizator(utilizatorDeCautatInBD);
        if(utilizatorObtinutDinBD == null){
            JOptionPane.showMessageDialog(null, "Credentialele utilizate nu corespund niciunui utilizator intregistrat in aplicatia noastra! Mai incercati.", "Eroare", JOptionPane.ERROR_MESSAGE);
        }else{
            String rol = utilizatorObtinutDinBD.getRol();
            String usernameUtilizatorLogat = utilizatorObtinutDinBD.getUsername();
            String locatieAngajatLogat = this.up.locatieUtilizator(usernameUtilizatorLogat);
            int id_librarie = this.up.idLibrarieAngajat(usernameUtilizatorLogat);
            if(rol.equals("ANGAJAT")) {
                AngajatController angajatController = new AngajatController(id_librarie, locatieAngajatLogat);
            }
            else if(rol.equals("MANAGER")){
                ManagerController managerController = new ManagerController();
            }
            else if(rol.equals("ADMINISTRATOR")){
                AdminController adminController = new AdminController();
            }
        }
    }

    public void email(){
        try (PrintWriter writer = new PrintWriter(new File("email.txt"))) {
            writer.println("V-ati autentificat cu username-ul: " + loginUI.getUsername());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
