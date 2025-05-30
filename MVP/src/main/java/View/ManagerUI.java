package View;

import Model.Carte;
import Model.Librarie;
import Presenter.ManagerPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.TreeSet;

public class ManagerUI extends JFrame implements ManagerInterface{
    private JPanel managerPanel;
    private JButton vizualizareListaBtn;
    private JTextArea textArea;
    private JComboBox<String> comboBox;
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
    private ManagerPresenter managerPresenter;

    public ManagerUI(List<Librarie> listaLibrarii){
        setTitle("Manager");
        setContentPane(managerPanel);
        setMinimumSize(new Dimension(800, 800));
        setVisible(true);

        managerPresenter = new ManagerPresenter(this);

        for(Librarie l : listaLibrarii){
            this.comboBox.addItem(l.getLocatie());
        }

        vizualizareListaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                managerPresenter.vizualizareLista();
            }
        });
        domeniuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                managerPresenter.filtrareListaDomeniu();
            }
        });
        disponibilitateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                managerPresenter.filtrareListaDisponibilitate();
            }
        });
        edituraBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                managerPresenter.filtrareListaEditura();
            }
        });
        autorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                managerPresenter.filtrareListaAutor();
            }
        });
        pretBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                managerPresenter.filtrareListaPret();
            }
        });
    }

    public String getComboBox(){
        return (String) this.comboBox.getSelectedItem();
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
}
