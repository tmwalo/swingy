package com.gmail.vuyotm.swingy.model.artifacts;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter

public abstract class Artifact {

    @NotEmpty
    private String  type;

    public Artifact(String type) {
        this.type = type;
    }

}
