package View;

import Model.Librarie;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ManagerUI extends JFrame{
    private JPanel managerPanel;
    private JButton vizualizareListaBtn;
    private JTextArea textArea;
    private JComboBox<String> listaLibrariiComboBox;
    private JTextField domeniuTF;
    private JTextField disponibilitateTF;
    private JTextField edituraTF;
    private JTextField autorTF;
    private JTextField pretTF;
    private JButton domeniuBtn;
    private JButton disponibilitateBtn;
    private JButton edituraBtn;
    private JButton autorBtn;
    private JButton pretBtn;
    private JLabel titleLbl;
    private JLabel selectLocationLbl;
    private JLabel languageLbl;
    private JCheckBox checkBoxRomana;
    private JCheckBox checkBoxSpaniola;
    private JCheckBox checkBoxEngleza;
    private JLabel selectatiCriteriulLbl;
    private JLabel listLbl;
    private JCheckBox checkBoxFranceza;
    private JTextField cautaCarteaDupaTitluTF;
    private JButton cautaCarteDupaTitluBtn;
    private JLabel salvareListaInFormateLbl;
    private JButton txtBtn;
    private JButton csvBtn;
    private JButton xmlBtn;
    private JButton jsonBtn;
    private JButton graficBtn;

    public ManagerUI(List<Librarie> listaLibrarii){
        setTitle("Manager");
        setContentPane(managerPanel);
        setMinimumSize(new Dimension(800, 800));
        setVisible(true);

        for(Librarie l : listaLibrarii){
            this.listaLibrariiComboBox.addItem(l.getLocatie());
        }

    }

    public void setTitleLbl(String text){
        this.titleLbl.setText(text);
    }

    public void setLanguageLbl(String text) {
        this.languageLbl.setText(text);
    }

    public void setSelectLocationLbl(String text){
        this.selectLocationLbl.setText(text);
    }

    public void setVizualizareListaBtn(String text){
        this.vizualizareListaBtn.setText(text);
    }

    public void setSelectatiCriteriulLbl(String text){
        this.selectatiCriteriulLbl.setText(text);
    }

    public void setDomeniuBtn(String text){
        this.domeniuBtn.setText(text);
    }

    public void setDisponibilitateBtn(String text){
        this.disponibilitateBtn.setText(text);
    }

    public void setEditura(String text){
        this.edituraBtn.setText(text);
    }

    public void setAutorBtn(String text){
        this.autorBtn.setText(text);
    }

    public void setPretBtn(String text){
        this.pretBtn.setText(text);
    }

    public void setListLbl(String text){
        this.listLbl.setText(text);
    }

    public void setGraficBtn(String text){
        this.graficBtn.setText(text);
    }

    public void setCautaCarteDupaTitluBtn(String text){
        this.cautaCarteDupaTitluBtn.setText(text);
    }

    public void setSalvareListaInFormateLbl(String text){
        this.salvareListaInFormateLbl.setText(text);
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

    public JButton getVizualizareListaBtn(){
        return this.vizualizareListaBtn;
    }

    public String getListaLibrariiComboBox(){
        return (String) this.listaLibrariiComboBox.getSelectedItem();
    }

    public String getCautareCarteDupaTitluTF(){
        return this.cautaCarteaDupaTitluTF.getText();
    }

    public JTextArea getTextArea(){
        return this.textArea;
    }

    public String getDomeniuTF(){
        return this.domeniuTF.getText();
    }

    public String getDisponibilitateTF(){
        return this.disponibilitateTF.getText();
    }

    public String getEdituraTF(){
        return this.edituraTF.getText();
    }

    public String getAutorTF(){
        return this.autorTF.getText();
    }

    public String getPretTF(){
        return this.pretTF.getText();
    }

    public JButton getDomeniuBtn(){
        return this.domeniuBtn;
    }

    public JButton getDisponibilitateBtn(){
        return this.disponibilitateBtn;
    }

    public JButton getEdituraBtn(){
        return this.edituraBtn;
    }

    public JButton getAutorBtn(){
        return this.autorBtn;
    }

    public JButton getPretBtn(){
        return this.pretBtn;
    }

    public JButton getCautaCarteDupaTitluBtn(){
        return this.cautaCarteDupaTitluBtn;
    }

    public JButton getTxtBtn(){
        return this.txtBtn;
    }

    public JButton getJsonBtn(){
        return this.jsonBtn;
    }

    public JButton getXmlBtn(){
        return this.xmlBtn;
    }

    public JButton getCsvBtn(){
        return this.csvBtn;
    }

    public JButton getGraficBtn(){
        return this.graficBtn;
    }

}
