package org.com;

import org.com.exception.InvalidInputException;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomGenTest {

    @Test
    public void testNextNum() {
        int[] numbers = {-1, 0, 1, 2, 3};
        float[] probabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};

        IRandomGenerator generator = new RandomGen(numbers, probabilities);

        for (int i = 0; i < 1000; i++) {
            int result = generator.nextNum();
            assertTrue(result >= -1 && result <= 3);
        }
    }

    @Test
    public void testNextNumReturnsZero() {
        int[] numbers = {1};
        float[] probabilities = {0};
        IRandomGenerator generator = new RandomGen(numbers, probabilities);


        int result = generator.nextNum();
        assertEquals(0, result);

    }

    @Test(expected = InvalidInputException.class)
    public void testInvalidInputArrayLength() {
        int[] numbers = {1, 2, 3};
        float[] probabilities = {0.2f, 0.3f};

        new RandomGen(numbers, probabilities).nextNum();

    }

    @Test(expected = InvalidInputException.class)
    public void testInvalidInputNegativeProbabilities() {
        int[] numbers = {1, 2, 3};
        float[] probabilities = {0.2f, 0.3f, -0.5f};

        new RandomGen(numbers, probabilities).nextNum();

    }
}
