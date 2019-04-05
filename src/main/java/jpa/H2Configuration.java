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

    public static void main (String[] args) {
        Connection conn = getDBConnection();
        if(conn!=null){
            System.out.println("SUKCES!!!");
        }else System.out.println("blebleble");
    }


    private static Connection getDBConnection() {

        Connection connection = null;

        try {
            Class.forName(h2Driver);
        } catch (ClassNotFoundException e) {
            System.out.println("cos z driver!");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(h2Addr,user,password);
        } catch (SQLException e) {
            System.out.println("coś z bazą, uzytkownikiem, lub hasłem!!!");
            e.printStackTrace();
        }

        return connection;

    }

}
