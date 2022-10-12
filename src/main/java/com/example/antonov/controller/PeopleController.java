package com.example.antonov.controller;

import com.example.antonov.entity.Person;
import com.example.antonov.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.example.antonov.controller.PeopleController.ROOT_URL;

@Controller
@RequestMapping(ROOT_URL)
@RequiredArgsConstructor
public class PeopleController {

    private final PersonService personService;

    public final static String ROOT_URL = "/persons";
    public final static String ID_PATH = "/{id}";
    public final static String ID_EDIT_PATH = "/{id}/edit";
    public final static String NEW_PERSON_PATH = "/new";

    @GetMapping(NEW_PERSON_PATH)
    public String newPerson(@ModelAttribute("person") Person person){
        return personService.newPerson(person);
    }

    @PostMapping
    public String createPerson(@ModelAttribute("person") Person person){
        return personService.createPerson(person);
    }

    @GetMapping
    public String showAllPersons(Model model){
        return personService.showAllPersons(model);
    }

    @GetMapping(ID_PATH)
    public String showPerson(@PathVariable(value = "id", required = true) Long id, Model model){
        return personService.showPerson(id, model);
    }

    @GetMapping(ID_EDIT_PATH)
    public String editPerson(@PathVariable("id") Long id, Model model){
        return personService.editPerson(id, model);
    }

    @RequestMapping(ID_PATH)
    public String updatePerson(@ModelAttribute("person") Person newPerson,
                               @PathVariable("id") Long id){
        return personService.updatePerson(newPerson, id);
    }

    @DeleteMapping(ID_PATH)
    public String deletePerson(@PathVariable("id") Long id){
        return personService.deletePerson(id);
    }

}