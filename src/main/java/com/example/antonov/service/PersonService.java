package com.example.antonov.service;

import com.example.antonov.entity.Person;
import com.example.antonov.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final  PersonRepository personRepository;

    public String newPerson(Person person){
        return "new";
    }

    public String createPerson(Person person){
        personRepository.save(person);
        return "redirect:/persons";
    }

    public String showAllPersons(Model model){
        model.addAttribute("people", personRepository.findAll());
        return "index";
    }

    public String showPerson(Long id, Model model){
        model.addAttribute("person", personRepository.findById(id).orElseThrow());
        return "show";
    }

    public String editPerson(Long id, Model model){
        model.addAttribute("person", personRepository.findById(id).orElseThrow());
        return "edit";
    }

    public String updatePerson(Person newPerson, Long id){
        Person person = personRepository.findById(id).orElseThrow();
        person.setName(newPerson.getName());
        personRepository.save(person);
        return "redirect:/persons";
    }

    public String deletePerson(Long id){
        personRepository.deleteById(id);
        return "redirect:/persons";
    }
}
