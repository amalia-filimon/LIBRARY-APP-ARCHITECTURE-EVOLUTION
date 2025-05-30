package Model.Persistenta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreareBazaDateTabele {
    private String DBURL = "jdbc:mysql://localhost:3306/";
    private String USER = "root";
    private String PASS = "tehniciP11@";
    private String DBNAME = "lant_de_librarii";
    private String completeDBURL = "jdbc:mysql://localhost:3306/lant_de_librarii";

    public void creareBazaDate() {

        try {
            //conexiunea nou creata cu baza de date
            Connection connection = DriverManager.getConnection(DBURL, USER, PASS);

            // crearea bazei de date
            Statement statement = connection.createStatement();
            String sql = "CREATE DATABASE " + DBNAME;
            statement.executeUpdate(sql);
            System.out.println("Database created successfully!");

            // inchidem conexiunea cu baza de date
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error creating database: " + e.getMessage());
        }
    }

    public void creareTabelUtilizatori() {

        try {
            Connection conn = DriverManager.getConnection(completeDBURL, USER, PASS);
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE utilizatori " +
                    "(id INTEGER AUTO_INCREMENT not NULL, " +
                    " username VARCHAR(255), " +
                    " password VARCHAR(255), " +
                    " role VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully!!!");

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            // Handle errors for JDBC
            System.out.println("Error!!!");
        }
    }

    public void creareTabelCarti(){

        try {
            Connection conn = DriverManager.getConnection(completeDBURL, USER, PASS);
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE carti " +
                    "(id INTEGER AUTO_INCREMENT not NULL, " +
                    " titlu VARCHAR(255), " +
                    " autor VARCHAR(255), " +
                    " domeniu VARCHAR(255), " +
                    " disponibilitate VARCHAR(255), " +
                    " editura VARCHAR(255), " +
                    " pret VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully!!!");

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            // Handle errors for JDBC
            System.out.println("Error!!!");
        }
    }

    public void creareTabelLibrarii(){

        try {
            Connection conn = DriverManager.getConnection(completeDBURL, USER, PASS);
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE librarii " +
                    "(id INTEGER AUTO_INCREMENT not NULL, " +
                    " locatie VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully!!!");

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            // Handle errors for JDBC
            System.out.println("Error!!!");
        }
    }

    public void creareTabelCarteLibrarie(){

        try {
            Connection conn = DriverManager.getConnection(completeDBURL, USER, PASS);
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE carte_librarie " +
                    "(id_relatie INTEGER AUTO_INCREMENT not NULL, " +
                    " id_carte INTEGER, " +
                    " id_librarie INTEGER, " +
                    " PRIMARY KEY ( id_relatie ))";

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully!!!");

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            // Handle errors for JDBC
            System.out.println("Error!!!");
        }
    }
}
