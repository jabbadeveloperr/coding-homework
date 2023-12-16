package org.com;

import org.com.exception.InvalidInputException;


public record RandomGen(int[] numbers, float[] probabilities) implements IRandomGenerator {
    public static final String INVALID_INPUT_MESSAGE = "Invalid input: lengths of numbers and probabilities must match, and probabilities must be non-negative.";


    @Override
    public int nextNum() {
        validateInput();
        double randNum = Math.random();
        float cumulativeProb = 0;

        for (int i = 0; i < probabilities.length; i++) {
            cumulativeProb += probabilities[i];
            if (randNum <= cumulativeProb) {
                return numbers[i];
            }
        }
        return 0;
    }


    private void validateInput() {
        if (numbers.length != probabilities.length || anyNegative(probabilities)) {
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        }
    }

    private boolean anyNegative(float[] array) {
        for (double value : array) {
            if (value < 0) return true;
        }
        return false;
    }
}
