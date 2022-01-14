package org.springframework.samples.petclinic.feeding;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "feeding_types")
public class FeedingType {

    @Id
    Integer id;

    @NotEmpty
    @Length(min = 5, max = 30)
    @Column(unique = true)
    String name;

    @NotEmpty
    String description;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet_type")
    @Column(name = "pet_type_id")
    @NotNull
    PetType petType;
}
