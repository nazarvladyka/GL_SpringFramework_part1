package com.nazarvladyka.guessNumber.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameImplTest {
    GameImpl game;

    @Before
    public void setUp() {
        game = new GameImpl();
    }

    @Test
    public void when_guessIsSmallerThanZero_then_returnFalse() {
        game.setGuess(-5);
        game.check();

        Assert.assertEquals(false, game.isValidNumberRange());
    }

    @Test
    public void isGameWon() {
        game.setGuess(5);
        game.setNumber(5);

        Assert.assertEquals(true, game.isGameWon());
    }

    @Test
    public void isGameLost() {
        for(int i = 0; i < 11; i++) {
            game.setGuess(8);
            game.setNumber(12);
            game.check();
        }

        Assert.assertEquals(true, game.isGameLost());
    }
}