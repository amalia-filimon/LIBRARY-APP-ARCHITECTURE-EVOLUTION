package Presenter;

import Model.Librarie;
import Model.Persistenta.LibrariePersistenta;
import Model.Persistenta.UtilizatorPersistenta;
import Model.Utilizator;
import View.LoginInterface;

import javax.swing.*;
import java.util.List;

public class LoginPresenter {
    private LoginInterface loginInterface;
    private UtilizatorPersistenta up;
    private LibrariePersistenta lp;

    public LoginPresenter(LoginInterface loginInterface){
        this.loginInterface = loginInterface;
        this.up = new UtilizatorPersistenta();
        this.lp = new LibrariePersistenta();
    }

    public void login(){
        String username = loginInterface.getUsername();
        String parola = loginInterface.getPassword();
        Utilizator utilizatorDeCautatInBD = new Utilizator(username, parola, null);
        Utilizator utilizatorObtinutDinBD = this.up.cautareUtilizator(utilizatorDeCautatInBD);
        if(utilizatorObtinutDinBD == null){
            JOptionPane.showMessageDialog(null, "Credentialele utilizate nu corespund niciunui utilizator intregistrat in aplicatia noastra! Mai incercati.", "Eroare", JOptionPane.ERROR_MESSAGE);
        }else{
            String rol = utilizatorObtinutDinBD.getRol();
            String usernameUtilizatorLogat = utilizatorObtinutDinBD.getUsername();
            String locatieAngajatLogat = this.up.locatieUtilizator(usernameUtilizatorLogat);
            int id_librarie = this.up.idLibrarieAngajat(usernameUtilizatorLogat);
            List<Librarie> listaLibrarii = lp.listaLibrarii();
            if(rol.equals("ANGAJAT"))
                loginInterface.setAngajat(id_librarie, locatieAngajatLogat);
            else if(rol.equals("MANAGER"))
                //la manager ii trimit lista de librarii
                loginInterface.setManager(listaLibrarii);
            else if(rol.equals("ADMINISTRATOR"))
                loginInterface.setAdministrator(listaLibrarii);
        }
    }

}
