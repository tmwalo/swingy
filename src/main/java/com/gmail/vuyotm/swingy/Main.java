package com.gmail.vuyotm.swingy;

import com.gmail.vuyotm.swingy.controller.GameController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        GameController  gameController;

        gameController = new GameController();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            gameController.runGame(bufferedReader);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
