package myasoedov.cs.model;

import myasoedov.cs.UI.UI;

import java.util.*;
import java.util.stream.Collectors;

public class Game {

    private final List<Player> players;
    private final UI userInterface;
    private int currentPosition;
    private final int userPosition;

    public Game(List<Player> players, UI userInterface, int userPosition) {
        this.players = players;
        this.userInterface = userInterface;
        currentPosition = (int) (Math.random() * players.size());
        this.userPosition = userPosition;
    }

    public int getUserPosition() {
        return userPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public UI getUserInterface() {
        return userInterface;
    }
    //TODO try-catch
    public void play() {
        int notCurrentPlayer;
        Card attackCard;
        Card defensiveCard;
        int penaltyScore;
        Player attackPlayer;
        Player defensivePlayer;

        do {
            if (currentPosition == players.size())
                currentPosition = 0;
            notCurrentPlayer = (currentPosition + 1) % 2;
            attackPlayer = players.get(currentPosition);
            defensivePlayer = players.get(notCurrentPlayer);
            userInterface.showRoles(players, currentPosition);
            userInterface.showSelection(players.get(userPosition));

            do {
                try {
                    attackCard = attackPlayer.makeMove(currentPosition);
                } catch (RuntimeException e) {
                    userInterface.showMessage(e.getMessage());
                    attackCard = null;
                }
            } while (attackCard == null);

            do {
                try {
                    attackCard = attackPlayer.makeMove(currentPosition);
                } catch (RuntimeException e) {
                    userInterface.showMessage(e.getMessage());
                    attackCard = null;
                }
            } while (attackCard == null);
            defensiveCard = defensivePlayer.makeMove(notCurrentPlayer);
            penaltyScore = defensiveCard.compareForDefense(attackCard);
            defensivePlayer.addPenaltyPoints(penaltyScore);
            defensivePlayer.updateOpponentsDrop(attackCard);
            attackPlayer.updateOpponentsDrop(defensiveCard);

            userInterface.showMove(attackPlayer, defensivePlayer, attackCard, defensiveCard);
            userInterface.showIntermediateResults(players);

            currentPosition++;
        } while (!checkToEnd());
        userInterface.showResults(sortByMinPoints());
    }

    private boolean checkToEnd() {
        for (Player player : players) {
            if (player.getCards().size() != 0)
                return false;
        }
        return true;
    }

    private List<Player> sortByMinPoints() {
        return players.stream().sorted(Comparator.comparingInt(Player::getPenaltyPoints)).collect(Collectors.toList());
    }
}
