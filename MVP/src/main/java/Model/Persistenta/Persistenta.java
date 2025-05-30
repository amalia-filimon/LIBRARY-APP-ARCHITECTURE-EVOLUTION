package Model.Persistenta;

import java.sql.*;

public class Persistenta {
    protected Connection conexiune;

    public Persistenta() {
        try {
            conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/lant_de_librarii", "root", "tehniciP11@");
        } catch (SQLException e) {
            System.out.println("Eroare!!!");
        }
    }

    public Connection getConexiune() {
        return conexiune;
    }

    public Connection deschidereConexiune(){
        try {
            conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/lant_de_librarii", "root", "tehniciP11@");
        } catch (SQLException e) {
            System.out.println("Eroare!!!");
        }
        return conexiune;
    }

    public void inchidereConexiune() {
        try{
            if(conexiune != null){
                conexiune.close();
            }
        }catch(SQLException ex){
            System.out.println("Eroare la inchiderea conexiunii!!!");
        }

    }

    public void comandaSQL(String comanda) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = this.deschidereConexiune();
            stmt = conn.createStatement();
            boolean hasResults = stmt.execute(comanda);
            if (hasResults) {
                // Afisam rezultatele
                System.out.println("OK!");
            } else {
                int rowsAffected = stmt.getUpdateCount();
                System.out.println("Numarul de randuri afectate: " + rowsAffected);
            }
        } catch (SQLException ex) {
            System.out.println("Eroare la crearea comenzii SQL!!!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                this.inchidereConexiune();
            } catch (SQLException ex) {
                System.out.println("Eroare la inchiderea prepareStatement!");
            }
        }
    }


    public String[][] obtinereDateTabel(String comanda){
        Connection conn;
        Statement stmt = null;
        ResultSet resultSet;
        String[][] tabel = null;
        int nrRanduri = 0;
        try{
            conn = this.deschidereConexiune();
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(comanda);
            if(resultSet == null)
                return null;
            //obtin numarul de coloane
            ResultSetMetaData metaData = resultSet.getMetaData();
            int nrColoane = metaData.getColumnCount();

            while(resultSet.next()){
                nrRanduri++;
            } //ResultSet a ajuns cu cursorul la final

            resultSet =  stmt.executeQuery(comanda);//execut comanda inca o data pentru a pozitiona cursorul din nou la inceput
            tabel = new String[nrRanduri][nrColoane];

            int i = 0;
            while (resultSet.next()) {
                for(int j = 0; j < nrColoane; j++){
                    tabel[i][j] = resultSet.getString(j+1);
                }
                i++;
            }

            return tabel;

        } catch (SQLException e) {
            System.out.println("Eroare la comanda pentru obtinerea datelor din tabel!!!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                this.inchidereConexiune();
            } catch (SQLException ex) {
                System.out.println("Eroare la inchidere statement!");
            }
        }
        return tabel;
    }
}
