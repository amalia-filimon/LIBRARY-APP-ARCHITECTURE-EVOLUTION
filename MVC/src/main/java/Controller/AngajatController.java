package Controller;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import Model.Persistenta.UtilizatorPersistenta;
import Model.Utilizator;
import View.AngajatUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class AngajatController {
    private CartePersistenta cp = null;
    private AngajatUI angajatUI = null;
    public AngajatController(int id_librarie, String locatieAngajatLogat){
        cp = new CartePersistenta();
        angajatUI = new AngajatUI(id_librarie, locatieAngajatLogat);

        angajatUI.getCheckBoxRomana().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Romana.csv");
            }
        });

        angajatUI.getCheckBoxEngleza().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Engleza.csv");
            }
        });

        angajatUI.getCheckBoxSpaniola().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Spaniola.csv");
            }
        });

        angajatUI.getCheckBoxFranceza().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Franceza.csv");
            }
        });

        angajatUI.getVizualizareListaBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vizualizareListaCarti();
            }
        });

        angajatUI.getDomeniuBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrareDupaDomeniu();
            }
        });

        angajatUI.getDisponibilitateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrareDupaDisponibilitate();
            }
        });

        angajatUI.getEdituraBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrareDupaEditura();
            }
        });

        angajatUI.getAutorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrareDupaAutor();
            }
        });

        angajatUI.getPretBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrareDupaPret();
            }
        });

        angajatUI.getCautareDupaTitluBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cautareCarteDupaTitlu();
            }
        });

        angajatUI.getVanzareCarteBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vanzareCarte();
            }
        });

        angajatUI.getAdaugatiCarteaBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adaugareCarte();
            }
        });

        angajatUI.getStergetiCarteaBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stergereCarte();
            }
        });

        angajatUI.getActualizatiCarteaBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizareCarte();
            }
        });

        angajatUI.getTxtBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvareTXT();
            }
        });

        angajatUI.getJsonBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvareJSON();
            }
        });

        angajatUI.getCsvBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvareCSV();
            }
        });

        angajatUI.getXmlBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvareXML();
            }
        });
    }

    public void setareLimba(String path){
        String line = "";
        String csvSeparator = ",";
        List<String> butoane = new ArrayList<>();
        List<String> etichete = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // citeste capul tabelului
            String headerLine = br.readLine();
            String[] headers = headerLine.split(csvSeparator);

            // parcurge linii de date
            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSeparator);

                // afiseaza mesaje pentru fiecare coloana
                for (int i = 0; i < headers.length; i++) {
                    String header = headers[i];
                    String value = values[i];

                    if (header.equals("Butoane")) {
                        if(!value.equals("null"))
                            butoane.add(value);
                    } else if (header.equals("Etichete")) {
                        if(!value.equals("null"))
                            etichete.add(value);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!butoane.isEmpty()){
            angajatUI.setVizualizareListaBtn(butoane.get(14));
            angajatUI.setDomeniuBtn(butoane.get(15));
            angajatUI.setDisponibilitateBtn(butoane.get(16));
            angajatUI.setEdituraBtn(butoane.get(17));
            angajatUI.setAutorBtn(butoane.get(18));
            angajatUI.setPretBtn(butoane.get(19));
            angajatUI.setAdaugatiCarteaBtn(butoane.get(20));
            angajatUI.setStergetiCarteaBtn(butoane.get(21));
            angajatUI.setActualizatiCarteaBtn(butoane.get(22));
            angajatUI.setCautareDupaTitluBtn(butoane.get(23));
            angajatUI.setVanzareCarteBtn(butoane.get(24));
        }
        if(!etichete.isEmpty()){
            angajatUI.setTitleLbl(etichete.get(22));
            angajatUI.setLanguageLbl(etichete.get(23));
            angajatUI.setSelectatiCriteriulLbl(etichete.get(24));
            angajatUI.setListaLbl(etichete.get(25));
            angajatUI.setCartiCRUDLbl(etichete.get(26));
            angajatUI.setBookTitleLbl(etichete.get(27));
            angajatUI.setAutorLbl(etichete.get(28));
            angajatUI.setDomeniuLbl(etichete.get(29));
            angajatUI.setDisponibilitateLbl(etichete.get(30));
            angajatUI.setEdituraLbl(etichete.get(31));
            angajatUI.setPretLbl(etichete.get(32));
            angajatUI.setStergereLbl(etichete.get(33));
            angajatUI.setActualizareLbl(etichete.get(34));
            angajatUI.setSalvareListaInFormateLbl(etichete.get(35));
        }
    }

    public void vizualizareListaCarti(){
        TreeSet<Carte> lista = cp.listaCarti(angajatUI.getIdLibrarie());
        JTextArea textArea = angajatUI.getTextArea();
        textArea.setText("");
        int i = 1;
        for(Carte c : lista){
            textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
            i++;
        }
    }

    public void filtrareDupaDomeniu(){
        String domeniuDeCautat = angajatUI.getDomeniuTF();
        JTextArea textArea = angajatUI.getTextArea();
        textArea.setText("");
        TreeSet<Carte> lista = cp.listaCarti(angajatUI.getIdLibrarie());
        int i = 1;
        for (Carte c: lista)
        {
            if(c.getDomeniu().equals(domeniuDeCautat)){
                textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
                i++;
            }
        }
    }

    public void filtrareDupaDisponibilitate(){
        String disponibilitateDeCautat = angajatUI.getDisponibilitateTF();
        JTextArea textArea = angajatUI.getTextArea();
        textArea.setText("");
        TreeSet<Carte> lista = cp.listaCarti(angajatUI.getIdLibrarie());
        int i = 1;
        for (Carte c: lista)
        {
            if(c.getDisponibilitate().equals(disponibilitateDeCautat)){
                textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
                i++;
            }
        }
    }

    public void filtrareDupaEditura(){
        String edituraDeCautat = angajatUI.getEdituraTF();
        JTextArea textArea = angajatUI.getTextArea();
        textArea.setText("");
        TreeSet<Carte> lista = cp.listaCarti(angajatUI.getIdLibrarie());
        int i = 1;
        for (Carte c: lista)
        {
            if(c.getEditura().equals(edituraDeCautat)){
                textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
                i++;
            }
        }
    }

    public void filtrareDupaAutor(){
        String autorDeCautat = angajatUI.getAutorTF();
        JTextArea textArea = angajatUI.getTextArea();
        textArea.setText("");
        TreeSet<Carte> lista = cp.listaCarti(angajatUI.getIdLibrarie());
        int i = 1;
        for (Carte c: lista)
        {
            if(c.getAutor().equals(autorDeCautat)){
                textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
                i++;
            }
        }
    }

    public void filtrareDupaPret(){
        String pretDeCautat = angajatUI.getPretTF();
        JTextArea textArea = angajatUI.getTextArea();
        textArea.setText("");
        TreeSet<Carte> lista = cp.listaCarti(angajatUI.getIdLibrarie());
        int i = 1;
        for (Carte c: lista)
        {
            if(c.getPret().equals(pretDeCautat)){
                textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
                i++;
            }
        }
    }

    public void cautareCarteDupaTitlu(){
        String titluDeCautat = angajatUI.getTitluTFCRUD();
        TreeSet<Carte> lista = cp.listaCarti(angajatUI.getIdLibrarie());
        JTextArea textArea = angajatUI.getTextArea();
        textArea.setText("");
        int i = 1;
        for (Carte c: lista)
        {
            if(c.getTitlu().equals(titluDeCautat)){
                textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
                i++;
            }
        }
    }

    public void vanzareCarte(){
        String titlu = angajatUI.getTitluTFCRUD();
        String autor = angajatUI.getAutorTFCRUD();
        int disponibilitateCurenta = 0;
        TreeSet<Carte> lista = cp.listaCarti(angajatUI.getIdLibrarie());
        for(Carte c : lista){
            if(c.getTitlu().equals(titlu) && c.getAutor().equals(autor)){
                disponibilitateCurenta = Integer.parseInt(c.getDisponibilitate());
            }
        }
        if(disponibilitateCurenta > 0){
            int nouaDisponibilitate = disponibilitateCurenta - 1;
            cp.actualizareCarte(titlu, autor, String.valueOf(nouaDisponibilitate));
        }else{
            JOptionPane.showMessageDialog(null, "Cartea nu mai este pe stoc!");
        }
    }

    public void adaugareCarte(){
        String titlu = angajatUI.getTitluTFCRUD();
        String autor = angajatUI.getAutorTFCRUD();
        String domeniu = angajatUI.getDomeniuTFCRUD();
        String disponibilitate = angajatUI.getDisponibilitateTFCRUD();
        String editura = angajatUI.getEdituraTFCRUD();
        String pret = angajatUI.getPretTFCRUD();

        Carte c = new Carte(titlu, autor, domeniu, disponibilitate, editura, pret);
        int idLibrarie = angajatUI.getIdLibrarie();
        cp.adaugareCarte(c, idLibrarie);
    }

    public void stergereCarte(){
        String titlu = angajatUI.getTitluTFCRUD();
        String autor = angajatUI.getAutorTFCRUD();

        int idLibrarie = angajatUI.getIdLibrarie();
        cp.stergereCarte(titlu, autor, idLibrarie);
    }

    public void actualizareCarte(){
        //se va actualiza disponibilitatea
        String titlu = angajatUI.getTitluTFCRUD();
        String autor = angajatUI.getAutorTFCRUD();
        String actualizarea = angajatUI.getDisponibilitateTFCRUD();
        cp.actualizareCarte(titlu, autor, actualizarea);

    }

    public void salvareTXT(){
        TreeSet<Carte> lista = cp.listaCarti(angajatUI.getIdLibrarie());

        try (PrintWriter writer = new PrintWriter(new File("situatie_carti_angajat.txt"))) {
            for (Carte c : lista) {
                writer.println(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void salvareJSON(){
        TreeSet<Carte> lista = cp.listaCarti(angajatUI.getIdLibrarie());
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(new File("situatie_carti_angajat.json"), lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvareCSV(){
        TreeSet<Carte> lista = cp.listaCarti(angajatUI.getIdLibrarie());
        String separator = ",";
        String fileName = "situatie_carti_angajat.csv";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("TITLU,AUTOR,DOMENIU,DISPONIBILITATE,EDITURA,PRET").append("\n");
            for (Carte c : lista) {
                writer.append(c.getTitlu()).append(separator)
                        .append(c.getAutor()).append(separator)
                        .append(c.getDomeniu()).append(separator)
                        .append(c.getDisponibilitate()).append(separator)
                        .append(c.getEditura()).append(separator)
                        .append(c.getPret()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvareXML(){
        TreeSet<Carte> lista = cp.listaCarti(angajatUI.getIdLibrarie());

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("Carti");
            document.appendChild(root);

            for (Carte carte : lista) {
                Element c = document.createElement("Carte");
                root.appendChild(c);

                Element titlu = document.createElement("titlu");
                titlu.appendChild(document.createTextNode(carte.getTitlu()));
                c.appendChild(titlu);

                Element autor = document.createElement("autor");
                autor.appendChild(document.createTextNode(carte.getAutor()));
                c.appendChild(autor);

                Element domeniu = document.createElement("domeniu");
                domeniu.appendChild(document.createTextNode(carte.getDomeniu()));
                c.appendChild(domeniu);

                Element disponibilitate = document.createElement("disponibilitate");
                disponibilitate.appendChild(document.createTextNode(carte.getDisponibilitate()));
                c.appendChild(disponibilitate);

                Element editura = document.createElement("editura");
                editura.appendChild(document.createTextNode(carte.getEditura()));
                c.appendChild(editura);

                Element pret = document.createElement("pret");
                pret.appendChild(document.createTextNode(carte.getPret()));
                c.appendChild(pret);

            }

            File xmlFile=new File("situatie_carti_angajat.xml");
            javax.xml.transform.TransformerFactory transformerFactory= javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(document);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(xmlFile);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

}
