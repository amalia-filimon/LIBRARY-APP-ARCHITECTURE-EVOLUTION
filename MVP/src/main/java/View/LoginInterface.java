package View;

import Model.Librarie;
import Model.Utilizator;

import java.util.List;

public interface LoginInterface {
    String getUsername();
    String getPassword();
    void setAngajat(int id_librarie, String locatie);
    void setAdministrator(List<Librarie> listaLibrarii);
    void setManager(List<Librarie> listaLibrarii);
}
