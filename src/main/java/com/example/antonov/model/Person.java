package com.example.antonov.model;
import javax.persistence.*;

@Entity
@Table(name = "PERSONS")
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false) //Колонка будет называться id и она не должна быть пустой
    private Long id;

    @Column(name="name")
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}