package io.github.steliospaps.spike.jpaspike.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OtherData {
    
    @Id
    private String dataId;
    
    @Column
    private String data;
}
