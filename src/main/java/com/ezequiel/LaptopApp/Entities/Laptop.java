package com.ezequiel.LaptopApp.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "laptops")
@Data
public class Laptop {

    //Atributos
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private Double price;

}
