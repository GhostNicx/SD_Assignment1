package com.utcn.demo.controller;

import com.utcn.demo.model.Person;
import com.utcn.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/getAll")
    public List<Person> getPerson(){
        return personService.retrievePersons();
    }


}
