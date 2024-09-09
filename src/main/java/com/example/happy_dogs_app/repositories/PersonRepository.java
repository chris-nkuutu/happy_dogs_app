package com.example.happy_dogs_app.repositories;

import com.example.happy_dogs_app.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
}
