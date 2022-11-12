package com.example.antonov.controller;

import com.example.antonov.dto.PersonDto;
import com.example.antonov.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PeopleController {

    private final PersonService personService;

    @GetMapping("/new")
    public PersonDto createPerson(@RequestParam("name") String name) {
        return personService.createPerson(name);
    }

    @GetMapping
    public List<PersonDto> showAllPersons(){
        return personService.showAllPersons();
    }

    @GetMapping("/{id}")
    public PersonDto showPerson(@PathVariable Long id){
        return personService.showPerson(id);
    }

    @RequestMapping("/{id}/edit")
    public PersonDto editPerson(@PathVariable Long id, @RequestParam("name") String name){
        return personService.editPerson(id, name);
    }

    @RequestMapping("/{id}/delete")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }

    @GetMapping("/find")
    public List<PersonDto> findByName(@RequestParam("name") String name) {
        return personService.findByName(name);
    }


}