package com.rgalmes;

import java.util.Arrays;

public class DiceRoll {

    private final int[] dices;

    public DiceRoll(int... dices) {
        this.dices = dices;
    }

    public int[] getDices() {
        return dices;
    }

    public DiceRoll subArrayWithExcludeValue(int excludeValue) {
        return new DiceRoll(Arrays.stream(dices)
                                  .filter(dice -> dice != excludeValue)
                                  .toArray());
    }
}
