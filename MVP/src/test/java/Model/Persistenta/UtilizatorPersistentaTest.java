package Model.Persistenta;

import Model.Utilizator;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

public class UtilizatorPersistentaTest extends TestCase {

    public void testAdaugareUtilizator() {
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Utilizator u = new Utilizator("rebecca_sas", "rebe1234", "ANGAJAT", "2000", "Opera 23");
        up.adaugareUtilizator(u);
        assertNotEquals("Nu exista date in tabel care sa corespunda comenzii SQL\r\n", outContent.toString());
        assertEquals("Numarul de randuri afectate: 1\r\n", outContent.toString());
    }

    public void testStergereUtilizator() {
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String username = "denis.man@yahoo.com";
        up.stergereUtilizator(username);

        assertEquals("Numarul de randuri afectate: 1\r\n", outContent.toString());
        assertNotEquals("Eroare la crearea comenzii SQL!!!\r\n", outContent.toString());

    }

    public void testCautareUtilizator() {
        // Arrange
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        Utilizator u1 = new Utilizator("catalin.ardelean", "catalin128", "MANAGER", "3000", "Muncii 78");
        Utilizator u2 = new Utilizator("alex_martari@gmail.com", "alexandru111", "ANGAJAT", "3000", "Rapsodiei 5");

        // Act
        Utilizator rezultat1 = up.cautareUtilizator(u1);
        Utilizator rezultat2 = up.cautareUtilizator(u2);

        // Assert
        assertNotNull(rezultat1);
        assertNotNull(rezultat2);
    }

    public void testActualizareUtilizator() {
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String username = "mihai.marc";
        String noulSalariu = "8000";
        up.actualizareUtilizator(username, noulSalariu);

        assertEquals("Numarul de randuri afectate: 1\r\n", outContent.toString());
        assertNotEquals("Eroare la crearea comenzii SQL!!!\r\n", outContent.toString());
    }

    public void testListaUtilizatori() {
        // Arrange
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        Utilizator u1 = new Utilizator("catalin.ardelean", "catalin128", "MANAGER", "3000", "Muncii 78");
        Utilizator u2 = new Utilizator("amalia", "123456", "ANGAJAT", "4000", "Muncii 78");

        // Act
        List<Utilizator> rezultat = up.listaUtilizatori();
        String util1 = String.valueOf(u1);
        String util2 = String.valueOf(rezultat.get(0)); //catalin.ardelean e pe pozitia 0 in lista si in baza de date

        // Assert
        assertNotNull(rezultat);
        assertEquals(6, rezultat.size()); //sunt 6 utilizatori in baza de date
        assertEquals(util1, util2);
        assertNotEquals(u2, rezultat.get(1));
    }

    public void testLocatieUtilizator() {
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String usernameUtilizatorLogat = "andreea_pop";
        String rezultat = up.locatieUtilizator(usernameUtilizatorLogat);
        assertNotEquals("Nu exista date in tabel care sa corespunda comenzii SQL\r\n", outContent.toString());
        assertNotNull(rezultat);
        assertEquals("Rapsodiei 5", rezultat);
    }

    public void testIdLibrarieAngajat() {
        UtilizatorPersistenta up = new UtilizatorPersistenta();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String usernameUtilizatorLogat = "andreea_pop";
        int rezultat = up.idLibrarieAngajat(usernameUtilizatorLogat);
        assertNotEquals("Nu exista date in tabel care sa corespunda comenzii SQL\r\n", outContent.toString());
        assertNotEquals(0, rezultat);
        assertEquals(2, rezultat);
    }
}