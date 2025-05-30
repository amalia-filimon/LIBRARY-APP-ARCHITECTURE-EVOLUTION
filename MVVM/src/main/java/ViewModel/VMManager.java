package ViewModel;

import ViewModel.Commands.*;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.table.DefaultTableModel;

public class VMManager {
    private Property<String> domeniuTF;
    private Property<String> disponibilitateTF;
    private Property<String> edituraTF;
    private Property<String> autorTF;
    private Property<String> pretTF;
    private Property<String> titluTF;
    private Property<String> listaLibrariicomboBox;
    private Property<DefaultTableModel> model;
    public IComanda vizualizareListaCarti;
    public IComanda filtrareListaDupaAutor;
    public IComanda filtrareListaDupaDomeniu;
    public IComanda filtrareListaDupaDisponibilitate;
    public IComanda filtrareListaDupaEditura;
    public IComanda filtrareListaDupaPret;
    public IComanda cautareCarteDupaTitlu;
    public IComanda salvareCSV;
    public IComanda salvareJSON;
    public IComanda salvareTXT;
    public IComanda salvareXML;

    public VMManager(){
        titluTF = PropertyFactory.createProperty("titlu", this, String.class);
        autorTF = PropertyFactory.createProperty("autor", this, String.class);
        domeniuTF = PropertyFactory.createProperty("domeniu", this, String.class);
        disponibilitateTF = PropertyFactory.createProperty("disponibilitate", this, String.class);
        edituraTF = PropertyFactory.createProperty("editura", this, String.class);
        pretTF = PropertyFactory.createProperty("pret", this, String.class);
        listaLibrariicomboBox = PropertyFactory.createProperty("listaLibrarii", this, String.class);
        model = PropertyFactory.createProperty("model", this, new DefaultTableModel());
        this.vizualizareListaCarti = new VizualizareListaCartiManager(this);
        this.filtrareListaDupaAutor = new FiltrareDupaAutorManager(this);
        this.filtrareListaDupaDomeniu = new FiltrareDupaDomeniuManager(this);
        this.filtrareListaDupaDisponibilitate = new FiltrareDupaDisponibilitateManager(this);
        this.filtrareListaDupaEditura = new FiltrareDupaEdituraManager(this);
        this.filtrareListaDupaPret = new FiltrareDupaPretManager(this);
        this.cautareCarteDupaTitlu = new CautareCarteDupaTitluManager(this);
        this.salvareCSV= new SalvareCSVmanager(this);
        this.salvareJSON = new SalvareJSONmanager(this);
        this.salvareTXT = new SalvareTXTmanager(this);
        this.salvareXML = new SalvareXMLmanager(this);
    }

    public String getDomeniuTF() {
        return domeniuTF.get();
    }

    public String getDisponibilitateTF() {
        return disponibilitateTF.get();
    }

    public String getEdituraTF() {
        return edituraTF.get();
    }

    public String getAutorTF() {
        return autorTF.get();
    }

    public String getPretTF() {
        return pretTF.get();
    }

    public String getTitluTF() {
        return titluTF.get();
    }

    public String getListaLibrariicomboBox() {
        return listaLibrariicomboBox.get();
    }

    public DefaultTableModel getTable(){
        return model.get();
    }

    public void setModel(DefaultTableModel defaultTableModel){
        model.set(defaultTableModel);
    }
}
