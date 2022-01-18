package org.springframework.samples.petclinic.feeding;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "feedings")
public class Feeding extends BaseEntity{

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @NotNull
    LocalDate startDate;

    @Column(name = "weeks_duration")
    @Positive
    @NotNull
    double weeksDuration;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pet_id")
    Pet pet;
    
    @ManyToOne
    @JoinColumn(name = "feeding_type_id")
    FeedingType feedingType;
}
