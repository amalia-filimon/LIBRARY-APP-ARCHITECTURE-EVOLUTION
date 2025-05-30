package Model;

import java.util.Observable;

public class Librarie {
    private String locatie;

    public Librarie(String locatie){
        this.locatie = locatie;
    }

    public String getLocatie() {
        return locatie;
    }
}
