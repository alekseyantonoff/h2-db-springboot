package com.example.antonov.controller;

import com.example.antonov.dto.PersonDto;
import com.example.antonov.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.antonov.controller.PeopleController.ROOT_URL;

@RestController
@RequestMapping(ROOT_URL)
@RequiredArgsConstructor
public class PeopleController {

    private final PersonService personService;


    public final static String ROOT_URL = "/persons";
    public final static String NEW_PATH = "/new";
    public final static String EDIT_PATH = "/{id}/edit";
    public final static String DELETE_PATH = "/{id}/delete";
    public final static String ID_PATH = "/{id}";
    public final static String FIND_PATH = "/find";


    @GetMapping(NEW_PATH)
    public PersonDto createPerson(@RequestParam("name") String name) {
        return personService.createPerson(name);
    }

    @GetMapping
    public List<PersonDto> showAllPersons(){
        return personService.showAllPersons();
    }

    @GetMapping(ID_PATH)
    public PersonDto showPerson(@PathVariable Long id){
        return personService.showPerson(id);
    }

    @RequestMapping(EDIT_PATH)
    public PersonDto editPerson(@PathVariable Long id, @RequestParam("name") String name){
        return personService.editPerson(id, name);
    }

    @RequestMapping(DELETE_PATH)
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }

    @GetMapping(FIND_PATH)
    public List<PersonDto> findByName(@RequestParam("name") String name) {
        return personService.findByName(name);
    }


}