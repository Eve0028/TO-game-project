package pk.rpgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pk.rpgame.controller.GameEngine;

@SpringBootApplication
public class RpgameApplication {
    public static void main(String[] args) throws Exception {
        GameEngine engine = new GameEngine();
        engine.startGame();
    }
}
