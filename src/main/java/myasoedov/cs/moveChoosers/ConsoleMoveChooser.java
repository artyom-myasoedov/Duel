package myasoedov.cs.moveChoosers;

import myasoedov.cs.model.MoveChooser;

import java.util.Scanner;

public class ConsoleMoveChooser implements MoveChooser {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int chooseCard(boolean attackMove) {
        return scanner.nextInt();
    }
}
