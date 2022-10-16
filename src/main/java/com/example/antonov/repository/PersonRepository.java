package com.example.antonov.repository;

import com.example.antonov.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    public List<Person> findAllPersonByName(String name);

}