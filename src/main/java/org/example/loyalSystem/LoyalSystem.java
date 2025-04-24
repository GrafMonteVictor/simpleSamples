package org.example.loyalSystem;

import lombok.AllArgsConstructor;
import java.util.Map;

@AllArgsConstructor
public class LoyalSystem {
    Map<Integer, Integer> sales;

    public Bucket getSale(Integer id, Bucket bucket) {
        if (!sales.containsKey(id)) {
            return bucket;
        }
        Integer saleForId = sales.get(id);
        for (Entity entity: bucket.getBucket()) {
            entity.setNewPrice(entity.getOldPrice() - entity.getOldPrice() * saleForId / 100);
        }
        return bucket;
    }
}
