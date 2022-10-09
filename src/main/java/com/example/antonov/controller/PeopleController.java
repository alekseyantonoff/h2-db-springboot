package com.example.antonov.controller;

import com.example.antonov.model.Person;
import com.example.antonov.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PeopleController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "new";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person") Person person){
        personRepository.save(person);
        return "redirect:/persons";
    }

    @GetMapping()
    public String showAllPersons(Model model){
        model.addAttribute("people", personRepository.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String showPerson(@PathVariable(value = "id", required = true) Long id, Model model){
        model.addAttribute("person", personRepository.findById(id).orElseThrow());
        return "show";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(@PathVariable("id") Long id, Model model){
        model.addAttribute("person", personRepository.findById(id).orElseThrow());
        return "edit";
    }

    @RequestMapping("/{id}")
    public String updatePerson(@ModelAttribute("person") Person newPerson,
                               @PathVariable("id") Long id){
        Person person = personRepository.findById(id).orElseThrow();
        person.setName(newPerson.getName());
        personRepository.save(person);
        return "redirect:/persons";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") Long id){
        personRepository.deleteById(id);
        return "redirect:/persons";
    }



}