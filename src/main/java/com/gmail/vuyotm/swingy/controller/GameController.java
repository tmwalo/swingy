package com.gmail.vuyotm.swingy.controller;

import com.gmail.vuyotm.swingy.model.Map;
import com.gmail.vuyotm.swingy.model.artifacts.Armor;
import com.gmail.vuyotm.swingy.model.artifacts.Helm;
import com.gmail.vuyotm.swingy.model.artifacts.Weapon;
import com.gmail.vuyotm.swingy.model.characters.Regular;
import com.gmail.vuyotm.swingy.model.characters.Shinheuh;
import com.gmail.vuyotm.swingy.util.RegularFactory;
import com.gmail.vuyotm.swingy.view.*;

import java.io.BufferedReader;
import java.io.IOException;

public class GameController {

    public void startGame(BufferedReader bufferedReader) throws IOException {
        StartGameView   startGameView;

        startGameView = new StartGameView();
        startGameView.displayStartScreen(bufferedReader);
        if (startGameView.getInputData().equals(StartGameView.LOAD_REGULAR))
            loadRegular();
        else if (startGameView.getInputData().equals(StartGameView.CREATE_NEW_REGULAR))
            createRegular(bufferedReader);
    }

    public void loadRegular() {

    }

    public void createRegular(BufferedReader bufferedReader) throws IOException {
        CreateNewRegularView    createNewRegularView;
        Regular                 regular;
        Map                     map;

        createNewRegularView = new CreateNewRegularView();
        createNewRegularView.displayRegularCreation(bufferedReader);
        regular = RegularFactory.newRegular(createNewRegularView.getRegularName(), createNewRegularView.getRegularPosition());
        map = new Map(regular);
        moveRegular(regular, map, bufferedReader);
    }

    public void moveRegular(Regular regular, Map map, BufferedReader bufferedReader) throws IOException {
        MoveRegularView         moveRegularView;
        RegularManager          regularManager;
        MapManager              mapManager;
        int                     originalX;
        int                     originalY;
        Shinheuh                encounteredShinheuh;
        ShinheuhManager         shinheuhManager;
        StatsAndArtifactsView   statsAndArtifactsView;

        moveRegularView = new MoveRegularView();
        regularManager = new RegularManager(regular);
        mapManager = new MapManager(map);
        statsAndArtifactsView = new StatsAndArtifactsView();
        while (true) {
            originalX = regular.getX();
            originalY = regular.getY();
            moveRegularView.displayMoveRegular(bufferedReader);
            if (moveRegularView.getMoveOption().equals("1"))
                regularManager.moveNorth();
            else if (moveRegularView.getMoveOption().equals("2"))
                regularManager.moveSouth();
            else if (moveRegularView.getMoveOption().equals("3"))
                regularManager.moveEast();
            else if (moveRegularView.getMoveOption().equals("4"))
                regularManager.moveWest();
            else if (moveRegularView.getMoveOption().equals("s")) {
                statsAndArtifactsView.displayStatsAndEquipment(regular);
                continue ;
            }
            if (mapManager.hasCrossedMapBorder(regular)) {
                map = new Map(regular);
                mapManager = new MapManager(map);
                moveRegularView.writeNewAreaMsg();
                continue ;
            }
            else if (mapManager.hasEncounteredShinheuh(regular)) {
                moveRegularView.displayEncounterOptions(bufferedReader);
                if (moveRegularView.getEncounterOption().equals("2") && regularManager.run()) {
                    regular.setX(originalX);
                    regular.setY(originalY);
                    moveRegularView.writeRunAwayMsg();
                    continue ;
                }
                encounteredShinheuh = (Shinheuh) (map.getGrid())[regular.getY()][regular.getX()];
                shinheuhManager = new ShinheuhManager(encounteredShinheuh);
                fight(regular, regularManager, encounteredShinheuh, shinheuhManager, bufferedReader);
            }
            (map.getGrid())[originalY][originalX] = null;
            (map.getGrid())[regular.getY()][regular.getX()] = regular;
        }
    }

    public void fight(Regular regular, RegularManager regularManager, Shinheuh shinheuh, ShinheuhManager shinheuhManager, BufferedReader bufferedReader) throws IOException {
        FightView       fightView;
        FightManager    fightManager;
        boolean         fightEnded;

        fightEnded = false;
        fightView = new FightView();
        fightManager = new FightManager(regular, regularManager, shinheuh, shinheuhManager);
        while (!fightEnded) {
            fightView.displayFightOptions(bufferedReader);
            if (fightView.getInputData().equals("1")) {
                fightManager.launchPhysicalAttack();
                fightView.writeToScreen(fightManager.getAttackRecord());
            }
            else if (fightView.getInputData().equals("2")) {
                fightManager.launchShinsooAttack();
                fightView.writeToScreen(fightManager.getAttackRecord());
            }
            if (regular.hasDied()) {
                fightView.writeRegularDeath();
                System.exit(0);
            }
            if (shinheuh.hasDied()) {
                fightView.writeShinheuhDeath();
                regular.setExperience(regular.getExperience() + shinheuh.getExpGiven());
                if (regularManager.hasLeveledUp()) {
                    regularManager.levelUp();
                    fightView.writeLeveledUp();
                }
                if (shinheuhManager.hasDroppedItem()) {
                    fightView.displayPickUpItemOptions(shinheuh, bufferedReader);
                    if (fightView.getInputData().equals("1")) {
                        if (shinheuh.getItemDrop().getType().equals("needle"))
                            regular.setWeapon((Weapon) shinheuh.getItemDrop());
                        else if (shinheuh.getItemDrop().getType().equals("helm"))
                            regular.setHelm((Helm) shinheuh.getItemDrop());
                        else if (shinheuh.getItemDrop().getType().equals("basic armor"))
                            regular.setArmor((Armor) shinheuh.getItemDrop());
                        else if (shinheuh.getItemDrop().getType().equals("ignition weapon"))
                            regular.setWeapon((Weapon) shinheuh.getItemDrop());
                    }
                }
                fightEnded = true;
            }
        }
    }

    public void runGame(BufferedReader bufferedReader) throws IOException {
        startGame(bufferedReader);
    }

}
