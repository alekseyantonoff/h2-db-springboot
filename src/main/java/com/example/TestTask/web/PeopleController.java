package com.example.TestTask.web;

import com.example.TestTask.model.Person;
import com.example.TestTask.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @RestController = @Controller + @ResponseBody.
 * Аннотация @RestController сообщает Spring, что этот код описывает конечную точку,
 * которая должна быть доступна через веб.
 */
@RestController
@RequestMapping("/")
//Аннотация нужна для того чтобы каждый метод внутри этого класса возвращал структуру в формате json
//@RequestMapping(value="", produces = "application/json")
public class PeopleController {

    //Проинициализируем репозиторий и сделаем его автозагружаемым
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public

    @RequestMapping("/persons")
    public Person createPerson(@RequestParam(value = "name", required = true) String name){
        return personRepository.save(new Person(name));
    }

    @GetMapping("/persons/show")
    public List<Person> showAllPersons(){
        return (List<Person>) personRepository.findAll(); //???????????????????????
    }

    @GetMapping("/persons/show/{id}")
    public Person showPerson(@PathVariable(value = "id", required = true) Long id){
        //@RequestParam раньше было так. Мы принимаем, а не передаем!!!!
        return personRepository.findById(id).orElseThrow();
    }

    @RequestMapping("/persons/delete/{id}")
    public List<Person> deletePerson(@PathVariable(value = "id", required = true) Long id){
        personRepository.deleteById(id);
        return (List<Person>) personRepository.findAll();
    }

    @RequestMapping("/persons/{id}/edit")
    public List <Person> edit(@PathVariable("id") Long id, @RequestParam(value = "name", required = true) String name){
        //Ищем человека по id и меняем ему имя на то что в url
        Person person = personRepository.findById(id).orElseThrow();
        person.setName(name);
        personRepository.save(person);
        return (List<Person>) personRepository.findAll();
    }


/*    @GetMapping("/persons")
    public String hello(){
        return "Hello World!";
    }*/

}
