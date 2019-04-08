package jpa.domain;

import javax.persistence.*;

/**
 * Created by Robert Burek
 */
@Entity
public class Indeks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @OneToOne(mappedBy = "indeks")
    private Student owner;

    public Indeks() {
    }

    public Indeks( String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Indeks{" +
                "id=" + id +
                ", number='" + number + '\'' +
               // ", owner=" + owner +
                '}';
    }

    public Student getOwner() {
        return owner;
    }

    public void setOwner(Student owner) {
        this.owner = owner;
    }

    public int getId(){
        return id;
    }
}
