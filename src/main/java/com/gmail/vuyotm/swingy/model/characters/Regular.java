package com.gmail.vuyotm.swingy.model.characters;

import com.gmail.vuyotm.swingy.model.artifacts.Armor;
import com.gmail.vuyotm.swingy.model.artifacts.Helm;
import com.gmail.vuyotm.swingy.model.artifacts.Weapon;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter

public abstract class Regular extends Character {

    @NotEmpty
    private String  name;
    @NotEmpty
    private String  classType;
    private Helm    helm;
    private Armor   armor;
    private Weapon  weapon;

    public Regular(int level, int physicalAttack, int physicalDefense, int shinsooAttack, int shinsooDefense, int speed, int evasion, int criticalHit, int hitPts, String name, String classType, Helm helm, Armor armor, Weapon weapon) {
        super(level, physicalAttack, physicalDefense, shinsooAttack, shinsooDefense, speed, evasion, criticalHit, hitPts);
        this.name = name;
        this.classType = classType;
        this.helm = helm;
        this.armor = armor;
        this.weapon = weapon;
    }

}
