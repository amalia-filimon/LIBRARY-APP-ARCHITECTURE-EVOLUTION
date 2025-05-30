package Model;

import java.awt.*;
import java.io.Serializable;
import java.util.Observable;

public class Librarie implements Serializable {
    private String locatie;

    public Librarie(String locatie){
        this.locatie = locatie;
    }

    public String getLocatie() {
        return locatie;
    }
}
