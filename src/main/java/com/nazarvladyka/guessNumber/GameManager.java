package com.nazarvladyka.guessNumber;

import com.nazarvladyka.guessNumber.util.JavaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameManager {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void startGame() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        log.info("Guess Number");

        // create context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Game game = context.getBean(Game.class);

        while(true) {
            System.out.print("Enter your number: ");
            int guess = Integer.parseInt(reader.readLine());
            game.setGuess(guess);
            game.check();
            if(game.isValidNumberRange()) {
//                log.info("My guess = {}", guess);

                if(guess < game.getSmallest()) {
                    game.setSmallest(guess);
                } else if (guess > game.getBiggest()) {
                    game.setBiggest(guess);
                }

                if(game.isGameLost()) {
                    System.out.println("Sorry you lose");
                    break;
                } else if(game.isGameWon()) {
                    System.out.println("Congrats, tou win!");
                    break;
                }

                if(game.getNumber() > game.getGuess()) {
                    System.out.println("Bigger!");
                } else {
                    System.out.println("Smaller!");
                }
                System.out.println("Number is between : " + game.getSmallest() + " and " + game.getBiggest());
                System.out.println("You have " + game.getRemainingGuesses() + " left") ;
            } else {
                System.out.println("Number is not valid!");
            }
        }
        context.close();
    }
}
