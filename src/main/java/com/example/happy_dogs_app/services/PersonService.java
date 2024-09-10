package com.example.happy_dogs_app.services;


import com.example.happy_dogs_app.DTO.PersonDTO;
import com.example.happy_dogs_app.models.Person;
import com.example.happy_dogs_app.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public boolean createPerson(PersonDTO dto) {
        try {
            personRepository.save(dto.toPerson());

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Iterable<PersonDTO> getAllPersons() {
        var persons = personRepository.findAll();

        var personDTOs = new ArrayList<PersonDTO>();

        for (var person : persons){
            var personDTO = new PersonDTO(person);
            personDTOs.add(personDTO);

        }
        return personDTOs;
    }

    public Optional<Person> getPersonById(String id) {
        return personRepository.findById(id);
    }

    public boolean updatePerson(String id, Person updatedPerson) {
        Optional<Person> existingPerson = personRepository.findById(id);
        if (existingPerson.isPresent()) {
           var person = existingPerson.get();
            person.setName(updatedPerson.getName());
            person.setBirthday(updatedPerson.getBirthday());
            person.setEmail(updatedPerson.getEmail());

           personRepository.save(person);
            return true;

        } else {

            return false;
        }
    }
    public boolean deletePerson(String id) {
        Optional<Person> existingPerson = personRepository.findById(id);
        if (existingPerson.isPresent()) {
            personRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}

