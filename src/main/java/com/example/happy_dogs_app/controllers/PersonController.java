package com.example.happy_dogs_app.controllers;

import com.example.happy_dogs_app.DTO.PersonDTO;
import com.example.happy_dogs_app.models.Person;
import com.example.happy_dogs_app.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping()
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO requestBody) {
        var created = personService.createPerson(requestBody);
        if (created) {
            return new ResponseEntity<>( " Person created successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(  " Failed to add new person", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<PersonDTO>> getAllPersons() {
        var persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id) {
        var person = personService.getPersonById(id);
        if(person.isPresent()){
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable String id, @RequestBody Person persons) {
       var isUpdated = personService.updatePerson(id, persons);
        if (isUpdated) {
            return new ResponseEntity<>("Person Updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update person",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable String id) {
        boolean deleted = personService.deletePerson(id);
        if (deleted) {
            return new ResponseEntity<>("Person with ID " + id + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Person with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    }


