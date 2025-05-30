package Model.Persistenta;

import Model.Carte;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CartePersistenta {
    private Persistenta persistenta;

    public CartePersistenta(){
        persistenta = new Persistenta();
    }

    public void adaugareCarte(Carte carte, int idLibrarie)
    {
        String titlu = carte.getTitlu();
        String autor = carte.getAutor();
        String domeniu = carte.getDomeniu();
        String disponibilitate = carte.getDisponibilitate();
        String editura = carte.getEditura();
        String pret = carte.getPret();
        String comandaSQL1 = "INSERT INTO carti (titlu, autor, domeniu, disponibilitate, editura, pret) VALUES ('" + titlu + "', '" + autor + "', '" + domeniu + "', '" + disponibilitate + "', '" + editura + "', '" + pret + "')";
        String comandaSQL2 = "SELECT * FROM carti WHERE titlu = '" + titlu + "' AND autor = '" + autor + "' AND editura = '" + editura + "'";
        this.persistenta.comandaSQL(comandaSQL1);
        String[][] tabel = this.persistenta.obtinereDateTabel(comandaSQL2);
        int idNouaCarte = 0;
        if(tabel.length != 0){
            idNouaCarte = Integer.parseInt(tabel[0][0]);
        }else{
            System.out.println("Nu exista date in tabel care sa corespunda comenzii SQL");
        }
        String comandaSQL3 = "INSERT INTO carte_librarie (id_carte, id_librarie) VALUES ('" + idNouaCarte + "', '" + idLibrarie + "')";
        this.persistenta.comandaSQL(comandaSQL3);
    }

    public void stergereCarte(String titlu, String autor, int idLibrarie)
    {
        //se sterge cartea doar din libraria unde lucreaza angajatul, nu se sterge de tot din bd pt ca ea poate apartine altei librarii
        String comandaSQL1 = "SELECT * FROM carti WHERE titlu = '" + titlu + "' AND autor = '" + autor + "'";
        String[][] tabel = this.persistenta.obtinereDateTabel(comandaSQL1);
        int idCarteDeSters = 0;
        if(tabel.length != 0){
            idCarteDeSters = Integer.parseInt(tabel[0][0]);
        }else{
            System.out.println("Nu exista date in tabel care sa corespunda comenzii SQL");
        }

        String comandaSQL2 = "DELETE FROM carte_librarie WHERE id_carte = '" + idCarteDeSters + "' AND id_librarie = '" + idLibrarie + "'";
        this.persistenta.comandaSQL(comandaSQL2);
    }

    public void actualizareCarte(String titlu, String autor, String disponibilitate)
    {
        //se actualizeaza disponibilitatea
        String comandaSQL = "UPDATE carti SET disponibilitate = '" + disponibilitate + "' WHERE titlu = '" + titlu + "' AND autor = '" + autor + "'";
        this.persistenta.comandaSQL(comandaSQL);

    }

    public TreeSet<Carte> listaCarti(int idLibrarie)
    {
        String comandaSQL = "SELECT * FROM carti WHERE id IN (SELECT id_carte FROM carte_librarie WHERE id_librarie = + '" + idLibrarie + "')";
        String[][] tabel = this.persistenta.obtinereDateTabel(comandaSQL);
        TreeSet<Carte> listaCarti = new TreeSet<>();
        if(tabel.length != 0){
            int i = 0;
            for(String[] row : tabel) {
                Carte c = new Carte(tabel[i][1], tabel[i][2], tabel[i][3], tabel[i][4], tabel[i][5], tabel[i][6]);
                listaCarti.add(c);
                i++;
            }
            return listaCarti;
        }else{
            System.out.println("Nu exista date in tabel care sa corespunda comenzii SQL");
        }
            return listaCarti;
    }

    public List<Carte> listaCartiTotala(){
        String comandaSQL1 = "SELECT * FROM carti";
        String[][] tabel = this.persistenta.obtinereDateTabel(comandaSQL1);
        List<Carte> listaCarti = new ArrayList<>();
        if(tabel.length != 0){
            int i = 0;
            for(String[] row : tabel){
                Carte c = new Carte(tabel[i][1], tabel[i][2], tabel[i][3], tabel[i][4], tabel[i][5], tabel[i][6]);
                listaCarti.add(c);
                i++;
            }
            return listaCarti;
        }else{
            System.out.println("Nu exista date in tabel care sa corespunda comenzii SQL");
        }
        return null;
    }


}
