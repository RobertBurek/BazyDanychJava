package jpa.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Robert Burek
 */
@Entity//(name = "uczniowie") dodatkowe znaczniki
public class Student {

    @Id                         //symbol przy unikatowym polu
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "IMIE")//    @Column(name="firstname", nullable = false) - dodatkowe znaczniki
    private String imie;

    //    @Column(name="surname") - dodatkowe znaczniki
    private String nazwisko;

    //    @Column(unique = true)  - dodatkowe znaczniki
    private String telephon;


    //    @Transient  //  to pole ma nie być mapowane do bazy danych  - dodatkowe znaczniki
    private String pesel;

    @Embedded
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private Indeks indeks;

    @ManyToOne(cascade = CascadeType.ALL)
    private University university;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@ManyToMany//(mappedBy = "students", cascade = CascadeType.ALL)
    private Set<Classes> classes;

    // hibernate wymaga pustego konstruktora ale może on być prywatny czyli taki którego nie użtwa się w prost
    private Student() {
    }

    public Student(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.classes = new HashSet<>();
    }

    public Student(String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public Student(String imie, String nazwisko, String telephon, String pesel, String indexNumber) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telephon = telephon;
        this.pesel = pesel;
        this.indeks = new Indeks(indexNumber);
    }

    public Student(String imie, String nazwisko, String telephon, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telephon = telephon;
        this.pesel = pesel;
    }


    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public String getTelephon() {
        return telephon;
    }

    //public void setId(int id) { this.id = id; }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setTelephon(String telephon) {
        this.telephon = telephon;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telephon='" + telephon + '\'' +
                ", pesel='" + pesel + '\'' +
                ", address=" + address +
                ", indeks=" + indeks +
                ", university=" + university +
                ", classes=" + classes +
                '}';
    }

    public String toString(Boolean YN) {
        return "Student{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", classes=" + classes +
                '}';
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setIndeks(Indeks idx) {
        this.indeks = idx;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public void addClasses(Classes classes){
        this.classes.add(classes);
    }

}