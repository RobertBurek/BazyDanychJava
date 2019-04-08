package jpa.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Robert Burek
 */
@Entity
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "classes")
    private Set<Student> students;


    public Classes(){}

    public Classes(String name) {
        this.name = name;
        students = new HashSet<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }
}
