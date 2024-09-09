package com.example.happy_dogs_app.repositories;

import com.example.happy_dogs_app.models.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, String> {
}
