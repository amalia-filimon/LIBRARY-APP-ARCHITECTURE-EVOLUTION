package View;

import javax.swing.*;
import java.awt.*;

public class AngajatUI extends JFrame{
    private JPanel angajatPanel;
    private JLabel locatieLibrarieLbl;
    private JTextArea textArea;
    private JButton vizualizareListaBtn;
    private JTextField domeniuTF;
    private JTextField disponibilitateTF;
    private JButton domeniuBtn;
    private JTextField edituraTF;
    private JTextField autorTF;
    private JTextField pretTF;
    private JButton disponibilitateBtn;
    private JButton edituraBtn;
    private JButton autorBtn;
    private JButton pretBtn;
    private JTextField titluTFCRUD;
    private JTextField autorTFCRUD;
    private JTextField domeniuTFCRUD;
    private JTextField disponibilitateTFCRUD;
    private JTextField edituraTFCRUD;
    private JTextField pretTFCRUD;
    private JButton adaugatiCarteaBtn;
    private JButton stergetiCarteaBtn;
    private JButton actualizatiCarteaBtn;
    private JLabel titleLbl;
    private JLabel selectatiCriteriulLbl;
    private JLabel listaLbl;
    private JLabel cartiCRUDLbl;
    private JLabel bookTitleLbl;
    private JLabel autorLbl;
    private JLabel domeniuLbl;
    private JLabel disponibilitateLbl;
    private JLabel edituraLbl;
    private JLabel pretLbl;
    private JLabel stergereLbl;
    private JLabel actualizareLbl;
    private JLabel languageLbl;
    private JCheckBox checkBoxRomana;
    private JCheckBox checkBoxSpaniola;
    private JCheckBox checkBoxEngleza;
    private JCheckBox checkBoxFranceza;
    private JButton cautareDupaTitluBtn;
    private JButton vanzareCarteBtn;
    private JLabel salvareListaInFormateLbl;
    private JButton txtBtn;
    private JButton jsonBtn;
    private JButton xmlBtn;
    private JButton csvBtn;
    private int idLibrarie;

    public AngajatUI(int id_librarie, String locatieLibrarie){
        setTitle("Angajat");
        setContentPane(angajatPanel);
        setMinimumSize(new Dimension(600, 500));
        setVisible(true);

        //setez locatia librariei in care lucreaza angajatul
        locatieLibrarieLbl.setText("Locatia librariei: " + locatieLibrarie);
        this.idLibrarie = id_librarie;

    }

    public void setTitleLbl(String text){
        this.titleLbl.setText(text);
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

    public void setEdituraBtn(String text){
        this.edituraBtn.setText(text);
    }

    public void setAutorBtn(String text){
        this.autorBtn.setText(text);
    }

    public void setPretBtn(String text){
        this.pretBtn.setText(text);
    }

    public void setBookTitleLbl(String text){
        this.bookTitleLbl.setText(text);
    }

    public void setDomeniuLbl(String text){
        this.domeniuLbl.setText(text);
    }

    public void setDisponibilitateLbl(String text){
        this.disponibilitateLbl.setText(text);
    }

    public void setEdituraLbl(String text){
        this.edituraLbl.setText(text);
    }

    public void setAutorLbl(String text){
        this.autorLbl.setText(text);
    }

    public void setPretLbl(String text){
        this.pretLbl.setText(text);
    }

    public void setAdaugatiCarteaBtn(String text){
        this.adaugatiCarteaBtn.setText(text);
    }

    public void setStergetiCarteaBtn(String text){
        this.stergetiCarteaBtn.setText(text);
    }

    public void setActualizatiCarteaBtn(String text){
        this.actualizatiCarteaBtn.setText(text);
    }

    public void setStergereLbl(String text){
        this.stergereLbl.setText(text);
    }

    public void setActualizareLbl(String text){
        this.actualizareLbl.setText(text);
    }

    public void setLanguageLbl(String text){
        this.languageLbl.setText(text);
    }

    public void setListaLbl(String text){
        this.listaLbl.setText(text);
    }

    public void setCartiCRUDLbl(String text){
        this.cartiCRUDLbl.setText(text);
    }

    public void setCautareDupaTitluBtn(String text){
        this.cautareDupaTitluBtn.setText(text);
    }

    public void setVanzareCarteBtn(String text){
        this.vanzareCarteBtn.setText(text);
    }

    public void setSalvareListaInFormateLbl(String text){
        this.salvareListaInFormateLbl.setText(text);
    }

    public int getIdLibrarie(){
        return this.idLibrarie;
    }

    public String getTitluTFCRUD() {
        return this.titluTFCRUD.getText();
    }

    public String getAutorTFCRUD() {
        return this.autorTFCRUD.getText();
    }

    public String getDomeniuTFCRUD() {
        return this.domeniuTFCRUD.getText();
    }

    public String getDisponibilitateTFCRUD() {
        return this.disponibilitateTFCRUD.getText();
    }

    public String getEdituraTFCRUD() {
        return this.edituraTFCRUD.getText();
    }

    public String getPretTFCRUD() {
        return this.pretTFCRUD.getText();
    }

    public void setLocatieLibrarieLbl(String text){
        this.locatieLibrarieLbl.setText(text);
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

    public JTextArea getTextArea(){
        return this.textArea;
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

    public JButton getCautareDupaTitluBtn(){
        return this.cautareDupaTitluBtn;
    }

    public JButton getVanzareCarteBtn(){
        return this.vanzareCarteBtn;
    }

    public JButton getAdaugatiCarteaBtn(){
        return this.adaugatiCarteaBtn;
    }

    public JButton getStergetiCarteaBtn(){
        return this.stergetiCarteaBtn;
    }

    public JButton getActualizatiCarteaBtn(){
        return this.actualizatiCarteaBtn;
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
}
