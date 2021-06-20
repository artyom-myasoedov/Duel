package myasoedov.cs.players;

import myasoedov.cs.model.Card;
import myasoedov.cs.model.MoveChooser;
import myasoedov.cs.model.Player;


import java.util.Map;

public class PlayerHuman extends Player {

    private final MoveChooser moveChooser;

    public PlayerHuman(Map<Integer, Card> cards, String name, int position, MoveChooser moveChooser) {
        super(cards, name, position);
        this.moveChooser = moveChooser;
    }

    @Override
    public void updateOpponentsDrop(Card lastDrop) {
    }

    @Override
    public int chooseCardToMove(int currentPosition) {
        return moveChooser.chooseCard(getPosition() == currentPosition);
    }
}
