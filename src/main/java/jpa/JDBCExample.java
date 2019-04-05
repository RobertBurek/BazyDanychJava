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

    public static void main(String[] args) throws SQLException {

        createTableForStudent();
        Student pawel = new Student(1, "Paweł");
        Student dawid = new Student(2, "Dawid");

        insertStudent(pawel);
        insertStudent(dawid);
        
        List<Student> students = getStudent();

        students.forEach(student -> {
            System.out.println(student);
        });

    }



    private static void createTableForStudent() throws SQLException {

        Connection connection = H2Configuration.getDBConnection();
//        try {
            Statement statement = connection.createStatement();
//        } catch (SQLException e) {
//            System.out.println("Problem z statement.");
//            e.printStackTrace();
//        }
        String createTable = "CREATE TABLE STUDENT (id int primary key, name varchar(255))";
        statement.execute(createTable);
        connection.commit();


    }

    private static void insertStudent(Student student) throws SQLException {

        Connection connection = H2Configuration.getDBConnection();
        Statement statement = connection.createStatement();
        String insert = "INSERT INTO STUDENT VALUES("+student.getId()+",\'"+student.getName()+"\')";
        statement.execute(insert);
        connection.commit();

    }

    private static List<Student> getStudent() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = H2Configuration.getDBConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            students.add(new Student(id,name));
        }
        return students;
    }


}
