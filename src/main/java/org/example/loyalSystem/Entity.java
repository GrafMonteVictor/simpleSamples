package org.example.loyalSystem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entity {
    private long id;
    private double oldPrice; //BigDecimal
    private double newPrice;

    public Entity( long id, double oldPrice) {
        this.oldPrice = oldPrice;
        this.newPrice = oldPrice;
        this.id = id;
    }
}
