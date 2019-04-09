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
//        System.out.println("-------------------utworzyłęm tabelę w bazie-----------------------");
//        readStudents();
//        System.out.println("---------------------odczytałem elementy tablicy z bazy---------------------------------");
//        Student ktos = readStudent(6);
//        System.out.println(ktos);
//        System.out.println("--------------------odczytałem dane nr=6 studenta z bazy--i zapisałe do objektu ktos----");
        entityManager.getTransaction().begin();
        Indeks indeks = entityManager.merge(new Indeks("123"));
        Indeks indeks0 = entityManager.merge(new Indeks( "000"));
        Indeks indeks1 = entityManager.merge(new Indeks( "111"));
        Indeks indeks2 = entityManager.merge(new Indeks( "222"));
//        Indeks indeks3 = entityManager.merge(new Indeks( "333"));
//        Indeks indeks4 = entityManager.merge(new Indeks( "444"));
//        Indeks indeks5 = entityManager.merge(new Indeks( "555"));
        entityManager.getTransaction().commit();
//        System.out.println(indeks);
////        System.out.println(indeks0);
////        System.out.println(indeks1);
////        System.out.println(indeks2);
////        System.out.println(indeks3);
////        System.out.println(indeks4);
////        System.out.println(indeks5);
//        System.out.println("--------------------stworzyłem indeks nr6 o numerze 123--------------------------------");
//        ktos.setIndeks(indeks);
//        System.out.println(ktos);
//        System.out.println("----------ustawiłem indeks do obiektu ktos------------------------------------------");
//        Address address = new Address("Domaniewska", "25", "02-300", "Warszawa");
//        System.out.println(address);
//        System.out.println("--------------------stworzyłem objekt address wszystkie dane adresowe------------------");
//        ktos.setAddress(address);
//        System.out.println(ktos);
//        System.out.println("-------------ustawiłem address na objelcie ktos--------------------------------");
//        ktos = entityManager.merge(ktos);
//        System.out.println(ktos);
//        System.out.println("--------------------wykonałem marge na objekcie ktos (nadpisałem w bazie)-----------");
//        System.out.println(readStudent(6));
//        System.out.println("--------------------wypisałem studenta nr6 na ekran dane wziąłem z bazy-----------------");
//        //System.out.println(ktos);
//        //Read
//        //   readStudents();
//        //Update
//        updateStudent(3, "", "", "654321", "");
//        System.out.println("--------------------zrobiłem update na nr3 student telefon 654321 bez merga ---------");
//        //Delete
//        //deleteStudent(5);
//
//        readStudents();
//        System.out.println("--------------------wypisałem wszystkich studentów na ekran dane wziąłem z bazy ---------");
//        readIndeks();
//        System.out.println("--------------------wypisałem wszystkie indeksy na ekran dane wziąłem z bazy ---------");
//        Student innyktos = readStudent(1);
//        Indeks innyIndeks = entityManager.merge(new Indeks("000"));
//        innyktos.setIndeks(innyIndeks);
//        innyIndeks.setOwner(innyktos);
//
//        entityManager.merge(innyIndeks);
//        entityManager.merge(innyktos);
//
//        Indeks indx = entityManager.find(Indeks.class,1);
//        System.out.println(indx);
//        System.out.println(readStudent(1));
//
//        Indeks mergeIndeks = entityManager.merge(indeks);
//        Indeks idxx = entityManager.find(Indeks.class,mergeIndeks.getId());
//        System.out.println(idxx);

        entityManager.getTransaction().begin();
        Student monika = entityManager.merge(new Student("Monika","Nowakowska", "343434",
                "89120206324","898"));
        entityManager.getTransaction().commit();
        System.out.println(monika);
        System.out.println("--------------");
        readStudents();
        System.out.println("-------------------------");
        readIndeks();

        entityManager.getTransaction().begin();
        University umk = entityManager.merge(new University("UMK"));
        umk.addStudent(monika);
        monika.setUniversity(umk);
        entityManager.merge(umk);
        entityManager.merge(monika);

        readStudent(7);
        Classes geografia = new Classes("GEOGRAFIA");
        Classes matematyka = new Classes("MATEMATYKA");
        matematyka.addStudent(monika);
        matematyka.addStudent(readStudent(3));
        geografia.addStudent(monika);
        geografia.addStudent(readStudent(4));
        entityManager.merge(geografia);
        entityManager.merge(matematyka);


        System.out.println(geografia);
        System.out.println(matematyka);
        Student nowy = new Student("Imie","Nazwisko");
        nowy.addClasses(geografia);
        entityManager.persist(nowy);
        entityManager.getTransaction().commit();
        System.out.println("___NOWY_____");
        System.out.println(nowy.toString(true));
        System.out.println("___NOWY_____");
//        monika.addClasses(geografia);
//        readStudent(4).addClasses(geografia);
        System.out.println(monika.toString(true));
        System.out.println(readStudent(4).toString(true));
//        for (int i=1; i<4 ;++i) umk.addStudent(readStudent(i));
//        entityManager.getTransaction().commit();
//        System.out.println(umk);
        //umk.toString();
        readStudents();




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

    public static void readIndeks() {
        //pobranie pojedyńczego elementu  tabeli
//        Student student = entityManager.find(Student.class, 0);
//        System.out.println(student);
        // pobranie całej tabeli  do ResultList
      //  Indeks indeks = entityManager.find(Indeks.class,6);
        //System.out.println(indeks);
        List fromindeks = entityManager.createQuery("from Indeks").getResultList();
        fromindeks.forEach(System.out::println);
    }


    private static void creatStudent() {

        Student pawel = new Student( "Paweł", "Kowalski");
        Student marian = new Student( "Marian", "Mikołajewicz");
        Student marianna = new Student( "Marianna", "Niemczycka");
        Student robert = new Student("Robert", "Jaaaaa", "70020421252");
        Student zenek = new Student( "Zennon", "Maślak", "256357", "85021206036");
        Student franek = new Student( "Franciszek", "Ktośtam", "82112541589");

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
