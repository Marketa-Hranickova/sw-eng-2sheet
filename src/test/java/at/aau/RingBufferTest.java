package at.aau;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class RingBufferTest {

    private RingBuffer<Integer> buffer;
    private final int CAPACITY = 3;

    @BeforeEach

    void setUp() {
        // here we initialize buffer before each case
        buffer = new RingBuffer<>(CAPACITY);
    }

    @Test
    void testConstructor_ValidCapacity() {
        assertDoesNotThrow(() -> new RingBuffer<>(1));
    }

    @Test
    void testIsEmpty_InitiallyTrue() {
        // if is empty will be true, this will happen
        assertTrue(buffer.isEmpty());
        assertEquals(0, buffer.size());
    }

    @Test
    void testIsEmpty_AfterPushPop() {
        buffer.push(1);
        // is isempty will be false
        assertFalse(buffer.isEmpty());
        buffer.pop();
        // if isempty will be true after pop
        assertTrue(buffer.isEmpty());
    }


    // ----borders-----

    @Test
    void testPush_Overflow() {
        buffer.push(1);
        buffer.push(2);
        buffer.push(3);
        // when count == buffer.length (true) in push()
        assertThrows(RuntimeException.class, () -> buffer.push(4),
                "should throw RuntimeException .");
    }

    @Test
    void testPop_Underflow() {
        // when isEmpty() (true) in pop()
        assertThrows(RuntimeException.class, () -> buffer.pop(),
                "should throw RuntimeException.");
    }

    //-----fifo tests

    @Test
    void testFifoOrder() {
        buffer.push(10);
        buffer.push(20);
        assertEquals(10, buffer.pop());
        assertEquals(20, buffer.pop());
        assertTrue(buffer.isEmpty());
    }

    @Test
    void testWrapAround_Push() {
        // filling (indexIn = 0)
        buffer.push(1); // 0
        buffer.push(2); // 1
        buffer.push(3); // 2
        // removing first (indexOut = 1)
        buffer.pop();
        // putting the border one, in this case 4 (indexIn = 0)
        buffer.push(4);

        assertEquals(2, buffer.pop());
        assertEquals(3, buffer.pop());
        assertEquals(4, buffer.pop());
        assertTrue(buffer.isEmpty());
    }

    @Test
    void testWrapAround_Pop() {
        buffer.push(1); // 0
        buffer.push(2); // 1
        buffer.push(3); // 2

        // moving every element
        buffer.pop(); // indexOut = 1
        buffer.pop(); // indexOut = 2
        buffer.pop(); // indexOut = 0 (wrap-around)

        assertTrue(buffer.isEmpty());
        buffer.push(4);
        buffer.push(5);

        assertEquals(4, buffer.pop()); // indexOut = 1
    }

    // ----iterator tests


    @Test
    void testIterator_EmptyBuffer() {
        Iterator<Integer> it = buffer.iterator();

        // when hasNext() == false
        assertFalse(it.hasNext());

        // when !hasNext() (true) in next()
        assertThrows(NoSuchElementException.class, it::next,
                "should throw NoSuchElementException.");
    }

    @Test
    void testIterator_RemoveUnsupported() {
        buffer.push(1);
        Iterator<Integer> it = buffer.iterator();
        it.next();

        // calling remove()
        assertThrows(UnsupportedOperationException.class, it::remove,
                "should throw UnsupportedOperationException.");
    }

    @Test
    void testPush_HandlesNullItems() {
        // behavior with null elements
        assertDoesNotThrow(() -> buffer.push(null));
        buffer.push(1);
        assertEquals(null, buffer.pop());
        assertEquals(1, buffer.pop());
    }

}
