package com.example.antonov.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PERSONS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name="name")
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public static Person of(String name) {
        return Person.builder()
                .name(name)
                .build();
    }

    public static Person of(Long id, String name) {
        return Person.builder()
                .id(id)
                .name(name)
                .build();
    }

}