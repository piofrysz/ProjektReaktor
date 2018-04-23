package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    Connection conn;
    public void driverRegistration(){
        String driverClassName = "com.mysql.jdbc.Driver";
        try {
            // rejestracja klasy sterownika
            Class.forName(driverClassName);
            System.out.println("Sterownik zarejestrowany w projekcie");
        } catch (ClassNotFoundException e) {
            System.out.println("Nie zarejestrowano klasy sterownika");
        }
    }
    public Connection setConnection(){
        String urlConn = "jdbc:mysql://localhost:3306/skrypt-projektreaktorDB";
        try {
            conn = DriverManager.getConnection(urlConn,"root","MaximuS94");
            System.out.println("Połączenie ustanowione!");
        } catch (SQLException e) {
            System.out.println("Błędny login lub hasło!");
        }
        return conn;
    }
}
