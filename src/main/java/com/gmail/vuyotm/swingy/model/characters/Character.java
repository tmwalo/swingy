package com.gmail.vuyotm.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter

public abstract class Character {

    @NotEmpty
    @Min(0)
    private int     level;
    @NotEmpty
    @Min(0)
    private int     physicalAttack;
    @NotEmpty
    @Min(0)
    private int     physicalDefense;
    @NotEmpty
    @Min(0)
    private int     shinsooAttack;
    @NotEmpty
    @Min(0)
    private int     shinsooDefense;
    @NotEmpty
    @Min(0)
    private int     speed;
    @NotEmpty
    @Min(0)
    @Max(100)
    private int     evasion;
    @NotEmpty
    @Min(0)
    @Max(100)
    private int     criticalHit;
    @NotEmpty
    @Min(0)
    private int     hitPts;

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

}
