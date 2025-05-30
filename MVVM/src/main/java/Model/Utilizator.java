package Model;

public class Utilizator {
    private String username;
    private String parola;
    private String rol;
    private String salariu;
    private String locatieLibrarie;

    public Utilizator(String username, String parola, String rol){
        this.username = username;
        this.parola = parola;
        this.rol = rol;
    }

    public Utilizator(String username, String parola, String rol, String salariu, String locatieLibrarie){
        this.username = username;
        this.parola = parola;
        this.rol = rol;
        this.salariu = salariu;
        this.locatieLibrarie = locatieLibrarie;
    }

    public String getUsername() {
        return username;
    }

    public String getParola() {
        return parola;
    }

    public String getRol() {
        return rol;
    }

    public String getSalariu() {
        return salariu;
    }

    public String getLocatieLibrarie(){
        return locatieLibrarie;
    }

//    public String toString(){
//        return "Username: " + this.username + ", Password: " + this.parola + ", Role: " + this.rol + ", Salary: " + this.salariu + ", Locatie Librarie: " + this.locatieLibrarie + "\n";
//    }
}
