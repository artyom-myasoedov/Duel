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

    public void play() {
        int notCurrentPosition;
        Card attackCard;
        Card defensiveCard;
        int penaltyScore;
        Player attackPlayer;
        Player defensivePlayer;

        do {
            if (currentPosition == players.size())
                currentPosition = 0;
            notCurrentPosition = (currentPosition + 1) % 2;
            attackPlayer = players.get(currentPosition);
            defensivePlayer = players.get(notCurrentPosition);
            userInterface.showRoles(players, currentPosition);
            userInterface.showSelection(players.get(userPosition));

            attackCard = makeMove(attackPlayer, currentPosition);
            defensiveCard = makeMove(defensivePlayer, currentPosition);

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

    private Card makeMove(Player player, int position) {
        Card card;
        try {
            card = player.makeMove(position);
        } catch (RuntimeException e) {
            userInterface.showMessage(e.getMessage());
            return makeMove(player, position);
        }
        return card;
    }

    private List<Player> sortByMinPoints() {
        return players.stream().sorted(Comparator.comparingInt(Player::getPenaltyPoints)).collect(Collectors.toList());
    }
}
