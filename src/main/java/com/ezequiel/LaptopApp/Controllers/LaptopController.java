package com.ezequiel.LaptopApp.Controllers;

import com.ezequiel.LaptopApp.Entities.Laptop;
import com.ezequiel.LaptopApp.Repositorys.LaptopRepo;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    //Atributos
    private final LaptopRepo laptopRepo;

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    public LaptopController (LaptopRepo laptopRepo){
        this.laptopRepo = laptopRepo;
    }

    //Buscar todas las laptops en db
    @GetMapping("/api/laptop")
    public List<Laptop> findAll(){
        return laptopRepo.findAll();
    }
    //Buscar un libro en db con su id
    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepo.findById(id);
//        return laptopOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//opcion 2
        if (laptopOpt.isPresent()){
            return ResponseEntity.ok(laptopOpt.get());
        } else {return ResponseEntity.notFound().build();}

    }
    //Crear un nueva laptop en db
    @PostMapping("/api/laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        //if laptop que no tenga id
        if (laptop.getId() != null){
            log.warn("trying to create a laptop with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepo.save(laptop);
        return ResponseEntity.ok(result);
    }
    //Actualizar una laptop existente en db
    @PutMapping("api/laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
//        Comprobar que existe la laptop
        if (laptop.getId() == null) {
            log.warn("trying to update a non exist laptop");
            return ResponseEntity.badRequest().build();
        } else if (!laptopRepo.existsById(laptop.getId())) {
            log.warn("trying to update a non exist laptop");
            return ResponseEntity.notFound().build();
        }
//        El proceso de actualización
        Laptop result = laptopRepo.save(laptop);
        return ResponseEntity.ok(result);
    }

    //Borrar una laptop en db
    @DeleteMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
//        Comprobar que exista
        if (!laptopRepo.existsById(id)){
            log.warn("trying to delete a non exist laptop");
            return ResponseEntity.notFound().build();
        }
//        Proceso de eliminar
        laptopRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
