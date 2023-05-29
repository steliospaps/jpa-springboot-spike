package io.github.steliospaps.spike.jpaspike.jpa;

import jakarta.persistence.Column;
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
    private static class OwnerFeatureId{
        private String ownerName;
        private String data2;
        private String otherData;
    }
    
    @Id
    @ManyToOne
    @JoinColumn(name = "DATA_ID")
    private OtherData otherData;
    
    @Id
    @Column(name="OWNER_NAME")
    private String ownerName;
    
    @Id
    private String data2;
    
}