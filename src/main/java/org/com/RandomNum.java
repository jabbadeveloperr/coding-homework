package org.com;

import org.com.exeption.InvalidInputException;
import org.com.exeption.NegativeProbabilityException;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.com.constant.Constant.*;

public class RandomNum implements IRandomGenerator {
    private static final Logger logger = Logger.getLogger(RandomNum.class.getName());

    private final int[] numbers;
    private final float[] probabilities;



    /**
     * Constructs a RandomNum with the given numbers and probabilities.
     *
     * @param numbers       The array of numbers to be generated.
     * @param probabilities The corresponding array of probabilities for each number.
     * @throws InvalidInputException        If the input arrays are invalid.
     * @throws NegativeProbabilityException If probabilities contain negative values.
     */
    public RandomNum(int[] numbers, float[] probabilities) {
        validateInput(numbers, probabilities);
        this.numbers = numbers;
        this.probabilities = probabilities;
        logger.log(Level.INFO, INSTANCE_CREATED_MESSAGE);
    }

    /**
     * Validates the input arrays.
     *
     * @param numbers       The array of numbers.
     * @param probabilities The array of probabilities.
     * @throws InvalidInputException        If the input arrays are invalid.
     * @throws NegativeProbabilityException If probabilities contain negative values.
     */
    private void validateInput(int[] numbers, float[] probabilities) {
        if (numbers.length != probabilities.length) {
            anyNegative(probabilities);
            logger.log(Level.SEVERE, INVALID_INPUT_MESSAGE);
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        }
    }

    /**
     * Checks if there is any negative value in the given array.
     *
     * @param array The array to check for negative values.
     * @return True if there is any negative value, false otherwise.
     */
    private void anyNegative(float[] array) {
        for (double value : array) {
            if (value < 0) {
                logger.log(Level.SEVERE, NEGATIVE_PROBABILITY_MESSAGE);
                throw new NegativeProbabilityException(NEGATIVE_PROBABILITY_MESSAGE);
            }
        }
    }

    /**
     * Generates a random number based on the probabilities provided.
     *
     * @return The randomly generated number.
     */
    @Override
    public int nextNum() {
        double randNum = Math.random();
        double cumulativeProb = 0;

        for (int i = 0; i < numbers.length; i++) {
            cumulativeProb += probabilities[i];
            if (randNum <= cumulativeProb) {
                return numbers[i];
            }
        }
        // If no number is selected, return 0.
        return 0;
    }
}
