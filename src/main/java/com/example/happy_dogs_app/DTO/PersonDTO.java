package com.example.happy_dogs_app.DTO;

import com.example.happy_dogs_app.models.Dog;
import com.example.happy_dogs_app.models.Person;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PersonDTO {

    private String id;

    public String name;

    public String birthday;

    public String email;

    public PersonDTO(Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
        this.birthday = person.getBirthday();
    }

    public Person toPerson(){
        return new Person(id, name, birthday, email, null);
    }
}
