package Model.Persistenta;

import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotEquals;

public class PersistentaTest extends TestCase {

    public void testGetConexiune() {
    }

    public void testDeschidereConexiune() throws SQLException {
        // Arrange
        Persistenta p = new Persistenta();

        // Act
        p.deschidereConexiune();
        Connection conexiune = p.getConexiune();

        // Assert
        assertTrue(conexiune.isValid(0));
    }

    public void testInchidereConexiune() throws SQLException {
        // Arrange
        Persistenta p = new Persistenta();
        p.deschidereConexiune();

        // Act
        p.inchidereConexiune();
        Connection conexiune = p.getConexiune();

        // Assert
        assertTrue(conexiune.isClosed());
    }

    public void testObtinereDateTabel(){
        // Arrange
        Persistenta p = new Persistenta();
        String vizualizareSQL = "SELECT * FROM utilizatori";

        // Act
        String[][] rezultat = p.obtinereDateTabel(vizualizareSQL);

        // Assert
        assertNotNull(rezultat);
        assertEquals(18, rezultat.length);
    }

    public void testComandaSQL(){
        // Arrange
        Persistenta p = new Persistenta();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String comandaSQL = "INSERT INTO utilizatori (username, password, role, salary, id_librarie) VALUES ('cosmin_andrei', 'cosmin1234', 'ANGAJAT', '4300', '4')";
        //String comandaSQL = "DELETE FROM utilizatori WHERE username = 'maria_elena'";
        // Act
        p.comandaSQL(comandaSQL);

        // Assert
        assertEquals("Numarul de randuri afectate: 1\r\n", outContent.toString());
        assertNotEquals("Eroare la comanda pentru obtinerea datelor din tabel!!!\r\n", outContent);
    }
}