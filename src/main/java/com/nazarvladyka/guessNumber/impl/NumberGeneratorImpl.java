package com.nazarvladyka.guessNumber.impl;

import com.nazarvladyka.guessNumber.NumberGenerator;
import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {
    private final Random random = new Random();

    @Value("${game.maxNumber}")
    private int maxNumber;

    @Override
    public int getNumber() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

}
