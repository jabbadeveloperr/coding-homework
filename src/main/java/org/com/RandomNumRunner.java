package org.com;

import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.com.constant.Constant.*;

/**
 * The {@code RandomNumRunner} class serves as the entry point for testing the CustomRandomGenerator.
 * It initializes the generator, generates result counts, and prints the results to the console.
 */
public class RandomNumRunner {
    private static final Logger logger = Logger.getLogger(RandomNumRunner.class.getName());
    private static IRandomGenerator generator;

    /**
     * Main method for testing the CustomRandomGenerator.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, 3};
        float[] probabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};

        generator = new RandomNum(numbers, probabilities);
        logger.log(Level.INFO, INITIALIZED_MESSAGE + generator.getClass().getSimpleName());
        Map<Integer, Integer> resultCounts = generateResultCounts(numbers, 100);
        printResultCounts(resultCounts);
    }

    /**
     * Generates result counts based on the provided numbers and total iterations.
     *
     * @param numbers         The array of numbers to be generated.
     * @param totalIterations The total number of iterations.
     * @return A map containing the result counts for each number.
     */
    public static Map<Integer, Integer> generateResultCounts(int[] numbers, int totalIterations) {
        Map<Integer, Integer> resultCounts = new TreeMap<>();

        // Initializing counts for each number
        for (int number : numbers) {
            resultCounts.putIfAbsent(number, 0);
        }

        // Generating random numbers and updating counts
        for (int i = 0; i < totalIterations; i++) {
            int randomNum = generator.nextNum();
            resultCounts.put(randomNum, resultCounts.get(randomNum) + 1);
        }

        logger.log(Level.INFO, GENERATED_MESSAGE + resultCounts);
        return resultCounts;
    }

    /**
     * Prints the result counts to the console.
     *
     * @param resultCounts A map containing the result counts for each number.
     */
    public static void printResultCounts(Map<Integer, Integer> resultCounts) {
        logger.log(Level.INFO, PRINTING_MESSAGE);
        resultCounts.forEach((key, value) -> System.out.println(key + ": " + value + " times."));
    }
}
