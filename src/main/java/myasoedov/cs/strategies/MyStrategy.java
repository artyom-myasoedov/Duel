package myasoedov.cs.strategies;

import myasoedov.cs.model.Card;
import myasoedov.cs.model.Strategy;

import java.util.List;
import java.util.Map;

public class MyStrategy implements Strategy {
    private int  counter= 0;
    //TODO optimal strategy
    @Override
    public int chooseCard(Map<Integer, Card> ownCards, List<Card> opponentsDrop, boolean attackMove) {
//        if (opponentsDrop.size() == 0) {
//            return ownCards.size() / 2;
//        }
//        if (attackMove)
//            return chooseAttackCard(ownCards, opponentsDrop);
//        else
//            return chooseDefensiveCard(ownCards, opponentsDrop);
        return counter++;
    }

    private int chooseAttackCard(Map<Integer, Card> ownCards, List<Card> opponentsDrop) {

        return 0;
    }

    private int chooseDefensiveCard(Map<Integer, Card> ownCards, List<Card> opponentsDrop) {

        return 0;
    }
}
