package jpa.domain;

import org.h2.command.ddl.CreateUserDataType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
        System.out.println("-------------------utworzyłęm tabelę w bazie-----------------------");
        readStudents();
        System.out.println("---------------------odczytałem elementy tablicy z bazy---------------------------------");
        Student ktos = readStudent(6);
        System.out.println(ktos);
        System.out.println("--------------------odczytałem dane nr=6 studenta z bazy--i zapisałe do objektu ktos----");
        Indeks indeks = new Indeks(6, "123");
        System.out.println(indeks);
        System.out.println("--------------------stworzyłem indeks nr6 o numerze 123--------------------------------");
        ktos.setIndeks(indeks);
        System.out.println(ktos);
        System.out.println("----------ustawiłem indeks do obiektu ktos------------------------------------------");
        Address address = new Address("Domaniewska", "25", "02-300", "Warszawa");
        System.out.println(address);
        System.out.println("--------------------stworzyłem objekt address wszystkie dane adresowe------------------");
        ktos.setAddress(address);
        System.out.println(ktos);
        System.out.println("-------------ustawiłem address na objelcie ktos--------------------------------");
        ktos = entityManager.merge(ktos);
        System.out.println(ktos);
        System.out.println("--------------------wykonałem marge na objekcie ktos (nadpisałem w bazie)-----------");
        System.out.println(readStudent(6));
        System.out.println("--------------------wypisałem studenta nr6 na ekran dane wziąłem z bazy-----------------");
        //System.out.println(ktos);
        //Read
        //   readStudents();
        //Update
        updateStudent(3, "", "", "654321", "");
        System.out.println("--------------------zrobiłem update na nr3 student telefon 654321 bez merga ---------");
        //Delete
        //deleteStudent(5);

        readStudents();
        System.out.println("--------------------wypisałem wszystkich studentów na ekran dane wziąłem z bazy ---------");
    }

    private static Student readStudent(int nr) {
        //entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, nr);
        //entityManager.getTransaction().commit();
        return student;
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

    public static void readStudents() {
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
