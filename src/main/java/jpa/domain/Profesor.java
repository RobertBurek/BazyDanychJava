package jpa.domain;

import javax.persistence.*;

/**
 * Created by Robert Burek
 */
@Entity
public class Profesor {

    @Id //symbol przy unikatowym polu
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="IMIE")//    @Column(name="firstname", nullable = false) - dodatkowe znaczniki
    private String imie;

    //    @Column(name="surname") - dodatkowe znaczniki
    private String nazwisko;

    //    @Column(unique = true)  - dodatkowe znaczniki
    private String telephon;


    //    @Transient  //  to pole ma nie być mapowane do bazy danych  - dodatkowe znaczniki
    private String pesel;

    @Embedded
    private Address address;

    // hibernate wymaga pustego konstruktora ale może on być prywatny czyli taki którego nie użtwa się w prost
    private Profesor() {
    }

    public Profesor( String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Profesor(int id, String imie, String nazwisko, String pesel) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public Profesor(int id, String imie, String nazwisko, String telephon, String pesel) {
        this.id = id;
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

    public String getPesel() { return pesel; }

    public String getTelephon() { return telephon; }

    public void setId(int id) { this.id = id; }

    public void setImie(String imie) {this.imie = imie;}

    public void setNazwisko(String nazwisko) {this.nazwisko = nazwisko;}

    public void setTelephon(String telephon) {this.telephon = telephon;}

    public void setPesel(String pesel) {this.pesel = pesel;}

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telephon='" + telephon + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }

}
