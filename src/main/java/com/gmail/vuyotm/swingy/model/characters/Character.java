package com.gmail.vuyotm.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter

public abstract class Character {

    @Min(1)
    private int     level;
    @Min(0)
    private int     physicalAttack;
    @Min(0)
    private int     physicalDefense;
    @Min(0)
    private int     shinsooAttack;
    @Min(0)
    private int     shinsooDefense;
    @Min(0)
    private int     speed;
    @Min(0)
    @Max(100)
    private int     evasion;
    @Min(0)
    @Max(100)
    private int     criticalHit;
    @Min(0)
    private int     hitPts;
    @Min(0)
    private int     x;
    @Min(0)
    private int     y;
    public static final int     EVASION_CAP = 100;
    public static final int     CRIT_HIT_CAP = 100;

    public Character(int level, int physicalAttack, int physicalDefense, int shinsooAttack, int shinsooDefense, int speed, int evasion, int criticalHit, int hitPts) {
        this.level = level;
        this.physicalAttack = physicalAttack;
        this.physicalDefense = physicalDefense;
        this.shinsooAttack = shinsooAttack;
        this.shinsooDefense = shinsooDefense;
        this.speed = speed;
        this.evasion = evasion;
        this.criticalHit = criticalHit;
        this.hitPts = hitPts;
    }

    public boolean hasDied() {
        if (hitPts == 0)
            return (true);
        else
            return (false);
    }

}
