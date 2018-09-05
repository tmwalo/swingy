package com.gmail.vuyotm.swingy.controller;

import com.gmail.vuyotm.swingy.model.Map;
import com.gmail.vuyotm.swingy.model.RegularContext;
import com.gmail.vuyotm.swingy.model.characters.Regular;
import com.gmail.vuyotm.swingy.model.characters.Shinheuh;
import com.gmail.vuyotm.swingy.storage.Database;
import com.gmail.vuyotm.swingy.util.RegularFactory;
import com.gmail.vuyotm.swingy.view.*;

import javax.validation.constraints.NotNull;
import java.awt.event.*;
import java.util.ArrayList;

public class GameGuiController {

    class StartGameEventHandler implements ActionListener {

        @NotNull
        private StartGameGuiView startGameGuiView;

        public StartGameEventHandler(StartGameGuiView startGameGuiView) {
            this.startGameGuiView = startGameGuiView;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startGameGuiView.getCreateRegularBtn()) {
                startGameGuiView.dispose();
                createRegular();
            }
            else if (e.getSource() == startGameGuiView.getLoadRegularBtn()) {
                startGameGuiView.dispose();
                loadRegular();
            }
        }

    }

    class CreateRegularEventHandler implements ActionListener {

        @NotNull
        private CreateNewRegularGuiView createNewRegularGuiView;

        public CreateRegularEventHandler(CreateNewRegularGuiView createNewRegularGuiView) {
            this.createNewRegularGuiView = createNewRegularGuiView;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String          regularName;
            String          regularPosition;
            RegularContext  regularContext;
            Regular         regular;
            Map             map;

            regularName = createNewRegularGuiView.getRegularName();
            regularPosition = createNewRegularGuiView.getRegularPosition();
            regularContext = new RegularContext(Database.CONNECTION_STRING);
            if (regularName.equals("")) {
                createNewRegularGuiView.displayErrorMsg("Please enter your name.");
                return ;
            }
            if (regularPosition.equals("")) {
                createNewRegularGuiView.displayErrorMsg("Please select a regular position.");
                return ;
            }
            regular = RegularFactory.newRegular(regularName, regularPosition);
            regularContext.openConnection();
            regularContext.postRegular(regular);
            regularContext.close();
            map = new Map(regular);
            createNewRegularGuiView.dispose();
            moveRegular(regular, map);
        }

    }

    class LoadRegularEventHandler implements ActionListener {

        @NotNull
        private LoadRegularGuiView  loadRegularGuiView;

        public LoadRegularEventHandler(LoadRegularGuiView loadRegularGuiView) {
            this.loadRegularGuiView = loadRegularGuiView;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int             regularId;
            RegularContext  regularContext;
            Regular         regular;
            Map             map;

            regularId = Integer.parseInt(e.getActionCommand());
            regularContext = new RegularContext(Database.CONNECTION_STRING);
            regularContext.openConnection();
            regular = regularContext.getRegular(regularId);
            regularContext.close();
            map = new Map(regular);
            loadRegularGuiView.dispose();
            moveRegular(regular, map);
        }

    }

    class MoveRegularEventHandler implements ActionListener, WindowListener {

        @NotNull
        private MoveRegularGuiView  moveRegularGuiView;
        @NotNull
        private Regular             regular;
        @NotNull
        private Map                 map;
        private RegularManager      regularManager;
        private MapManager          mapManager;

        public MoveRegularEventHandler(MoveRegularGuiView moveRegularGuiView) {
            this.moveRegularGuiView = moveRegularGuiView;
        }

        public MoveRegularEventHandler(MoveRegularGuiView moveRegularGuiView, Regular regular, Map map) {
            this.moveRegularGuiView = moveRegularGuiView;
            this.regular = regular;
            this.map = map;
            regularManager = new RegularManager(regular);
            mapManager = new MapManager(map);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int                 originalX;
            int                 originalY;
            Shinheuh            encounteredShinheuh;
            ShinheuhManager     shinheuhManager;

            originalX = regular.getX();
            originalY = regular.getY();
            if (e.getSource() == moveRegularGuiView.getNorthBtn())
                regularManager.moveNorth();
            else if (e.getSource() == moveRegularGuiView.getSouthBtn())
                regularManager.moveSouth();
            else if (e.getSource() == moveRegularGuiView.getEastBtn())
                regularManager.moveEast();
            else if (e.getSource() == moveRegularGuiView.getWestBtn())
                regularManager.moveWest();
            if (mapManager.hasCrossedMapBorder(regular)) {
                map = new Map(regular);
                mapManager = new MapManager(map);
                moveRegularGuiView.setFeedbackTxt("You have entered a new area.");
                return ;
            }
            else if (mapManager.hasEncounteredShinheuh(regular)) {
                moveRegularGuiView.setVisible(false);
                encounteredShinheuh = (Shinheuh) (map.getGrid())[regular.getY()][regular.getX()];
                shinheuhManager = new ShinheuhManager(encounteredShinheuh);
//                fight(regular, regularManager, encounteredShinheuh, shinheuhManager);
            }
/*            (map.getGrid())[originalY][originalX] = null;
            (map.getGrid())[regular.getY()][regular.getX()] = regular;
*/        }

        @Override
        public void windowClosing(WindowEvent e) {
            RegularContext  regularContext;

            regularContext = new RegularContext(Database.CONNECTION_STRING);
            regularContext.openConnection();
            regularContext.putRegular(regular);
            regularContext.close();
            System.exit(0);
        }

        @Override
        public void windowOpened(WindowEvent e) {}

        @Override
        public void windowClosed(WindowEvent e) {}

        @Override
        public void windowIconified(WindowEvent e) {}

        @Override
        public void windowDeiconified(WindowEvent e) {}

        @Override
        public void windowActivated(WindowEvent e) {}

        @Override
        public void windowDeactivated(WindowEvent e) {}

    }

    public void startGame() {
        StartGameGuiView        startGameGuiView;
        StartGameEventHandler   startGameEventHandler;

        startGameGuiView = new StartGameGuiView();
        startGameEventHandler = new StartGameEventHandler(startGameGuiView);
        startGameGuiView.addListenerCreateRegularBtn(startGameEventHandler);
        startGameGuiView.addListenerLoadRegularBtn(startGameEventHandler);
    }

    public void createRegular() {
        CreateNewRegularGuiView     createNewRegularGuiView;
        CreateRegularEventHandler   createRegularEventHandler;

        createNewRegularGuiView = new CreateNewRegularGuiView();
        createRegularEventHandler = new CreateRegularEventHandler(createNewRegularGuiView);
        createNewRegularGuiView.addListenerCreateRegularBtn(createRegularEventHandler);
    }

    public void loadRegular() {
        ArrayList<Regular>          regulars;
        RegularContext              regularContext;
        LoadRegularGuiView          loadRegularGuiView;
        LoadRegularEventHandler     loadRegularEventHandler;

        regularContext = new RegularContext(Database.CONNECTION_STRING);
        regularContext.openConnection();
        regulars = regularContext.getAllRegulars();
        regularContext.close();
        loadRegularGuiView = new LoadRegularGuiView(regulars);
        loadRegularEventHandler = new LoadRegularEventHandler(loadRegularGuiView);
        loadRegularGuiView.addListenerAllBtns(loadRegularEventHandler);
    }

    public void moveRegular(Regular regular, Map map) {
        MoveRegularGuiView      moveRegularGuiView;

        moveRegularGuiView = new MoveRegularGuiView();
    }

    public void fight(Regular regular, RegularManager regularManager, Shinheuh shinheuh, ShinheuhManager shinheuhManager) {
        FightGuiView    fightGuiView;

        fightGuiView = new FightGuiView();
    }

    public void runGame() {
        startGame();
    }

}
