package com.ezequiel.LaptopApp.Repositorys;

import com.ezequiel.LaptopApp.Entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Long> {
}
