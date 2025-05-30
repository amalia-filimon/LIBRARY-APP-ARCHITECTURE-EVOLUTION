package Model;

public class Carte implements Comparable<Carte>{
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

}
