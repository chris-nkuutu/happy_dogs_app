package com.example.happy_dogs_app.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DogDTO {

    private String id;

    public String name;

    public String breed;

    private String imageUrl;
}
