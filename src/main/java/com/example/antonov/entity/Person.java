package com.example.antonov.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "PERSONS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name="name")
    private String name;


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
