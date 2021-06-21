package myasoedov.cs.strategies;

import myasoedov.cs.model.Card;
import myasoedov.cs.model.Strategy;

import java.util.*;

public class MyStrategy implements Strategy {
    private final double MEDIAN_DECK_VALUE = 5.5;
    private final int SCORE_SUM = 66;

    @Override
    public int chooseCard(Map<Integer, Card> ownCards, List<Card> opponentsDrop, boolean attackMove) {
        if (opponentsDrop.size() == 0) {
            if (attackMove) {
                return 0;
            } else {
                return 5;
            }
        }
        if (attackMove)
            return chooseAttackCard(ownCards, opponentsDrop);
        else
            return chooseDefensiveCard(ownCards, opponentsDrop);
    }

    private int chooseAttackCard(Map<Integer, Card> ownCards, List<Card> opponentsDrop) {
        if (getMedian(opponentsDrop) >= MEDIAN_DECK_VALUE) {
            return Collections.max(ownCards.keySet());
        } else {
            return Collections.min(ownCards.keySet());
        }
    }

    private int chooseDefensiveCard(Map<Integer, Card> ownCards, List<Card> opponentsDrop) {
        long borders = (getMedian(opponentsDrop) > MEDIAN_DECK_VALUE ? Math.round(ownCards.size() / (4.0 / 3)) : Math.round(ownCards.size() /4.0));
        if (borders == 0)
            borders++;
        var res = ownCards.keySet().stream().sorted(Integer::compareTo).limit(borders).max(Integer::compareTo);
        try {
            if (res.isPresent()) {
                return res.get();
            } else
                throw new IllegalStateException();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return chooseDefensiveCard(ownCards, opponentsDrop);
        }

    }

    private double getMedian(Collection<Card> opponentsDrop) {
        var res = opponentsDrop.stream().mapToInt(Card::getValue).average();
        if (res.isPresent()) {
            return res.getAsDouble();
        }
        throw new IllegalStateException();
    }
}
