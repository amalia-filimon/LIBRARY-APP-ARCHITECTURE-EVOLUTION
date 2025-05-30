package Model;

import java.io.Serializable;
import java.util.Observable;

public class Carte implements Comparable<Carte>, Serializable {
    private String titlu;
    private String autor;
    private String domeniu;
    private String disponibilitate;
    private String editura;
    private String pret;

    public Carte(String titlu, String autor, String domeniu, String disponibilitate, String editura, String pret){
        this.titlu = titlu;
        this.autor = autor;
        this.domeniu = domeniu;
        this.disponibilitate = disponibilitate;
        this.editura = editura;
        this.pret = pret;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public String getDomeniu() {
        return domeniu;
    }

    public String getDisponibilitate() {
        return disponibilitate;
    }

    public String getEditura() {
        return editura;
    }

    public String getPret() {
        return pret;
    }

    public int compareTo(Carte altaCarte){
        int sortareAutor = this.autor.compareTo(altaCarte.autor);
        if(sortareAutor != 0){
            return sortareAutor;
        }else{
            return this.titlu.compareTo(altaCarte.titlu);
        }

    }

    public String toString(){
        return "Titlu: " + this.titlu + ", Autor: " + this.autor + ", Domeniu: " + this.domeniu + ", Disponibilitate: " + this.disponibilitate + ", Editura: " + this.editura + ", Pret: " + this.pret + "\n";
    }

}
