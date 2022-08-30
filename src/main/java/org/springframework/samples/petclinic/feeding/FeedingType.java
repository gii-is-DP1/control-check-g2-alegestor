package org.springframework.samples.petclinic.feeding;


import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedingType{

    String name;

    String description;

    PetType petType;
}
