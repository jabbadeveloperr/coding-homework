package org.com;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, 3};
        float[] probabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};

        RandomGen generator = new RandomGen(numbers, probabilities);
        ResultCount resultCount = new ResultCount(generator);
        resultCount.printResultCounts(100);
    }


}
