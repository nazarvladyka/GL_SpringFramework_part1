package com.nazarvladyka.guessNumber.util;

import com.nazarvladyka.guessNumber.Game;
import com.nazarvladyka.guessNumber.NumberGenerator;
import com.nazarvladyka.guessNumber.impl.GameImpl;
import com.nazarvladyka.guessNumber.impl.NumberGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:settings.properties"})
public class JavaConfig {

    @Bean
    public NumberGenerator numberGenerator(){
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game(){
        return new GameImpl();
    }
}
