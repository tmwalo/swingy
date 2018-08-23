package com.gmail.vuyotm.swingy.view;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;

@Getter
@Setter

public class MoveRegularView extends BaseConsoleView {

    private String              moveOption;
    private String              encounterOption;
    public static final String  DIRECTIONS = "Press 1 to go North." + System.lineSeparator()
                                            + "Press 2 to go South." + System.lineSeparator()
                                            + "Press 3 to go East." + System.lineSeparator()
                                            + "Press 4 to go West." + System.lineSeparator();

    public static final String  ENCOUTER_SHINHEUH = "You have encountered a Shinheuh." + System.lineSeparator()
                                                    + "Press 1 to fight." + System.lineSeparator()
                                                    + "Press 2 to run away." + System.lineSeparator();

    public void writeMoveOptions() {
        writeToScreen(System.lineSeparator() + DIRECTIONS);
    }

    public void writeEncounterOptions() {
        writeToScreen(System.lineSeparator() + ENCOUTER_SHINHEUH);
    }

    public void writeRunAwayMsg () {
        writeToScreen(System.lineSeparator() + "You managed to run away." + System.lineSeparator());
    }

    public void writeNewAreaMsg() {
        writeToScreen(System.lineSeparator() + "You have entered a new area." + System.lineSeparator());
    }

    public void displayMoveRegular(BufferedReader bufferedReader) throws IOException {
        boolean selectMove;

        selectMove = false;
        while (!selectMove) {
            writeMoveOptions();
            getUserInput(bufferedReader);
            setMoveOption(getInputData());
            if (getMoveOption().equals("1"))
                selectMove = true;
            else if (getMoveOption().equals("2"))
                selectMove = true;
            else if (getMoveOption().equals("3"))
                selectMove = true;
            else if (getMoveOption().equals("4"))
                selectMove = true;
            else if (getMoveOption().equals("s"))
                selectMove = true;
            else if (getMoveOption().equals("q"))
                System.exit(0);
            else
                writeToScreen(System.lineSeparator() + "Invalid input." + System.lineSeparator());
        }
    }

    public void displayEncounterOptions(BufferedReader bufferedReader) throws IOException {
        boolean selectEncounterOption;

        selectEncounterOption = false;
        while (!selectEncounterOption) {
            writeEncounterOptions();
            getUserInput(bufferedReader);
            setEncounterOption(getInputData());
            if (getEncounterOption().equals("1"))
                selectEncounterOption = true;
            else if (getEncounterOption().equals("2"))
                selectEncounterOption = true;
            else if (getEncounterOption().equals("q"))
                System.exit(0);
            else
                writeToScreen(System.lineSeparator() + "Invalid input." + System.lineSeparator());
        }
    }

}
