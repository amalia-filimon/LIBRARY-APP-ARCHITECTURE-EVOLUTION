package View;

import Model.Carte;
import Presenter.AngajatPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

public class AngajatUI extends JFrame implements AngajatInterface{
    private JPanel angajatPanel;
    private JLabel locatieLibrarieLbl;
    private JTextArea textArea;
    private JButton sortareBtn;
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
    private AngajatPresenter angajatPresenter;
    private int idLibrarie;

    public AngajatUI(int id_librarie, String locatieLibrarie){
        setTitle("Angajat");
        setContentPane(angajatPanel);
        setMinimumSize(new Dimension(600, 500));
        setVisible(true);

        angajatPresenter = new AngajatPresenter(this);

        //setez locatia librariei in care lucreaza angajatul
        locatieLibrarieLbl.setText("Locatia librariei: " + locatieLibrarie);
        this.idLibrarie = id_librarie;

        sortareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                angajatPresenter.vizualizareListaSortata();
            }
        });
        domeniuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                angajatPresenter.filtrareListaDomeniu();
            }
        });
        disponibilitateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                angajatPresenter.filtrareListaDisponibilitate();
            }
        });
        edituraBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                angajatPresenter.filtrareListaEditura();
            }
        });
        autorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                angajatPresenter.filtrareListaAutor();
            }
        });
        pretBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                angajatPresenter.filtrareListaPret();
            }
        });
        adaugatiCarteaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angajatPresenter.adaugareCarteNoua();
            }
        });
        stergetiCarteaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angajatPresenter.stergereCarte();
            }
        });
        actualizatiCarteaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angajatPresenter.actualizareCarte();
            }
        });
    }

    public int getIdLibrarie(){
        return this.idLibrarie;
    }

    @Override
    public void vizualizareListaCartiSortata(TreeSet<Carte> lista) {
        int i = 1;
        for(Carte c : lista){
            this.textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
            i++;
        }
    }

    @Override
    public void filtrareDomeniu(TreeSet<Carte> lista) {
        int i = 1;
        String domeniu = this.domeniuTF.getText();
        for(Carte c : lista){
            if(c.getDomeniu().equals(domeniu)){
                this.textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
            }
            i++;
        }
    }

    @Override
    public void filtrareDisponibilitate(TreeSet<Carte> lista) {
        int i = 1;
        String disponibilitate = this.disponibilitateTF.getText();
        for(Carte c : lista){
            if(c.getDisponibilitate().equals(disponibilitate)){
                this.textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
            }
            i++;
        }
    }

    @Override
    public void filtrareEditura(TreeSet<Carte> lista) {
        int i = 1;
        String editura = this.edituraTF.getText();
        for(Carte c : lista){
            if(c.getEditura().equals(editura)){
                this.textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
            }
            i++;
        }
    }

    @Override
    public void filtrareAutor(TreeSet<Carte> lista) {
        int i = 1;
        String autor = this.autorTF.getText();
        for(Carte c : lista){
            if(c.getAutor().equals(autor)){
                this.textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
            }
            i++;
        }
    }

    @Override
    public void filtrarePret(TreeSet<Carte> lista) {
        int i = 1;
        String pret = this.pretTF.getText();
        for(Carte c : lista){
            if(c.getPret().equals(pret)){
                this.textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
            }
            i++;
        }
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
}
