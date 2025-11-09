package at.aau;

public class ComputerRecommender {
    /* Equivalence Partitions
     * 1-5;A
     * 6-INF;B
     * ...
     */
    public ComputerType getRecommendedComputerTypePerBudget(int maxBudget) throws InvalidBudgetException {

        if (maxBudget <= 0) {
            throw new InvalidBudgetException("Budget must be greater than zero.");
        } else if (maxBudget <= 450) {
            return ComputerType.ENTRYLVL;
        } else if (maxBudget <= 600) {
            return ComputerType.BDGTPC;
        } else if (maxBudget <= 1500) {
            return ComputerType.GAMINGPC;
        } else {
            return ComputerType.ENTHUSIASTHPC;
        }

    }






}

