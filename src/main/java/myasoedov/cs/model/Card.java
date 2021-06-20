package myasoedov.cs.model;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private final int value;

    public static Card duelCardFrom(int value) {
        if (value < 0 || value > 11)
            throw new IllegalArgumentException("Invalid value!");

        return new Card(value);
    }

    public static Map<Integer, Card> deckOf(final int minCardValue, final int maxCardValue) {
        Map<Integer, Card> deck = new HashMap<>();
        for (int i = minCardValue; i < maxCardValue; i++) {
            deck.put(i, Card.duelCardFrom(i));
        }
        return deck;
    }

    public Card(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int compareForDefense(Card attackCard) {
        if (attackCard == null) {
            throw new NullPointerException("Other card is null!");
        }
        return -Math.min(value - attackCard.getValue(), 0);
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                '}';
    }
}
