package org.example.controller;

import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/hello")
    public String sayHello() {
        List<Person> people = personRepository.findAll();
        if (people.isEmpty()) {
            return "Anyone find in base";
        }
       return "Hello "+people.get(0).getName()+"!";
    }
}
