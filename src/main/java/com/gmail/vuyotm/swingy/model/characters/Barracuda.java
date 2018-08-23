package com.gmail.vuyotm.swingy.model.characters;

import com.gmail.vuyotm.swingy.model.artifacts.Weapon;

public class Barracuda extends Shinheuh {

    private static final int    baseExp = 400;

    public Barracuda() {
        this(1, 10, 5, 0, 5, 8, 1, 1, 15, "barracuda");
    }

    public Barracuda(int level) {
        this(level, 10 * level, 5 * level, 0 * level, 5 * level, 8 * level, 1 * level, 1 * level, 15, "barracuda");
    }

    public Barracuda(int level, int physicalAttack, int physicalDefense, int shinsooAttack, int shinsooDefense, int speed, int evasion, int criticalHit, int hitPts, String type) {
        super(level, physicalAttack, physicalDefense, shinsooAttack, shinsooDefense, speed, evasion, criticalHit, hitPts, type);
        this.setExpGiven(baseExp * level);
        setItemDrop(new Weapon("ignition weapon", 5 * level, 10 * level));
    }

}
