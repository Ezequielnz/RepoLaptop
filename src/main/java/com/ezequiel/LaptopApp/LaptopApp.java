package com.ezequiel.LaptopApp;

import com.ezequiel.LaptopApp.Entities.Laptop;
import com.ezequiel.LaptopApp.Repositorys.LaptopRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ezequiel.LaptopApp")
public class LaptopApp {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(LaptopApp.class, args);
		LaptopRepo repoLocal = context.getBean(LaptopRepo.class);

		Laptop mac = new Laptop();
		mac.setMarca("apple");
		mac.setModelo("MacBook Pro 2022");
		mac.setPrice(1200D);
		repoLocal.save(mac);
	}
}
