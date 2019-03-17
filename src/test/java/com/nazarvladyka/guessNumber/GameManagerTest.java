package com.nazarvladyka.guessNumber;

import com.nazarvladyka.guessNumber.impl.GameImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.*;

public class GameManagerTest {
    GameImpl game;

    @Before
    public void setUp() throws IOException {
        game = new GameImpl();
        GameManager.startGame();
    }

    @Test
    public void guessIsBiggerThanRange() {
        game.setGuess(158);

        Assert.assertEquals(false, game.isValidNumberRange());
    }
}