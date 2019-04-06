package jpa;

import jpa.domain.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Robert Burek
 */
public class JDBCExample {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        createTableForStudent();
        Student pawel = new Student(1, "Paweł", "Kowalski");
        Student marianna = new Student(2, "Marianna", "Jankowska");
        Student robert = new Student(3, "Robert", "Burek");

        insertStudent(pawel);
        insertStudent(marianna);
        insertStudent(robert);

        List<Student> students = getStudent();

        // students.forEach(System.out::println);
        students.forEach(student -> {
            System.out.println(student);
        });

        System.out.println(getUczen(2));
    }


    private static void createTableForStudent() throws SQLException, ClassNotFoundException {

        Connection polaczenie = H2Configuration.getDBConnection();
//        try {
        Statement komunikat = polaczenie.createStatement();
//        } catch (SQLException e) {
//            System.out.println("Problem z statement.");
//            e.printStackTrace();
//        }

        String createTable = "CREATE TABLE STUDENT (id int primary key, imie varchar(255), nazwisko varchar(255))";
        komunikat.execute(createTable);

        polaczenie.commit();
    }

    private static void insertStudent(Student student) throws SQLException, ClassNotFoundException {

        Connection polaczenie = H2Configuration.getDBConnection();
        Statement komunikat = polaczenie.createStatement();
        String insert =
                "INSERT INTO STUDENT VALUES(" + student.getId() + ",\'" + student.getImie() + "\',\'" + student.getNazwisko() + "\')";
        komunikat.execute(insert);
        polaczenie.commit();

    }

    private static List<Student> getStudent() throws SQLException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        Connection connection = H2Configuration.getDBConnection();
        Statement zapytanie = connection.createStatement();
        ResultSet rezultatZapytania = zapytanie.executeQuery("SELECT * FROM STUDENT");
        while (rezultatZapytania.next()) {
            int id = rezultatZapytania.getInt("id");
            String imie = rezultatZapytania.getString("imie");
            String nazwisko = rezultatZapytania.getString("nazwisko");
            students.add(new Student(id, imie, nazwisko));
        }
        return students;
    }

    private static Student getUczen(int Id) throws SQLException, ClassNotFoundException {
        Student uczen = new Student(0, "", "");
        Connection polaczenie = H2Configuration.getDBConnection();
        Statement zapytanie = polaczenie.createStatement();
        ResultSet rezultatZapytania = zapytanie.executeQuery("SELECT * FROM STUDENT WHERE id = " + Id);
        while (rezultatZapytania.next()) {
            int id = rezultatZapytania.getInt("id");
            String imie = rezultatZapytania.getString("imie");
            String nazwisko = rezultatZapytania.getString("nazwisko");
            uczen = new Student(id, imie, nazwisko);
        }
        return uczen;
    }


}
