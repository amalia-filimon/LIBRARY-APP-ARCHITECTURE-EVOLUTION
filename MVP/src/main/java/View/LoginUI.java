package View;

import Model.Librarie;
import Presenter.LoginPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginUI extends JFrame implements LoginInterface{
    private JTextField usernameTF;
    private JTextField passwordTF;
    private JButton loginBtn;
    private JPanel loginPanel;
    private LoginPresenter loginPresenter;

    public LoginUI(){
        setTitle("Login Page");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(600, 500));
        setVisible(true);

        loginPresenter = new LoginPresenter(this);


        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPresenter.login();
            }
        });
    }

    public String getUsername(){
        return this.usernameTF.getText();
    }

    public String getPassword(){
        return this.passwordTF.getText();
    }

    public void setAdministrator(List<Librarie> listaLibrarii){
        AdministratorUI adminUI = new AdministratorUI(listaLibrarii);
        setVisible(false);
    }

    public void setAngajat(int id_librarie, String locatie){
        AngajatUI angajatUI = new AngajatUI(id_librarie, locatie);
        setVisible(false);
    }

    public void setManager(List<Librarie> listaLibrarii){
        ManagerUI managerUI = new ManagerUI(listaLibrarii);
        setVisible(false);
    }


}
