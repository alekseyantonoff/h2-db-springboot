package com.example.antonov.service;

import com.example.antonov.dto.PersonDto;
import com.example.antonov.entity.Person;
import com.example.antonov.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService{

    private final  PersonRepository personRepository;

    public PersonDto createPerson(String name){
        Person result = personRepository.save(Person.of(name));
        return PersonDto.of(result);
    }

    public List<PersonDto> showAllPersons(){
        List<Person> result = personRepository.findAll();
        return result
                .stream()
                .map(PersonDto::of)
                .toList();
    }

    public PersonDto showPerson(Long id){
        Person result = personRepository.findById(id).orElseThrow();
        return PersonDto.of(result);
    }

    public PersonDto editPerson(Long id, String name){
        Person result = personRepository.save(Person.of(id, name));
        return PersonDto.of(result);
    }


    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }

    public List<PersonDto> findByName(String name){
        List<Person> result = personRepository.findByName(name);
        return result
                .stream()
                .map(PersonDto::of)
                .toList();
    }

}
