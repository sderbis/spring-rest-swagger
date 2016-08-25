package com.example.spring.rest.model;

import com.wordnik.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class Gizmo implements Serializable {

    @NotEmpty
    String id;
    String name;

    public Gizmo() {
    }

    public Gizmo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @ApiModelProperty(required = true, notes = "unique identifier this Gizmo")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ApiModelProperty(required = true, notes = "name of this Gizmo")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
