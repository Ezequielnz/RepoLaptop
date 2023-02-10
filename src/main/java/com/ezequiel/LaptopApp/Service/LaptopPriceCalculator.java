package com.ezequiel.LaptopApp.Service;

import com.ezequiel.LaptopApp.Entities.Laptop;

import java.util.Objects;

public class LaptopPriceCalculator {
    public Double calculatePrice(Laptop laptop){
        Double price = laptop.getPrice();

        if (Objects.equals(laptop.getMarca(), "apple")){
            price += 200D;
        }

        return price;
    }
}
