package at.aau;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ComputerRecommenderTest {

    private final ComputerRecommender recommender = new ComputerRecommender();

    @Test
    void testInvalidBudgetZero() {
        assertThrows(InvalidBudgetException.class, () -> {
            recommender.getRecommendedComputerTypePerBudget(0);
        });
    }

    @Test
    void testBoundaryValue450Min() throws InvalidBudgetException {
        assertEquals(ComputerType.ENTRYLVLPC, recommender.getRecommendedComputerTypePerBudget(1));
    }

    @Test
    void testBoundaryValue450Max() throws InvalidBudgetException {
        assertEquals(ComputerType.ENTRYLVLPC, recommender.getRecommendedComputerTypePerBudget(450));
    }

    @Test
    void testBoundaryValue451Min() throws InvalidBudgetException {
        assertEquals(ComputerType.BDGTPC, recommender.getRecommendedComputerTypePerBudget(451));
    }

}
