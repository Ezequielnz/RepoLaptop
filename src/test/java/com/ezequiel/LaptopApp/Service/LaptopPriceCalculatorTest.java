package com.ezequiel.LaptopApp.Service;

import com.ezequiel.LaptopApp.Entities.Laptop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LaptopPriceCalculatorTest {

    @Test
    void calculatePrice() {
//        Configuración de la prueba
        Laptop laptop = new Laptop();
        laptop.setMarca("apple");
        laptop.setModelo("MacBook Air");
        laptop.setPrice(1000D);
        LaptopPriceCalculator calculator = new LaptopPriceCalculator();

//        Se ejecuta el método
        Double price = calculator.calculatePrice(laptop);
        System.out.println(price);

//        Comprobaciones aserciones
        assertTrue(price > 0);
        assertEquals(1200.0, price);

    }
}