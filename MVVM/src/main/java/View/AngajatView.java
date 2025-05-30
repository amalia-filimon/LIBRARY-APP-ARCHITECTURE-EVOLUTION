package View;

import ViewModel.VMAngajat;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AngajatView extends JFrame {

    private JPanel contentPane;
    @Bind(value = "text", target = "titluTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField titluTF;
    @Bind(value = "text", target = "autorTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField autorTF;
    @Bind(value = "text", target = "domeniuTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField domeniuTF;
    @Bind(value = "text", target = "disponibilitateTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField disponibilitateTF;
    @Bind(value = "text", target = "edituraTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField edituraTF;
    @Bind(value = "text", target = "pretTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField pretTF;
    private JLabel locatieLibrarieLbl;
    private JButton infoBtn;
    private JButton vizualizareListaBtn;
    private JButton adaugareBtn;
    private JButton stergereBtn;
    private JButton actualizareBtn;
    private JButton vanzareCarteBtn;
    private JButton cautareDupaTitluBtn;
    private JButton filtrareDomeniuBtn;
    private JButton filtrareDisponibilitateBtn;
    private JButton filtrareEdituraBtn;
    private JButton filtrareAutorBtn;
    private JButton filtrarePretBtn;
    @Bind(value = "model", target = "model.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable tabelCarti = new JTable(new DefaultTableModel());
    private JScrollPane scrollPane;
    private JButton csvBtn;
    private JButton jsonBtn;
    private JButton xmlBtn;
    private JButton txtBtn;
    private VMAngajat vmAngajat;

    public AngajatView(int idLibrarie, String locatieLibrarie) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Angajat");
        setBounds(100, 100, 1500, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        //setVisible(true);

        JLabel lblNewLabel = new JLabel("Bun venit pe pagina Angajatului!");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setBounds(576, 22, 385, 39);
        contentPane.add(lblNewLabel);

        infoBtn = new JButton("Consultati instructiunile");
        infoBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        infoBtn.setBounds(635, 106, 238, 29);
        contentPane.add(infoBtn);

        scrollPane = new JScrollPane(tabelCarti);
        tabelCarti.setRowHeight(25);
        scrollPane.setBounds(410, 156, 765, 439);
        contentPane.add(scrollPane, BorderLayout.WEST);

        JLabel lblNewLabel_1 = new JLabel("Titlu");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(35, 157, 55, 22);
        contentPane.add(lblNewLabel_1);

        titluTF = new JTextField();
        titluTF.setBounds(126, 157, 264, 29);
        contentPane.add(titluTF);
        titluTF.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Autor");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(32, 205, 58, 24);
        contentPane.add(lblNewLabel_2);

        autorTF = new JTextField();
        autorTF.setBounds(126, 206, 264, 29);
        contentPane.add(autorTF);
        autorTF.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Domeniu");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(21, 255, 78, 22);
        contentPane.add(lblNewLabel_3);

        domeniuTF = new JTextField();
        domeniuTF.setBounds(126, 255, 264, 29);
        contentPane.add(domeniuTF);
        domeniuTF.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Disponibilitate");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_4.setBounds(10, 305, 114, 22);
        contentPane.add(lblNewLabel_4);

        disponibilitateTF = new JTextField();
        disponibilitateTF.setBounds(126, 305, 264, 29);
        contentPane.add(disponibilitateTF);
        disponibilitateTF.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Editura");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_5.setBounds(33, 356, 68, 22);
        contentPane.add(lblNewLabel_5);

        edituraTF = new JTextField();
        edituraTF.setBounds(126, 356, 264, 29);
        contentPane.add(edituraTF);
        edituraTF.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Pret");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_6.setBounds(46, 404, 44, 22);
        contentPane.add(lblNewLabel_6);

        pretTF = new JTextField();
        pretTF.setBounds(126, 404, 264, 29);
        contentPane.add(pretTF);
        pretTF.setColumns(10);

        vizualizareListaBtn = new JButton("Vizualizati cartile din librarie");
        vizualizareListaBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        vizualizareListaBtn.setBounds(10, 473, 390, 39);
        contentPane.add(vizualizareListaBtn);

        locatieLibrarieLbl = new JLabel("");
        locatieLibrarieLbl.setHorizontalAlignment(SwingConstants.CENTER);
        locatieLibrarieLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        locatieLibrarieLbl.setBounds(576, 71, 385, 25);
        contentPane.add(locatieLibrarieLbl);

        //setez locatia librariei in care lucreaza angajatul
        locatieLibrarieLbl.setText("Locatia librariei: " + locatieLibrarie);

        JLabel lblNewLabel_7 = new JLabel("Filtrati cartile din librarie dupa urmatoarele criterii:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_7.setBounds(591, 605, 406, 29);
        contentPane.add(lblNewLabel_7);

        adaugareBtn = new JButton("Adaugati cartea");
        adaugareBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        adaugareBtn.setBounds(10, 541, 192, 29);
        contentPane.add(adaugareBtn);

        stergereBtn = new JButton("Stergeti cartea");
        stergereBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        stergereBtn.setBounds(212, 541, 188, 29);
        contentPane.add(stergereBtn);

        actualizareBtn = new JButton("Actualizati cartea");
        actualizareBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        actualizareBtn.setBounds(10, 587, 195, 29);
        contentPane.add(actualizareBtn);

        filtrareAutorBtn = new JButton("Autor");
        filtrareAutorBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        filtrareAutorBtn.setBounds(915, 648, 103, 29);
        contentPane.add(filtrareAutorBtn);

        filtrareDomeniuBtn = new JButton("Domeniu");
        filtrareDomeniuBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        filtrareDomeniuBtn.setBounds(443, 648, 114, 29);
        contentPane.add(filtrareDomeniuBtn);

        filtrareDisponibilitateBtn = new JButton("Disponibilitate");
        filtrareDisponibilitateBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        filtrareDisponibilitateBtn.setBounds(586, 648, 167, 29);
        contentPane.add(filtrareDisponibilitateBtn);

        filtrareEdituraBtn = new JButton("Editura");
        filtrareEdituraBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        filtrareEdituraBtn.setBounds(787, 648, 98, 28);
        contentPane.add(filtrareEdituraBtn);

        filtrarePretBtn = new JButton("pret");
        filtrarePretBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        filtrarePretBtn.setBounds(1047, 648, 85, 29);
        contentPane.add(filtrarePretBtn);

        vanzareCarteBtn = new JButton("Vindeti cartea");
        vanzareCarteBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        vanzareCarteBtn.setBounds(215, 587, 185, 28);
        contentPane.add(vanzareCarteBtn);

        cautareDupaTitluBtn = new JButton("Cautati o carte dupa titlu");
        cautareDupaTitluBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        cautareDupaTitluBtn.setBounds(10, 643, 390, 39);
        contentPane.add(cautareDupaTitluBtn);

        JLabel lblNewLabel_8 = new JLabel("Salvati situatia cartilor din librarie ");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_8.setBounds(1200, 206, 276, 23);
        contentPane.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("intr-unul din urmatoarele formate:");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_9.setBounds(1185, 228, 291, 22);
        contentPane.add(lblNewLabel_9);

        csvBtn = new JButton("csv");
        csvBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        csvBtn.setBounds(1276, 302, 114, 29);
        contentPane.add(csvBtn);

        jsonBtn = new JButton("json");
        jsonBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jsonBtn.setBounds(1276, 356, 114, 29);
        contentPane.add(jsonBtn);

        xmlBtn = new JButton("xml");
        xmlBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        xmlBtn.setBounds(1276, 418, 114, 29);
        contentPane.add(xmlBtn);

        txtBtn = new JButton("txt");
        txtBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtBtn.setBounds(1276, 478, 114, 29);
        contentPane.add(txtBtn);

        vmAngajat = new VMAngajat();

        try {
            Binder.bind(this, vmAngajat);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        infoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AngajatView.showMessage("Pentru a adauga o carte noua, " +
                        "completati toate campurile corespunzatoare si apasati butonul: Adaugati cartea!\n" + "\n" +
                        "Pentru a sterge o carte, introduceti titlul si autorul cartii pe care doriti sa o stergeti si apasati butonul: Stergeti cartea!\n" + "\n" +
                        "Pentru a actualiza o carte, introduceti titlul si autorul cartii si noua disponibilitate cu care se va face actualizarea,\n" +
                        " iar apoi apasati butonul: Actualizati cartea!");
            }
        });

        vizualizareListaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.setIdLibrarie(idLibrarie);
                vmAngajat.vizualizareListaCarti.executa();
                designTables();
            }
        });

        adaugareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.adaugareCarte.executa();
            }
        });

        stergereBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.stergereCarte.executa();
            }
        });

        actualizareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.actualizareCarte.executa();
            }
        });

        vanzareCarteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.vanzareCarte.executa();
            }
        });

        cautareDupaTitluBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.cautareCarteDupaTitlu.executa();
            }
        });

        filtrareDomeniuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.filtrareDupaDomeniu.executa();
            }
        });

        filtrareDisponibilitateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.filtrareDupaDisponibilitate.executa();
            }
        });

        filtrareEdituraBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.filtrareDupaEditura.executa();
            }
        });

        filtrareAutorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.filtrareDupaAutor.executa();
            }
        });

        filtrarePretBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.filtrareDupaPret.executa();
            }
        });

        csvBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.salvareCSV.executa();
            }
        });

        jsonBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.salvareJSON.executa();
            }
        });

        txtBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.salvareTXT.executa();
            }
        });

        xmlBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAngajat.salvareXML.executa();
            }
        });

        setVisible(true);
    }

    public static void showMessage(String message){
        JOptionPane.showMessageDialog(new JFrame(), message);
    }

    public void designTables(){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < tabelCarti.getColumnModel().getColumnCount(); i++){
            tabelCarti.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        tabelCarti.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

}
