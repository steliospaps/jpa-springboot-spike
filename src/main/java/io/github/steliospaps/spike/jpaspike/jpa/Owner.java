package io.github.steliospaps.spike.jpaspike.jpa;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Owner {
    
    @Id
    private String name;
    
    @Column
    private String field1;
    
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name="OWNER_NAME")
    private List<OwnerFeature> features;
}
