package jpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Robert Burek
 */
@Entity
public class Indeks {

    @Id
    private int id;

    private String number;



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
                '}';
    }
}
