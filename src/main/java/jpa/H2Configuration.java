package jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Robert Burek
 */
public class H2Configuration {

    private static String h2Driver = "org.h2.Driver";
    private static String h2Addr = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static String user = "";
    private static String password = "";

//    metoda tylko dla testu połączeniu
//    public static void main(String[] args) {
//        Connection conn = getDBConnection();
//        if (conn != null) {
//            System.out.println("SUKCES!!!");
//        } else System.out.println("Nic z tego, brak połączenie!!!");
//    }


    public static Connection getDBConnection() {

        Connection connection = null;

        try {
            Class.forName(h2Driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Błąd DRIVERA!!!");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(h2Addr, user, password);
        } catch (SQLException e) {
            System.out.println("Adres bazy, użytkownik lub hasło!!!");
            e.printStackTrace();
        }

        return connection;

    }

}
