package View;

import Model.Librarie;
import Model.Utilizator;
import Presenter.AdminPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AdministratorUI extends JFrame implements AdminInterface{
    private JTextField usernameTF;
    private JTextField passwordTF;
    private JTextField roleTF;
    private JTextField salaryTF;
    private JButton adaugatiUtilizatorulButton;
    private JButton stergetiUtilizatorulButton;
    private JButton actualizatiSalariulButton;
    private JPanel adminMainPanel;
    private JButton vizualizareBtn;
    private JTextArea textArea;
    private JComboBox comboBox;
    private AdminPresenter adminPresenter;

    public AdministratorUI(List<Librarie> listaLibrarii){
        setTitle("Angajat");
        setContentPane(adminMainPanel);
        setMinimumSize(new Dimension(900, 700));
        setVisible(true);

        for(Librarie l : listaLibrarii){
            this.comboBox.addItem(l.getLocatie());
        }

        adminPresenter = new AdminPresenter(this);

        adaugatiUtilizatorulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPresenter.adaugareUtilizatorNou();
                textArea.setText("");
            }
        });

        stergetiUtilizatorulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPresenter.eliminareUtilizator();
                textArea.setText("");
            }
        });

        actualizatiSalariulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPresenter.actualizareUtilizator();
                textArea.setText("");
            }
        });
        vizualizareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPresenter.listaUtilizatori();
            }
        });
    }

    @Override
    public String getUsernameTF() {
        return this.usernameTF.getText();
    }

    @Override
    public String getPasswordTF() {
        return this.passwordTF.getText();
    }

    @Override
    public String getRoleTF() {
        return this.roleTF.getText();
    }

    @Override
    public String getSalaryTF() {
        return this.salaryTF.getText();
    }

    @Override
    public String getComboBox(){
        return (String) this.comboBox.getSelectedItem();
    }

    @Override
    public void setListaUtilizatori(List<Utilizator> listaUtilizatori) {
        int i = 1;
        for(Utilizator u : listaUtilizatori){
            this.textArea.append(i + ". Username: " + u.getUsername() + ", Password: " + u.getParola() + ", Role: " + u.getRol() + ", Salary: " + u.getSalariu() + ", Locatie Librarie: " + u.getLocatieLibrarie() + "\n");
            i++;
        }
    }
}
