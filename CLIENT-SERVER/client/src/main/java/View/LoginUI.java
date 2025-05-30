package View;

import Model.Subiect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LoginUI extends JFrame{
    private JTextField usernameTF;
    private JTextField passwordTF;
    private JButton loginBtn;
    private JPanel loginPanel;
    private JLabel languageLbl;
    private JLabel titleLbl;
    private JLabel usernameLbl;
    private JLabel passwordLbl;
    private JCheckBox checkBoxRomana;
    private JCheckBox checkBoxEngleza;
    private JCheckBox checkBoxSpaniola;
    private JCheckBox checkBoxFranceza;
    private Subiect loginSubiect = new Subiect();

    public LoginUI() {
        setTitle("Login Page");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(500, 500));
        setVisible(true);

    }
    public Subiect getLoginSubiect(){
        return this.loginSubiect;
    }

    public void setLoginBtn(String name){
        this.loginBtn.setText(name);
    }

    public void setLanguageLbl(String name){
        this.languageLbl.setText(name);
    }

    public void setTitleLbl(String name){
        this.titleLbl.setText(name);
    }

    public void setUsernameLbl(String name){
        this.usernameLbl.setText(name);
    }

    public void setPassword(String name){
        this.passwordLbl.setText(name);
    }

    public String getUsername(){
        return this.usernameTF.getText();
    }

    public String getPassword(){
        return this.passwordTF.getText();
    }

    public JCheckBox getCheckBoxRomana() {
        return checkBoxRomana;
    }

    public JCheckBox getCheckBoxEngleza() {
        return checkBoxEngleza;
    }

    public JCheckBox getCheckBoxSpaniola() {
        return checkBoxSpaniola;
    }

    public JCheckBox getCheckBoxFranceza() {
        return checkBoxFranceza;
    }

    public JButton getLoginBtn(){
        return this.loginBtn;
    }
}
