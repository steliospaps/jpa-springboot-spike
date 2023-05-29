package io.github.steliospaps.spike.jpaspike.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@IdClass(OwnerFeature.OwnerFeatureId.class)
@Data
public class OwnerFeature {
    
    @Data
    public static class OwnerFeatureId{
        private String owner;
        private String data2;
        private String otherData;
    }
    @Id   
    @JsonIgnore
    @ManyToOne(optional = false)
    private Owner owner;
    
    @Id
    @ManyToOne    
    @JoinColumn(name = "DATA_ID")
    private OtherData otherData;
        
    @Id
    private String data2;
    
}
