package com.example.happy_dogs_app.DTO;

import com.example.happy_dogs_app.models.Dog;
import com.example.happy_dogs_app.models.Person;
import lombok.Data;



@Data
public class PersonDTO {
    private String id;

    public String name;

    public String birthday;

    public String email;


    public Person toPerson(){
        return new Person(id, name, birthday, email, null);
    }
}
