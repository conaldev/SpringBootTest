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

    @Size(min = 5, max = 20)
    String name;

    @ManyToOne
    Country country;

    @Min(value = 5,message = "phai lon hon 5")
    Long area;

    @Min(value = 6,message = "phai lon hon 6")
    Long population;

    @Min(value = 7,message = "phai lon hon 7")
    Long GDP;

    @Size(min = 5,message = "lon hon 5 ki tu")
    String description;

}
