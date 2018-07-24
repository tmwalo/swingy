package com.gmail.vuyotm.swingy.model.characters;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter

public class Shinheuh extends Character {

    @NotEmpty
    private String  type;

    public Shinheuh(int level, int physicalAttack, int physicalDefense, int shinsooAttack, int shinsooDefense, int speed, int evasion, int criticalHit, int hitPts, String type) {
        super(level, physicalAttack, physicalDefense, shinsooAttack, shinsooDefense, speed, evasion, criticalHit, hitPts);
        this.type = type;
    }

}
