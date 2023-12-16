package org.com;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.TreeMap;

@AllArgsConstructor

public class ResultCount {
    private IRandomGenerator randomGenerator;

    public Map<Integer, Integer> generateResultCounts(int totalIterations) {
        Map<Integer, Integer> resultCounts = new TreeMap<>();
        for (int number : randomGenerator.numbers()) {
            resultCounts.putIfAbsent(number, 0);
        }

        for (int i = 0; i < totalIterations; i++) {
            int randomNum = randomGenerator.nextNum();
            resultCounts.put(randomNum, resultCounts.get(randomNum) + 1);
        }

        return resultCounts;
    }

    public String printResultCounts(int number) {
        Map<Integer, Integer> resultCounts = generateResultCounts(number);
        StringBuilder resultString = new StringBuilder();

        resultCounts.forEach((key, value) ->
                resultString.append(key).append(": ").append(value).append(" times\n"));

        return resultString.toString();
    }

}
