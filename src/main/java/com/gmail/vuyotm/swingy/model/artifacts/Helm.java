package com.gmail.vuyotm.swingy.model.artifacts;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Min;

@Getter
@Setter

public class Helm extends Artifact {

    @Min(0)
    private int     hitPtsBonus;

    public Helm(String type, int hitPtsBonus) {
        super(type);
        this.hitPtsBonus = hitPtsBonus;
    }

}
