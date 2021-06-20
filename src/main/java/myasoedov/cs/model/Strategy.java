package myasoedov.cs.model;

import java.util.List;
import java.util.Map;

public interface Strategy {

    int chooseCard(Map<Integer, Card> ownCards, List<Card> opponentsDrop, boolean attackMove);
}
