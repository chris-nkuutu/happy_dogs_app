package com.example.happy_dogs_app.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;

    public String name;

    public String birthday;

    public String email;



    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Dog> dogs;
}
