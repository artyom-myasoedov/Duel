package myasoedov.cs.players;

import myasoedov.cs.model.Card;
import myasoedov.cs.model.Player;
import myasoedov.cs.model.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerAI extends Player {

    private final List<Card> opponentsDrop = new ArrayList<>();
    private final Strategy strategy;

    public PlayerAI(Map<Integer, Card> cards, int position, Strategy strategy) {
        super(cards, "AI", position);
        this.strategy = strategy;
    }

    @Override
    public void updateOpponentsDrop(Card lastDrop) {
        opponentsDrop.add(lastDrop);
    }

    @Override
    public int chooseCardToMove(int currentPosition) {
        return strategy.chooseCard(getCards(), opponentsDrop, currentPosition == getPosition());
    }
}
