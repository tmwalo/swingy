package com.gmail.vuyotm.swingy.util;

import com.gmail.vuyotm.swingy.model.characters.*;

public abstract class PlayerRegularFactory {

    public static PlayerRegular newPlayerRegular(String classType) {

        if (classType.equals("scout")) {
            Scout player;

            player = new Scout();
            return (player);
        }
        else if (classType.equals("light bearer")) {
            LightBearer player;

            player = new LightBearer();
            return (player);
        }
        else if (classType.equals("fisherman")) {
            Fisherman player;

            player = new Fisherman();
            return (player);
        }
        else if (classType.equals("spear bearer")) {
            SpearBearer player;

            player = new SpearBearer();
            return (player);
        }
        else if (classType.equals("wave controller")) {
            WaveController player;

            player = new WaveController();
            return (player);
        }
        else {
            throw new IllegalArgumentException(classType + " is an unknown class for regulars.");
        }

    }

}
