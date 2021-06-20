package myasoedov.cs.UI;

import myasoedov.cs.model.Card;
import myasoedov.cs.model.Player;

import java.util.List;

public interface UI {

    void showRoles(List<Player> players, int currentPosition);

    void showIntermediateResults(List<Player> players);

    void showMessage(String message);

    void showSelection(Player player);

    void showMove(Player player1, Player player2, Card card1, Card card2);

    void showResults(List<Player> players);
}
