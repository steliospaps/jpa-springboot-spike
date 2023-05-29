package io.github.steliospaps.spike.jpaspike.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.steliospaps.spike.jpaspike.jpa.Owner;
import io.github.steliospaps.spike.jpaspike.jpa.OwnerRepository;

@RestController
public class Controller {

    private OwnerRepository ownerRepository;
    
    public Controller(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;

    }

    @GetMapping(path = "/owner", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Owner> getOwners() {
        
        return ownerRepository.findAll();
    }

    @GetMapping(path = "/owner/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Owner> getOwner(@PathVariable String name) {
        
        return ResponseEntity.of(ownerRepository.findById(name));
    }
}
