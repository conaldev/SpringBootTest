package com.minh.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty
    @Size(min = 5, max = 20)
    String name;

    @ManyToOne
    Country country;

    @NotEmpty
    @Min(value = 5,message = "phai lon hon 5")
    Long area;

    @NotEmpty
    @Min(value = 6,message = "phai lon hon 6")
    Long population;

    @NotEmpty
    @Min(value = 7,message = "phai lon hon 7")
    Long GDP;

    @NotEmpty
    @Size(min = 5,message = "lon hon 5 ki tu")
    String description;

}
