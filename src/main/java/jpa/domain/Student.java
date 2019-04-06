package jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created by Robert Burek
 */
@Entity//(name = "uczniowie") dodatkowe znaczniki
public class Student {

    @Id //symbol przy unikatowym polu
    private int id;

//    @Column(name="firstname", nullable = false) - dodatkowe znaczniki
    private String imie;

//    @Column(name="surname") - dodatkowe znaczniki
    private String nazwisko;

//    @Column(unique = true)  - dodatkowe znaczniki
    private String telephon;

//    @Transient  //  to pole ma nie być mapowane do bazy danych  - dodatkowe znaczniki
    private String pesel;

    // hibernate wymaga pustego konstruktora ale może on być prywatny czyli taki którego nie użtwa się w prost
    private Student() {
    }

    public Student(int id, String imie, String nazwisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
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


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}
