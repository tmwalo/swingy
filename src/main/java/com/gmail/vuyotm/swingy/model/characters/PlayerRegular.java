package com.gmail.vuyotm.swingy.model.characters;

import com.gmail.vuyotm.swingy.model.artifacts.Armor;
import com.gmail.vuyotm.swingy.model.artifacts.Helm;
import com.gmail.vuyotm.swingy.model.artifacts.Weapon;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Min;

@Getter
@Setter

public abstract class PlayerRegular extends Regular {

    @NotEmpty
    @Min(0)
    private int     experience;

    public PlayerRegular(int level, int physicalAttack, int physicalDefense, int shinsooAttack, int shinsooDefense, int speed, int evasion, int criticalHit, int hitPts, String name, String classType, Helm helm, Armor armor, Weapon weapon, int experience) {
        super(level, physicalAttack, physicalDefense, shinsooAttack, shinsooDefense, speed, evasion, criticalHit, hitPts, name, classType, helm, armor, weapon);
        this.experience = experience;
    }

}
