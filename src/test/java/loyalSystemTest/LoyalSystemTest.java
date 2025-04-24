package loyalSystemTest;

import org.example.loyalSystem.Bucket;
import org.example.loyalSystem.Entity;
import org.example.loyalSystem.LoyalSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//отсутвие id - нет скидки

public class LoyalSystemTest {
    LoyalSystem loyalSystem;
    Map<Integer, Integer> sales;
    @BeforeEach
    void setUp() {
        sales = new HashMap<>(Map.of(
                1, 10,
                2, 12,
                3, 99,
                4, 100));
        loyalSystem = new LoyalSystem(sales);
    }
    @Test
    void getSaleTest1() {
        Entity entity1 = new Entity(112, 10000);
        Entity entity2 = new Entity(11, 100);
        Entity entity3 = new Entity(1, 1000);
        Bucket bucket = new Bucket(List.of(entity1, entity2, entity3));
        var resultBucket = loyalSystem.getSale(2, bucket);

        Assertions.assertEquals(8800, resultBucket.getBucket().get(0).getNewPrice());
        Assertions.assertEquals(88, resultBucket.getBucket().get(1).getNewPrice());
        Assertions.assertEquals(880, resultBucket.getBucket().get(2).getNewPrice());
    }

    @Test
    void getSaleTest2() {
        Entity entity1 = new Entity(112, 10000);
        Entity entity2 = new Entity(11, 100);
        Entity entity3 = new Entity(1, 1000);
        Bucket bucket = new Bucket(List.of(entity1, entity2, entity3));
        var resultBucket = loyalSystem.getSale(5, bucket);

        Assertions.assertEquals(10000, resultBucket.getBucket().get(0).getNewPrice());
        Assertions.assertEquals(100, resultBucket.getBucket().get(1).getNewPrice());
        Assertions.assertEquals(1000, resultBucket.getBucket().get(2).getNewPrice());
    }
}
