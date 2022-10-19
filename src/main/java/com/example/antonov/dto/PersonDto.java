package com.example.antonov.dto;

import com.example.antonov.entity.Person;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonDto {
    private Long id;
    private String name;

    public static PersonDto of(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .name(person.getName())
                .build();
    }
}
