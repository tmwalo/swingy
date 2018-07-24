package com.gmail.vuyotm.swingy.model.artifacts;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Min;

@Getter
@Setter

public class Weapon extends Artifact {

    @NotEmpty
    @Min(0)
    private int     physicalAttackBonus;
    @NotEmpty
    @Min(0)
    private int     shinsooAttackBonus;

    public Weapon(String type, int physicalAttackBonus, int shinsooAttackBonus) {
        super(type);
        this.physicalAttackBonus = physicalAttackBonus;
        this.shinsooAttackBonus = shinsooAttackBonus;
    }

}