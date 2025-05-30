package View;

import Model.Librarie;
import ViewModel.VMAdmin;
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
import java.util.List;

public class AdminView extends JFrame {

    private JPanel contentPane;
    @Bind(value = "text", target = "usernameTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField usernameTF;
    @Bind(value = "text", target = "passwordTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField passwordTF;
    @Bind(value = "text", target = "salaryTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField salaryTF;
    @Bind(value = "text", target = "locatieLibrarieComboBox.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField locatieLibrarieTF = new JTextField();
    private JComboBox locatieLibrarieComboBox;
    @Bind(value = "text", target = "roleComboBox.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField rolTF = new JTextField();
    private JComboBox roleComboBox;
    @Bind(value = "model", target = "model.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable usersTable = new JTable(new DefaultTableModel());
    private JScrollPane scrollPane;
    private JButton adaugareBtn;
    private JButton stergereBtn;
    private JButton actualizareBtn;
    private JButton infoBtn;
    private JButton vizualizareBtn;
    private JButton filtrareBtn;
    private VMAdmin vmAdmin;

    public AdminView(List<Librarie> listaLibrarii) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel usernameLbl = new JLabel("Username");
        usernameLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        usernameLbl.setBounds(10, 133, 87, 19);
        contentPane.add(usernameLbl);

        JLabel passwordLbl = new JLabel("Password");
        passwordLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passwordLbl.setBounds(10, 189, 72, 13);
        contentPane.add(passwordLbl);

        JLabel roleLbl = new JLabel("Role");
        roleLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        roleLbl.setBounds(10, 240, 45, 13);
        contentPane.add(roleLbl);

        JLabel salaryLbl = new JLabel("Salary");
        salaryLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        salaryLbl.setBounds(10, 287, 72, 19);
        contentPane.add(salaryLbl);

        JLabel libraryLbl = new JLabel("Library");
        libraryLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        libraryLbl.setBounds(10, 347, 72, 17);
        contentPane.add(libraryLbl);

        usernameTF = new JTextField();
        usernameTF.setBounds(92, 128, 200, 30);
        contentPane.add(usernameTF);
        usernameTF.setColumns(10);

        passwordTF = new JTextField();
        passwordTF.setBounds(92, 183, 200, 30);
        contentPane.add(passwordTF);
        passwordTF.setColumns(10);

        roleComboBox = new JComboBox();
        roleComboBox.setBounds(92, 233, 200, 30);
        contentPane.add(roleComboBox);

        salaryTF = new JTextField();
        salaryTF.setBounds(92, 284, 200, 30);
        contentPane.add(salaryTF);
        salaryTF.setColumns(10);

        locatieLibrarieComboBox = new JComboBox();
        locatieLibrarieComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        locatieLibrarieComboBox.setBounds(92, 340, 200, 30);
        contentPane.add(locatieLibrarieComboBox);

        adaugareBtn = new JButton("Adaugati utilizatorul");
        adaugareBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        adaugareBtn.setBounds(45, 408, 206, 30);
        contentPane.add(adaugareBtn);

        stergereBtn = new JButton("Stergeti utilizatorul");
        stergereBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        stergereBtn.setBounds(45, 458, 206, 30);
        contentPane.add(stergereBtn);

        actualizareBtn = new JButton("Actualizati utilizatorul");
        actualizareBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        actualizareBtn.setBounds(45, 509, 206, 30);
        contentPane.add(actualizareBtn);

        JLabel lblNewLabel = new JLabel("Bun venit pe pagina Administratorului!");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(377, 10, 468, 30);
        contentPane.add(lblNewLabel);

        infoBtn = new JButton("Consultati instructiunile");
        infoBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        infoBtn.setBounds(498, 63, 218, 30);
        contentPane.add(infoBtn);

        scrollPane = new JScrollPane(usersTable);
        usersTable.setRowHeight(25);
        scrollPane.setBounds(329, 133, 830, 457);
        contentPane.add(scrollPane, BorderLayout.WEST);

        vizualizareBtn = new JButton("Vizualizati utilizatorii");
        vizualizareBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        vizualizareBtn.setBounds(45, 560, 206, 30);
        contentPane.add(vizualizareBtn);

        filtrareBtn = new JButton("Filtrati utilizatorii");
        filtrareBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        filtrareBtn.setBounds(45, 607, 206, 30);
        contentPane.add(filtrareBtn);

        vmAdmin = new VMAdmin();

        for(Librarie l : listaLibrarii){
            this.locatieLibrarieComboBox.addItem(l.getLocatie());
        }
        locatieLibrarieTF.setText(locatieLibrarieComboBox.getSelectedItem().toString());


        String[] roluri = {"ADMINISTRATOR", "MANAGER", "ANGAJAT"};
        for(String rol: roluri){
            this.roleComboBox.addItem(rol);
        }
        rolTF.setText(roleComboBox.getSelectedItem().toString());

        try {
            Binder.bind(this, vmAdmin);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        locatieLibrarieComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                locatieLibrarieTF.setText(locatieLibrarieComboBox.getSelectedItem().toString());
            }
        });

        roleComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rolTF.setText(roleComboBox.getSelectedItem().toString());
            }
        });

        infoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminView.showMessage("Pentru a adauga un utilizator, " +
                        "completati toate campurile corespunzatoare si apasati butonul: Adaugati utilizatorul!\n" + "\n" +
                        "Pentru a sterge un utilizator, introduceti username-ul utilizatorului pe care doriti sa-l stergeti si apasati butonul: Stergeti utilizatorul!\n" + "\n" +
                        "Pentru a actualiza un utilizator, introduceti username-ul utilizatorului si noul salariu cu care se va face actualizarea,\n" +
                        "iar apoi apasati butonul: Actualizati utilizatorul!" + "\n\n" +
                        "Pentru a filtra lista utilizatorilor dupa tipul acestora, selectati rolul dupa care doriti sa se faca filtrarea, \n" +
                        "iar apoi apasati butonul: Filtrati utilizatorii!");
            }
        });

        adaugareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAdmin.adaugareUtilizatorComanda.executa();
            }
        });

        stergereBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAdmin.stergereUtilizatorComanda.executa();
            }
        });

        actualizareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAdmin.actualizareUtilizatorComanda.executa();
            }
        });

        vizualizareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAdmin.vizualizareListaComanda.executa();
                designTables();
            }
        });

        filtrareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmAdmin.filtrareListaDupaRolComanda.executa();
            }
        });

        setVisible(true);
    }

    public void designTables(){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < usersTable.getColumnModel().getColumnCount(); i++){
            usersTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        usersTable.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

    public static void showMessage(String message){
        JOptionPane.showMessageDialog(new JFrame(), message);
    }
}
