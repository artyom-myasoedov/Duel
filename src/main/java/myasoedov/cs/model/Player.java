package myasoedov.cs.model;

import java.util.Map;

public abstract class Player {
    private final Map<Integer, Card> cards;
    private int penaltyPoints = 0;
    private final String name;
    private final int position;

    public Player(Map<Integer, Card> cards, String name, int position) {
        this.cards = cards;
        this.name = name;
        this.position = position;
    }

    public Map<Integer, Card> getCards() {
        return cards;
    }

    public int getPosition() {
        return position;
    }

    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    public String getName() {
        return name;
    }

    public void addPenaltyPoints(int penaltyPoints) {
        this.penaltyPoints += penaltyPoints;
    }

    public Card makeMove(int currentPosition) {
        int cardValue = chooseCardToMove(currentPosition);
        Card temp = getCards().get(cardValue);
        getCards().remove(cardValue);
        return temp;
    }

    public abstract void updateOpponentsDrop(Card lastDrop);

    public abstract int chooseCardToMove(int currentPosition);
}
