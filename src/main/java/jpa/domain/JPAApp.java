package jpa.domain;

import org.h2.command.ddl.CreateUserDataType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Robert Burek
 */
public class JPAApp {
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpaPersistence");

    static EntityManager entityManager = factory.createEntityManager();


    public static void main(String[] args) {

        //CRUD
        //Create
        creatStudent();
        //Read
        //   readStudents();
        //Update
        updateStudent(3, "", "", "654321", "");
        //Delete
        deleteStudent(5);


        readStudents();
    }

    private static void deleteStudent(int nr) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, nr);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    private static void updateStudent(int nr, String... elements) {
        Student student = entityManager.find(Student.class, nr);
        if (!elements[0].equals("")) student.setImie(elements[0]);
        if (!elements[1].equals("")) student.setNazwisko(elements[1]);
        if (!elements[2].equals("")) student.setTelephon(elements[2]);
        if (!elements[3].equals("")) student.setPesel(elements[3]);
        entityManager.merge(student);
        System.out.println(student);

    }

    private static void readStudents() {
        //pobranie pojedyńczego elementu  tabeli
//        Student student = entityManager.find(Student.class, 0);
//        System.out.println(student);
        // pobranie całej tabeli  do ResultList
        List fromstudent = entityManager.createQuery("from Student").getResultList();
        fromstudent.forEach(System.out::println);
    }


    private static void creatStudent() {

        Student pawel = new Student(0, "Paweł", "Kowalski");
        Student marian = new Student(1, "Marian", "Mikołajewicz");
        Student marianna = new Student(3, "Marianna", "Niemczycka");
        Student robert = new Student(4, "Robert", "Jaaaaa", "70020421252");
        Student zenek = new Student(5, "Zennon", "Maślak", "256357", "85021206036");
        Student franek = new Student(6, "Franciszek", "Ktośtam", "82112541589");

        entityManager.getTransaction().begin();
        entityManager.persist(pawel);
        entityManager.persist(marianna);
        entityManager.persist(marian);
        entityManager.persist(robert);
        entityManager.persist(zenek);
        entityManager.persist(franek);
        entityManager.getTransaction().commit();
    }
}
