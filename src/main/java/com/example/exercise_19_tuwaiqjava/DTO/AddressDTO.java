package com.example.exercise_19_tuwaiqjava.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotNull
    private Integer teacher_id;
    private String area;
    private String street;
    @Positive(message = "cannot be negative or zero")
    private Integer building_number;

}
