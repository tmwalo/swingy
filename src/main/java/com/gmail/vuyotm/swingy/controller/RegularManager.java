package com.gmail.vuyotm.swingy.controller;

import com.gmail.vuyotm.swingy.model.characters.Character;
import com.gmail.vuyotm.swingy.model.characters.Regular;
import com.gmail.vuyotm.swingy.model.characters.Shinheuh;

import java.util.concurrent.ThreadLocalRandom;

public class RegularManager {

    private Regular regular;

    public RegularManager(Regular regular) {
        this.regular = regular;
    }

    public void physicalAttack(Shinheuh enemy) {

        int     totalAttack;
        int     effectiveAttack;
        int     newEnemyHp;

        if (enemy == null)
            throw new IllegalArgumentException("Enemy being attacked may not be null.");
        if (regular.getWeapon() != null)
            totalAttack = regular.getPhysicalAttack() + regular.getWeapon().getPhysicalAttackBonus();
        else
            totalAttack = regular.getPhysicalAttack();
        if (totalAttack > enemy.getPhysicalDefense())
            effectiveAttack = totalAttack - enemy.getPhysicalDefense();
        else
            effectiveAttack = 0;
        if (effectiveAttack < enemy.getHitPts())
            newEnemyHp = enemy.getHitPts() - effectiveAttack;
        else
            newEnemyHp = 0;
        enemy.setHitPts(newEnemyHp);

    }

    public void shinsooAttack(Shinheuh enemy) {

        int     totalAttack;
        int     effectiveAttack;
        int     newEnemyHp;

        if (enemy == null)
            throw new IllegalArgumentException("Enemy being attacked may not be null.");
        if (regular.getWeapon() != null)
            totalAttack = regular.getShinsooAttack() + regular.getWeapon().getShinsooAttackBonus();
        else
            totalAttack = regular.getShinsooAttack();
        if (totalAttack > enemy.getShinsooDefense())
            effectiveAttack = totalAttack - enemy.getShinsooDefense();
        else
            effectiveAttack = 0;
        if (effectiveAttack < enemy.getHitPts())
            newEnemyHp = enemy.getHitPts() - effectiveAttack;
        else
            newEnemyHp = 0;
        enemy.setHitPts(newEnemyHp);

    }

    public boolean run() {
        int randNum;
        int min;
        int max;

        min = 0;
        max = 1;
        randNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        if (randNum == 1)
            return (true);
        else
            return (false);
    }

    public boolean hasLeveledUp() {
        int requiredExpNextLvl;
        int actualExp;

        requiredExpNextLvl = (regular.getLevel() * 1000) + ((regular.getLevel() - 1) * (regular.getLevel() - 1) * 450);
        actualExp = regular.getExperience();
        if (actualExp >= requiredExpNextLvl)
            return (true);
        else
            return (false);
    }

    public void levelUp() {
        while (hasLeveledUp()) {
            regular.setLevel(regular.getLevel() + 1);
            regular.setHitPts(regular.getHitPts() + 15);
            regular.setPhysicalAttack(regular.getPhysicalAttack() + 1);
            regular.setPhysicalDefense(regular.getPhysicalDefense() + 1);
            regular.setShinsooAttack(regular.getShinsooAttack() + 1);
            regular.setShinsooDefense(regular.getShinsooDefense() + 1);
            regular.setSpeed(regular.getSpeed() + 1);
            if (regular.getEvasion() < Character.EVASION_CAP)
                regular.setEvasion(regular.getEvasion() + 1);
            if (regular.getCriticalHit() < Character.CRIT_HIT_CAP)
                regular.setCriticalHit(regular.getCriticalHit() + 1);
        }
    }

    public void moveNorth() {
        regular.setY(regular.getY() - 1);
    }

    public void moveSouth() {
        regular.setY(regular.getY() + 1);
    }

    public void moveEast() {
        regular.setX(regular.getX() + 1);
    }

    public void moveWest() {
        regular.setX(regular.getX() - 1);
    }

}