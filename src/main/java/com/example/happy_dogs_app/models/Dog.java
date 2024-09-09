package com.example.happy_dogs_app.models;

import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    public String name;

    public String breed;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

}
