package org.com;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.com.constant.Constant.GENERATED_MESSAGE;

@AllArgsConstructor

public class ResultCount {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private RandomGen randomGenerator;

    private Map<Integer, Integer> generateResultCounts(int totalIterations) {
        Map<Integer, Integer> resultCounts = new TreeMap<>();
        for (int number : randomGenerator.numbers()) {
            resultCounts.putIfAbsent(number, 0);
        }

        for (int i = 0; i < totalIterations; i++) {
            int randomNum = randomGenerator.nextNum();
            resultCounts.put(randomNum, resultCounts.get(randomNum) + 1);
        }

        logger.log(Level.INFO, GENERATED_MESSAGE + resultCounts);
        return resultCounts;
    }

    public void printResultCounts(int number) {
        generateResultCounts(number)
                .forEach((key, value) ->
                        System.out.println(key + ": " + value + " times."));
    }
}
