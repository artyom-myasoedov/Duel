package myasoedov.cs.players;

import myasoedov.cs.UI.ConsoleUI;
import myasoedov.cs.model.Card;
import myasoedov.cs.model.Game;
import myasoedov.cs.model.Player;
import myasoedov.cs.moveChoosers.ConsoleMoveChooser;
import myasoedov.cs.strategies.MyStrategy;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class MyTest {

    @Test
    public void testPlug() {
        Player player = new PlayerHuman(new HashMap<>(),"lkl", 0, new ConsoleMoveChooser());
        player.updateOpponentsDrop(new Card(9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCard() {
        Card card1 = Card.duelCardFrom(10);
        System.out.println(card1);
        Card.duelCardFrom(20);
    }
}