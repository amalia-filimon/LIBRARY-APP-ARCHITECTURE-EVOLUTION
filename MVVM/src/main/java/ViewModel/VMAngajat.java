package ViewModel;

import ViewModel.Commands.*;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.table.DefaultTableModel;

public class VMAngajat {
    private Property<String> titluTF;
    private Property<String> autorTF;
    private Property<String> domeniuTF;
    private Property<String> disponibilitateTF;
    private Property<String> edituraTF;
    private Property<String> pretTF;
    private Property<DefaultTableModel> model;
    private int idLibrarie;
    public IComanda vizualizareListaCarti;
    public IComanda adaugareCarte;
    public IComanda stergereCarte;
    public IComanda actualizareCarte;
    public IComanda vanzareCarte;
    public IComanda cautareCarteDupaTitlu;
    public IComanda filtrareDupaDomeniu;
    public IComanda filtrareDupaDisponibilitate;
    public IComanda filtrareDupaEditura;
    public IComanda filtrareDupaAutor;
    public IComanda filtrareDupaPret;
    public IComanda salvareCSV;
    public IComanda salvareJSON;
    public IComanda salvareTXT;
    public IComanda salvareXML;

    public VMAngajat(){
        titluTF = PropertyFactory.createProperty("titlu", this, String.class);
        autorTF = PropertyFactory.createProperty("autor", this, String.class);
        domeniuTF = PropertyFactory.createProperty("domeniu", this, String.class);
        disponibilitateTF = PropertyFactory.createProperty("disponibilitate", this, String.class);
        edituraTF = PropertyFactory.createProperty("editura", this, String.class);
        pretTF = PropertyFactory.createProperty("pret", this, String.class);
        model = PropertyFactory.createProperty("model", this, new DefaultTableModel());
        this.vizualizareListaCarti = new VizualizareListaCarti(this);
        this.adaugareCarte = new AdaugareCarte(this);
        this.stergereCarte = new StergereCarte(this);
        this.actualizareCarte = new ActualizareCarte(this);
        this.vanzareCarte = new VanzareCarte(this);
        this.cautareCarteDupaTitlu = new CautareCarteDupaTitlu(this);
        this.filtrareDupaDomeniu = new FiltrareDupaDomeniu(this);
        this.filtrareDupaDisponibilitate = new FiltrareDupaDisponibilitate(this);
        this.filtrareDupaEditura = new FiltrareDupaEditura(this);
        this.filtrareDupaAutor = new FiltrareDupaAutor(this);
        this.filtrareDupaPret = new FiltrareDupaPret(this);
        this.salvareCSV = new SalvareCSVangajat(this);
        this.salvareJSON = new SalvareJSONangajat(this);
        this.salvareTXT = new SalvareTXTangajat(this);
        this.salvareXML = new SalvareXMLangajat(this);
    }

    public String getTitluTF() {
        return titluTF.get();
    }

    public String getAutorTF() {
        return autorTF.get();
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

    public String getPretTF() {
        return pretTF.get();
    }

    public int getIdLibrarie() {
        return idLibrarie;
    }

    public void setIdLibrarie(int idLibrarie) {
        this.idLibrarie = idLibrarie;
    }

    public DefaultTableModel getTable(){
        return model.get();
    }

    public void setModel(DefaultTableModel defaultTableModel){
        model.set(defaultTableModel);
    }
}
