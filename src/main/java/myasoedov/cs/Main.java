package myasoedov.cs;

import myasoedov.cs.UI.ConsoleUI;
import myasoedov.cs.model.Card;
import myasoedov.cs.model.Game;
import myasoedov.cs.moveChoosers.ConsoleMoveChooser;
import myasoedov.cs.players.PlayerAI;
import myasoedov.cs.players.PlayerHuman;
import myasoedov.cs.strategies.MyStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Game game = new Game(List.of(new PlayerHuman(Card.deckOf(0, 12), "Artyom", 0, new ConsoleMoveChooser()),
                new PlayerAI(Card.deckOf(0, 12), 1, new MyStrategy())), new ConsoleUI(), 0);
        game.play();
    }
}
