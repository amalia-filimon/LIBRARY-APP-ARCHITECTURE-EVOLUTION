package Controller;

import Connection.ProxyServer;
import Model.Carte;
import Model.Librarie;
import View.ManagerUI;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class ManagerController {
    private ManagerUI managerUI;
    private ProxyServer proxyServer;
    public ManagerController(List<Librarie> listaLibrarii){
        this.managerUI = new ManagerUI(listaLibrarii);
        this.proxyServer = ProxyServer.getInstance();

        managerUI.getCheckBoxRomana().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Romana.csv");
            }
        });

        managerUI.getCheckBoxEngleza().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Engleza.csv");
            }
        });

        managerUI.getCheckBoxSpaniola().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Spaniola.csv");
            }
        });

        managerUI.getCheckBoxFranceza().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setareLimba("src/main/resources/Franceza.csv");
            }
        });

        managerUI.getVizualizareListaBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vizualizareLista();
            }
        });

        managerUI.getDomeniuBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrareDupaDomeniu();
            }
        });

        managerUI.getDisponibilitateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrareDupaDisponibilitate();
            }
        });

        managerUI.getEdituraBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrareDupaEditura();
            }
        });

        managerUI.getAutorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrareDupaAutor();
            }
        });

        managerUI.getPretBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrareDupaPret();
            }
        });

        managerUI.getCautaCarteDupaTitluBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cautareCarteDupaTitlu();
            }
        });

        managerUI.getTxtBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvareTXT();
            }
        });

        managerUI.getJsonBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvareJSON();
            }
        });

        managerUI.getCsvBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvareCSV();
            }
        });

        managerUI.getXmlBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvareXML();
            }
        });

        managerUI.getGraficBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generareGrafic();
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
            managerUI.setVizualizareListaBtn(butoane.get(6));
            managerUI.setDomeniuBtn(butoane.get(7));
            managerUI.setDisponibilitateBtn(butoane.get(8));
            managerUI.setEditura(butoane.get(9));
            managerUI.setAutorBtn(butoane.get(10));
            managerUI.setPretBtn(butoane.get(11));
            managerUI.setCautaCarteDupaTitluBtn(butoane.get(12));
            managerUI.setGraficBtn(butoane.get(13));
        }
        if(!etichete.isEmpty()){
            managerUI.setTitleLbl(etichete.get(16));
            managerUI.setLanguageLbl(etichete.get(17));
            managerUI.setSelectLocationLbl(etichete.get(18));
            managerUI.setSelectatiCriteriulLbl(etichete.get(19));
            managerUI.setListLbl(etichete.get(20));
            managerUI.setSalvareListaInFormateLbl(etichete.get(21));
        }
    }

    public void vizualizareLista(){
        proxyServer.sendObject("VIZUALIZARE_LISTA_MANAGER");
        String locatieLibrarie = managerUI.getListaLibrariiComboBox();
        proxyServer.sendObject(locatieLibrarie);
        TreeSet<Carte> lista = (TreeSet<Carte>) proxyServer.receiveData();
        JTextArea textArea = managerUI.getTextArea();
        textArea.setText("");
        int i = 1;
        for (Carte c: lista)
        {
            textArea.append(i + ". Titlu: " + c.getTitlu() + ", Autor: " + c.getAutor() + ", Domeniu: " + c.getDomeniu() + ", Disponiblitate: " + c.getDisponibilitate() + ", Editura: " + c.getEditura() + ", Pret: " + c.getPret() + "\n");
            i++;
        }
    }

    public void filtrareDupaDomeniu(){
        proxyServer.sendObject("FILTRARE_DUPA_DOMENIU_MANAGER");
        String domeniuDeCautat = managerUI.getDomeniuTF();
        List<Carte> lista = (List<Carte>) proxyServer.receiveData();
        JTextArea textArea = managerUI.getTextArea();
        textArea.setText("");
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
        proxyServer.sendObject("FILTRARE_DUPA_DISPONIBILITATE_MANAGER");
        String disponibilitateDeCautat = managerUI.getDisponibilitateTF();
        List<Carte> lista = (List<Carte>) proxyServer.receiveData();
        JTextArea textArea = managerUI.getTextArea();
        textArea.setText("");
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
        proxyServer.sendObject("FILTRARE_DUPA_EDITURA_MANAGER");
        String edituraDeCautat = managerUI.getEdituraTF();
        List<Carte> lista = (List<Carte>) proxyServer.receiveData();
        JTextArea textArea = managerUI.getTextArea();
        textArea.setText("");
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
        proxyServer.sendObject("FILTRARE_DUPA_AUTOR_MANAGER");
        String autorDeCautat = managerUI.getAutorTF();
        List<Carte> lista = (List<Carte>) proxyServer.receiveData();
        JTextArea textArea = managerUI.getTextArea();
        textArea.setText("");
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
        proxyServer.sendObject("FILTRARE_DUPA_PRET_MANAGER");
        String pretDeCautat = managerUI.getPretTF();
        List<Carte> lista = (List<Carte>) proxyServer.receiveData();
        JTextArea textArea = managerUI.getTextArea();
        textArea.setText("");
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
        proxyServer.sendObject("CAUTARE_CARTE_DUPA_TITLU_MANAGER");
        String titluDeCautat = managerUI.getCautareCarteDupaTitluTF();
        List<Carte> lista = (List<Carte>) proxyServer.receiveData();
        JTextArea textArea = managerUI.getTextArea();
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

    public void salvareTXT(){
        proxyServer.sendObject("SALVARE_TXT_MANAGER");
        List<Carte> lista = (List<Carte>) proxyServer.receiveData();
        try (PrintWriter writer = new PrintWriter(new File("situatie_carti_manager.txt"))) {
            for (Carte c : lista) {
                writer.println(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void salvareCSV(){
        proxyServer.sendObject("SALVARE_CSV_MANAGER");
        List<Carte> lista = (List<Carte>) proxyServer.receiveData();
        String separator = ",";
        String fileName = "situatie_carti_manager.csv";

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

    public void salvareJSON(){
        proxyServer.sendObject("SALVARE_JSON_MANAGER");
        List<Carte> lista = (List<Carte>) proxyServer.receiveData();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(new File("situatie_carti_manager.json"), lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvareXML(){
        proxyServer.sendObject("SALVARE_XML_MANAGER");
        List<Carte> lista = (List<Carte>) proxyServer.receiveData();

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

            File xmlFile=new File("situatie_carti_manager.xml");
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

    public void generareGrafic(){
        proxyServer.sendObject("GENERARE_GRAFIC_MANAGER");
        DefaultPieDataset dataset = new DefaultPieDataset();
        List<Carte> lista = (List<Carte>) proxyServer.receiveData();
        //numarul cartilor din fiecare domeniu
        Map<String, Integer> domeniileCartilor = new HashMap<>();
        for(Carte c : lista){
            String domeniu = c.getDomeniu();
            domeniileCartilor.put(domeniu, domeniileCartilor.getOrDefault(domeniu, 0) + 1);
        }

        for(String domeniu: domeniileCartilor.keySet()){
            int nr = domeniileCartilor.get(domeniu);
            dataset.setValue(domeniu, nr);
        }

        JFreeChart chart1 = ChartFactory.createPieChart("Statistici cărți", dataset, true, true, false);

        //creez un chartFrame pt a afisa graficul
        ChartFrame frame = new ChartFrame("Statistici cărți", chart1);

        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        for(String domeniu: domeniileCartilor.keySet()){
            int nr = domeniileCartilor.get(domeniu);
            dataset2.addValue(nr, "Numarul cartilor din fiecare domeniu", domeniu);
        }
        JFreeChart chart2 = ChartFactory.createBarChart("Statistici cărți", "Domeniu", "Numar carti", dataset2);
        ChartFrame frame2 = new ChartFrame("Statistici cărți", chart2);

        frame.pack();
        frame.setVisible(true);

        frame2.pack();
        frame2.setVisible(true);
    }
}
