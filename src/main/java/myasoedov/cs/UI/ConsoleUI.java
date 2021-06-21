package myasoedov.cs.UI;

import myasoedov.cs.model.Card;
import myasoedov.cs.model.Player;

import java.util.List;

public class ConsoleUI implements UI {

    @Override
    public void showRoles(List<Player> players, int currentPosition) {
        System.out.println("-----------------------------------------");
        for (Player player : players) {
            System.out.print(player.getName());
            if (player.getPosition() == currentPosition)
                System.out.println(" - attacks");
            else System.out.println(" - defends");
        }
        System.out.println("-----------------------------------------");
    }

    @Override
    public void showIntermediateResults(List<Player> players) {

        System.out.println("-*-*-*-*-  Intermediate scores  -*-*-*-*-");
        players.forEach(player -> System.out.println(player.getName() + " - " + player.getPenaltyPoints()));
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    }

    @Override
    public void showMessage(String message) {
        System.out.println("!!! Attention !!!");
        System.out.println(message);
    }

    @Override
    public void showSelection(Player player) {
        System.out.println(player.getCards().keySet());
        System.out.println("Choose card: ");
    }

    @Override
    public void showMove(Player player1, Player player2, Card card1, Card card2) {
        System.out.println("-----------------------------------------");
        System.out.println("Attacking player: " + player1.getName() + " put: " + card1.getValue());
        System.out.println("Defending player: " + player2.getName() + " put: " + card2.getValue());
        System.out.println(player2.getName() + " was awarded " + card2.compareForDefense(card1) + " penalty points");
        System.out.println("-----------------------------------------");
    }


    @Override
    public void showResults(List<Player> players) {
        Player winner = players.get(0);
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println(winner.getName() + ": " + winner.getPenaltyPoints() + " - winner!");
        players.stream().skip(1).forEach(player -> {
            System.out.print(player.getName() + ": " + player.getPenaltyPoints());
            if (player.getPenaltyPoints() == winner.getPenaltyPoints()) {
                System.out.println(" - winner!");
            } else {
                System.out.println();
            }
        });
    }
}
