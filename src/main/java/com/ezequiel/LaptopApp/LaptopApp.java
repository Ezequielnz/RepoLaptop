package com.ezequiel.LaptopApp;

import com.ezequiel.LaptopApp.Entities.Laptop;
import com.ezequiel.LaptopApp.Repositorys.LaptopRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LaptopApp {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LaptopApp.class, args);
		LaptopRepo repository = context.getBean(LaptopRepo.class);

		Laptop Mac = new Laptop();
		Mac.setId(null);
		Mac.setMarca("Apple");
		Mac.setModelo("MacBook Pro 2022");

		Laptop Mac2 = new Laptop();
		Mac2.setId(null);
		Mac2.setMarca("Apple");
		Mac2.setModelo("MacBook Air 2021");
		repository.save(Mac);
		repository.save(Mac2);

		System.out.println(repository.count());
		System.out.println(repository.findAll());
	}

}
