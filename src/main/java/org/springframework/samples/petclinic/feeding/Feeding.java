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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "feedings")
public class Feeding {

    @Id
    Integer id;

    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @NotEmpty
    LocalDate startDate;

    @Column(name = "week_duration")
    @Min(value = 1l)
    double weeksDuration;
    
    @NotNull
    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "feeding")
    Pet pet;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "feeding")
    @Column(name = "feeding_type")
    FeedingType feedingType;
}
