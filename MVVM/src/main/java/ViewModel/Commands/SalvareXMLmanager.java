package ViewModel.Commands;

import Model.Carte;
import Model.Persistenta.CartePersistenta;
import ViewModel.VMAngajat;
import ViewModel.VMManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.util.List;
import java.util.TreeSet;

public class SalvareXMLmanager implements IComanda{
    private VMManager vmManager;
    public SalvareXMLmanager(VMManager vm){
        this.vmManager = vm;
    }

    @Override
    public void executa() {
        CartePersistenta cp = new CartePersistenta();
        List<Carte> lista = cp.listaCartiTotala();

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
}
