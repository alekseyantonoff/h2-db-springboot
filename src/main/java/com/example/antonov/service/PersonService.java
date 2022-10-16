package com.example.antonov.service;

import com.example.antonov.entity.Person;
import com.example.antonov.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService{

    private final  PersonRepository personRepository;

    public ModelAndView newPerson(Person person){
        return new ModelAndView("new");
    }

    public ModelAndView createPerson(Person person){
        personRepository.save(person);
        return new ModelAndView("redirect:/persons");
    }

    public ModelAndView showAllPersons(Model model){
        model.addAttribute("people", personRepository.findAll());
        return new ModelAndView("index");
    }

    public ModelAndView showPerson(Long id, Model model){
        model.addAttribute("person", personRepository.findById(id).orElseThrow());
        return new ModelAndView("show");
    }

    public ModelAndView editPerson(Long id, Model model){
        model.addAttribute("person", personRepository.findById(id).orElseThrow());
        return new ModelAndView("edit");
    }

    public ModelAndView updatePerson(Person newPerson, Long id){
        Person person = personRepository.findById(id).orElseThrow();
        person.setName(newPerson.getName());
        personRepository.save(person);
        return new ModelAndView("redirect:/persons");
    }

    public ModelAndView deletePerson(Long id){
        personRepository.deleteById(id);
        return new ModelAndView("redirect:/persons");
    }

/*    public List<Person> findPersonByName(String name){
        return personRepository.findAllPersonByName(name);
    }*/

    public ModelAndView findPersonByName(Model model, String name){
        model.addAttribute("people", personRepository.findAllPersonByName(name));
        return new ModelAndView("foundpeople");
    }

    public ModelAndView showFindForm(Model model){
        return new ModelAndView("find");
    }



}
