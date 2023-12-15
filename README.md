# Random Number Generator

This project implements a simple random number generator based on given probabilities for each number.

## Overview

The project consists of three main classes:

1. `IRandomGenerator`: An interface defining the contract for classes that generate random numbers.
2. `RandomGen`: A class implementing the `IRandomGenerator` interface. It generates random numbers based on provided probabilities.
3. `ResultCount`: A class that counts and prints the occurrences of randomly generated numbers.
## Usage

To use the random number generator, follow these steps:

1. Create an array of numbers and an array of corresponding probabilities.
2. Instantiate a `RandomGen` object with the arrays of numbers and probabilities.
3. Instantiate a `ResultCount` object with the `RandomGen` object.
4. Call the `printResultCounts` method on the `ResultCount` object with the desired number of iterations.

Example:

```java
public class Main {
    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, 3};
        float[] probabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};

        RandomGen generator = new RandomGen(numbers, probabilities);
        ResultCount resultCount = new ResultCount(generator);
        resultCount.printResultCounts(100);
    }
}
```

## Cumulative Algorithm

The random number generator in this project utilizes a cumulative algorithm to generate numbers based on provided probabilities. Here's an explanation of how the cumulative approach works:

Explanation
The cumulative algorithm involves creating a cumulative probability distribution for each number. This distribution is obtained by summing up the probabilities for each number, resulting in a series of cumulative probabilities.

When generating a random number, a random value between 0 and 1 is generated. This value is then compared with the cumulative probabilities. The first number for which the cumulative probability exceeds the random value is selected as the result.

