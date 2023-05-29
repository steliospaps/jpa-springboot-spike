package io.github.steliospaps.spike.jpaspike.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.steliospaps.spike.jpaspike.jpa.Owner;
import io.github.steliospaps.spike.jpaspike.jpa.OwnerFeature;
import io.github.steliospaps.spike.jpaspike.jpa.OwnerRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
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
    
    @PostMapping(path="/owner/{name}/addFeature", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Owner> addOwnerFeature(@PathVariable String name) {
        
        return ResponseEntity.of(ownerRepository.findById(name)//
                .map(i -> {
                    log.info("addingFeature");
                    OwnerFeature feature = new OwnerFeature();
                    
                    feature.setOtherData(i.getFeatures().get(0).getOtherData());
                    feature.setData2("someNewData"+System.currentTimeMillis());
                    
                    i.addFeature(feature);
                    
                    
                    log.info("saving");
                    return ownerRepository.save(i);
                })
                );
    }

    @PostMapping(path="/owner/{name}/removeFeature", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Owner> removeOwnerFeature(@PathVariable String name) {
        
        return ResponseEntity.of(ownerRepository.findById(name)//
                .map(i -> {
                    log.info("removingFeature");
                    i.getFeatures().remove(0);
                    
                    log.info("saving");
                    return ownerRepository.save(i);
                })
                );
    }
}
