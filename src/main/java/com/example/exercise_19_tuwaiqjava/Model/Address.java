package com.example.exercise_19_tuwaiqjava.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {


    //Address Class :
    //area , street , buildingNumber ( Add all required validation )
    @Id
    private Integer id;
    @NotEmpty
    private String area;
    @NotEmpty
    private String street;
    @NotNull
    @Positive(message = "cannot be negative or zero")
    private Integer building_number;


    private Integer teacher_id;
}
