package Model.Persistenta;

import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotEquals;

public class CreareBazaDateTabeleTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testCreareBazaDate() {
        CreareBazaDateTabele bd = new CreareBazaDateTabele();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        bd.creareBazaDate();
        assertNotEquals("Database created successfully!\r\n", outContent.toString());
        assertEquals("Error creating database: Can't create database 'lant_de_librarii'; database exists\r\n", outContent.toString());

    }

    public void testCreareTabelUtilizatori() {
    }

    public void testCreareTabelCarti() {
    }

    public void testCreareTabelLibrarii() {
        CreareBazaDateTabele bd = new CreareBazaDateTabele();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        bd.creareTabelLibrarii();
        assertNotEquals("Table created successfully!!!\r\n", outContent.toString());
        assertEquals("Error!!!\r\n", outContent.toString());

    }

    public void testCreareTabelCarteLibrarie() {
    }
}