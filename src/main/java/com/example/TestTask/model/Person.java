package com.example.TestTask.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.TABLE;

/**
 * Аннотацией @Entity отмечаются классы, которые представляют собой сущности базы данных.
 * Например, если в базе данных есть таблица User, которая содержит список пользователей,
 * в Java должен существовать класс User, отмеченный аннотацией @Entity,
 * объектом этого класса будет строка таблицы User.
 * Часто используется совместно с аннотацией @Table,
 * которая помогает явно определить некоторую информацию о таблице.
 *
 * @Table (name = "PERSONS") - Название таблицы
 */
@Entity
@Table(name = "PERSONS")
public class Person {

    @Id //Указываем что это поле будет ID
    //@GeneratedValue //И оно будет генерироваться автоматически
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false) //Колонка будет называться id и она не должна быть пустой
    private Long id;

    @Column(name="name")
    private String name;

    /**
     * Обязательно нужно создавать пустой конструктор для корректной сериализации
     */
    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
