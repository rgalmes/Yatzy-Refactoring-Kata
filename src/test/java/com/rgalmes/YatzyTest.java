package com.rgalmes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    private static final Yatzy yatzy = new Yatzy();

    @Test
    @DisplayName("chance should sum all dices")
    public void chance() {
        assertEquals(5, yatzy.chance(new DiceRoll(1, 1, 1, 1, 1)));
        assertEquals(15, yatzy.chance(new DiceRoll(2, 3, 4, 5, 1)));
        assertEquals(16, yatzy.chance(new DiceRoll(3, 3, 4, 5, 1)));
        assertEquals(14, yatzy.chance(new DiceRoll(1, 1, 3, 3, 6)));
        assertEquals(21, yatzy.chance(new DiceRoll(4, 5, 5, 6, 1)));
    }

    @Test
    @DisplayName("ones should sum all one dices")
    public void ones() {
        assertEquals(1, yatzy.ones(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(2, yatzy.ones(new DiceRoll(1, 2, 1, 4, 5)));
        assertEquals(4, yatzy.ones(new DiceRoll(1, 2, 1, 1, 1)));

        assertEquals(0, yatzy.ones(new DiceRoll(6, 2, 2, 4, 5)));
    }

    @Test
    @DisplayName("twos should sum all two dices")
    public void twos() {
        assertEquals(4, yatzy.twos(new DiceRoll(1, 2, 3, 2, 6)));
        assertEquals(10, yatzy.twos(new DiceRoll(2, 2, 2, 2, 2)));

        assertEquals(0, yatzy.twos(new DiceRoll(1, 5, 3, 4, 6)));
    }

    @Test
    @DisplayName("threes should sum all three dices")
    public void threes() {
        assertEquals(6, yatzy.threes(new DiceRoll(1, 2, 3, 2, 3)));
        assertEquals(12, yatzy.threes(new DiceRoll(2, 3, 3, 3, 3)));

        assertEquals(0, yatzy.threes(new DiceRoll(2, 5, 5, 5, 5)));
    }

    @Test
    @DisplayName("fours should sum all four dices")
    public void fours() {
        assertEquals(12, yatzy.fours(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(4, yatzy.fours(new DiceRoll(4, 5, 5, 5, 5)));

        assertEquals(0, yatzy.fours(new DiceRoll(1, 2, 3, 6, 5)));
    }

    @Test
    @DisplayName("fives should sum all five dices")
    public void fives() {
        assertEquals(10, yatzy.fives(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(20, yatzy.fives(new DiceRoll(4, 5, 5, 5, 5)));

        assertEquals(0, yatzy.fives(new DiceRoll(2, 2, 2, 2, 2)));
    }

    @Test
    @DisplayName("sixes should sum all six dices")
    public void sixes() {
        assertEquals(6, yatzy.sixes(new DiceRoll(4, 4, 6, 5, 5)));
        assertEquals(18, yatzy.sixes(new DiceRoll(6, 5, 6, 6, 5)));

        assertEquals(0, yatzy.sixes(new DiceRoll(4, 4, 4, 5, 5)));
    }

    @Test
    @DisplayName("onePair should find one pair of dice and calculate score")
    public void onePair() {
        assertEquals(6, yatzy.onePair(new DiceRoll(3, 4, 3, 5, 6)));
        assertEquals(10, yatzy.onePair(new DiceRoll(5, 3, 3, 3, 5)));
        assertEquals(12, yatzy.onePair(new DiceRoll(5, 3, 6, 6, 5)));

        assertEquals(0, yatzy.onePair(new DiceRoll(1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("threeOfAKind should find three of kind of dice and calculate score")
    public void threeOfAKind() {
        assertEquals(9, yatzy.threeOfAKind(new DiceRoll(3, 3, 3, 4, 5)));
        assertEquals(15, yatzy.threeOfAKind(new DiceRoll(5, 3, 5, 4, 5)));
        assertEquals(12, yatzy.threeOfAKind(new DiceRoll(4, 4, 4, 4, 5)));

        assertEquals(0, yatzy.threeOfAKind(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(0, yatzy.threeOfAKind(new DiceRoll(2, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("fourOfAKind should find four of kind of dice and calculate score")
    public void fourOfAKind() {
        assertEquals(12, yatzy.fourOfAKind(new DiceRoll(3, 3, 3, 3, 5)));
        assertEquals(20, yatzy.fourOfAKind(new DiceRoll(5, 5, 5, 4, 5)));
        assertEquals(16, yatzy.fourOfAKind(new DiceRoll(4, 4, 4, 4, 4)));

        assertEquals(0, yatzy.fourOfAKind(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(0, yatzy.fourOfAKind(new DiceRoll(4, 4, 3, 2, 1)));
        assertEquals(0, yatzy.fourOfAKind(new DiceRoll(4, 4, 4, 2, 2)));
    }

    @Test
    @DisplayName("yatzy should find that all the dice are identical and score 50")
    public void yatzy() {
        assertEquals(50, yatzy.yatzy(new DiceRoll(4, 4, 4, 4, 4)));
        assertEquals(50, yatzy.yatzy(new DiceRoll(6, 6, 6, 6, 6)));

        assertEquals(0, yatzy.yatzy(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(0, yatzy.yatzy(new DiceRoll(6, 6, 3, 3, 3)));
        assertEquals(0, yatzy.yatzy(new DiceRoll(6, 6, 6, 3, 3)));
        assertEquals(0, yatzy.yatzy(new DiceRoll(6, 6, 6, 6, 3)));
    }

    @Test
    @DisplayName("twoPair should find two pair of dice and calculate score")
    public void twoPair() {
        assertEquals(14, yatzy.twoPair(new DiceRoll(3, 3, 4, 5, 4)));
        assertEquals(16, yatzy.twoPair(new DiceRoll(3, 3, 5, 5, 5)));
        assertEquals(8, yatzy.twoPair(new DiceRoll(1, 1, 2, 3, 3)));

        assertEquals(0, yatzy.twoPair(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(0, yatzy.twoPair(new DiceRoll(1, 1, 2, 3, 4)));
    }

    @Test
    @DisplayName("fullHouse should find one pair, three of kind of dice and calculate score")
    public void fullHouse() {
        assertEquals(18, yatzy.fullHouse(new DiceRoll(6, 2, 2, 2, 6)));
        assertEquals(19, yatzy.fullHouse(new DiceRoll(3, 5, 3, 5, 3)));

        assertEquals(0, yatzy.fullHouse(new DiceRoll(1, 2, 2, 2, 2)));
        assertEquals(0, yatzy.fullHouse(new DiceRoll(6, 1, 2, 2, 6)));
        assertEquals(0, yatzy.fullHouse(new DiceRoll(6, 2, 3, 4, 6)));
        assertEquals(0, yatzy.fullHouse(new DiceRoll(2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("smallStraight should find this dices (1,2,3,4,5) and score 15")
    public void smallStraight() {
        assertEquals(15, yatzy.smallStraight(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(15, yatzy.smallStraight(new DiceRoll(2, 3, 4, 5, 1)));

        assertEquals(0, yatzy.smallStraight(new DiceRoll(2, 3, 4, 5, 6)));
        assertEquals(0, yatzy.smallStraight(new DiceRoll(1, 2, 2, 4, 4)));
    }

    @Test
    @DisplayName("largeStraight should find this dices (2,3,4,5,6) and score 20")
    public void largeStraight() {
        assertEquals(20, yatzy.largeStraight(new DiceRoll(6, 2, 3, 4, 5)));
        assertEquals(20, yatzy.largeStraight(new DiceRoll(2, 3, 4, 5, 6)));

        assertEquals(0, yatzy.largeStraight(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(0, yatzy.largeStraight(new DiceRoll(1, 2, 2, 4, 4)));
    }
}
