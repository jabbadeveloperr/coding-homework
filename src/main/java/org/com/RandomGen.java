package org.com;

import lombok.Data;
import org.com.exeption.InvalidInputException;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.com.constant.Constant.INVALID_INPUT_MESSAGE;


public record RandomGen(int[] numbers, float[] probabilities) implements IRandomGenerator {
    private static final Logger logger = Logger.getLogger(RandomGen.class.getName());

    private boolean anyNegative(float[] array) {
        for (double value : array) {
            return value < 0;
        }
        return true;
    }

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
            logger.log(Level.SEVERE, INVALID_INPUT_MESSAGE);
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        }
    }
}
