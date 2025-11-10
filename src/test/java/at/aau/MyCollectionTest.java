
package at.aau;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyCollectionTest {

    private MyCollection collection;
    private final int CAPACITY = 5;

    @BeforeEach
    void setUp() {
        collection = new MyCollection(CAPACITY);
    }

    /**
     * should fail
     */
    @Test
    void testEmpty_ClearsCollectionAndResetsSize() {
        // I am doing this so the collection os not empty
        collection.add("A");
        collection.add("B");
        collection.add("C");

        assertEquals(3, collection.size(),
                "before testing it should have 3 elements.");

        collection.empty();
        assertEquals(0, collection.size(),
                "should be 0.");
    }

    @Test
    void testInitialSizeIsZero() {
        assertEquals(0, collection.size(), "new collection should be 0.");
    }

    @Test
    void testSizeIncrementsAfterAdd() {
        collection.add("TestString");
        assertEquals(1, collection.size(), "size should increase by 1.");
    }
}