package ViewModel.Commands;

import Model.Librarie;
import Model.Persistenta.LibrariePersistenta;
import Model.Persistenta.UtilizatorPersistenta;
import Model.Utilizator;
import View.AdminView;
import View.AngajatView;
import View.ManagerView;
import ViewModel.VMLogin;

import javax.swing.*;
import java.util.List;

public class ComandaLogin implements IComanda{

    private VMLogin vmLogin;

    public ComandaLogin(VMLogin vm){
        this.vmLogin = vm;
    }

    @Override
    public void executa() {
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        LibrariePersistenta lp = new LibrariePersistenta();

        String username = this.vmLogin.getUsernameTF();
        String parola = this.vmLogin.getPasswordTF();

        Utilizator utilizatorDeCautatInBD = new Utilizator(username, parola, null);
        Utilizator utilizatorObtinutDinBD = up.cautareUtilizator(utilizatorDeCautatInBD);

        if(utilizatorObtinutDinBD == null){
            JOptionPane.showMessageDialog(null, "Credentialele utilizate nu corespund niciunui utilizator intregistrat in aplicatia noastra! Mai incercati.", "Eroare", JOptionPane.ERROR_MESSAGE);
        }else{
            String rol = utilizatorObtinutDinBD.getRol();
            String usernameUtilizatorLogat = utilizatorObtinutDinBD.getUsername();
            String locatieAngajatLogat = up.locatieUtilizator(usernameUtilizatorLogat);
            int id_librarie = up.idLibrarieAngajat(usernameUtilizatorLogat);
            List<Librarie> listaLibrarii = lp.listaLibrarii();
            if(rol.equals("ANGAJAT")){
                AngajatView angajatView = new AngajatView(id_librarie, locatieAngajatLogat);
            }
            else if(rol.equals("MANAGER")){
                //la manager ii trimit lista de librarii
                ManagerView managerView = new ManagerView(listaLibrarii);
            }
            else if(rol.equals("ADMINISTRATOR")){
                AdminView adminview = new AdminView(listaLibrarii);
            }

        }
    }
}
