package com.gmail.vuyotm.swingy.model.artifacts;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Min;

@Getter
@Setter

public class Armor extends Artifact {

    @NotEmpty
    @Min(0)
    private int     physicalDefenseBonus;
    @NotEmpty
    @Min(0)
    private int     shinsooDefenseBonus;

    public Armor(String type, int physicalDefenseBonus, int shinsooDefenseBonus) {
        super(type);
        this.physicalDefenseBonus = physicalDefenseBonus;
        this.shinsooDefenseBonus = shinsooDefenseBonus;
    }

}
