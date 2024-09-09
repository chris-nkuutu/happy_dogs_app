package com.example.happy_dogs_app.controllers;

import com.example.happy_dogs_app.models.Dog;
import com.example.happy_dogs_app.services.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dogs")
@RequiredArgsConstructor
public class DogController {

    private final DogService dogService;

    @GetMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @PostMapping()
    public ResponseEntity<String> createDog(@RequestBody Dog dog){
       var created = dogService.createDog(dog);
        if(created){
            return new ResponseEntity<>("Dog created successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to create dog", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    public ResponseEntity<Iterable<Dog>> getAllDogs(){
        var dogs = dogService.getAllDogs();
        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDog(@PathVariable String id, @RequestBody Dog dog) {
        boolean updated = dogService.updateDog(id, dog);
        if (updated) {
            return new ResponseEntity<>(id, HttpStatus.OK); // Return the id on success
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable String id) {
      var dog = dogService.getDogById(id);
      if(dog.isPresent()){
          return new ResponseEntity<>(dog.get(), HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDog(@PathVariable String id) {
        boolean deleted = dogService.deleteDog(id);
        if (deleted) {
            return new ResponseEntity<>("Dog with ID " + id + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Dog with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

}
