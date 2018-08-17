package com.gmail.vuyotm.swingy;

import com.gmail.vuyotm.swingy.model.Map;
import com.gmail.vuyotm.swingy.model.characters.Regular;
import com.gmail.vuyotm.swingy.model.characters.WaveController;

public class Main {

    public static void main(String[] args) {

        System.out.println("Let the game begin!");

        Regular player;
        Map     map;

        player = new WaveController("7thWave");
        player.setLevel(4);
        map = new Map(player);
        System.out.println(map);;

    }

}
