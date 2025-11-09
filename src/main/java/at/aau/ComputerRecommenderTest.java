package at.aau;

import org.testng.annotations.Test;
import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

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
        assertEquals(ComputerType.ENTRYLVL, recommender.getRecommendedComputerTypePerBudget(1));
    }

    @Test
    void testBoundaryValue450Max() throws InvalidBudgetException {
        assertEquals(ComputerType.ENTRYLVL, recommender.getRecommendedComputerTypePerBudget(450));
    }

    @Test
    void testBoundaryValue451Min() throws InvalidBudgetException {
        assertEquals(ComputerType.BDGTPC, recommender.getRecommendedComputerTypePerBudget(451));
    }

}
