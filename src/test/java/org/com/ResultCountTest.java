package org.com;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class ResultCountTest {

    @Test
    public void testGenerateResultCounts() {
        int[] numbers = {-1, 0, 1, 2, 3};
        float[] probabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};
        IRandomGenerator generator = new RandomGen(numbers, probabilities);
        ResultCount resultCount = new ResultCount(generator);

        // Generate result counts for 1000 iterations
        Map<Integer, Integer> resultCounts = resultCount.generateResultCounts(1000);

        // Verify that the counts sum up to the total number of iterations
        int totalCount = resultCounts.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(1000, totalCount);

        // Verify that each number is within the expected range
        for (int number : resultCounts.keySet()) {
            assertTrue(number >= -1 && number <= 3);
        }
    }
    @Test
    public void testPrintResultCounts() {
        int[] numbers = {-1, 0, 1, 2, 3};
        float[] probabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};
        IRandomGenerator generator = new RandomGen(numbers, probabilities);
        ResultCount resultCount = new ResultCount(generator);

        String printedResult = resultCount.printResultCounts(10);
        assertNotNull(printedResult);
    }

}
