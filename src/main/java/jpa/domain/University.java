package jpa.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Robert Burek
 */
@Entity
@NamedQuery(name = "Uniwersytety", query = "SELECT s FROM University s")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)//(mappedBy = "university")
    private Set<Student> students;

    private University() {
    }

    public University(String name) {
        this.students = new HashSet<>();
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }


    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                // ", students=" + students +
                '}';
    }
}
