package View;

import Model.Librarie;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AdministratorUI extends JFrame {
    private JTextField usernameTF;
    private JTextField passwordTF;
    private JTextField salaryTF;
    private JButton adaugatiUtilizatorulButton;
    private JButton stergetiUtilizatorulButton;
    private JButton actualizatiSalariulButton;
    private JPanel adminMainPanel;
    private JButton vizualizareBtn;
    private JTextArea textArea;
    private JComboBox comboBox;
    private JLabel languageLbl;
    private JLabel addUserLbl;
    private JLabel usernameLbl;
    private JLabel passwordLbl;
    private JLabel roleLbl;
    private JLabel salaryLbl;
    private JLabel locationLbl;
    private JLabel stergereUserLbl;
    private JLabel actualizareLbl;
    private JLabel vizualizareLbl;
    private JLabel titleLbl;
    private JCheckBox checkBoxRomana;
    private JCheckBox checkBoxSpaniola;
    private JCheckBox checkBoxEngleza;
    private JCheckBox checkBoxFranceza;
    private JComboBox roleComboBox;
    private JLabel filterLbl;
    private JButton filterTheListBtn;

    public AdministratorUI(List<Librarie> listaLibrarii){
        setTitle("Administrator");
        setContentPane(adminMainPanel);
        setMinimumSize(new Dimension(900, 700));
        setVisible(true);

        for(Librarie l : listaLibrarii){
            this.comboBox.addItem(l.getLocatie());
        }

        String[] roluri = {"ADMINISTRATOR", "MANAGER", "ANGAJAT"};
        for(String rol: roluri){
            this.roleComboBox.addItem(rol);
        }

    }

    public void setAdaugatiUtilizatorulButton(String text) {
        this.adaugatiUtilizatorulButton.setText(text);
    }

    public void setStergetiUtilizatorulButton(String text) {
        this.stergetiUtilizatorulButton.setText(text);
    }

    public void setActualizatiSalariulButton(String text) {
        this.actualizatiSalariulButton.setText(text);
    }

    public void setVizualizareBtn(String text) {
        this.vizualizareBtn.setText(text);
    }

    public void setLanguageLbl(String text) {
        this.languageLbl.setText(text);
    }

    public void setAddUserLbl(String text) {
        this.addUserLbl.setText(text);
    }

    public void setUsernameLbl(String text) {
        this.usernameLbl.setText(text);
    }

    public void setPasswordLbl(String text) {
        this.passwordLbl.setText(text);
    }

    public void setRoleLbl(String text) {
        this.roleLbl.setText(text);
    }

    public void setSalaryLbl(String text) {
        this.salaryLbl.setText(text);
    }

    public void setLocationLbl(String text) {
        this.locationLbl.setText(text);
    }

    public void setStergereUserLbl(String text) {
        this.stergereUserLbl.setText(text);
    }

    public void setActualizareLbl(String text) {
        this.actualizareLbl.setText(text);
    }

    public void setVizualizareLbl(String text) {
        this.vizualizareLbl.setText(text);
    }

    public void setTitleLbl(String text){
        this.titleLbl.setText(text);
    }

    public void setFilterTheListBtn(String text){
        this.filterTheListBtn.setText(text);
    }

    public void setFilterLbl(String text){
        this.filterLbl.setText(text);
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

    public JButton getAdaugatiUtilizatorulButton(){
        return this.adaugatiUtilizatorulButton;
    }

    public JButton getStergetiUtilizatorulButton(){
        return this.stergetiUtilizatorulButton;
    }

    public JButton getActualizatiSalariulButton(){
        return this.actualizatiSalariulButton;
    }

    public JButton getVizualizareBtn(){
        return this.vizualizareBtn;
    }

    public JButton getFilterTheListBtn(){
        return this.filterTheListBtn;
    }

    public String getUsernameTF(){
        return this.usernameTF.getText();
    }

    public String getPasswordTF(){
        return this.passwordTF.getText();
    }

    public String getRoleComboBox(){
        return (String) this.roleComboBox.getSelectedItem();
    }

    public String getSalaryTF(){
        return this.salaryTF.getText();
    }

    public String getComboBox(){
        return (String) this.comboBox.getSelectedItem();
    }

    public JTextArea getTextArea(){
        return this.textArea;
    }
}
