package com.gmail.vuyotm.swingy;

import com.gmail.vuyotm.swingy.controller.GameController;
import com.gmail.vuyotm.swingy.controller.GameGuiController;
import com.gmail.vuyotm.swingy.storage.Database;
import com.gmail.vuyotm.swingy.view.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
/*
        GameController  gameController;

        Database.createDB();
        gameController = new GameController();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            gameController.runGame(bufferedReader);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:swingy.db");
        }
        catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

*/

        Database.createDB();
        GameGuiController   gameGuiController;

        gameGuiController = new GameGuiController();
        gameGuiController.startGame();

/*

        StartGameGuiView    startGameGuiView;

        startGameGuiView = new StartGameGuiView();



        CreateNewRegularGuiView     createNewRegularGuiView;

        createNewRegularGuiView = new CreateNewRegularGuiView();


        MoveRegularGuiView  moveRegularGuiView;

        moveRegularGuiView = new MoveRegularGuiView();


        FightGuiView    fightGuiView;

        fightGuiView = new FightGuiView();


        StatsAndArtifactsGuiView    statsAndArtifactsGuiView;

        statsAndArtifactsGuiView = new StatsAndArtifactsGuiView();

*/

    }

}
