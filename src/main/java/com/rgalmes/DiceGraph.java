package com.rgalmes;

import java.util.Arrays;

public class DiceGraph {

    private static final int NUMBER_OF_DICE_VALUE = 6;

    private final int[] sumOfDices;

    public DiceGraph(DiceRoll dices) {
        this.sumOfDices = new int[NUMBER_OF_DICE_VALUE];
        for (int dice : dices.getDices()) {
            sumOfDices[dice - 1]++;
        }
    }

    private DiceGraph(int... sumOfDices) {
        this.sumOfDices = sumOfDices;
    }

    public int[] getSumOfDices() {
        return sumOfDices;
    }

    public DiceGraph subGraph(int from, int to) {
        return new DiceGraph(Arrays.copyOfRange(sumOfDices, from, to));
    }
}
