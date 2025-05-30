package View;

import Model.Librarie;
import ViewModel.VMManager;
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

public class ManagerView extends JFrame {

    private JPanel contentPane;
    @Bind(value = "text", target = "domeniuTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField domeniuTF;
    @Bind(value = "text", target = "disponibilitateTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField disponibilitateTF;
    @Bind(value = "text", target = "edituraTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField edituraTF;
    @Bind(value = "text", target = "autorTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField autorTF;
    @Bind(value = "text", target = "pretTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField pretTF;
    @Bind(value = "text", target = "titluTF.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField titluTF;
    @Bind(value = "text", target = "listaLibrariicomboBox.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField listaLibrariiTF = new JTextField();
    private JComboBox listaLibrariicomboBox;
    private JButton vizualizareBtn;
    private JButton disponibilitateaBtn;
    private JButton domeniuBtn;
    private JButton edituraBtn;
    private JButton autorBtn;
    private JButton pretBtn;
    @Bind(value = "model", target = "model.value", type = BindingType.TARGET_TO_SOURCE)
    private JTable tabelCarti = new JTable(new DefaultTableModel());
    private JScrollPane scrollPane;
    private JButton csvBtn;
    private JButton jsonBtn;
    private JButton txtBtn;
    private JButton xmlBtn;
    private JButton cautareBtn;
    private VMManager vmManager;

    public ManagerView(List<Librarie> listaLibrarii) {
        setTitle("Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1400, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        scrollPane = new JScrollPane(tabelCarti);
        tabelCarti.setRowHeight(25);
        scrollPane.setBounds(733, 95, 630, 597);
        contentPane.add(scrollPane, BorderLayout.WEST);

        JLabel lblNewLabel = new JLabel("Bun venit pe pagina Managerului!");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setBounds(506, 10, 395, 32);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Selectati librarie careia doriti sa-i vizualizati lista de carti");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(32, 95, 479, 32);
        contentPane.add(lblNewLabel_1);

        listaLibrariicomboBox = new JComboBox();
        listaLibrariicomboBox.setBounds(32, 137, 438, 32);
        contentPane.add(listaLibrariicomboBox);

        vizualizareBtn = new JButton("Vizualizati lista");
        vizualizareBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        vizualizareBtn.setBounds(506, 137, 167, 32);
        contentPane.add(vizualizareBtn);

        JLabel lblNewLabel_2 = new JLabel("Selectati criteriul dupa care doriti filtrarea listei");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(32, 201, 438, 22);
        contentPane.add(lblNewLabel_2);

        domeniuTF = new JTextField();
        domeniuTF.setBounds(32, 240, 438, 32);
        contentPane.add(domeniuTF);
        domeniuTF.setColumns(10);

        domeniuBtn = new JButton("Domeniu");
        domeniuBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        domeniuBtn.setBounds(506, 240, 167, 32);
        contentPane.add(domeniuBtn);

        disponibilitateTF = new JTextField();
        disponibilitateTF.setBounds(32, 282, 438, 32);
        contentPane.add(disponibilitateTF);
        disponibilitateTF.setColumns(10);

        disponibilitateaBtn = new JButton("Disponibilitate");
        disponibilitateaBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        disponibilitateaBtn.setBounds(506, 278, 167, 36);
        contentPane.add(disponibilitateaBtn);

        edituraTF = new JTextField();
        edituraTF.setBounds(32, 324, 438, 32);
        contentPane.add(edituraTF);
        edituraTF.setColumns(10);

        edituraBtn = new JButton("Editura");
        edituraBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        edituraBtn.setBounds(506, 324, 167, 32);
        contentPane.add(edituraBtn);

        autorTF = new JTextField();
        autorTF.setBounds(32, 366, 438, 32);
        contentPane.add(autorTF);
        autorTF.setColumns(10);

        autorBtn = new JButton("Autor");
        autorBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        autorBtn.setBounds(506, 366, 167, 32);
        contentPane.add(autorBtn);

        pretTF = new JTextField();
        pretTF.setBounds(32, 408, 438, 32);
        contentPane.add(pretTF);
        pretTF.setColumns(10);

        pretBtn = new JButton("Pret");
        pretBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        pretBtn.setBounds(506, 408, 167, 32);
        contentPane.add(pretBtn);

        JLabel lblNewLabel_3 = new JLabel("Cautati o carte dupa titlu");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(32, 462, 339, 22);
        contentPane.add(lblNewLabel_3);

        titluTF = new JTextField();
        titluTF.setBounds(32, 494, 438, 32);
        contentPane.add(titluTF);
        titluTF.setColumns(10);

        cautareBtn = new JButton("Cautati");
        cautareBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        cautareBtn.setBounds(506, 494, 167, 32);
        contentPane.add(cautareBtn);

        JLabel lblNewLabel_4 = new JLabel("Salvati lista cu situatia cartilor din toate librariile in una din formatele de mai jos");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_4.setBounds(32, 550, 691, 22);
        contentPane.add(lblNewLabel_4);

        csvBtn = new JButton("csv");
        csvBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        csvBtn.setBounds(32, 596, 127, 32);
        contentPane.add(csvBtn);

        jsonBtn = new JButton("json");
        jsonBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        jsonBtn.setBounds(199, 596, 127, 32);
        contentPane.add(jsonBtn);

        txtBtn = new JButton("txt");
        txtBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtBtn.setBounds(364, 596, 127, 32);
        contentPane.add(txtBtn);

        xmlBtn = new JButton("xml");
        xmlBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
        xmlBtn.setBounds(532, 596, 127, 32);
        contentPane.add(xmlBtn);

        vmManager = new VMManager();

        for(Librarie l : listaLibrarii){
            this.listaLibrariicomboBox.addItem(l.getLocatie());
        }
        listaLibrariiTF.setText(listaLibrariicomboBox.getSelectedItem().toString());

        try {
            Binder.bind(this, vmManager);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        listaLibrariicomboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaLibrariiTF.setText(listaLibrariicomboBox.getSelectedItem().toString());
            }
        });

        vizualizareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmManager.vizualizareListaCarti.executa();
                designTables();
            }
        });

        autorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmManager.filtrareListaDupaAutor.executa();
            }
        });

        domeniuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmManager.filtrareListaDupaDomeniu.executa();
            }
        });

        disponibilitateaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmManager.filtrareListaDupaDisponibilitate.executa();
            }
        });

        edituraBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmManager.filtrareListaDupaEditura.executa();
            }
        });

        pretBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmManager.filtrareListaDupaPret.executa();
            }
        });

        cautareBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmManager.cautareCarteDupaTitlu.executa();
            }
        });

        csvBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmManager.salvareCSV.executa();
            }
        });

        jsonBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmManager.salvareJSON.executa();
            }
        });

        txtBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmManager.salvareTXT.executa();
            }
        });

        xmlBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vmManager.salvareXML.executa();
            }
        });

        setVisible(true);
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
