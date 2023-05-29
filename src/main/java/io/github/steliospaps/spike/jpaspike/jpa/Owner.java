package io.github.steliospaps.spike.jpaspike.jpa;

import java.util.List;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "owner",fetch = FetchType.EAGER)
    //@JoinColumn(name="OWNER_NAME",nullable = false)
    private List<OwnerFeature> features;

    public void addFeature(OwnerFeature feature) {
        feature.setOwner(this);
        features.add(feature);
    }
}
