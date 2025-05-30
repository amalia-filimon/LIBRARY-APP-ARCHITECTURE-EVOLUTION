package Model;

public class UtilizatorBuilder {
    private String username;
    private String parola;
    private String rol;
    private String salariu;
    private String locatieLibrarie;

    public UtilizatorBuilder setUsername(String username){
        this.username = username;
        return this;
    }

    public UtilizatorBuilder setParola(String parola){
        this.parola = parola;
        return this;
    }

    public UtilizatorBuilder setRol(String rol){
        this.rol = rol;
        return this;
    }

    public UtilizatorBuilder setSalariu(String salariu){
        this.salariu = salariu;
        return this;
    }

    public UtilizatorBuilder setLocatieLibrarie(String locatieLibrarie){
        this.locatieLibrarie = locatieLibrarie;
        return this;
    }

    public Utilizator build(){
        if(username != null && parola != null && rol != null && salariu != null && locatieLibrarie != null){
            return new Utilizator(username, parola, rol, salariu, locatieLibrarie);
        }else if(username != null && parola != null){
            return new Utilizator(username, parola, null);
        }else
            return null;
    }
}
