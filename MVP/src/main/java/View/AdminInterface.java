package View;

import Model.Utilizator;

import java.util.List;

public interface AdminInterface {
    String getUsernameTF();
    String getPasswordTF();
    String getRoleTF();
    String getSalaryTF();
    String getComboBox();
    void setListaUtilizatori(List<Utilizator> listaUtilizatori);
}
