package Model.Persistenta;

import Model.Librarie;
import Model.Utilizator;

import java.util.ArrayList;
import java.util.List;

public class LibrariePersistenta {
    private Persistenta persistenta;

    public LibrariePersistenta(){
        persistenta = new Persistenta();
    }

    public void adaugareLibrarie(Librarie librarie){
        String locatie = librarie.getLocatie();
        String comandaSQL = "INSERT INTO librarii (locatie) VALUES ('" + locatie + "')";
        persistenta.comandaSQL(comandaSQL);
    }

    public List<Librarie> listaLibrarii(){
        String comandaSQL = "SELECT * FROM librarii";
        String[][] tabel = this.persistenta.obtinereDateTabel(comandaSQL);
        List<Librarie> listaLibrarii = new ArrayList<>();
        if(tabel.length != 0){
            int i = 0;
            for(String[] row : tabel) {
                Librarie l = new Librarie(tabel[i][1]);
                listaLibrarii.add(l);
                i++;
            }
            return listaLibrarii;
        }else{
            System.out.println("Nu exista date in tabel care sa corespunda comenzii SQL");
        }
        return null;
    }

    public int idLibrarieDupaLocatie(String locatie){
        String comandaSQL = "SELECT * FROM librarii WHERE locatie = '" + locatie + "'";
        String[][] tabel = this.persistenta.obtinereDateTabel(comandaSQL);
        int id = 0;
        if(tabel.length != 0){
            id = Integer.parseInt(tabel[0][0]);
            return id;
        }else{
            System.out.println("Nu exista date in tabel care sa corespunda comenzii SQL");
        }
        return id;
    }
}
