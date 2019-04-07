package jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Robert Burek
 */
@Entity
public class Indeks {

    @Id
    private int id;

    private String number;

    @OneToOne(mappedBy = "indeks")
    private Student owner;

    public Indeks() {
    }

    public Indeks(int id, String number) {
        this.id = id;
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
}
