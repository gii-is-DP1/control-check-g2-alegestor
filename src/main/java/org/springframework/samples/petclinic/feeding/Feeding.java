package org.springframework.samples.petclinic.feeding;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "feedings")
public class Feeding extends BaseEntity {

	@DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "start_date")
    @NotNull
    LocalDate startDate;

    @Positive
    @Column(name = "weeks_duration")
    double weeksDuration;
    
    @ManyToOne
    @JoinColumn(name = "pet_id")
    @NotNull
    Pet pet;
    
    @ManyToOne
    @JoinColumn(name = "feeding_type")
    FeedingType feedingType;
}
