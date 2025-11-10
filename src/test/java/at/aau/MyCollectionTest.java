
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

    @Test
    void testRemove_SuccessfulRemovalDecreasesSize() {
        String removedItem = "K odstranění";
        collection.add(removedItem);
        collection.add("Druhý prvek");

        assertEquals(2, collection.size(), "Collection should have 2 elements.");

        collection.remove(removedItem);

        assertEquals(1, collection.size(), "Size has to decrease.");
    }

    @Test
    void testRemove_OnEmptyListThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            collection.remove("any string");
        }, "when it will bw empty collection it should throw an exeption.");

        assertEquals(0, collection.size(), "after exception the size should not change.");
    }

    @Test
    void testRemove_NonExistentItemThrowsException() {
        collection.add("element");

        assertThrows(IllegalArgumentException.class, () -> {
            collection.remove("non existing element");
        }, "should throw IllegalArgumentException.");

        assertEquals(1, collection.size(), "size should stay the same.");
    }
}