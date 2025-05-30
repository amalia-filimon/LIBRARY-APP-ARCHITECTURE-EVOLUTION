package ViewModel;

import Model.Utilizator;
import ViewModel.Commands.*;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;

import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class VMAdmin {
    private Property<String> usernameTF;
    private Property<String> passwordTF;
    private Property<String> roleComboBox;
    private Property<String> salaryTF;
    private Property<String> locatieLibrarieComboBox;
    private Property<DefaultTableModel> model;
    public IComanda adaugareUtilizatorComanda;
    public IComanda stergereUtilizatorComanda;
    public IComanda actualizareUtilizatorComanda;
    public IComanda vizualizareListaComanda;
    public IComanda filtrareListaDupaRolComanda;

    public VMAdmin(){
        usernameTF = PropertyFactory.createProperty("username", this, String.class);
        passwordTF = PropertyFactory.createProperty("password", this, String.class);
        roleComboBox = PropertyFactory.createProperty("rol", this, String.class);
        salaryTF = PropertyFactory.createProperty("salary", this, String.class);
        locatieLibrarieComboBox = PropertyFactory.createProperty("locatieLibrarie", this, String.class);
        model = PropertyFactory.createProperty("model", this, new DefaultTableModel());
        this.adaugareUtilizatorComanda = new AdaugareUtilizator(this);
        this.stergereUtilizatorComanda = new StergereUtilizator(this);
        this.actualizareUtilizatorComanda = new ActualizareUtilizator(this);
        this.vizualizareListaComanda = new VizualizareListaUtilizatori(this);
        this.filtrareListaDupaRolComanda = new FiltrareListaDupaRol(this);
    }

    public String getUsernameTF() {
        return usernameTF.get();
    }

    public String getPasswordTF() {
        return passwordTF.get();
    }

    public String getRolComboBox() {
        return roleComboBox.get();
    }

    public String getSalaryTF() {
        return salaryTF.get();
    }

    public String getLocatieLibrarieComboBox() {
        return locatieLibrarieComboBox.get();
    }

    public DefaultTableModel getTable(){
        return model.get();
    }

    public void setModel(DefaultTableModel defaultTableModel){
        model.set(defaultTableModel);
    }

}
