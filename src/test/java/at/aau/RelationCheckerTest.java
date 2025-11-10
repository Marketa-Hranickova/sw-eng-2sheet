package at.aau;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RelationCheckerTest {
    @Test
    void testCase_SC_BC_1() {
        int x = 0;
        int y = 0;
        // u = x = 0; w = 0;
        // v = u + y = 0 + 0 = 0
        int expected = 0;

        int result = RelationChecker.checkRelation(x, y);

        assertEquals(expected, result, "Test (0, 0) should return 0.");
    }

    @Test
    void testCase_SC_BC_2() {
        int x = 10;
        int y = 17;
        // R.3(T): u = y = 17; w = 2;
        // R.10(F): v = u + x / w = 17 + 10 / 2 = 17 + 5 = 22
        int expected = 22;

        int result = RelationChecker.checkRelation(x, y);

        assertEquals(expected, result, "Test (10, 17) should return 22.");
    }

}
