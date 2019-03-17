package com.nazarvladyka.guessNumber;

import org.springframework.context.annotation.Bean;

import java.io.IOException;

public interface Game {

    int getNumber();

    void setNumber(int number);

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    void setSmallest(int smallest);

    int getBiggest();

    void setBiggest(int biggest);

    int getRemainingGuesses();

    void reset() throws IOException;

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();

}
