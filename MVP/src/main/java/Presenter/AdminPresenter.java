package Presenter;

import Model.Persistenta.UtilizatorPersistenta;
import Model.Utilizator;
import View.AdminInterface;
import View.LoginInterface;

import java.util.List;

public class AdminPresenter {
    private AdminInterface adminInterface;
    private UtilizatorPersistenta up;

    public AdminPresenter(AdminInterface adminInterface){
        this.adminInterface = adminInterface;
        this.up = new UtilizatorPersistenta();
    }

    public void adaugareUtilizatorNou(){
        String username = adminInterface.getUsernameTF();
        String parola = adminInterface.getPasswordTF();
        String rol = adminInterface.getRoleTF();
        String salariu = adminInterface.getSalaryTF();
        String locatieLibrarie = adminInterface.getComboBox();

        Utilizator u = new Utilizator(username, parola, rol, salariu, locatieLibrarie);
        up.adaugareUtilizator(u);
    }

    public void eliminareUtilizator(){
        String username = adminInterface.getUsernameTF();
        up.stergereUtilizator(username);
    }

    public void actualizareUtilizator(){
        String username = adminInterface.getUsernameTF();
        String salariu = adminInterface.getSalaryTF();
        up.actualizareUtilizator(username, salariu);
    }

    public void listaUtilizatori(){
        List<Utilizator> listaUtilizatori = up.listaUtilizatori();
        adminInterface.setListaUtilizatori(listaUtilizatori);
    }
}
