package com.example.antonov.controller;

import com.example.antonov.entity.Person;
import com.example.antonov.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.example.antonov.controller.PeopleController.ROOT_URL;

@RestController
@RequestMapping(ROOT_URL)
@RequiredArgsConstructor
public class PeopleController {

    private final PersonService personService;

    public final static String ROOT_URL = "/persons";
    public final static String ID_PATH = "/{id}";
    public final static String ID_EDIT_PATH = "/{id}/edit";
    public final static String NEW_PERSON_PATH = "/new";
    public final static String FIND_PERSON_PATH = "/find";
    public final static String FOUND_PEOPLE_PATH = "/foundpeople";

    @GetMapping(NEW_PERSON_PATH)
    public ModelAndView newPerson(@ModelAttribute("person") Person person){
        return personService.newPerson(person);
    }

    @PostMapping
    public ModelAndView createPerson(@ModelAttribute("person") Person person){
        return personService.createPerson(person);
    }

    @GetMapping
    public ModelAndView showAllPersons(Model model){
        return personService.showAllPersons(model);
    }

    @GetMapping(ID_PATH)
    public ModelAndView showPerson(@PathVariable(value = "id", required = true) Long id, Model model){
        return personService.showPerson(id, model);
    }

    @GetMapping(ID_EDIT_PATH)
    public ModelAndView editPerson(@PathVariable("id") Long id, Model model){
        return personService.editPerson(id, model);
    }

    @RequestMapping(ID_PATH)
    public ModelAndView updatePerson(@ModelAttribute("person") Person newPerson,
                               @PathVariable("id") Long id){
        return personService.updatePerson(newPerson, id);
    }

    @DeleteMapping(ID_PATH)
    public ModelAndView deletePerson(@PathVariable("id") Long id){
        return personService.deletePerson(id);
    }


    @GetMapping(FIND_PERSON_PATH)
    public ModelAndView showFindForm(Model model){
        return personService.showFindForm(model);
    }

    @GetMapping(FOUND_PEOPLE_PATH)
    public ModelAndView nameSubmit(@RequestParam(required=false, name="name") String name, Model model) {
        model.addAttribute("name", name);
        return personService.findPersonByName(model, name);
    }


}