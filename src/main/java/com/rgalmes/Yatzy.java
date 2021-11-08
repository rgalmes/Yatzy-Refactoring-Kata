package com.rgalmes;

import java.util.Arrays;

public class Yatzy {

    private static final int MIN_DICE_VALUE = 1;
    private static final int MAX_DICE_VALUE = 6;

    public static final int NUMBER_OF_DICES_IN_ROLL = 5;

    private static final int SMALL_STRAIGHT_SCORE = 15;
    private static final int LARGE_STRAIGHT_SCORE = 20;
    private static final int YATZY_SCORE = 50;

    public Yatzy() {
    }

    public int chance(DiceRoll dices) {
        return Arrays.stream(dices.getDices())
                     .sum();
    }

    public int ones(DiceRoll dices) {
        return sumOfDiceOfTheSameValue(1, dices);
    }

    public int twos(DiceRoll dices) {
        return sumOfDiceOfTheSameValue(2, dices);
    }

    public int threes(DiceRoll dices) {
        return sumOfDiceOfTheSameValue(3, dices);
    }

    public int fours(DiceRoll dices) {
        return sumOfDiceOfTheSameValue(4, dices);
    }

    public int fives(DiceRoll dices) {
        return sumOfDiceOfTheSameValue(5, dices);
    }

    public int sixes(DiceRoll dices) {
        return sumOfDiceOfTheSameValue(6, dices);
    }

    public int onePair(DiceRoll dices) {
        return bestValueOfDiceOfTheSameValue(2, dices) * 2;
    }

    public int threeOfAKind(DiceRoll dices) {
        return bestValueOfDiceOfTheSameValue(3, dices) * 3;
    }

    public int fourOfAKind(DiceRoll dices) {
        return bestValueOfDiceOfTheSameValue(4, dices) * 4;
    }

    public int yatzy(DiceRoll dices) {
        return bestValueOfDiceOfTheSameValue(5, dices) != 0 ?
               YATZY_SCORE : 0;
    }

    public int twoPair(DiceRoll dices) {
        int firstPair = bestValueOfDiceOfTheSameValue(2, dices);
        if (firstPair != 0) {
            int secondPair = bestValueOfDiceOfTheSameValue(2, dices.subArrayWithExcludeValue(firstPair));
            if (secondPair != 0) {
                return (firstPair + secondPair) * 2;
            }
        }
        return 0;
    }

    public int fullHouse(DiceRoll dices) {
        int threeOfKind = bestValueOfDiceOfTheSameValue(3, dices);
        if (threeOfKind != 0) {
            int pair = bestValueOfDiceOfTheSameValue(2, dices.subArrayWithExcludeValue(threeOfKind));
            if (pair != 0) {
                return threeOfKind * 3 + pair * 2;
            }
        }
        return 0;
    }

    public int smallStraight(DiceRoll dices) {
        return isStraight(new DiceGraph(dices).subGraph(0, NUMBER_OF_DICES_IN_ROLL)) ?
               SMALL_STRAIGHT_SCORE : 0;
    }

    public int largeStraight(DiceRoll dices) {
        return isStraight(new DiceGraph(dices).subGraph(1, NUMBER_OF_DICES_IN_ROLL + 1)) ?
               LARGE_STRAIGHT_SCORE : 0;
    }

    private int sumOfDiceOfTheSameValue(int value, DiceRoll dices) {
        return Arrays.stream(dices.getDices())
                     .filter(dice -> dice == value)
                     .sum();
    }

    private int bestValueOfDiceOfTheSameValue(int numberOfDices, DiceRoll dices) {
        DiceGraph sumOfDices = new DiceGraph(dices);
        for (int diceValue = MAX_DICE_VALUE; diceValue >= MIN_DICE_VALUE; diceValue--) {
            if (sumOfDices.getSumOfDices()[diceValue - 1] >= numberOfDices) {
                return (diceValue);
            }
        }
        return 0;
    }

    private boolean isStraight(DiceGraph subDiceGraph) {
        return Arrays.stream(subDiceGraph.getSumOfDices())
                     .filter(value -> value != 1)
                     .count() == 0;
    }
}
