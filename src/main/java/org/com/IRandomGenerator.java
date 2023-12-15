    package org.com;

    /**
     * The {@code IRandomGenerator} interface defines the contract for classes that generate random numbers.
     * Implementing classes must provide a method to generate the next random number.
     */
    interface IRandomGenerator {

        /**
         * Generates the next random number.
         *
         * @return The generated random number.
         */
        int nextNum();
    }
