package Model.Persistenta;

import Model.Utilizator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilizatorPersistenta {
    private Persistenta persistenta;

    public UtilizatorPersistenta(){
        persistenta = new Persistenta();
    }

    public void adaugareUtilizator(Utilizator utilizator)
    {
        String user = utilizator.getUsername();
        String parola = utilizator.getParola();
        String rol = utilizator.getRol();
        String salariu = utilizator.getSalariu();
        String locatieLibrarie = utilizator.getLocatieLibrarie();
        String comandaSQL1 = "SELECT * FROM librarii WHERE locatie = '" + locatieLibrarie + "'";
        String tabel[][] = this.persistenta.obtinereDateTabel(comandaSQL1);
        if(tabel.length != 0){
            String comandaSQL2 = "INSERT INTO utilizatori (username, password, role, salary, id_librarie) VALUES ('" + user + "', '" + parola + "', '" + rol + "', '" + salariu + "', '" + tabel[0][0] + "')";
            this.persistenta.comandaSQL(comandaSQL2);
        }else{
            System.out.println("Nu exista date in tabel care sa corespunda comenzii SQL");
        }
    }

    public void stergereUtilizator(String username)
    {
        String comandaSQL = "DELETE FROM utilizatori WHERE username = '" + username + "'";
        this.persistenta.comandaSQL(comandaSQL);
    }

    public Utilizator cautareUtilizator(Utilizator utilizator) {
        //aceasta metoda cauta strict un singur utilizator are care un username si o parola unica (nu mai exista alt utilizator cu acelasi username si aceeasi parola)
        String comandaSQL = "SELECT * FROM utilizatori WHERE username = '" + utilizator.getUsername() + "' AND password = '" + utilizator.getParola() + "'";
        String[][] tabel = this.persistenta.obtinereDateTabel(comandaSQL);
        if(tabel.length != 0){
            Utilizator u = new Utilizator(tabel[0][1], tabel[0][2], tabel[0][3]);
            return u;
        }else{
            System.out.println("Nu exista date in tabel care sa corespunda comenzii SQL");
        }
        return null;
    }

    public void actualizareUtilizator(String username, String salariu){
        String comandaSQL = "UPDATE utilizatori SET salary = '" + salariu + "' WHERE username = '" + username + "'";
        this.persistenta.comandaSQL(comandaSQL);
    }

    public List<Utilizator> listaUtilizatori(){
        String comandaSQL1 = "SELECT * FROM utilizatori";
        String[][] tabel = this.persistenta.obtinereDateTabel(comandaSQL1);
        List<Utilizator> listaUtilizatori = new ArrayList<>();
        if(tabel.length != 0){
            int i = 0;
            for(String[] row : tabel) {
                int id = Integer.parseInt(tabel[i][5]);
                String comandaSQL2 = "SELECT * FROM librarii WHERE id = '" + id + "'";
                String[][] tabelLibrarii = this.persistenta.obtinereDateTabel(comandaSQL2);
                if(tabelLibrarii.length != 0){
                    Utilizator u = new Utilizator(tabel[i][1], tabel[i][2], tabel[i][3], tabel[i][4], tabelLibrarii[0][1]);
                    listaUtilizatori.add(u);
                }
                i++;
            }
            return listaUtilizatori;
        }else{
            System.out.println("Nu exista date in tabel care sa corespunda comenzii SQL");
        }
        return null;
    }

    public String locatieUtilizator(String usernameUtilizatorLogat){
        String comandaSQL = "SELECT * FROM librarii WHERE id IN (SELECT id_librarie FROM utilizatori WHERE username = '" + usernameUtilizatorLogat + "')";
        String[][] tabel = this.persistenta.obtinereDateTabel(comandaSQL);
        if(tabel.length != 0){
            return tabel[0][1];
        }else{
            System.out.println("Nu exista date in tabel care sa corespunda comenzii SQL");
        }
        return null;
    }

    public int idLibrarieAngajat(String usernameUtilizatorLogat){
        String comandaSQL = "SELECT * FROM utilizatori WHERE username = '" + usernameUtilizatorLogat + "'";
        String[][] tabel = this.persistenta.obtinereDateTabel(comandaSQL);
        if(tabel.length != 0){
            return Integer.parseInt(tabel[0][5]);
        }else{
            System.out.println("Nu exista date in tabel care sa corespunda comenzii SQL");
        }
        return 0;
    }

//    public void adaugareFK()
//    {
//        String sql = "ALTER TABLE carte_librarie ADD CONSTRAINT id_librarie FOREIGN KEY (id_librarie) REFERENCES librarii (id)";
//        this.persistenta.comandaSQL(sql);
//    }

}
